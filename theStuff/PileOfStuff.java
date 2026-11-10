package theStuff;

import java.util.ArrayList;
import java.util.List;


public class PileOfStuff{    
    private ArrayList<ThisStuff> theStuff = new ArrayList<ThisStuff>();

    public boolean addThisStuff (ThisStuff ThisStuff) {
        if (ThisStuff == null){
            return false;
        }
        if (findThisStuff(ThisStuff.getThisStuffId()) != null) {
            return false;
        }

        theStuff.add(ThisStuff);
        return true;
    }

    public ThisStuff findThisStuff(String ThisStuffId){
        for (ThisStuff s : theStuff){
            if (m.getThisStuffId().equals(ThisStuffId)){
                return s;
            }
        }
        return null;
    }


    public boolean removeThisStuff(String ThisStuffId){
        Material ThisStuff = findThisStuff(ThisStuffId);

            if (ThisStuff != null){
                theStuff.remove(ThisStuff);
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
