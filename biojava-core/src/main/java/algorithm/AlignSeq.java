package algorithm;

import java.io.File;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import org.biojava.nbio.core.sequence.template.AbstractSequence;
import org.biojava.nbio.core.sequence.template.Compound;


class AlignSeq {

    private AbstractSequence<Compound> seq1 = null, seq2 = null;
    // private DPMatrix dp;
    private Alignment align;

    public AlignSeq(File f1, File f2) throws CompoundNotFoundException {

        // LinkedHashMap<String, AbstractSequence<Compound>> map1, map2;
        Collection<AbstractSequence<Compound>> col1, col2;
        col1 = readAnySequence(f1);
        col2 = readAnySequence(f2);
        if ((col1 == null) || (col2 == null))
            return;

        // We expect just one protein sequence in each map
        seq1 = firstSeq(col1);
        seq2 = firstSeq(col2);

        DPMatrix dp = new DPMatrix1(seq1, seq2);
        align = dp.getAlignment();

        // Profile here
        // System.out.println("Profile");
    }

    private Collection<AbstractSequence<Compound>> readAnySequence(File f) throws CompoundNotFoundException {

        // Try DNA first
        try { 
            // LinkedHashMap<String, DNASequence> tmap;
        	
            LinkedHashMap tmap = FastaReaderHelper.readFastaDNASequence(f);
            System.out.println(tmap);
            System.out.println(tmap.values());
            if (tmap != null)
                return tmap.values();
        }
        catch (Exception e) {
            // Fall through to read protein
        }

        try {
            LinkedHashMap tmap = FastaReaderHelper.readFastaProteinSequence(f);
            if (tmap != null)
                return tmap.values();
        }
        catch (Exception e) {
            System.out.println("read exception: " + e);
        }

        return null;
    }

    private AbstractSequence<Compound> firstSeq(Collection<AbstractSequence<Compound>> col) {

        // Collection<AbstractSequence<Compound>> col = map.values();
        Iterator<AbstractSequence<Compound>> it = col.iterator();
        if (!it.hasNext()) {
            return null;
        }
//System.out.println(it.next());
        return it.next();
    }

    Alignment getAlign() {

        return align;
    }

}


