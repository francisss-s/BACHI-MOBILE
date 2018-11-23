package cl.uach.inf.bachimovil;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment implements AsyncResponse {
    ListView viewCourseList;
    View view;
    ArrayList<String> getListCourse;

    public CoursesFragment() {
        // Required empty public constructor
        getListCourse = new ArrayList<String>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cursos, container, false);
        viewCourseList = (ListView) view.findViewById(R.id.lvMyCourse);

        //getCourseList();

        ServiceManager serviceManager = new ServiceManager(this.getActivity(),this);
        serviceManager.callService("http://vulzgaming.com/getcourse.php");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(CoursesFragment.this.getActivity(), android.R.layout.simple_list_item_1, getListCourse);
        viewCourseList.setAdapter(adaptador);

        return view;
    }

    public void getCourseList() {
        getListCourse = new ArrayList<String>();
        ServiceManager serviceManager = new ServiceManager(this.getActivity(),this);
        serviceManager.callService("http://vulzgaming.com/getcourse.php");
    }

    @Override
    public void obtainServiceResult(JSONObject jsonObject) {
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("course");
            for(int i=0;i<jsonArray.length();i++){
                getListCourse.add(jsonArray.getJSONObject(i).getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}