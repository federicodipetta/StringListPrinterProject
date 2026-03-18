package cs.mdp.unicam.writable;

/**
 * Una basica implementazione di WritableElement che accetta qualsiasi oggetto e 
 * lo converte in stringa tramite toString() per essere scritto.
 */
public class WritableBasicElement implements WritableElement {

    private final String element;

    public WritableBasicElement(Object element) {
        if(element == null || element.toString().isEmpty()) {
            throw new IllegalArgumentException("Element cannot be null or empty");
        }
        this.element = element.toString();
    }

    @Override
    public String getStringToWrite() {
        return element;
    }
    
}
