package com.sambit.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product_dtls")
public class ProductDtl {
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "product_type", nullable = false, length = 45)
    private String productType;

    @NotNull
    @Column(name = "weight", nullable = false)
    private Double weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ProductDtl{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", weight=" + weight +
                '}';
    }
}