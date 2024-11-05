package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getDashboard(Model model, @RequestParam("page") int page) {
        Page<Product> products = this.productService.fetchProducts(PageRequest.of(page - 1, 6));
        List<Product> productList = products.getContent();
        model.addAttribute("products", productList);
        return "admin/product/show";
    }

    @RequestMapping("/admin/product/{id}")
    public String getDetailProduct(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Product product = this.productService.findProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/detail";
    }

    @GetMapping("/admin/product/create") // GET
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProductPage(Model model, @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult, @RequestParam("nameProductImg") MultipartFile file) {

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>>>>>>>>>>>>" + error.getField());
        }
        // validate
        if (newProductBindingResult.hasErrors()) {
            return "/admin/product/create";
        }
        // Upload image
        String image = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(image);
        this.productService.handleSaveProduct(product);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.findProductById(id);
        model.addAttribute("product", product);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(Model model, @ModelAttribute("product") @Valid Product dataForm,
            BindingResult productBindingResult, @RequestParam("nameProductImg") MultipartFile file) {
        if (productBindingResult.hasErrors()) {
            return "/admin/product/update";
        }
        Product currentProduct = this.productService.findProductById(dataForm.getId());
        if (currentProduct != null) {
            currentProduct.setName(dataForm.getName());
            currentProduct.setPrice(dataForm.getPrice());
            currentProduct.setDetailDesc(dataForm.getDetailDesc());
            currentProduct.setShortDesc(dataForm.getShortDesc());
            currentProduct.setQuantity(dataForm.getQuantity());
            currentProduct.setSold(dataForm.getSold());
            currentProduct.setFactory(dataForm.getFactory());
            currentProduct.setTarget(dataForm.getTarget());
            currentProduct.setImage(this.uploadService.handleSaveUploadFile(file, "product"));
            this.productService.handleSaveProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Product product = this.productService.findProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/delete";
    }

    @PostMapping("admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("id") long id) {
        Product product = this.productService.findProductById(id);
        this.productService.handleDeleteProduct(product);
        return "redirect:/admin/product";
    }

}
