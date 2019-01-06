package cl.uach.inf.bachimovil;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowMaterial extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_material);
        Material thing = ShowResults.shownObject;
        TextView dire = (TextView) findViewById(R.id.urlinfo);
        TextView fecha = (TextView) findViewById(R.id.dateinfo);
        TextView descri = (TextView) findViewById(R.id.descinfo);
        TextView tipo = (TextView) findViewById(R.id.typeinfo);
        TextView tags = (TextView) findViewById(R.id.taginfo);
        setTitle(thing.getName());
        dire.setText(thing.getUrl());
        fecha.setText(thing.getDate());
        descri.setText(thing.getDescription());
        tipo.setText(thing.getType());

        String tagString="";
        for(int i=0;i<thing.getTags().size();i++){
            tagString+=thing.getTags().get(i);
            if(i!=thing.getTags().size()-1){tagString+=", ";}
        }
        tags.setText(tagString);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.favstar) {
            String matId = ShowResults.shownObject.getMaterialId();
            boolean esta=false;
            for(int i=0;i<MaterialFragment.favList.size();i++){
                if(MaterialFragment.favList.get(i).equalsIgnoreCase(ShowResults.shownObject.getMaterialId())){
                    esta=true;
                }
            }
            if (esta){ Toast.makeText(ShowMaterial.this,"Ya esta en favoritos", Toast.LENGTH_LONG).show();}
            else{
                Toast.makeText(ShowMaterial.this,"Agregado a favoritos", Toast.LENGTH_LONG).show();
                MaterialFragment.favList.add(ShowResults.shownObject.getMaterialId());
            }

        }
        if (v.getId() == R.id.dangereport) {
            Toast.makeText(ShowMaterial.this,"Material Reportado", Toast.LENGTH_LONG).show();
            //aqui iria el servicio de reporte con el backend
        }
    }
}
