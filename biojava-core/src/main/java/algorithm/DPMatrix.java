package algorithm;


import org.biojava.nbio.core.sequence.template.AbstractSequence;
import org.biojava.nbio.core.sequence.template.Compound;

 
public abstract class DPMatrix {
    protected final AbstractSequence<Compound> seq1;
    protected final AbstractSequence<Compound> seq2;
    
    DPMatrix(AbstractSequence<Compound> seq1,
            AbstractSequence<Compound> seq2) {
        
        this.seq1   = seq1;
        this.seq2   = seq2;
    }
    
    abstract Alignment getAlignment ();
}