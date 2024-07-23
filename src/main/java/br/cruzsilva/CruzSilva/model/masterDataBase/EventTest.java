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


@Entity
@Table (name="event_test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_event_test")
    private Long cdnEventTest;

    @Column(name = "cdn_test_number")
    private Long cdnTestNumber;

    @Column (name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cdn_event", referencedColumnName = "cdn_event")
    @Fetch(FetchMode.SELECT)
    private Event event;

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


    public EventTest(Long cdnEventTest) {
        this.cdnEventTest = cdnEventTest;
    }
}
