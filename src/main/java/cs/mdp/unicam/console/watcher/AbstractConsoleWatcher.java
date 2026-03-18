package cs.mdp.unicam.console.watcher;

import java.util.List;

/**
 * Questa interfaccia rappresenta un watcher per la console, che permette di catturare l'output prodotto da un Runnable.
 * Il metodo capture esegue il Runnable e restituisce una lista di stringhe rappresentantio l'output catturato, 
 * con ogni stringa rappresentante una riga dell'output.
 */
public interface AbstractConsoleWatcher {

    public List<String> capture(Runnable runnable);

}
