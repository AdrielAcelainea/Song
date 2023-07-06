package sg.edu.rp.c346.id22016845.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {
    ListView songList;
    ArrayAdapter<String> songStuff;
    ArrayList<String> songg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        songList=findViewById(R.id.listing);
        DBHelper db = new DBHelper(SongList.this);
        db.close();
        DBHelper listdb = new DBHelper(SongList.this);
        songg=listdb.getSongContent();
        listdb.close();
        songStuff=new ArrayAdapter<>(SongList.this, android.R.layout.simple_list_item_1,songg);
        songList.setAdapter(songStuff);
    }
}