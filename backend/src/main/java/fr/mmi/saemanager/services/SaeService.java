package fr.mmi.saemanager.services;

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
        return repo.findAll();
    }

    public Sae getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("SAÉ introuvable"));
    }

    public List<Sae> getFiltered(String semestre, String domaine, boolean sortByNoteDesc) {
        List<Sae> result;
        if (semestre != null && domaine != null) {
            result = repo.findBySemestreAndDomaine(semestre, domaine);
        } else if (semestre != null) {
            result = repo.findBySemestre(semestre);
        } else if (domaine != null) {
            result = repo.findByDomaine(domaine);
        } else if (sortByNoteDesc) {
            result = repo.findAllByOrderByNoteDesc();
        } else {
            result = repo.findAll();
        }
        return result;
    }
}
