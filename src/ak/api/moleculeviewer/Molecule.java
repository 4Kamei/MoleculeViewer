package ak.api.moleculeviewer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 16/09/2015.
 */
public class Molecule {

    //Parameters.
    private ArrayList<Bond> bonds;
    private ArrayList<Atom> atoms;
    private ArrayList<Atom> longestChain;
    private Atom root;

    /**
     * Constructor for the molecule, root atom needs to be specified in order to 'grow' the molecule out of.
     * root should be part of the longest chain, in order to render properly
     * @param root the root atom for the molecule.
     */
    public Molecule(Atom root){
        if(root == null)
            throw new IllegalArgumentException("Root atom cannot be null");
        //initialise bonds to a new array
        bonds = new ArrayList<>();
        atoms = new ArrayList<>();
        longestChain = new ArrayList<>();
        this.root = root;
        this.atoms.add(root);
        this.longestChain.add(root);
    }

    /**
     *
     * @param baseAtom the base for the bond removal, this atom will remain after the bond is destroyed
     * @param extension the extension atom, this atom will be destroyed after the bond is removed
     */
    public void removeBond(Atom baseAtom, Atom extension){
        if(extension == root)
            throw new IllegalArgumentException("extension atom cannot be null");
        if(extension.getBondedAtoms().containsAll(atoms))
            throw new UnsupportedOperationException("cannot remove whole chain, please use removeAllBonds");
        //TODO: Fix collector
        //Collector<Bond, ?, ArrayList<Bond>> collector = Collector.of(ArrayList::new, ArrayList::add, (list, bond) -> { list.add(bond); return list});
        //bonds = bonds.stream().filter(bond -> !bond.getAtoms().contains(extension)).collect(collector);
    }

    /**
     * Removes a whole chain from the molecule,
     * <code> C - C - X - C </code> if X is removed, then the molecule will end up being
     * <code> C - C </code>
     * @param baseAtom the base atom from which to unbond
     * @param extension the atom on the other side of the bond, this will be removed once the bond is broken
     */
    public void removeAllBonds(Atom baseAtom, Atom extension){

    }

    /**
     * Adds a bond to an atom in the existing molecule.
     * @param baseAtom the base atom from which to bond from
     * @param exension the extension atom - the second atom
     * @return integer - the ID of root atom.
     */
    public int addBond(Atom baseAtom, Atom exension, Bond.BondType bondType){
        if(baseAtom == null)
            throw new IllegalArgumentException("base atom cannot be null");
        if(exension == null)
            throw new IllegalArgumentException("extension atom cannot be null");
        if(baseAtom == exension)
            throw new IllegalArgumentException("base and extension atoms cannot be the same");

        bonds.add(new Bond(baseAtom, exension, bondType));
        return bonds.size();
    }

    /**
     * A method used to return all of the atoms in a molecule
     * @return all the atoms in the molecule,
     */
    public ArrayList<Atom> getAllAtoms(){
        return atoms;
    }

    /**
     * A method used to return the longest chain of atoms, useful if naming.
     * @return returns <code> ArrayList<Atom></code>
     */
    public ArrayList<Atom> getLongestChain(){
        return longestChain;
    }


}
