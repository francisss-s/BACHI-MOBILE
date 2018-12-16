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
        TextView nombre = (TextView) findViewById(R.id.nombre);
        TextView dire = (TextView) findViewById(R.id.dire);
        TextView fecha = (TextView) findViewById(R.id.fecha);
        TextView descri = (TextView) findViewById(R.id.descri);
        nombre.setText(thing.getName()+"\n");
        dire.setText(thing.getUrl()+"\n");
        fecha.setText(thing.getDate()+"\n");
        descri.setText(thing.getDescription()+"\n");

    }

}
