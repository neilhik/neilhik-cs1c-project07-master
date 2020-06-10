package hashTables;
import cs1c.SongEntry;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TableGenerator {
    //Tables for tableOfSongIDs and tableOfSongGenres
    private FHhashQPwFind <Integer,SongCompInt> tableByID ;
    private FHhashQPwFind <String,SongsCompGenre> tableByGenre ;
    private ArrayList<String> genres = new ArrayList<>();
    public TableGenerator()
    {
        tableByID = new FHhashQPwFind<>();
        tableByGenre = new FHhashQPwFind<>();
        genres = new ArrayList<>();

    }
    //Write the method populateIDtable(), which populates the tableOfIDs hash table.
    public FHhashQPwFind <Integer,SongCompInt> populateIDtable(SongEntry[] allSongs) {
        for (SongEntry e : allSongs)
        {
            SongCompInt newWrapper = new SongCompInt (e);
            tableByID.insert(newWrapper);
        }
        return tableByID;
    }
    //Write the method populateGenreTable(), which populates the tableOfGenres hash table and ArrayList of genre names.
    public FHhashQPwFind<String, SongsCompGenre> populateGenreTable(SongEntry[] allSongs)
    {
        SongsCompGenre current;

        for (SongEntry x : allSongs) {

            try {
                current = tableByGenre.find(x.getGenre());
                current.addSong(x);
            }
            catch (NoSuchElementException e)
            {
                SongsCompGenre newGenre = new SongsCompGenre(x.getGenre());
                newGenre.addSong(x);
                tableByGenre.insert(newGenre);
                genres.add(newGenre.getName());
            }
        }
        return tableByGenre;
    }
    public ArrayList<String> getGenreNames() {
        return genres;
    }
}
