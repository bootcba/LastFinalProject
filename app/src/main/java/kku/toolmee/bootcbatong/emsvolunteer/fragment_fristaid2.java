package kku.toolmee.bootcbatong.emsvolunteer;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_fristaid2 extends Fragment {
    private Button btnAEDToCPR;
    private MediaPlayer mediaPlayer;
    private TabItem tabItem1;



    public fragment_fristaid2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fristaid2, container, false);
        //ปุ่ม to CPR
        //ผูก
    /*   mediaPlayer = MediaPlayer.create(getContext(),R.raw.aed);
        mediaPlayer.start();*/
        btnAEDToCPR = (Button) rootView.findViewById(R.id.btnAEDToCPR);

        //เปลี่ยนหน้า
        btnAEDToCPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity().getApplicationContext(), CprAid.class);
               startActivity(intent);
                //stop sound
                 //mediaPlayer.stop();




            }

        });


        return rootView;

    }
}
