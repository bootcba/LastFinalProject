package kku.toolmee.bootcbatong.emsvolunteer;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_fristaid3 extends Fragment {
    private MediaPlayer mediaPlayer;
    private TabItem tabItem3;



    public fragment_fristaid3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fristaid3, container, false);
      //  return inflater.inflate(R.layout.fragment_fristaid3, container, false);
      /*  mediaPlayer = MediaPlayer.create(getContext(),R.raw.sathar);
        mediaPlayer.start();*/

        return rootView;
    }

}
