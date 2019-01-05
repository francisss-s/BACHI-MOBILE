package cl.uach.inf.bachimovil;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class ShowMaterial extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_material);
        Material thing = ShowResults.shownObject;
        TextView nombre = (TextView) findViewById(R.id.nameinfo);
        TextView dire = (TextView) findViewById(R.id.urlinfo);
        TextView fecha = (TextView) findViewById(R.id.dateinfo);
        TextView descri = (TextView) findViewById(R.id.descinfo);
        TextView tipo = (TextView) findViewById(R.id.typeinfo);
        nombre.setText(thing.getName());
        dire.setText(thing.getUrl());
        fecha.setText(thing.getDate());
        descri.setText(thing.getDescription());
        tipo.setText(thing.getType());

    }

}
