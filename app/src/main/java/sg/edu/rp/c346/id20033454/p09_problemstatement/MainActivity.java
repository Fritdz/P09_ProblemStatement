package sg.edu.rp.c346.id20033454.p09_problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

    TextView tvTitle, tvSingers, tvYear, tvStars;
    EditText etTitle, etSingers, etYear;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button btnInsert, btnShow;
    ArrayList<Song> as;
    int rbResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle=findViewById(R.id.tvTitle);
        tvSingers=findViewById(R.id.tvSingers);
        tvYear=findViewById(R.id.tvYear);
        tvStars=findViewById(R.id.tvStars);
        etTitle=findViewById(R.id.etTitle);
        etSingers=findViewById(R.id.etSingers);
        etYear=findViewById(R.id.etYear);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
        rb5=findViewById(R.id.rb5);
        btnInsert=findViewById(R.id.btnInsert);
        btnShow=findViewById(R.id.btnShow);

        ArrayList<Song> as = new ArrayList<Song>();



        btnInsert.setOnClickListener(new View.OnClickListener() {
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

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title, singers, year, stars);

                if(inserted_id != -1){
                    as.clear();
                    as.addAll(dbh.getAllSongs());
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ShowList.class);
                startActivity(i);
            }
        });

    }
}