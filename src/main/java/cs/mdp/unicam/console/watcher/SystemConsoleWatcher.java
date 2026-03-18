package cs.mdp.unicam.console.watcher;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Un'implementazione di AbstractConsoleWatcher che cattura l'output prodotto da un Runnable 
 * reindirizzando temporaneamente System.out a un ByteArrayOutputStream.
 * Dopo l'esecuzione del Runnable, ripristina System.out al suo stato originale 
 * e restituisce l'output catturato come una lista di stringhe, con ogni stringa rappresentante una riga dell'output.
 */
public class SystemConsoleWatcher implements AbstractConsoleWatcher {

    @Override
    public List<String> capture(Runnable runnable) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return getAndCleanOutput(baos);
    }

    private List<String> getAndCleanOutput(ByteArrayOutputStream baos) {
        return Arrays.stream(baos.toString().split(System.lineSeparator()))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .toList();
    }

}
