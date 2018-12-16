package cl.uach.inf.bachimovil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;


    public CustomAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return ShowResults.modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ShowResults.modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);


            holder.tvFruit = (TextView) convertView.findViewById(R.id.animal);
            holder.tvnumber = (TextView) convertView.findViewById(R.id.number);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvFruit.setText(ShowResults.modelArrayList.get(position).getName());
        holder.tvnumber.setText(String.valueOf(ShowResults.modelArrayList.get(position).getLikes()));



        return convertView;
    }

    private class ViewHolder {

        private TextView tvFruit, tvnumber;

    }

}