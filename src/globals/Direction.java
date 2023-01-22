package globals;

public enum Direction {
    //the enum class is not subject to change, much like using the final
    NORTH,
    SOUTH,
    EAST,
    WEST;
    /*
        NOEXIT has an integer value which is convenient when initializing the
        'Exit' fields in Room objects. All valid exists indicate a Room number
        whereas NOEXIT is -1.
    */
    public static final int NOEXIT = -1;
}