package fr.mmi.saemanager.controllers;

import fr.mmi.saemanager.models.Sae;
import fr.mmi.saemanager.services.SaeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO production : restreindre origins aux domaines autorisés (ex: "http://mondomaine.com")
@RestController
@RequestMapping("/api/saes")
@CrossOrigin(origins = "*")
public class SaeController {

    private final SaeService service;

    public SaeController(SaeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Sae> create(@Valid @RequestBody Sae sae) {
        return new ResponseEntity<>(service.createSae(sae), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sae>> getAll(
            @RequestParam(required = false) String semestre,
            @RequestParam(required = false) String domaine,
            @RequestParam(required = false, defaultValue = "false") boolean sortByNoteDesc) {
        return ResponseEntity.ok(service.getFiltered(semestre, domaine, sortByNoteDesc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sae> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sae> update(@PathVariable Long id, @Valid @RequestBody Sae sae) {
        return ResponseEntity.ok(service.updateSae(id, sae));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSae(id);
        return ResponseEntity.noContent().build();
    }
}
