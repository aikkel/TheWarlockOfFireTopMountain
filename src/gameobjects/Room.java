package gameobjects;

public class Room extends ThingHolder implements java.io.Serializable{

    private int n, s, e, w;

    public int ChoiseForStatsSwitch;

    //player
    public Room(String aName, String aDescription, int aN, int aS, int aE, int aW, ThingList tl, int aChoiseForStatsSwitch) {
        super(aName, aDescription, tl); // init superclass
        this.n = aN;
        this.s = aS;
        this.e = aE;
        this.w = aW;
        this.ChoiseForStatsSwitch = aChoiseForStatsSwitch;
    }
    // --- accessor methods ---
    // n
    public int getN() {
        return n;
    }

    public void setN(int aN) {
        this.n = aN;
    }

    // s
    public int getS() {
        return s;
    }

    public void setS(int aS) {
        this.s = aS;
    }

    // e
    public int getE() {
        return e;
    }

    public void setE(int aE) {
        this.e = aE;
    }

    // w
    public int getW() {
        return w;
    }

    void setW(int aW) {
        this.w = aW;
    }

    public String describe() {
        return String.format("%s. %s.",
                getName(), getDescription())
                + "\nThings here:\n" + getThings().describeThings();
    }
    public String describeRoomWithoutItems() {
        return String.format("%s. %s.",
                getName(), getDescription());
    }
}
