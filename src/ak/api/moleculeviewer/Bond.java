package ak.api.moleculeviewer;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 15/09/2015.
 */
public class Bond {

    public enum BondType{
        SINGLE,
        DOUBLE,
        TRIPLE
    }
    //Properties
    private BondType bondType;
    private ArrayList<Atom> atoms = new ArrayList<>(2);

    /**
     * Constructor for the bond, an error gets thrown if the atoms are the same, are null
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
        atoms.add(firstAtom);
        atoms.add(secondAtom);
        bondType = type;
    }

    public BondType getBondType() {
        return bondType;
    }

    /**The function to get the other atom of the bond, since a bond can only exists between two atoms.
     *
     * @param atom - the atom to be removed.
     * @return Atom - the other atom from the bond
     */
    public Atom getOtherAtom(Atom atom){
        if (!atoms.contains(atom))
            throw new IllegalArgumentException(atoms + "doesn't contain " + atom);
        return atoms.stream().filter(a -> a != atom).collect(Collectors.toList()).get(0);
    }

    /**
     *
     * @return the two atoms that form the bond.
     */
    public ArrayList<Atom> getAtoms(){
        return atoms;
    }

}
