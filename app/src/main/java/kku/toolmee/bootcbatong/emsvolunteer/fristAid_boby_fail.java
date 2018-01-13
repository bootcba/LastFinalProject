package kku.toolmee.bootcbatong.emsvolunteer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class fristAid_boby_fail extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fristaid_boby_fail);
        //ช้อความบน toolbar
        getSupportActionBar().setTitle("อุบัติเหตุรุนแรง/ตกจากที่สูง");

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mediaPlayer = MediaPlayer.create(this,R.raw.fail);
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
