package fr.mmi.saemanager.repositories;

import fr.mmi.saemanager.models.NoteEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteEtudiantRepository extends JpaRepository<NoteEtudiant, Long> {
}
