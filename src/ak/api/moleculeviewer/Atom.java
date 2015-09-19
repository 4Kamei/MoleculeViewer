package ak.api.moleculeviewer;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Each atom should have a list of bond it contains that is updated whenever something happens to the other atom of the bond, this should include
 * the atom being removed -> remove bond
 * the atom removing the bond -> remove bond
 * an atom bond with this atom -> bond is created with other atom
 *    C   D
 *    |   |
 *  - A - B - E
 *    |   |
 *    F   G
 *
 *   'A' has bonds C, B, F.
 *   'B' has bonds A, D, E, G
 *   'C' has bond  A
 *   'D' has bond  B
 *   'E' has bond  B
 *   'F' has bond  A
 *   'G' has bond  B
 *
 *   If F breaks the bond then B is updated so that it no longer contains bond (B -> F) and F is updated so that it no longer contains bond (F -> B)
 *
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 15/09/2015.
 */


public class Atom {

    //parameters

    private static AtomType type;
    private ArrayList<Bond> bonds;


    public Atom(AtomType type){
        Atom.type = type;
        bonds = new ArrayList<>();
    }

    /**
     * @return type of atom
     */
    public AtomType getType() {
        return type;
    }
    /**
     * Method used to get all of the atoms connected with this atom
     * @return returns all atoms bonded with this atom
     */
    public ArrayList<Atom> getBondedAtoms(){
        ArrayList<Atom> atoms = new ArrayList<>(bonds.size());
        bonds.stream().forEachOrdered(bond -> atoms.add(bond.getOtherAtom(this)));
        return atoms;
    }

    /**
     * Removes a bond from this atom. Upon removing a bond the other bond is automatically removed
     * X -> Y is removed then Y -> X is also removed.
     * @param atom the atom to unbond from this atom
     */
    public void removeBond(Atom atom){
        if(bonds.stream().anyMatch(bond -> bond.getAtoms().contains(atom))) {
            bonds = bonds.stream().filter(bond -> bond.getOtherAtom(this) != atom).collect(Collectors.toCollection(ArrayList::new));
            atom.removeBond(this);
        }
    }

    /**
     * Bonds two atoms together. Upon making a bond with an atom the other bond is created
     * if X is bonded with Y bond <code> (X -> Y) </code> is created, (Y -> X) is also created to maintain integrity.
     * @param atom the atom to form a bond to form this atom
     */
    public void addBond(Atom atom, BondType type){
        //Stops infinite recursion
        bonds.add(new Bond(this, atom, type));
        if(!atom.getBondedAtoms().contains(this)) {
            //Recursive call to add the bond when the scope is atom
            atom.addBond(this, type);
        }
    }

}
