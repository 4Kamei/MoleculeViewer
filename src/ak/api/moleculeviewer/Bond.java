package ak.api.moleculeviewer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 15/09/2015.
 */
public class Bond {

    //Properties
    private BondType bondType;
    private Atom root;
    private Atom extension;

    /**
     * Constructor for the bond, an error gets thrown if the atoms are the same or are null
     * @param firstAtom the first atom for the bond
     * @param secondAtom the second atom for the bond
     * @param type the type of the bond
     */
    public Bond(Atom firstAtom, Atom secondAtom, BondType type){
        if(firstAtom == secondAtom)
            throw new IllegalArgumentException("Both atoms cannot be the same");
        if(firstAtom == null || secondAtom == null)
            throw new IllegalArgumentException("One of the atoms is null");
        if(type == null)
            throw new IllegalArgumentException("Bond type is null");
        root = firstAtom;
        extension = secondAtom;
        bondType = type;
    }

    /**
     * Returns the strength of the bond
     * @return BondType - strength of the bond
     */
    public BondType getBondType() {
        return bondType;
    }

    /**The function to get the other atom of the bond, since a bond can only exists between two atoms.
     *
     * @param atom - the atom to be removed.
     * @return Atom - the other atom from the bond
     */
    public Atom getOtherAtom(Atom atom){
        if(atom != root && atom != extension)
            throw new NullPointerException(atom + " does not exist in bond " + this);
        if(atom == extension)
            return root;
        else
            return extension;
    }

    /**
     *
     * @return the two atoms that form the bond.
     */
    public ArrayList<Atom> getAtoms(){
        ArrayList<Atom> atoms = new ArrayList<Atom>(2);
        atoms.add(root);
        atoms.add(extension);
        return atoms;
    }

}
