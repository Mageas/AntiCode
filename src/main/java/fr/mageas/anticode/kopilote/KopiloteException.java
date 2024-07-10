package fr.mageas.anticode.kopilote;

public class KopiloteException extends Exception {
    public KopiloteException() {
        super("Unable to connect to Kopilote API");
    }
}
