package fr.mmi.saemanager.services;

import fr.mmi.saemanager.exceptions.SaeNotFoundException;
import fr.mmi.saemanager.models.Sae;
import fr.mmi.saemanager.repositories.SaeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaeService {

    private final SaeRepository repo;

    public SaeService(SaeRepository repo) {
        this.repo = repo;
    }

    public Sae createSae(Sae sae) {
        return repo.save(sae);
    }

    public List<Sae> getAll() {
        return repo.findAllWithNotes();
    }

    public Sae getById(Long id) {
        return repo.findByIdWithNotes(id)
                .orElseThrow(() -> new SaeNotFoundException(id));
    }

    public Sae updateSae(Long id, Sae updated) {
        Sae existing = getById(id);
        existing.setTitre(updated.getTitre());
        existing.setDescription(updated.getDescription());
        existing.setSemestre(updated.getSemestre());
        existing.setDomaine(updated.getDomaine());
        existing.setImageUrl(updated.getImageUrl());
        existing.setCompetences(updated.getCompetences());
        existing.setRessourcesHumaines(updated.getRessourcesHumaines());
        existing.setDateDebut(updated.getDateDebut());
        existing.setDateFin(updated.getDateFin());
        existing.setNote(updated.getNote());
        existing.setTauxReussite(updated.getTauxReussite());
        existing.setUeCorrespondante(updated.getUeCorrespondante());
        existing.setLienSite(updated.getLienSite());
        existing.setLienCode(updated.getLienCode());
        return repo.save(existing);
    }

    public void deleteSae(Long id) {
        if (!repo.existsById(id)) {
            throw new SaeNotFoundException(id);
        }
        repo.deleteById(id);
    }

    public List<Sae> getFiltered(String semestre, String domaine, boolean sortByNoteDesc) {
        if (semestre != null && domaine != null) {
            return repo.findBySemestreAndDomaineWithNotes(semestre, domaine);
        } else if (semestre != null) {
            return repo.findBySemestreWithNotes(semestre);
        } else if (domaine != null) {
            return repo.findByDomaineWithNotes(domaine);
        } else if (sortByNoteDesc) {
            return repo.findAllByOrderByNoteDescWithNotes();
        } else {
            return repo.findAllWithNotes();
        }
    }
}
