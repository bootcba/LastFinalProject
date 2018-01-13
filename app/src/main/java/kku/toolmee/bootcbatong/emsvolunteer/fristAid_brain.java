package kku.toolmee.bootcbatong.emsvolunteer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class fristAid_brain extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristaid_brain);

        //ช้อความบน toolbar
        getSupportActionBar().setTitle("หลอกเลือดแตก/ตีบ/ตัน");
        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       mediaPlayer = MediaPlayer.create(fristAid_brain.this,R.raw.brain);
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
