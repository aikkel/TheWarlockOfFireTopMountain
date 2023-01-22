package gameobjects;

//Thing er en ancestor af alle andre klasser
public class Thing implements java.io.Serializable{

    // Basic Thing type that defines all objects in the Adventure
    public String name;
    public String description;

    //Attack Damage
    private int currentSkill;
    private int maxSkill;

    //health
    private int currentStamina;
    private int maxStamina;

    private int currentLuck;
    private int maxLuck;

    private int charges;

    public Thing() {

    }

    //Possible objects
    public Thing(String aName,String aDescription){
        this.name=aName;
        this.description=aDescription;
    }

    //Til player
    public Thing(String aName,String aDescription, int aCurrentSkill, int aMaxSkill, int aCurrentStamina, int aMaxStamina, int aCurrentLuck, int aMaxLuck){
        this.name=aName;
        this.description=aDescription;
        this.currentSkill=aCurrentSkill;
        this.maxSkill=aMaxSkill;
        this.currentStamina=aCurrentStamina;
        this.maxStamina=aMaxStamina;
        this.currentLuck = aCurrentLuck;
        this.maxLuck=aMaxLuck;
    }

    //til enemy
    public Thing(String aName,String aDescription, int aCurrentSkill, int aCurrentStamina){
        this.name=aName;
        this.description=aDescription;
        this.currentSkill=aCurrentSkill;
        this.currentStamina=aCurrentStamina;
    }

    //til items
    public Thing(String aName,String aDescription, int aCurrentSkill, int aMaxSkill, int aCurrentStamina, int aMaxStamina, int aCurrentLuck, int aMaxLuck, int aCharges ){
        this.name=aName;
        this.description=aDescription;
        this.currentSkill=aCurrentSkill;
        this.maxSkill=aMaxSkill;
        this.currentStamina=aCurrentStamina;
        this.maxStamina=aMaxStamina;
        this.currentLuck = aCurrentLuck;
        this.maxLuck=aMaxLuck;
        this.charges=aCharges;
    }

    public String getName() {
        return name;
    }
    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public int getCurrentSkill() {
        return currentSkill;
    }
    public void setCurrentSkill(int aCurrentSkill) {
        this.currentSkill = aCurrentSkill;
    }

    public int getCurrentStamina() {
        return currentStamina;
    }
    public void setCurrentStamina(int aCurrentStamina) {
        this.currentStamina = aCurrentStamina;
    }

    public int getMaxSkill() {
        return maxSkill;
    }
    public void setMaxSkill(int aMaxSkill) {
        this.maxSkill = aMaxSkill;
    }

    public int getMaxStamina() {
        return maxStamina;
    }
    public void setMaxStamina(int aMaxStamina) {
        this.maxStamina = aMaxStamina;
    }

    public int getCurrentLuck() {
        return currentLuck;
    }
    public void setCurrentLuck(int aCurrentLuck) {
        this.currentLuck = aCurrentLuck;
    }

    public int getMaxLuck() {
        return maxLuck;
    }
    public void setMaxLuck(int aMaxLuck) {
        this.maxLuck = aMaxLuck;
    }

    public int getCharges() {
        return charges;
    }
    public void setCharges(int charges) {
        this.charges = charges;
    }
}