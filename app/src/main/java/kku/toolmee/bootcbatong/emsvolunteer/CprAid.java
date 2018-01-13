package kku.toolmee.bootcbatong.emsvolunteer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DELL on 27/11/2560.
 */

public class CprAid extends AppCompatActivity {

    TextView TextViewTime, TextViewCPRCircle, TextViewNumOfTime;
    Button buttonplay;
    private CprTime timerCPR;
    private Thread threadCPR;
    private Context TimeContext;
    private CprTime timerCPRCir;
    private Thread threadCPRCir;
    private Context TimeContextCir;
    private MediaPlayer cprSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpr);
        TextViewTime = (TextView) findViewById(R.id.textViewTimeCPR);
        TextViewCPRCircle = (TextView) findViewById(R.id.textViewCircleCPR);
        TextViewNumOfTime = (TextView) findViewById(R.id.textView2);
        buttonplay = (Button) findViewById(R.id.button_datapeople);
        TimeContext = this;
        cprSound = MediaPlayer.create(this, R.raw.cprsound);
        TextViewNumOfTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timerCPR == null) {
                    timerCPR = new CprTime(TimeContext);
                    threadCPR = new Thread(timerCPR);
                    threadCPR.start();
                    timerCPR.start();
                    cprSound.start();
                } else if(timerCPR != null) {

                        timerCPR.stop();
                        threadCPR.interrupt();
                        threadCPR = null;
                        timerCPR = null;
                        cprSound.pause();
                }
            }
        });
        getSupportActionBar().setTitle("CPR");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
            cprSound.stop();
        }
        return super.onOptionsItemSelected(item);
    }
    public void UpdateTimeText(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextViewTime.setText(time);
            }
        });
    }
    public void UpdateTimeTextCircle(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextViewCPRCircle.setText(time);
            }
        });
    }
    public  void   UpdateTimeTextNumOfTime(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextViewNumOfTime.setText(time);
            }
        });
    }
}
