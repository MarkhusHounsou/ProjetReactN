package fr.mmi.saemanager.repositories;

import fr.mmi.saemanager.models.Sae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaeRepository extends JpaRepository<Sae, Long> {
    List<Sae> findBySemestre(String semestre);
    List<Sae> findByDomaine(String domaine);
    List<Sae> findBySemestreAndDomaine(String semestre, String domaine);
    List<Sae> findAllByOrderByNoteDesc();
}
