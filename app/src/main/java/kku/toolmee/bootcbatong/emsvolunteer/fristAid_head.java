package kku.toolmee.bootcbatong.emsvolunteer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class fristAid_head extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristaid_head);

        //ช้อความบน toolbar

        getSupportActionBar().setTitle("บาดเจ็บที่ศีรษะ");

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         mediaPlayer = MediaPlayer.create(fristAid_head.this,R.raw.head);
        mediaPlayer.start();
    }

    //Add back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
            mediaPlayer.stop();
        }

        return super.onOptionsItemSelected(item);
    }
}
