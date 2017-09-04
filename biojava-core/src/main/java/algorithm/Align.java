package algorithm;

import java.io.File;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
/**
 * Takes input of two sequences(Protein or nucleotide) as command line args 
 */
public class Align {

    /**
     * @param args the command line arguments
     * @throws CompoundNotFoundException 
     */
    public static void main(String[] args) throws CompoundNotFoundException {

        if (args.length != 2) {
            System.out.println("Usage: align file1 file2");
            System.exit(0);
        }

        File f1 = new File(args[0]);
        File f2 = new File(args[1]);
        
        AlignSeq as = new AlignSeq(f1, f2);
        Alignment al = as.getAlign();
        System.out.println(al);
    }

}
