package ak.api.moleculeviewer;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 15/09/2015.
 */
public class Atom {

    AtomType type;

    public Atom(AtomType type){
        this.type = type;
        AtomType.CARBON.getGroupNum();
    }

}
