package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class alertEmergency extends AppCompatActivity {
    private MediaPlayer mediaPlayer_cpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_emergency);

        //ช้อความบน toolbar

        getSupportActionBar().setTitle("จุดเกิดเหตุฉุกเฉิน");

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set ค่าส่งไปconstrustor
        String[] distance = {"900 ม.", "3 กม.", "1 กม.","500 ม.","8 กม."};
        String[] time = {"10:00 น.", "12:00 น.","12:05 น.","12:30","13:00"};
        String[] address = {"มหาวิทยาลัยขอนแก่น", "ศูนย์อาหารบริการ 1", "โรงชาย", "หอพักหญิงที่ 24", "หอนพรัตน์"};
        String[] name = {"สมชาย","สมหมาย","จริงใจ","ข้าวหอม","กิมเล้ง"};

        int[] imgId = { R.drawable.ic_bell_red, R.drawable.ic_bell_green, R.drawable.ic_bell_red,
                R.drawable.ic_bell_green,R.drawable.ic_bell_green,};
        //ประกาศconstrutor
        adapter_alertEmergency adapter = new adapter_alertEmergency(getApplicationContext(), distance,time,address,name,imgId);

        ListView listView =(ListView)findViewById(R.id.listView_alertEmergency);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                AlertDialog.Builder spBuilder = new AlertDialog.Builder(alertEmergency.this);
                spBuilder.setIcon(R.drawable.ic_checked);
                spBuilder.setTitle("ยืนยัน");
                spBuilder.setMessage("การตอบรับเข้าช่วยเหลือผู้ประสบเหตุ");
                spBuilder.setCancelable(false); //ทำให้มันคลิกออกไม่ได้

                spBuilder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),detail_alertEmergency.class);
                        startActivity(intent);
                    }
                });
               spBuilder.setNeutralButton("ยกเเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = spBuilder.create();
                alertDialog.show();


            }
        });

    }

    //กำหนดหน้าได้ ใช้กรณีกำหนดหน้า
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, menuVolunteer.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);



                return true;

            default:


                return super.onOptionsItemSelected(item);

        }
    }
}
