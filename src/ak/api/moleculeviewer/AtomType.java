package ak.api.moleculeviewer;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 16/09/2015.
 */
public enum AtomType{

    //Name (Symbol, Atomic Name, Atomic Mass, Proton Number
    //Main Block
    HELIUM      ("He", "Helium", 3, 2),
    LITHIUM     ("Li", "Lithium", 7, 3),
    BERYLLIUM   ("Be", "Beryllium", 9, 4),
    BORON       ("B", "Boron", 11, 5),
    CARBON      ("C", "Carbon", 12, 6),
    NITROGEN    ("N", "Nitrogen", 14, 7),
    OXYGEN      ("O", "Oxygen", 16, 8),
    FLUORINE    ("F", "Fluorine", 19, 9),
    NEON        ("Ne", "Neon", 20, 10);

    private int      atomicMass;
    private int      protonNumber;
    private String   atomicSymbol;
    private String   atomicName;

    public double getAtomicMass() {return atomicMass;}
    public int getProtonNumber() {return protonNumber;}
    public String getAtomicName() {return atomicName;}
    public String getSymbol(){ return atomicSymbol;}

    AtomType(String Symbol, String atomicName, int atomicMass, int protonNumber){
        this.atomicSymbol = Symbol;
        this.atomicName = atomicName;
        this.atomicMass = atomicMass;
        this.protonNumber = protonNumber;
    }

    public static AtomType getTypeBySymbol(String symbol){
        for(AtomType p : AtomType.values()){
            if(p.getSymbol().equals(symbol))
                return p;
        }
        return null;
    }
}