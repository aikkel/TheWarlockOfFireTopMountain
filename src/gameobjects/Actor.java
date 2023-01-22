package gameobjects;

//any moveable characters - Actor defines the player and any movable characters
public class Actor extends ThingHolder implements java.io.Serializable {

    private Room room; // the Room where the Person is at present

    public Actor(String aName, String aDescription, int aCurrentSkill, int aMaxSkill, int aCurrentStamina, int aMaxStamina, int aCurrentLuck, int aMaxLuck, ThingList tl, Room aRoom) {
        super(aName, aDescription, aCurrentSkill, aMaxSkill, aCurrentStamina, aMaxStamina, aCurrentLuck, aMaxLuck, tl); // init super class
        this.room = aRoom;

    }

    public void setRoom(Room aRoom) {
        this.room = aRoom;
    }
    public Room getRoom() {
        return this.room;
    }
}