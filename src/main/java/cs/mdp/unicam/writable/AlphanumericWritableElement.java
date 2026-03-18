package cs.mdp.unicam.writable;

public class AlphanumericWritableElement extends FixedWritableElement {

    public AlphanumericWritableElement(WritableElement element) {
        super(element);
    }

    @Override
    public String getFixedString(String s) {
        return s.chars()
        .filter(a -> Character.isAlphabetic(a))
        .mapToObj(x -> "" + x)
        .reduce((a, b) -> a + b).orElse("");
    }

}