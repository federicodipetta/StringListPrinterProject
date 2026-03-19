package cs.mdp.unicam.writer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class StdOutListWriterFactory implements AbstractListWriterFactory {

    private final LinkedHashSet<FixingWritingOption> options;

    public StdOutListWriterFactory(){
        options = new LinkedHashSet<>();
    }

    @Override
    public void addSetting(FixingWritingOption option) {
        options.addLast(option);
    }

    @Override
    public AbstractWriter create() {
        return new StdOutWriter(new ArrayList<>(this.options));
    }

}
