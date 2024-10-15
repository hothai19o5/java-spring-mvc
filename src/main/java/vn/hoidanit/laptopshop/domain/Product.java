package vn.hoidanit.laptopshop.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty(message = "Name cannot empty")
    private String name;

    @NotNull
    private double price;

    @NotNull
    private long quantity;

    private String image;

    @NotNull
    @NotEmpty(message = "Detail Desc cannot empty")
    @Column(columnDefinition = "TEXT")
    private String detailDesc;

    @NotNull
    @NotEmpty(message = "Short Desc cannot empty")
    @Column(columnDefinition = "TEXT")
    private String shortDesc;

    @NotNull
    private long sold;

    @NotNull
    @NotEmpty(message = "Factory cannot empty")
    private String factory;

    @NotNull
    @NotEmpty(message = "Target cannot empty")
    private String target;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Product [Id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", image="
                + image + ", detailDesc=" + detailDesc + ", shortDesc=" + shortDesc + ", sold=" + sold + ", factory="
                + factory + ", target=" + target + "]";
    }

}
