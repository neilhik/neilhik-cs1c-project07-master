package hashTables;
import cs1c.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;

public class LinearVsQuadraticComparison {
    public static int linearSearch(ArrayList<SongEntry> t, SongEntry s){
        for (int i = 0; i<t.size(); i++){
            SongEntry ts = t.get(i);
            if (s.compareTo(ts) == 0){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args)
    {

        final String DATAFILE = "resources/music_genre_subset.json";
        MyTunes m = new MyTunes();
        SongEntry [] allSongs = m.readSongsFromDataFile(DATAFILE);
        ArrayList<SongEntry> list1 = new ArrayList<SongEntry>();
        Collections.addAll(list1, allSongs);
        //System.out.println(list1);
        SongEntry st = new SongEntry("Tear On Your Shoulder", 217, "Coco Electrik", "dance and electronica", "44823");
        SongCompInt si = new SongCompInt(st);
        TableGenerator t2 = new TableGenerator();
        FHhashQPwFind <Integer,SongCompInt> t3 = t2.populateIDtable(allSongs);
        System.out.println(System.nanoTime());
        SongCompInt ts = t3.find(44823);
        System.out.println(System.nanoTime());
        System.out.println(ts);
        System.out.println(System.currentTimeMillis());
        int foundIndex = LinearVsQuadraticComparison.linearSearch(list1, st);
        System.out.println(System.currentTimeMillis());
        System.out.println(foundIndex);

    }


}
