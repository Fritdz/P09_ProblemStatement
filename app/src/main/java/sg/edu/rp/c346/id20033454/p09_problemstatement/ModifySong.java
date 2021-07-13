package sg.edu.rp.c346.id20033454.p09_problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ModifySong extends AppCompatActivity {

    TextView tvTitle, tvSingers, tvYear, tvStars;
    EditText etTitle, etSingers, etYear, etId;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button btnUpdate, btnDelete, btnCancel ;
    ArrayList<Song> as;
    int rbResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvTitle=findViewById(R.id.tvTitle);
        tvSingers=findViewById(R.id.tvSingers);
        tvYear=findViewById(R.id.tvYear);
        tvStars=findViewById(R.id.tvStars);
        etTitle=findViewById(R.id.etTitle);
        etSingers=findViewById(R.id.etSingers);
        etYear=findViewById(R.id.etYear);
        etId=findViewById(R.id.etID);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
        rb5=findViewById(R.id.rb5);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnCancel=findViewById(R.id.btnCancel);

        ArrayList<Song> as = new ArrayList<Song>();
        Intent i = getIntent();
        int songPos = i.getIntExtra("id", 0);
        DBHelper dbh = new DBHelper(ModifySong.this);
        as.clear();
        as.addAll(dbh.getAllSongs());
        Song data = as.get(songPos);
        etId.setText(""+songPos);
        etTitle.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));
        int stars = data.getStars();
        if (stars==1){
            rb1.setChecked(true);
        } else if (stars==2){
            rb2.setChecked(true);
        } else if (stars==2){
            rb3.setChecked(true);
        } else if (stars==2){
            rb4.setChecked(true);
        } else if (stars==2){
            rb5.setChecked(true);
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked()){
                    rbResult=1;
                }else if (rb2.isChecked()){
                    rbResult=2;
                }else if (rb3.isChecked()){
                    rbResult=3;
                }else if (rb4.isChecked()){
                    rbResult=4;
                }else if (rb5.isChecked()){
                    rbResult=5;
                }
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int stars = rbResult;
                Song newSong = new Song(title, singers, year, stars);


                DBHelper dbh = new DBHelper(ModifySong.this);
                long inserted_id = dbh.updateSong(newSong, songPos);

                if(inserted_id != -1){
                    finish();
                }

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                long inserted_id = dbh.deleteSong(songPos);
                if(inserted_id != -1){
                    finish();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}