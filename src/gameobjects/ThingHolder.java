package gameobjects;

//Thingholder is a thing that CAN contain a list of other things  (fx rooms, players, treasurechest)
public class ThingHolder extends Thing implements java.io.Serializable{

    private ThingList things = new ThingList( );

    public ThingHolder() {

    }

    //for chests, closets, pots, obs.
    public ThingHolder(String aName, String aDescription, ThingList tl) {
        super(aName, aDescription);
        things = tl;
    }
    //for player
    public ThingHolder(String aName, String aDescription, int aCurrentSkill, int aMaxSkill, int aCurrentStamina, int aMaxStamina, int aCurrentLuck, int aMaxLuck, ThingList tl) {
        super(aName, aDescription, aCurrentSkill, aMaxSkill, aCurrentStamina, aMaxStamina, aCurrentLuck, aMaxLuck);
        things = tl;
    }

    //for enemy
    public ThingHolder(String aName, String aDescription, int aCurrentSkill, int aCurrentStamina) {
        super(aName, aDescription, aCurrentSkill, aCurrentStamina);

    }
    public ThingList getThings() {
        return things;
    }

    public void setThings(ThingList things) {
        this.things = things;
    }
}