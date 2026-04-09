package fr.mmi.saemanager.controllers;

import fr.mmi.saemanager.models.Sae;
import fr.mmi.saemanager.services.SaeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saes")
@CrossOrigin(origins = "*")
public class SaeController {

    private final SaeService service;

    public SaeController(SaeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Sae> create(@RequestBody Sae sae) {
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
}
