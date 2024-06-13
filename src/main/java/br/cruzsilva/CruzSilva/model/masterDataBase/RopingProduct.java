package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "roping_division_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_division_product")
    private Long cdnRopingDivisionProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "stock_qty")
    private BigDecimal stockQty;

    @Column(name = "stock_qty_available")
    private BigDecimal stockQtyAvailable;

    @Column(name = "stock_cost")
    private BigDecimal stockCost;

    @Column(name = "sales_released_until")
    private LocalDateTime salesReleasedUntil;

    @ManyToOne
    @JoinColumn(name = "cdn_roping", referencedColumnName = "cdn_roping")
    @Fetch(FetchMode.SELECT)
    private Roping roping;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "creation_user")
    private String creationUser;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "update_user")
    private String updateUser;

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }

    public RopingProduct(Long cdnRopingDivisionProduct) {
        this.cdnRopingDivisionProduct = cdnRopingDivisionProduct;
    }
}