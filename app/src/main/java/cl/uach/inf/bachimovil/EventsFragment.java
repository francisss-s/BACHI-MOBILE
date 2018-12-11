package cl.uach.inf.bachimovil;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment implements AsyncResponse
{
    // 0 - Anuncios 1 - Eventos
    int state = 0;
    boolean leftMenuOn = false;
    LinearLayout leftMenu;
    HorizontalScrollView hScroll;
    View view;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_eventos, container, false);
        leftMenu = view.findViewById(R.id.LeftMenu);
        hScroll = view.findViewById(R.id.HScroll);

        hScroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });



        return view;

    }

    public void toggleLeftMenu(boolean state)
    {

        if(state)
        {
            animateMenu((int)((float)getResources().getDisplayMetrics().widthPixels * 0.8f), 128);
        }
        else
        {
            animateMenu(0, 128);
        }
        leftMenuOn = state;
    }

    public void animateMenu(int width, int duration)
    {
        ValueAnimator anim = ValueAnimator.ofInt(leftMenu.getMeasuredWidth(), width);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = leftMenu.getLayoutParams();
                layoutParams.width = val;
                leftMenu.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(duration);
        anim.start();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {

        switch (v.getId())
        {
            // Left Menu Button
            case R.id.MenuButton:
                {
                    toggleLeftMenu(!leftMenuOn);
                }
                break;
        }

        /*
        if(v.getId() == R.id.btnConsulta) {

            int randomNum = (int) (24*Math.random()+1);

            ServiceManager serviceManager = new ServiceManager(this.getActivity(),this);
            serviceManager.callService("http://146.83.216.206/info104/getMaterials.php?tags=");

        }
        */

    }

    @Override
    public void obtainServiceResult(JSONObject jsonObject) {
        try
        {

            JSONArray jsonArray = jsonObject.getJSONArray("materials");
            String text = "";
            for(int i=0;i<jsonArray.length();i++){
                text += jsonArray.getJSONObject(i).getString("url")+"\n";
            }

            //mostrarConsulta.setText(text);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
