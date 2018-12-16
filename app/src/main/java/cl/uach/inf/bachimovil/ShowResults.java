package cl.uach.inf.bachimovil;

import android.os.Bundle;
import android.app.Activity;

import java.util.ArrayList;

public class ShowResults extends Activity {

    public static ArrayList<Material> modelArrayList;
    public static ArrayList<Material> resultList;
    private CustomAdapter customAdapter;
    private String[] fruitlist = new String[]{"Apples", "Oranges", "Potatoes", "Tomatoes","Grapes","a","b","c","d","e","f"};

    private ArrayList<Material> getModel(){
        ArrayList<Material> list = new ArrayList<>();
        for(int i = 0; i < fruitlist.length; i++){

            Material model = new Material();
            model.setNumber(1);
            model.setName(fruitlist[i]);
            model.setUrl(""+(i+1));
            model.setDate(""+(i+2));
            model.setDescription((i+3)+" "+(i+4)+" "+(i+5)+" "+(i+6)+" "+(i+7));
            list.add(model);
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
    }

}
