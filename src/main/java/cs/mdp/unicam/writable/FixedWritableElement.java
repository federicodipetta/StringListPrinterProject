package cs.mdp.unicam.writable;

/**
 * Questa classe astratta rappresenta un elemento che può essere scritto da un AbstractWriter, 
 * ma che modifica la stringa da scrivere in base alla stringa originale.
 */
public abstract class FixedWritableElement implements WritableElement {

    private final WritableElement element;

    public FixedWritableElement(WritableElement element) {
        this.element = element;
    }

    @Override
    public String getStringToWrite() {
        return getFixedString(element.getStringToWrite());
    }

    /**
     * Restituisce la stringa da scrivere, modificata in base alla stringa originale.
     * @param s la stringa originale da modificare
     * @return la stringa modificata da scrivere
     */
    public abstract String getFixedString(String s);

}
