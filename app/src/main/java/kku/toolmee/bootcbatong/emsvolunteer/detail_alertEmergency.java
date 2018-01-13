package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class detail_alertEmergency extends AppCompatActivity {

    private Button btnCommit;
    private ImageButton imbtn_profileSufferer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_alert_emergency);

        //ช้อความบน toolbar
        getSupportActionBar().setTitle("รายละเอียดจุดเกิดเหตุ");

        imbtn_profileSufferer = (ImageButton)findViewById(R.id.toProfileSufferer);
        imbtn_profileSufferer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),show_profileSufferer.class);
                startActivity(intent);
            }
        });
        btnCommit = (Button)findViewById(R.id.btnCommit);
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder spBuilder = new AlertDialog.Builder(detail_alertEmergency.this);
                spBuilder.setIcon(R.drawable.ic_checked);
                spBuilder.setTitle("ยืนยันการเข้าถึงจุดเกิดเหตุ");
                spBuilder.setMessage("คุณได้เข้าถึงจุดเกิดเหตุเรียบร้อยแล้ว");
                spBuilder.setCancelable(false); //ทำให้มันคลิกออกไม่ได้

                spBuilder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),alertEmergency.class);
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
}
