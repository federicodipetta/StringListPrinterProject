package cs.mdp.unicam;

import cs.mdp.unicam.writable.WritableElement;

/**
 * Questa interfaccia rappresenta un writer astratto che può scrivere elementi di tipo WritableElement.
 * Il metodo print accetta un elemento di tipo WritableElement e lo scrive in qualche modo 
 * (ad esempio, stampandolo sulla console, scrivendolo su un file, ecc.).
 * Il metodo print con un Iterable di WritableElement permette di scrivere una collezione di elementi, 
 * scrivendo ciascun elemento individualmente.
 */
public interface AbstractWriter{

    public void print(WritableElement t);

    public default void print(Iterable<WritableElement> list) {
        for (WritableElement t : list) {
            print(t);
        }
    }
}
