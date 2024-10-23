package vn.hoidanit.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import jakarta.servlet.DispatcherType;
import vn.hoidanit.laptopshop.service.CustomUserDetailsService;
import vn.hoidanit.laptopshop.service.UserService;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfigurtation {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new CustomUserDetailsService(userService);
    }
    // Lỗi vòng lặp không giới hạn khi login sai password
    // @Bean
    // public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder,
    // UserDetailsService userDetailsService) throws Exception {
    //     AuthenticationManagerBuilder authenticationManagerBuilder = http
    //         .getSharedObject(AuthenticationManagerBuilder.class);
    //     authenticationManagerBuilder
    //         .userDetailsService(userDetailsService)
    //         .passwordEncoder(passwordEncoder);
    //     return authenticationManagerBuilder.build();
    // }
    @Bean
    public DaoAuthenticationProvider authProvider(
        PasswordEncoder passwordEncoder,
        UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        // authProvider.setHideUserNotFoundExceptions(false);
        return authProvider;
    }
    // Cấu hình cho firewall để cho phép chuỗi "//" trong URL
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true);  // Cho phép chuỗi "//" trong URL
        return firewall;
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler(){
        return new CustomSuccessHandler();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.INCLUDE) .permitAll()
                .requestMatchers("/", "/login", "/product/**", "/client/**", "/css/**", "/js/**", "/images/**", "/avatar/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated())

            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .failureUrl("/login?error")
                .successHandler(customSuccessHandler())
                .permitAll())
            .exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/403"));

        return http.build();
    }

}
