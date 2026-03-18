package cs.mdp.unicam.service;

import java.util.List;

import cs.mdp.unicam.writable.WritableBasicElement;
import cs.mdp.unicam.writable.WritableElement;
import cs.mdp.unicam.writer.AbstractListWriterFactory;
import cs.mdp.unicam.writer.AbstractWriter;
import cs.mdp.unicam.writer.StdOutListWriterFactory;

public class WritingStdStringListService implements AbstractWritingListService<String> {

    @Override
    public void writeAll(List<String> elements) {
        AbstractListWriterFactory factory = new StdOutListWriterFactory();
        AbstractWriter writer = factory.create();
        List<WritableElement> we = elements.stream().map(e -> getElementFromString(e)).toList();
        writer.print(we);
    }

    private WritableElement getElementFromString(String s){
        return new WritableBasicElement(s);
    }

}
