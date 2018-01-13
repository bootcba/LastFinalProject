package kku.toolmee.bootcbatong.emsvolunteer;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_manuFristAid extends Fragment {

    private ImageButton imageButton_brain,
                        imageButton_head,
                        imageButton_boby;
    private MediaPlayer mediaPlayer;


    public static fragment_manuFristAid newInstance() {

       return new fragment_manuFristAid();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manufristaid, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ผูก
        imageButton_brain = (ImageButton) view.findViewById(R.id.manu_brain);
        imageButton_head = (ImageButton) view.findViewById(R.id.manu_head);
        imageButton_boby = (ImageButton) view.findViewById(R.id.manu_boby);


        //ดปลี่ยนหน้า
        imageButton_brain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),fristAid_brain.class);
                startActivity(intent);
            }
        });
        imageButton_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),fristAid_head.class);
                startActivity(intent);
            }
        });
        imageButton_boby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),fristAid_manuBoby.class);
                startActivity(intent);
            }
        });
    }
}




