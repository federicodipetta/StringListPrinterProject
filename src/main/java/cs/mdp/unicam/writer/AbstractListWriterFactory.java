package cs.mdp.unicam.writer;

/**
 * Questa interfaccia rappresenta una factory per creare istanze di AbstractWriter.
 */
public interface AbstractListWriterFactory {

    /**
     * Aggiunge un opzione al writer
     * @param option opzione da aggiungere
     */
    public void addSetting(FixingWritingOption option);

    /**
     * Crea il writer con le importazioni inserite
     * @return il writer con le importazioni
     */
    public AbstractWriter create();
    
}
