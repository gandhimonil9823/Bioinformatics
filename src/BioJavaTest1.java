import java.net.URL;

import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.Alignments.PairwiseSequenceAlignerType;
import org.biojava.nbio.alignment.SimpleGapPenalty;
/*import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import org.biojava.nbio.core.*;
import org.biojava.nbio.alignment.*;
*/
import org.slf4j.*;

import org.biojava.nbio.core.alignment.matrices.SimpleSubstitutionMatrix;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;






@SuppressWarnings("unused")
public class BioJavaTest1 {

	public static void main(String[] args)
	{

		String[] ids = {"Q21691","O28951"};
		
		try
		{
			alignPairGlobal(ids[0],ids[1]);
		}
		 catch (Exception e) 
		{
	            e.printStackTrace();
	}
	}

	private static void alignPairGlobal(String id1, String id2) throws Exception
	{
		ProteinSequence s1 = getSequenceForID(id1);
		ProteinSequence s2 = getSequenceForID(id2);

		SubstitutionMatrix<AminoAcidCompound> matrix = new SimpleSubstitutionMatrix<AminoAcidCompound>(null, null);
		SequencePair<ProteinSequence, AminoAcidCompound> pair = Alignments.getPairwiseAlignment(s1,s2,PairwiseSequenceAlignerType.GLOBAL, new SimpleGapPenalty(),matrix);
		System.out.printf("%n%s vs %s%n%s",pair.getQuery().getAccession(),pair.getTarget().getAccession(), pair);


	}
	




	private static ProteinSequence getSequenceForID(String uniProtId) throws Exception
	{
		URL uniprotFasta = new URL (String.format("http://www.uniprot.org/uniprot/%s.fasta", uniProtId));
		ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(uniprotFasta.openStream()).get(uniProtId);
		System.out.printf("id : %s %s%n%s%n",uniProtId, seq, seq.getOriginalHeader());
		return seq;
	}

	
}
