package cl.uach.inf.bachimovil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UploadMaterial extends AppCompatActivity {
    private boolean completo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_material);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.floatingActionButton) {
            completo=true;
            Material material=new Material();


            EditText edit = (EditText)findViewById(R.id.nameinfo);
            String info = edit.getText().toString();
            if(info.replaceAll(" ","").length()==0){completo=false;}
            material.setName(info);
            edit.setText("");

            edit = (EditText)findViewById(R.id.urlinfo);
            info = edit.getText().toString();
            if(info.replaceAll(" ","").length()==0){completo=false;}
            material.setUrl(info);
            edit.setText("");

            edit = (EditText)findViewById(R.id.typeinfo);
            info = edit.getText().toString();
            if(info.replaceAll(" ","").length()==0){completo=false;}
            material.setType(info);
            edit.setText("");

            edit = (EditText)findViewById(R.id.taginfo);
            info = edit.getText().toString();
            if(info.replaceAll(" ","").length()==0){completo=false;}
            material.setTags(new ArrayList<String>(Arrays.asList(info.split(" "))));
            edit.setText("");

            edit = (EditText)findViewById(R.id.descinfo);
            info = edit.getText().toString();
            material.setDescription(info);
            edit.setText("");

            Time today = new Time(Time.getCurrentTimezone());
            today.setToNow();
            material.setDate(""+today.monthDay+"-"+(today.month+1)+"-"+today.year);

            findViewById(R.id.mainLayout).requestFocus();

            if(completo){
                ShowResults.shownObject=material;
                startActivity(new Intent(UploadMaterial.this, ShowMaterial.class));
            }
            else{
                Toast.makeText(UploadMaterial.this,"HAY CAMPOS INCOMPLETOS", Toast.LENGTH_LONG).show();
            }




        }


    }


}
