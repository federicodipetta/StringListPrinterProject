package cs.mdp.unicam.writable;

/**
 * Questa interfaccia rappresenta un elemento che può essere scritto da un AbstractWriter. 
 * Deve implementare il metodo getStringToWrite, che restituisce la stringa da scrivere.
 */
public interface WritableElement {

    /**
     * Restituisce la stringa da scrivere.
     * @return la stringa da scrivere
     */
    public String getStringToWrite();

}
