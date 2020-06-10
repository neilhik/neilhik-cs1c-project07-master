package hashTables;
import cs1c.*;

public class SongCompInt implements Comparable<Integer>{
    //Contains a single SongEntry object as the attribute.
    SongEntry data;
    public SongCompInt ( SongEntry newSong){
        data = newSong;
    }
    //Declare that it implements the Comparable< ... > interface of type Integer.
    public int compareTo (Integer otherID) {
        return otherID.compareTo(data.getID()); // Reverse?
    }
    //Overrides superclass toString method. Returns string value of SongEntry data held within
    public String toString () { return data.toString();}
    //Overrides superclass equals method to compare two instances of this class by int data.id
    public boolean equals (Object o) {
        if (!(o instanceof Integer)) {
            return false;
        }
        int otherID = (Integer) o;
        return data.getID() == otherID;
    }
    //Overrides superclass hashCode method. Hashes objects by the data.id number.
    public int hashCode() {
        return data.getID();}
}
