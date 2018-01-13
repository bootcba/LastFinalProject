package kku.toolmee.bootcbatong.emsvolunteer;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_fristaid1 extends Fragment {

   private FloatingActionButton button_FabToCPR;
   private Button btnToCPR;
   private ImageView imCPR;
   private MediaPlayer mediaPlayer;
   private TabItem tabItem0;

   public static fragment_fristaid1 newInstance()  {
        return new fragment_fristaid1();
   }

   public fragment_fristaid1(){}

   @Override
   public void  onCreate (Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_fristaid1, container, false);

       /* mediaPlayer = MediaPlayer.create(getContext(),R.raw.bone);
        mediaPlayer.start();*/

        btnToCPR = (Button) rootView.findViewById(R.id.btnToCPR);
        btnToCPR.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View v) {


                    Intent intent = new Intent(getActivity().getApplicationContext(),CprAid.class);
                    startActivity(intent);
                 //  mediaPlayer.stop();
                }
            });

        return rootView;
    }

    @Override
    public void onActivityCreated (Bundle saveInstanceState){
       super.onActivityCreated(saveInstanceState);
    }


}
