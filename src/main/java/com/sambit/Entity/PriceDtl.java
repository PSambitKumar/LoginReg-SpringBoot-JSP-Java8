package com.sambit.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "price_dtls")
public class PriceDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sl_no", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductDtl product;

    @NotNull
    @Column(name = "`current_date`", nullable = false)
    private Date currentDate;

    @NotNull
    @Column(name = "current_gold_rate_per_gram", nullable = false)
    private Double currentGoldRatePerGram;

    @NotNull
    @Column(name = "making_charge_after_discount", nullable = false)
    private Double makingChargeAfterDiscount;

    @Column(name = "gross_amount")
    private Double grossAmount;

    @NotNull
    @Column(name = "gst_amount", nullable = false)
    private Double gstAmount;

    @NotNull
    @Column(name = "net_price", nullable = false)
    private Double netPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDtl getProduct() {
        return product;
    }

    public void setProduct(ProductDtl product) {
        this.product = product;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Double getCurrentGoldRatePerGram() {
        return currentGoldRatePerGram;
    }

    public void setCurrentGoldRatePerGram(Double currentGoldRatePerGram) {
        this.currentGoldRatePerGram = currentGoldRatePerGram;
    }

    public Double getMakingChargeAfterDiscount() {
        return makingChargeAfterDiscount;
    }

    public void setMakingChargeAfterDiscount(Double makingChargeAfterDiscount) {
        this.makingChargeAfterDiscount = makingChargeAfterDiscount;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(Double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    @Override
    public String toString() {
        return "PriceDtl{" +
                "id=" + id +
                ", product=" + product +
                ", currentDate=" + currentDate +
                ", currentGoldRatePerGram=" + currentGoldRatePerGram +
                ", makingChargeAfterDiscount=" + makingChargeAfterDiscount +
                ", grossAmount=" + grossAmount +
                ", gstAmount=" + gstAmount +
                ", netPrice=" + netPrice +
                '}';
    }
}