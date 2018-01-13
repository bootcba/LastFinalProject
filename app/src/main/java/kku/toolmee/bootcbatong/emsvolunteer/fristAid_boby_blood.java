package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class fristAid_boby_blood extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fristaid_bboby_blood);
        //ช้อความบน toolbar
        getSupportActionBar().setTitle("ภาวะเลือดตกใน");

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mediaPlayer = MediaPlayer.create(this,R.raw.blood);
        mediaPlayer.start();







    }
    //Add back button
  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
            this.gobacktopreviousactivity();

        }
        return super.onOptionsItemSelected(item);

    }*/



    //กำหนดหน้าได้ ใช้กรณีกำหนดหน้า
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, fristAid_manuBoby.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                MediaPlayerStop();



                return true;

            default:


                return super.onOptionsItemSelected(item);

        }
    }
    void MediaPlayerStop(){
        //stop music player
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}
