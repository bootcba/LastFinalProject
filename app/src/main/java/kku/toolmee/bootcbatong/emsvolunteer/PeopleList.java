package kku.toolmee.bootcbatong.emsvolunteer;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DELL on 13/11/2560.
 */

public class PeopleList extends ArrayAdapter<People> {
    private Activity context;
    private List<People> peopleList;

    public  PeopleList(Activity context, List<People> peoples){
        super(context,R.layout.listview_people,peoples);
        this.context = context;
        this.peopleList = peoples;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View ListViewItem = inflater.inflate(R.layout.listview_people,null,true);
        TextView textViewName = (TextView) ListViewItem.findViewById(R.id.textViewName);
        TextView textViewLName = (TextView) ListViewItem.findViewById(R.id.textViewLname);
        TextView textViewIdgard = (TextView) ListViewItem.findViewById(R.id.textViewIdgard);
        TextView textViewDisase = (TextView) ListViewItem.findViewById(R.id.textViewDisease);
        TextView textViewBeallergic = (TextView) ListViewItem.findViewById(R.id.textViewBe_allergic);
        TextView textViewDrug = (TextView) ListViewItem.findViewById(R.id.textViewDrug);
        TextView textViewTel = (TextView) ListViewItem.findViewById(R.id.textViewTel);



        People people = peopleList.get(position);
        textViewName.setText(people.getName());
        textViewLName.setText(people.getLname());
        textViewIdgard.setText(people.getIdgard());
        textViewDisase.setText(people.getDisease());
        textViewBeallergic.setText(people.getBe_allergic());
        textViewDrug.setText(people.getDrug());
        textViewTel.setText(people.getTel());

        return ListViewItem;
    }
}
