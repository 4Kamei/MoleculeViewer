package ak.api.moleculeviewer;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 16/09/2015.
 */
public enum AtomType{

    //Symbol, Rel. Atomic Mass, Group Number,
    CARBON ("C", 12, 4),
    HYDROGEN ("H", 1, 1),
    CHLORINE ("Cl", 35.5, 7),
    NITROGEN ("N", 14, 5);

    private String symbol = null;
    private double relMass;
    private int groupNum;

    double atomicMass(){ return relMass;}
    int getGroupNum(){ return groupNum;}
    String getSymbol(){ return symbol;}

    AtomType(String Symbol, double mass, int groupNumber){
        this.symbol = Symbol;
        this.relMass = mass;
        this.groupNum = groupNumber;
    }

    public static AtomType getTypeBySymbol(String symbol){
        for(AtomType p : AtomType.values()){
            if(p.getSymbol().equals(symbol))
                return p;
        }
        return null;
    }
}