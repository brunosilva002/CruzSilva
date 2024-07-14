package br.cruzsilva.CruzSilva.model.masterDataBase;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roping_payment_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RopingPaymentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_roping_payment_type")
    private Long cdnRopingPaymentType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cdn_roping", referencedColumnName = "cdn_roping")
    @Fetch(FetchMode.SELECT)
    private Roping roping;

    @ManyToOne
    @JoinColumn(name = "cdn_payment_type", referencedColumnName = "cdn_payment_type")
    @Fetch(FetchMode.SELECT)
    private PaymentType paymentType;

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

    public RopingPaymentType(Long cdnRopingPaymentType) {
        this.cdnRopingPaymentType = cdnRopingPaymentType;
    }
}