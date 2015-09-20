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
        atoms = new ArrayList<>();
        longestChain = new ArrayList<>();
        this.root = root;
        this.atoms.add(root);
        this.longestChain.add(root);
    }

    /**
     * Adds a bond to an atom in the existing molecule.
     * @param baseAtom the base atom from which to bond from
     * @param extension the extension atom - the second atom
     * @param bondType the strength of the bond
     * @return integer - the ID of base atom.
     */
    public void addBond(Atom baseAtom, Atom extension, BondType bondType){
        if(baseAtom == null)
            throw new IllegalArgumentException("base atom cannot be null");
        if(extension == null)
            throw new IllegalArgumentException("extension atom cannot be null");
        if(baseAtom == extension)
            throw new IllegalArgumentException("base and extension atoms cannot be the same");
        baseAtom.addBond(extension, bondType);
        atoms.add(extension);
    }

    /**
     *
     * @param baseAtom the base for the bond removal, this atom will remain after the bond is destroyed
     * @param extension the extension atom, this atom will be destroyed after the bond is removed
     */
    public void removeBond(Atom baseAtom, Atom extension) {
        if (extension == null)
            throw new IllegalArgumentException("extension atom cannot be null");
        if (extension.getBondedAtoms().containsAll(atoms))
            throw new UnsupportedOperationException("cannot remove whole chain, please use removeAllBonds");
        //TODO: Java 8 streams why are you so complicated.
        baseAtom.getBondedAtoms().remove(extension);
        atoms.stream().filter(atom -> atom != extension).collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Removes a whole chain from the molecule,
     * <code> C - C - X - C </code> if X is removed, then the molecule will end up being
     * <code> C - C </code>
     * @param baseAtom the base atom from which to unbond
     * @param extension the atom on the other side of the bond, this will be removed once the bond is broken
     */
    public void removeAllBonds(Atom baseAtom, Atom extension){
        if (extension == null)
            throw new IllegalArgumentException("extension atom cannot be null");
        //TODO: Write recursive function to through the whole bond 'tree' and remove starting from the top
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
