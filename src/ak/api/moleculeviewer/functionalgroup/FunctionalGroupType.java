package ak.api.moleculeviewer.functionalgroup;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 21/09/2015.
 */
public enum FunctionalGroupType {

    CATION (1),
    CARBOXYLIC_ACID(2),
    CARBOXYLIC_ACID_ESTER(3),
    ACID_CHLORIDE (4),
    AMIDE (5),
    NITRILE (6),
    ALDEHYDE (7),
    KETONE (8),
    ALCOHOL (9),
    THIOL (10),
    AMINE (11),
    ALKENE (12),
    ALKYNE (13);

    private int priority;
    FunctionalGroupType(int priority){
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
