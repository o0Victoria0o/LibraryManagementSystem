package theGuy;

import java.util.ArrayList;
import java.util.List;

public class MultipleGuys {

private ArrayList<ThisGuy> myGuys = new ArrayList<ThisGuy>();
public boolean addMyGuy (ThisGuy newGuy) {
    if (newGuy == null || newGuy.getGuyId() == null) {
        return false;
    } for (ThisGuy oldGuy : myGuys) {
        if (oldGuy.getGuyId().equals(newGuy.getGuyId())) {
        return false;
        } 
    }
    myGuys.add(newGuy);
    return true;
}   

public ThisGuy checkMyGuy(String searchMyGuyId) {
    for (ThisGuy guyRecord : myGuys) {
        if (guyRecord.getGuyId().equals(searchMyGuyId)) {
            return guyRecord;
        }
    } return null;
}

public boolean eraseMyGuy(String targetMyGuyId) {
    ThisGuy guyToErase = checkMyGuy(targetMyGuyId);

    if (guyToErase != null) {
        myGuys.remove(guyToErase);
        return true;
    } return false;
}

public List<ThisGuy> getMyGuys(){
    return new ArrayList<>(myGuys);
}
}