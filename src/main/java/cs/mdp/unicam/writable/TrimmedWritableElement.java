package cs.mdp.unicam.writable;

import java.util.Arrays;

/**
 * Una implementazione di WritableElement che estende FixedWritableElement e fornisce una logica di trimming 
 * per ogni riga della stringa da scrivere. Rimuove spazi bianchi all'inizio e alla fine di ogni riga.
 */
public class TrimmedWritableElement extends FixedWritableElement {

    public TrimmedWritableElement(WritableElement element) {
        super(element);
    }

    @Override
    public String getFixedString(String s) {
        return Arrays.asList(s.split("\n")).stream()
        .map(String::trim)
        .filter(a -> !a.isEmpty())
        .reduce((a, b) -> a + "\n" + b).orElse("");
    }

}
