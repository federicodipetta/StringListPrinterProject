package cs.mdp.unicam.writable;

import java.util.Arrays;

public class MonoLineWritableElement  extends FixedWritableElement {

    public MonoLineWritableElement(WritableElement element) {
        super(element);
    }

    @Override
    public String getFixedString(String s) {
        return Arrays.asList(s.split("\n")).stream()
        .filter(a -> !a.isEmpty())
        .reduce((a, b) -> a + " " + b).orElse("");
    }

}
