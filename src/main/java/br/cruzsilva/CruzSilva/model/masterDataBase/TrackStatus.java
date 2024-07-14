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
@Table(name = "track_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdn_track_status")
    private Long cdnTrackStatus;

    @Column(name = "name")
    private String name;

    public TrackStatus(Long cdnTrackStatus) {
        this.cdnTrackStatus = cdnTrackStatus;
    }
}