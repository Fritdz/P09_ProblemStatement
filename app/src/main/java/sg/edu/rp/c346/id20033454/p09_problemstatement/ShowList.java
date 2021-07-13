package sg.edu.rp.c346.id20033454.p09_problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    Button btn5Star;
    ListView lvSongs;
    ArrayList<Song> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        btn5Star=findViewById(R.id.btn5Star);
        lvSongs=findViewById(R.id.lvSongs);


        DBHelper dbh = new DBHelper(ShowList.this);

        al = new ArrayList<Song>();
        al.addAll(dbh.getAllSongs());
        aa= new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1,al);
        lvSongs.setAdapter(aa);

        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter ="";
                al.clear();
                al.addAll(dbh.getAllSongs(filter));
                aa.notifyDataSetChanged();
            }
        });
    }
}