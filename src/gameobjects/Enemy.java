package gameobjects;

//TODO IKKE FÆRDIG - SKAL GIVES STATS OSV
//TODO OVERHOVEDET IKKE LAVET - KOPIERET FRA ACTOR
public class Enemy extends ThingHolder implements java.io.Serializable {

    public Enemy() {

    }

    private Room room; // the Room where the Person is at present
    private int id;
    private int item_fk;

    public Enemy(int aId, String aName, String aDescription, int aCurrentSkill, int aCurrentStamina, int aItem_fk) {
        super(aName, aDescription, aCurrentSkill, aCurrentStamina); // init super class
        this.id = aId;
        this.item_fk=aItem_fk;
    }

    public void setRoom(Room aRoom) {
        this.room = aRoom;
    }
    public Room getRoom() {
        return this.room;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getItem_fk() {
        return item_fk;
    }
    public void setItem_fk(int item_fk) {
        this.item_fk = item_fk;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "room=" + room +
                ", id=" + id +
                ", item_fk=" + item_fk +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
