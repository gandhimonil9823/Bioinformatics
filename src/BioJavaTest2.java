import org.biojava.nbio.structure.Structure;

import org.biojava.*;
import org.biojava.nbio.structure.gui.BiojavaJmol;
import org.biojava.nbio.structure.io.PDBFileReader;
/**
 *
 * @author peterg
 */
@SuppressWarnings("unused")
public class BioJavaTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(System.getenv("PDB_DIR"));
//      System.setProperty("PDB_DIR", "C:\\Project\\");
//    System.setProperty("PDB_CACHE_DIR", "C:\\Project\\");
//        System.out.println(System.getenv("PDB_DIR"));
        try {
            PDBFileReader pdbr = new PDBFileReader();
            pdbr.setPath("C:\\Users\\gandhimonil\\Desktop\\CS 46B Workspace\\Bioinformatics\\src")
            
            ;

            String pdbCode = "1IYJ";

            Structure struc = pdbr.getStructureById(pdbCode);
            BiojavaJmol jmolPanel = new BiojavaJmol();
            jmolPanel.setStructure(struc);

            // send some RASMOL style commands to Jmol
            jmolPanel.evalString("select *; color chain;");
            jmolPanel.evalString("select *; wireframe off; backbone 0.4;");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}