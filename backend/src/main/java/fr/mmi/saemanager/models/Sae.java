package fr.mmi.saemanager.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
public class Sae {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    private List<String> competences;

    private String semestre; // Ex: "S3", "S4"
    private String domaine; // Ex: "Web", "Design", "Audiovisuel"
    
    private String imageUrl;

    @ElementCollection
    private List<String> ressourcesHumaines;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    private Double note;
    private Double tauxReussite;

    private String ueCorrespondante;
    private String lienSite;
    private String lienCode;

    @OneToMany(mappedBy = "sae", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<NoteEtudiant> notesEtudiants;
}
