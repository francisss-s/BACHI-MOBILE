package cl.uach.inf.bachimovil;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static cl.uach.inf.bachimovil.MaterialFragment.resultList;

public class ShowResults extends Activity {

    public static ArrayList<Material> modelArrayList;
    private ListView lv;
    private CustomAdapter customAdapter;
    public static Material shownObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        lv = (ListView) findViewById(R.id.lv);

        modelArrayList = MaterialFragment.resultList;
        customAdapter = new CustomAdapter(this);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                shownObject = modelArrayList.get(position);
                startActivity(new Intent(ShowResults.this, ShowMaterial.class));



            }
        });

    }

}
