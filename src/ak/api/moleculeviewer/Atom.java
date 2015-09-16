package ak.api.moleculeviewer;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 15/09/2015.
 */
public class Atom {


    public enum AtomType{

    //Symbol, Rel. Atomic Mass, Group Number,

    CARBON ("C", 12, 4),
    HYDROGEN ("H", 1, 1),
    CHLORINE ("Cl", 35.5, 7),
    NITROGEN ("N", 14, 5);

    private String symbol = null;
    private double relMass;
    private int groupNum;

    private double atomicMass(){ return relMass;}
    private int getGroupNum(){ return groupNum;}
    private String getSymbol(){ return symbol;}

        AtomType(String Symbol, double mass, int groupNumber){
            this.symbol = Symbol;
            this.relMass = mass;
            this.groupNum = groupNumber;
        }

    }

    AtomType type;

    public Atom(AtomType type){
        this.type = type;
    }



}
