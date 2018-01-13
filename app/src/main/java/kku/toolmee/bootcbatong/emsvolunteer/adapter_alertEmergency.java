package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BOOTCABA on 15-Nov-17.
 */

public class adapter_alertEmergency extends BaseAdapter {

    Context mContext;
    String[] strDistance,strTime,straddress,strName;
    int[] imgId;


    public adapter_alertEmergency(Context context,String[] strDistance,String[] strTime,
                                  String[] straddress, String[] strName , int[] imgId){

        this.mContext = context;
        this.strDistance =  strDistance;
        this.strTime = strTime;
        this.straddress = straddress;
        this.strName = strName;
        this.imgId = imgId;
    }
    public int getCount(){
        return strDistance.length;
    }
    public Object getItem(int position){
        return null;
    }
    public long getItemId(int position){
        return 0;

    }
    public View getView(int position, View view, ViewGroup paernt){
        LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = mInflater.inflate(R.layout.adapter_alert_emergency, paernt, false);

        TextView tvDistence = (TextView)view.findViewById(R.id.textDistance);
        tvDistence.setText(strDistance[position]);
        TextView tvTime = (TextView)view.findViewById(R.id.textTime);
        tvTime.setText(strTime[position]);
        TextView tvAddress =(TextView)view.findViewById(R.id.textAddress);
        tvAddress.setText(straddress[position]);
        TextView tvName = (TextView)view.findViewById(R.id.textName);
        tvName.setText(strName[position]);

        ImageView imageView = (ImageView)view.findViewById(R.id.imAlertEmergency);
        imageView.setBackgroundResource(imgId[position]);

        return view;
    }
}
