package gameobjects;

//Denne classe er for possible objects og disse object er UDELUKKENDE items man kan tage på sig
public class Treasure extends Thing implements java.io.Serializable{
    /*
    This is a very simple example of a subclass of the Thing class.
    Treasure adds on an int value and a get accessor but not a set
    accessor since the value of each Treasure never varies - it is
    set just once when the object is constructed.
    */

//possible potions - altså potions man kan drikke
    public Treasure(String aName,String aDescription, int aCurrentSkill, int aMaxSkill, int aCurrentStamina, int aMaxStamina, int aCurrentLuck, int aMaxLuck, int aCharges) {
        super(aName, aDescription, aCurrentSkill, aMaxSkill, aCurrentStamina, aMaxStamina, aCurrentLuck, aMaxLuck, aCharges); // init superclass
    }
}