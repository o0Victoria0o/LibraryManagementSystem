package theStuff;

import java.util.ArrayList;
import java.util.List;


public class PileOfStuff{    
    private ArrayList<ThisStuff> theStuff = new ArrayList<ThisStuff>();

    public boolean addThisStuff (ThisStuff ThisStuff) {
        if (ThisStuff == null){
            return false;
        }
        if (findThisStuff(ThisStuff.getStuffId()) != null) {
            return false;
        }

        theStuff.add(ThisStuff);
        return true;
    }

    public ThisStuff findThisStuff(String StuffId){
        for (ThisStuff s : theStuff){
            if (s.getStuffId().equals(StuffId)){
                return s;
            }
        }
        return null;
    }


    public boolean removeThisStuff(String StuffId){
        ThisStuff stuff = findThisStuff(StuffId);

            if (stuff != null){
                theStuff.remove(stuff);
                return true;
            }
        
        return false;
    }
    public List<ThisStuff> getAlltheStuff(){
        return new ArrayList<>(theStuff);
    }

    public int getThisStuffCount(){
        return theStuff.size();
    }
}
