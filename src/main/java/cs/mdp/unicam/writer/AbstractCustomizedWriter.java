package cs.mdp.unicam.writer;

import cs.mdp.unicam.writable.AlphanumericWritableElement;
import cs.mdp.unicam.writable.MonoLineWritableElement;
import cs.mdp.unicam.writable.TrimmedWritableElement;
import cs.mdp.unicam.writable.WritableElement;

public abstract class AbstractCustomizedWriter implements AbstractWriter {

    protected WritableElement applyOption(WritableElement t, FixingWritingOption op) {
        switch (op){
            case Alphanumeric: return new AlphanumericWritableElement(t);
            case MonoLine: return new MonoLineWritableElement(t);
            case Trim: return new TrimmedWritableElement(t);
        }
        throw new IllegalArgumentException("Unexpected value: " + op);
    }
}
