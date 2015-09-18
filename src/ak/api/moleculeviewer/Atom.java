package ak.api.moleculeviewer;

import java.util.ArrayList;

/**
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
     * Method used to get all of the atoms connected with this atom
     * @return returns all atoms bonded with this atom
     */
    public ArrayList<Atom> getBondedAtoms(){
        ArrayList<Atom> atoms = new ArrayList<>(bonds.size());
        bonds.stream().forEachOrdered(bond -> atoms.add(bond.getOtherAtom(this)));
        return atoms;
    }

}
