package hashTables;
import cs1c.*;
import java.util.*;

public class SongsCompGenre implements Comparable<String> {
    String name;
    ArrayList<SongEntry> data;
    //Contains an attribute of type String for the name of the genre.
    public SongsCompGenre (String genre){
        name = genre;
        data = new ArrayList<>();
    }
    //Getter methods for the attributes.
    public String getName() {

        return name;
    }
    //Contains an attribute of type ArrayList<SongEntry> for all the songs in that genre, which is our data.
    public ArrayList<SongEntry> getData() {
        return data;
    }
    //Contains the method void addSong(SongEntry e), which adds a song to the list of songs.
    public void addSong(SongEntry e)
    {
        data.add(e);
    }
    //Declare that it implements the Comparable< ... > interface of type String.
    public int compareTo(String other) {
        return name.compareTo(other);
    }
    //Overrides superclass toString method. Returns string value of SongEntry data held within
    public String toString () {
        String wholeList = "";
        for (SongEntry e : data){
            wholeList += e.toString() + "\n";
        }
        return wholeList;
    }
    //Overrides superclass equals method to compare two instances of this class by int data.id
    public boolean equals (Object o)
    { if (!(o instanceof String)) {
        return false;
    }
        String otherName = (String) o;
        return name.equals(otherName);
    }
    //Overrides superclass hashCode method. Hashes objects by the data.id number.
    public int hashCode() { return name.hashCode();}

}
