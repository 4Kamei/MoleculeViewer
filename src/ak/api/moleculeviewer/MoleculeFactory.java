package ak.api.moleculeviewer;

import java.util.ArrayList;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 16/09/2015.
 */
public class MoleculeFactory {

    Molecule molecule;
    /**
     * Constructor for Molecule,
     * @param root
     */
    public MoleculeFactory(AtomType root){
        molecule = new Molecule(new Atom(root));
    }


}
