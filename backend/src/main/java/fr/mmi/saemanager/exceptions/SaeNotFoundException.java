package fr.mmi.saemanager.exceptions;

public class SaeNotFoundException extends RuntimeException {
    public SaeNotFoundException(Long id) {
        super("SAÉ introuvable avec l'identifiant : " + id);
    }
}
