package cs.mdp.unicam.writer;

import java.util.LinkedList;
import java.util.List;

public class StdOutListWriterFactory implements AbstractListWriterFactory {

    private final List<FixingWritingOption> options;

    public StdOutListWriterFactory(){
        options = new LinkedList<>();
    }

    @Override
    public void addSetting(FixingWritingOption option) {
        for (FixingWritingOption op : options) {
            if(op == option) return;
        }
        options.add(option);
    }

    @Override
    public AbstractWriter create() {
        return new StdOutWriter(options);
    }

}
