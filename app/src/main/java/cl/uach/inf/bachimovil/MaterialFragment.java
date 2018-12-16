package cl.uach.inf.bachimovil;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialFragment extends Fragment implements AsyncResponse {
    String response;
    String usr;
    TextView mostrarConsultaM;
    Button btnConsultarM;

    SearchView searchView;
    CustomAdapter customAdapter;
    public static ArrayList<Material> resultList;

    public static String globalQuery; //esto solo existe para probar la busqueda antes que backend la implemente en servicio.

    View view;

    public MaterialFragment() {
        // Required empty public constructor
    }


    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_material, container, false);

        mostrarConsultaM = view.findViewById(R.id.resultadoConsultaM);
        btnConsultarM = view.findViewById(R.id.btnConsultaM);

        searchView= (SearchView) view.findViewById(R.id.search_mat);
        searchView.setQueryHint("Busqueda");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            @RequiresApi(api = Build.VERSION_CODES.N)
            public boolean onQueryTextSubmit(String query) {

                //Toast.makeText(getActivity(), query, Toast.LENGTH_LONG).show();
                globalQuery=query;
                searchView.setQuery("", false);
                searchView.clearFocus();

                getMaterials(query);

                //Intent intent = new Intent(getActivity(), ShowResults.class);
                //startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Toast.makeText(getActivity(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {
        if(v.getId() == R.id.btnConsultaM) {

            int randomNum = (int) (24*Math.random()+1);
            globalQuery="all"; //esto es para probar
            ServiceManager serviceManager = new ServiceManager(this.getActivity(),this);
            //serviceManager.callService("http://146.83.216.206/info104/getMaterials.php?tags=");
            serviceManager.callService("http://146.83.216.206/info104/getMaterialsV0.php");

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getMaterials(String searchTags) {

        int randomNum = (int) (24*Math.random()+1);
        //Toast.makeText(getActivity(), "Funciono", Toast.LENGTH_LONG).show();
        ServiceManager serviceManager = new ServiceManager(this.getActivity(),this);
        //serviceManager.callService("http://146.83.216.206/info104/getMaterials.php?tags=");
        serviceManager.callService("http://146.83.216.206/info104/getMaterialsV0.php");


    }

    @Override
    public void obtainServiceResult(JSONObject jsonObject) {
        try
        {
            JSONArray jsonArray = jsonObject.getJSONArray("materials");
            ArrayList<Material> materiales = new ArrayList<Material>();
            for(int i=0;i<jsonArray.length();i++){
                Material material = new Material();
                material.setName(jsonArray.getJSONObject(i).getString("name"));
                material.setUrl(jsonArray.getJSONObject(i).getString("url"));
                material.setDate(jsonArray.getJSONObject(i).getString("dateCreated"));
                material.setUserId(jsonArray.getJSONObject(i).getString("userId"));
                material.setType(jsonArray.getJSONObject(i).getString("type"));
                material.setDescription(jsonArray.getJSONObject(i).getString("description"));
                material.setMaterialId(jsonArray.getJSONObject(i).getString("materialId"));
                ArrayList<String> tagList = new ArrayList<String>();
                JSONArray tagArray = jsonArray.getJSONObject(i).getJSONArray("tags");
                int len;
                if (tagArray == null) {len=0;}
                else {len=tagArray.length();}
                System.out.println(len);
                for(int j=0;j<len;j++){
                    tagList.add(tagArray.getString(j));
                }
                material.setTags(tagList);
                materiales.add(material);
            }
            //busqueda implementada para prueba, en version vinal esto se hace en el servicio
            if (globalQuery.equalsIgnoreCase("all")){}
            else {
                String[] busqueda = globalQuery.split(" ");
                ArrayList<Material> temp = new ArrayList<Material>();
                for(int i=0;i<materiales.size();i++){
                    boolean agregar=false;
                    for (int j=0; j<materiales.get(i).getTags().size();j++){
                        for (String s:busqueda){
                            if (s.equalsIgnoreCase(materiales.get(i).getTags().get(j))){
                                agregar=true;
                            }
                        }
                        if (agregar==true){
                            temp.add(materiales.get(i));
                        }
                    }
                }
                materiales=temp;
            }
            //termina busqueda de prueba
            resultList=materiales;
            if (resultList.size()>0){
                Intent intent = new Intent(getActivity(), ShowResults.class);
                startActivity(intent);
            }
            else{
                mostrarConsultaM.setText("No se encontraron resultados");
            }



        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
