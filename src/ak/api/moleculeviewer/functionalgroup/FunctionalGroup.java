package ak.api.moleculeviewer.functionalgroup;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 21/09/2015.
 */
public class FunctionalGroup {

    private FunctionalGroupType type;

    public FunctionalGroup(FunctionalGroupType type){
        this.type = type;
    }

    public FunctionalGroupType getType(){
        return type;
    }


}
