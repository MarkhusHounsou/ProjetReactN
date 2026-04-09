package fr.mmi.saemanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NoteEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    // Note peut être nulle si l'étudiant n'a "pas de note"
    private Double valeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sae_id")
    @JsonBackReference
    private Sae sae;
}
