package cs.mdp.unicam.writer;

import java.util.ArrayList;
import java.util.List;

import cs.mdp.unicam.writable.WritableElement;

public class StdOutWriter extends AbstractCustomizedWriter {

    private final List<FixingWritingOption> options;

    public StdOutWriter(List<FixingWritingOption> options){
        this.options = new ArrayList<>();
        options.forEach(this.options::add);
    }

    @Override
    public void print(WritableElement t) {
        for (FixingWritingOption op : options) {
            t = applyOption(t, op);
        }
        System.out.println(t.getStringToWrite());
    }

}
