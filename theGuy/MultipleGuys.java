package theGuy;

import java.util.ArrayList;
import java.util.List;

public class MultipleGuys {

private ArrayList<ThisGuy> myGuys = new ArrayList<ThisGuy>();

}

public boolean addMyGuy (ThisGuy newGuy) {
    if (newGuy == null || newGuy.getGuyId() == null) {
        return false;
    }
    for (ThisGuy oldGuy : myGuys) {
        if (oldGuy.getGuyId().equals(newGuy.getGuyId)))
    }
    
}