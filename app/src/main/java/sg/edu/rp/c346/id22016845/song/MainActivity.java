package sg.edu.rp.c346.id22016845.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText title;
    EditText singers;
    EditText year;
    RadioGroup stars;
    ArrayList<String> songs;
    Button input;
    Button showList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.editTextText);
        singers=findViewById(R.id.editTextText2);
        year=findViewById(R.id.editTextText3);
        stars=findViewById(R.id.radioGroup);
        input=findViewById(R.id.button);
        showList=findViewById(R.id.button2);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String WTitle=(title.getText().toString());
                String WSingers= (singers.getText().toString());
                int WYear=Integer.parseInt(year.getText().toString());
                int WStar=0;
                int RadioGroupId=stars.getCheckedRadioButtonId();
                if(RadioGroupId==R.id.radioButton){
                    WStar+=1;
                }else if(RadioGroupId==R.id.radioButton2){
                    WStar+=2;
                }else if(RadioGroupId==R.id.radioButton3){
                    WStar+=3;
                }else if(RadioGroupId==R.id.radioButton4){
                    WStar+=4;
                }else if(RadioGroupId==R.id.radioButton5){
                    WStar+=5;
                }
                db.insertSong(WTitle, WSingers, WYear, WStar);
            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SongList.class);
                startActivity(intent);
            }
        });
    }
}