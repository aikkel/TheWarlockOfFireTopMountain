package gameobjects;
import java.util.ArrayList;
import gameobjects.Thing;

//Thinglist: er en form for list for treasure objects, hvor disse lists kan blive put i rum
public class ThingList extends ArrayList<Thing> implements java.io.Serializable{

    public String describeThings() {
        String s = "";
        if (this.size() == 0) {
            s = "nothing.\n";
        } else {
            for (Thing t : this) {
                s = s + t.getName() + ": " + t.getDescription() + "\n";
            }
        }
        return s;
    }

    public Thing thisOb(String aName) {
        Thing athing = null;
        String thingName = "";
        String aNameLowCase = aName.trim().toLowerCase();
        for (Thing t : this) {
            thingName = t.getName().trim().toLowerCase();
            if (thingName.equals(aNameLowCase)) {
                athing = t;
            }
        }
        return athing;
    }
}