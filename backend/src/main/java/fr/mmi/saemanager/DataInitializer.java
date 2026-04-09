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
        // Optionnel : ne pas exécuter si des SAÉ existent déjà pour éviter les doublons au redémarrage
        // if (saeRepository.count() > 0) return;

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
        addNote(notes, sae, "BEN BOUBAKER Sheinez", 10.05);
        addNote(notes, sae, "BAL Zeinabou", 13.05);
        addNote(notes, sae, "HOUNSOU Markhus", 12.3);
        addNote(notes, sae, "MHOUMADI Makine", 10.8);
        addNote(notes, sae, "BUHOT Yanis", 12.0);
        addNote(notes, sae, "CHAPUT Théo", 12.375);
        addNote(notes, sae, "HAMON Alexandre", 13.125);
        addNote(notes, sae, "VANDELET Marin", 15.0);
        addNote(notes, sae, "CHTIOUI Ibtissem", 13.45);
        addNote(notes, sae, "GONCALVES Hugo Vitor", 11.7);
        addNote(notes, sae, "PEREIRA Ruben", 11.7);
        addNote(notes, sae, "MAHJOUB Assia", 10.7);
        addNote(notes, sae, "KONATE Hamed", 10.65);
        addNote(notes, sae, "KECKET-BAKER Trystan", 10.4);
        addNote(notes, sae, "MANSOIBOU Warrick", 10.4);
        addNote(notes, sae, "CHEURFA Liam", 15.05);
        addNote(notes, sae, "BRUSA Joris", 11.3);
        addNote(notes, sae, "CARPENTIER Timothé", 13.05);
        addNote(notes, sae, "MONLAY Tom", null);
        addNote(notes, sae, "ZAIEM Sarah", 12.75);
        addNote(notes, sae, "BROUILLARD Thilya", 11.75);
        addNote(notes, sae, "BUISSET Nicolas", 15.25);
        addNote(notes, sae, "HENRIQUES MATEUS Léonardo", null);
        addNote(notes, sae, "THIABAS HOULAI Keyla", 10.95);
        addNote(notes, sae, "EDDABACHI Younes", 10.45);
        addNote(notes, sae, "KOUASSI Emmanuel", 11.7);
        addNote(notes, sae, "PEREZ SANCHEZ John", 12.2);
        addNote(notes, sae, "THEVAKUMAR Aathavan", 15.55);
        addNote(notes, sae, "VIGNESWARAN Abi", 11.8);
        addNote(notes, sae, "SALAOUDINE Saffana", 13.8);
        addNote(notes, sae, "BAER Oscar", 12.55);
        addNote(notes, sae, "LAWSON Killian", 13.275);
        addNote(notes, sae, "VEOPRASEUTH Nolan", 10.9);
        addNote(notes, sae, "ZENATI Mehdi", 12.65);
        addNote(notes, sae, "PREVOST Adrien", 14.15);
        addNote(notes, sae, "VASANTHAN Luxchan", 11.55);
        addNote(notes, sae, "KRISHNAKUMAR Abeeschan", 12.8);
        addNote(notes, sae, "ANTUNES Enzo", 10.8);
        addNote(notes, sae, "RANNOU Nicolas", 10.3);
        addNote(notes, sae, "BALDINETTI Mattéo", 15.95);
        addNote(notes, sae, "DINH Ken", 18.7);
        addNote(notes, sae, "ROURE Vincent", 15.45);
        addNote(notes, sae, "SEGHIRI Marwan", 13.45);
        addNote(notes, sae, "CAMELIN Yannis", 14.05);
        addNote(notes, sae, "RAKOTOMAVO Mathias", 13.8);
        addNote(notes, sae, "SOM Yohan", 15.175);
        addNote(notes, sae, "LOPERE Alexandre", 13.55);

        sae.setNotesEtudiants(notes);
        saeRepository.save(sae);
    }

    private void initSae303() {
        Sae sae = new Sae();
        sae.setTitre("SAE 303");
        sae.setSemestre("S3");
        sae.setDescription("Projet SAE 303 - Notes des étudiants");

        List<NoteEtudiant> notes = new ArrayList<>();
        addNote(notes, sae, "ADJAOUD Rayane", 13.75);
        addNote(notes, sae, "HUANG Patrick", 11.75);
        addNote(notes, sae, "NIEWIDZIALA-BECKER Zoran", 11.75);
        addNote(notes, sae, "LOUBARESSE Victor", 13.0);
        addNote(notes, sae, "LUFUNDU Océane", 9.75);
        addNote(notes, sae, "BOREL Maïlys", 9.25);
        addNote(notes, sae, "MONNERAT Maxime", 10.5);
        addNote(notes, sae, "DA COSTA Timéo", 17.0);
        addNote(notes, sae, "GADAGNI Soumiyya", 17.25);
        addNote(notes, sae, "JANVIER Charly", 17.0);
        addNote(notes, sae, "TREFFAULT Axel", 17.0);
        addNote(notes, sae, "MORANCY Manon", 5.25);
        addNote(notes, sae, "ONESTAS Radji", 5.25);
        addNote(notes, sae, "MAUDET Dylan", 5.25);
        addNote(notes, sae, "MOYEUX Dorian", 5.25);
        addNote(notes, sae, "Enes GÜNDEM", 15.25);
        addNote(notes, sae, "Erwan PICARD-ALVAREZ", 15.5);
        addNote(notes, sae, "Lucas ROBERT", 15.25);
        addNote(notes, sae, "Enzo ABDI", 17.75);
        addNote(notes, sae, "CORPET Kilian", 13.25);
        addNote(notes, sae, "THEVIN Alexis", 13.0);
        addNote(notes, sae, "LACHAB Imène", 14.25);
        addNote(notes, sae, "GERANCE Lény", 14.75);
        addNote(notes, sae, "PARADIS Jérémy", 10.25);
        addNote(notes, sae, "GIROUX Benjamin", 10.25);
        addNote(notes, sae, "SAIDJ Sofiane", 14.0);
        addNote(notes, sae, "YO KING CHUEN Darel", 10.25);
        addNote(notes, sae, "REDOT Naël", 10.25);
        addNote(notes, sae, "LAUDET Mathieu", 15.0);
        addNote(notes, sae, "JOUAN Gregoire", 14.75);
        addNote(notes, sae, "GOSMAT Adam", 14.5);
        addNote(notes, sae, "FARRUGGIA Maxime", 14.5);
        addNote(notes, sae, "DERENNES Maxime", 17.75);
        addNote(notes, sae, "KERGASTEL Témi", null);
        addNote(notes, sae, "TOCQUEVILLE Joachim", 12.5);
        addNote(notes, sae, "CHISIU Sébastien", 16.25);
        addNote(notes, sae, "DRAME Ibrahim", 13.0);
        addNote(notes, sae, "CHOUDJAY Dylan", 11.5);
        addNote(notes, sae, "SAVOURIN Thomas", 11.75);
        addNote(notes, sae, "GUIDDIR Naïm", 11.25);
        addNote(notes, sae, "CHUPIN Nathan", 11.0);
        addNote(notes, sae, "Maxence COSTE", 16.25);
        addNote(notes, sae, "Samuel RABARIJAONA", 15.75);
        addNote(notes, sae, "Clément GUESNON", 5.0);
        addNote(notes, sae, "Corentin DELEN", 15.75);
        addNote(notes, sae, "SAMOURA Diaba", 15.75);
        addNote(notes, sae, "ADMI Séfora", 11.0);
        addNote(notes, sae, "GILET Amel", 15.5);
        addNote(notes, sae, "LEBRETON Laura", 14.0);
        addNote(notes, sae, "LUYEYE POLYDOR Nelly", 10.5);
        addNote(notes, sae, "BOULLARD Raphaël", 14.5);
        addNote(notes, sae, "KADI Wassim", 11.5);
        addNote(notes, sae, "SIMON-JEAN Leana", 11.5);
        addNote(notes, sae, "MARTON Eliot", 11.5);
        addNote(notes, sae, "FLEURY Noa", 14.0);
        addNote(notes, sae, "ANDOUARD Liam", 13.25);
        addNote(notes, sae, "BOUQUET Ethan", 14.25);
        addNote(notes, sae, "JEULAND Enzo", 13.25);
        addNote(notes, sae, "TRELLE Florian", 13.25);

        sae.setNotesEtudiants(notes);
        saeRepository.save(sae);
    }
}
