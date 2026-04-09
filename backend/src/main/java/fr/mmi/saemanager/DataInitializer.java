package fr.mmi.saemanager;

import fr.mmi.saemanager.models.NoteEtudiant;
import fr.mmi.saemanager.models.Sae;
import fr.mmi.saemanager.repositories.SaeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SaeRepository saeRepository;

    public DataInitializer(SaeRepository saeRepository) {
        this.saeRepository = saeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Évite les doublons lors des redémarrages
        if (saeRepository.count() > 0) return;

        initSae501();
        initSae303();
    }

    private void addNote(List<NoteEtudiant> list, Sae sae, String nom, Double valeur) {
        NoteEtudiant n = new NoteEtudiant();
        n.setNom(nom);
        n.setValeur(valeur);
        n.setSae(sae);
        list.add(n);
    }

    private void initSae501() {
        Sae sae = new Sae();
        sae.setTitre("SAE 501");
        sae.setSemestre("S5");
        sae.setDescription("Projet SAE 501 - Notes des étudiants");

        List<NoteEtudiant> notes = new ArrayList<>();
        addNote(notes, sae, "ETU-501-001", 10.05);
        addNote(notes, sae, "ETU-501-002", 13.05);
        addNote(notes, sae, "ETU-501-003", 12.3);
        addNote(notes, sae, "ETU-501-004", 10.8);
        addNote(notes, sae, "ETU-501-005", 12.0);
        addNote(notes, sae, "ETU-501-006", 12.375);
        addNote(notes, sae, "ETU-501-007", 13.125);
        addNote(notes, sae, "ETU-501-008", 15.0);
        addNote(notes, sae, "ETU-501-009", 13.45);
        addNote(notes, sae, "ETU-501-010", 11.7);
        addNote(notes, sae, "ETU-501-011", 11.7);
        addNote(notes, sae, "ETU-501-012", 10.7);
        addNote(notes, sae, "ETU-501-013", 10.65);
        addNote(notes, sae, "ETU-501-014", 10.4);
        addNote(notes, sae, "ETU-501-015", 10.4);
        addNote(notes, sae, "ETU-501-016", 15.05);
        addNote(notes, sae, "ETU-501-017", 11.3);
        addNote(notes, sae, "ETU-501-018", 13.05);
        addNote(notes, sae, "ETU-501-019", null);
        addNote(notes, sae, "ETU-501-020", 12.75);
        addNote(notes, sae, "ETU-501-021", 11.75);
        addNote(notes, sae, "ETU-501-022", 15.25);
        addNote(notes, sae, "ETU-501-023", null);
        addNote(notes, sae, "ETU-501-024", 10.95);
        addNote(notes, sae, "ETU-501-025", 10.45);
        addNote(notes, sae, "ETU-501-026", 11.7);
        addNote(notes, sae, "ETU-501-027", 12.2);
        addNote(notes, sae, "ETU-501-028", 15.55);
        addNote(notes, sae, "ETU-501-029", 11.8);
        addNote(notes, sae, "ETU-501-030", 13.8);
        addNote(notes, sae, "ETU-501-031", 12.55);
        addNote(notes, sae, "ETU-501-032", 13.275);
        addNote(notes, sae, "ETU-501-033", 10.9);
        addNote(notes, sae, "ETU-501-034", 12.65);
        addNote(notes, sae, "ETU-501-035", 14.15);
        addNote(notes, sae, "ETU-501-036", 11.55);
        addNote(notes, sae, "ETU-501-037", 12.8);
        addNote(notes, sae, "ETU-501-038", 10.8);
        addNote(notes, sae, "ETU-501-039", 10.3);
        addNote(notes, sae, "ETU-501-040", 15.95);
        addNote(notes, sae, "ETU-501-041", 18.7);
        addNote(notes, sae, "ETU-501-042", 15.45);
        addNote(notes, sae, "ETU-501-043", 13.45);
        addNote(notes, sae, "ETU-501-044", 14.05);
        addNote(notes, sae, "ETU-501-045", 13.8);
        addNote(notes, sae, "ETU-501-046", 15.175);
        addNote(notes, sae, "ETU-501-047", 13.55);

        sae.setNotesEtudiants(notes);
        saeRepository.save(sae);
    }

    private void initSae303() {
        Sae sae = new Sae();
        sae.setTitre("SAE 303");
        sae.setSemestre("S3");
        sae.setDescription("Projet SAE 303 - Notes des étudiants");

        List<NoteEtudiant> notes = new ArrayList<>();
        addNote(notes, sae, "ETU-303-001", 13.75);
        addNote(notes, sae, "ETU-303-002", 11.75);
        addNote(notes, sae, "ETU-303-003", 11.75);
        addNote(notes, sae, "ETU-303-004", 13.0);
        addNote(notes, sae, "ETU-303-005", 9.75);
        addNote(notes, sae, "ETU-303-006", 9.25);
        addNote(notes, sae, "ETU-303-007", 10.5);
        addNote(notes, sae, "ETU-303-008", 17.0);
        addNote(notes, sae, "ETU-303-009", 17.25);
        addNote(notes, sae, "ETU-303-010", 17.0);
        addNote(notes, sae, "ETU-303-011", 17.0);
        addNote(notes, sae, "ETU-303-012", 5.25);
        addNote(notes, sae, "ETU-303-013", 5.25);
        addNote(notes, sae, "ETU-303-014", 5.25);
        addNote(notes, sae, "ETU-303-015", 5.25);
        addNote(notes, sae, "ETU-303-016", 15.25);
        addNote(notes, sae, "ETU-303-017", 15.5);
        addNote(notes, sae, "ETU-303-018", 15.25);
        addNote(notes, sae, "ETU-303-019", 17.75);
        addNote(notes, sae, "ETU-303-020", 13.25);
        addNote(notes, sae, "ETU-303-021", 13.0);
        addNote(notes, sae, "ETU-303-022", 14.25);
        addNote(notes, sae, "ETU-303-023", 14.75);
        addNote(notes, sae, "ETU-303-024", 10.25);
        addNote(notes, sae, "ETU-303-025", 10.25);
        addNote(notes, sae, "ETU-303-026", 14.0);
        addNote(notes, sae, "ETU-303-027", 10.25);
        addNote(notes, sae, "ETU-303-028", 10.25);
        addNote(notes, sae, "ETU-303-029", 15.0);
        addNote(notes, sae, "ETU-303-030", 14.75);
        addNote(notes, sae, "ETU-303-031", 14.5);
        addNote(notes, sae, "ETU-303-032", 14.5);
        addNote(notes, sae, "ETU-303-033", 17.75);
        addNote(notes, sae, "ETU-303-034", null);
        addNote(notes, sae, "ETU-303-035", 12.5);
        addNote(notes, sae, "ETU-303-036", 16.25);
        addNote(notes, sae, "ETU-303-037", 13.0);
        addNote(notes, sae, "ETU-303-038", 11.5);
        addNote(notes, sae, "ETU-303-039", 11.75);
        addNote(notes, sae, "ETU-303-040", 11.25);
        addNote(notes, sae, "ETU-303-041", 11.0);
        addNote(notes, sae, "ETU-303-042", 16.25);
        addNote(notes, sae, "ETU-303-043", 15.75);
        addNote(notes, sae, "ETU-303-044", 5.0);
        addNote(notes, sae, "ETU-303-045", 15.75);
        addNote(notes, sae, "ETU-303-046", 15.75);
        addNote(notes, sae, "ETU-303-047", 11.0);
        addNote(notes, sae, "ETU-303-048", 15.5);
        addNote(notes, sae, "ETU-303-049", 14.0);
        addNote(notes, sae, "ETU-303-050", 10.5);
        addNote(notes, sae, "ETU-303-051", 14.5);
        addNote(notes, sae, "ETU-303-052", 11.5);
        addNote(notes, sae, "ETU-303-053", 11.5);
        addNote(notes, sae, "ETU-303-054", 11.5);
        addNote(notes, sae, "ETU-303-055", 14.0);
        addNote(notes, sae, "ETU-303-056", 13.25);
        addNote(notes, sae, "ETU-303-057", 14.25);
        addNote(notes, sae, "ETU-303-058", 13.25);
        addNote(notes, sae, "ETU-303-059", 13.25);

        sae.setNotesEtudiants(notes);
        saeRepository.save(sae);
    }
}
