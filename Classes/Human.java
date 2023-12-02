package Classes;
import Enums.Location;
import Enums.ObjectType;
import Enums.determLvl;
import Interfaces.GetLocationInterface;

public class Human implements GetLocationInterface{
    private String humanName;
    private Location humanLocation;
    private int moneySpent;
    public Human(String humanName, Location humanLocation){
        this.humanName = humanName;
        this.humanLocation = humanLocation;
        this.moneySpent = 0;
    }
    public void scream(String phrase, determLvl lvl){
        System.out.println(humanName + " is screaming: " + '"' + phrase + '"' + " (" + lvl + ")");
    }
    public void tryToSleep(ObjectType object, determLvl lvl){
        System.out.println(humanName + " laid his head on the " + object + " (" + lvl + ")");
        System.out.println(humanName + " try to sleep" + " (" + lvl + ")");
    }
    public void tryToSleep(determLvl lvl){
        System.out.println(humanName + " try to sleep" + " (" + lvl + ")");
    }
    public void buy(Obj obj, determLvl lvl){
        if (lvl == determLvl.ALREADY){ this.moneySpent += obj.getCost(); }
        System.out.println(this.getName() + " buy a new " + obj.getType() + " (" + lvl + ")");
    }

    public void stopTheTrain(determLvl lvl){
         System.out.println(this.getName() + " demands to stop the train (" + lvl + ")");
    }

    public int getMoneySpent(){
        return this.moneySpent;
    }
    public String getName(){
        return this.humanName;
    }
    @Override
    public Location getLocation(){ return this.humanLocation;}
    public void Move(Location loc, determLvl lvl){
        System.out.println(this.getName() + " moves to " + loc + " (" + lvl + ")");
    }
    
    public boolean equals(Object obj){
        if (obj==null) {return false;}
        if (obj.getClass() != this.getClass()){ return false; }
        Human human = (Human) obj;
        if (this.hashCode() != human.hashCode()){ return false; }
        return (this.humanLocation == human.getLocation() && this.humanName == human.getName());
    }
    public int hashCode(){
        return this.moneySpent * this.humanName.length();
    }
    public String toString(){
        return "name: " + this.getName() + "; location: " + this.getLocation() + "; spent money: " + this.getMoneySpent();
    }

}
