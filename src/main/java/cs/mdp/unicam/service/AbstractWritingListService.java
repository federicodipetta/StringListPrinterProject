package cs.mdp.unicam.service;

import java.util.List;

/**
 * Questa interfaccia rappresenta un servizio di scrittura generico
 */
public interface AbstractWritingListService<E> {

    /**
     * Scrive tutti gli elementi della lista tramite lo scrittore appropriato
     * @param elements
     */
    public void writeAll(List<E> elements);

}
