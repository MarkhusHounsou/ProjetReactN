package fr.mmi.saemanager.repositories;

import fr.mmi.saemanager.models.Sae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaeRepository extends JpaRepository<Sae, Long> {

    @Query("SELECT DISTINCT s FROM Sae s LEFT JOIN FETCH s.notesEtudiants")
    List<Sae> findAllWithNotes();

    @Query("SELECT DISTINCT s FROM Sae s LEFT JOIN FETCH s.notesEtudiants WHERE s.id = :id")
    Optional<Sae> findByIdWithNotes(Long id);

    @Query("SELECT DISTINCT s FROM Sae s LEFT JOIN FETCH s.notesEtudiants WHERE s.semestre = :semestre")
    List<Sae> findBySemestreWithNotes(String semestre);

    @Query("SELECT DISTINCT s FROM Sae s LEFT JOIN FETCH s.notesEtudiants WHERE s.domaine = :domaine")
    List<Sae> findByDomaineWithNotes(String domaine);

    @Query("SELECT DISTINCT s FROM Sae s LEFT JOIN FETCH s.notesEtudiants WHERE s.semestre = :semestre AND s.domaine = :domaine")
    List<Sae> findBySemestreAndDomaineWithNotes(String semestre, String domaine);

    @Query("SELECT DISTINCT s FROM Sae s LEFT JOIN FETCH s.notesEtudiants ORDER BY s.note DESC")
    List<Sae> findAllByOrderByNoteDescWithNotes();

    // Méthodes conservées pour compatibilité
    List<Sae> findBySemestre(String semestre);
    List<Sae> findByDomaine(String domaine);
    List<Sae> findBySemestreAndDomaine(String semestre, String domaine);
    List<Sae> findAllByOrderByNoteDesc();
}
