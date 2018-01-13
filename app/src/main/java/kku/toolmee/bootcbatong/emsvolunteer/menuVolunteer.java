package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class menuVolunteer extends AppCompatActivity {

    private ImageButton imageButton_alert;
    private ImageButton imageButton_cpr;
    private ImageButton imageButton_fristAid;
    private ImageButton imageButton_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_volunteer);

        //ผูฏ
        imageButton_alert = (ImageButton)findViewById(R.id.alert);
        imageButton_cpr = (ImageButton)findViewById(R.id.cpr);
        imageButton_fristAid = (ImageButton)findViewById(R.id.fristAid);
        imageButton_logout = (ImageButton)findViewById(R.id.logout);



        //เปลี่ยนหน้า
        imageButton_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),alertEmergency.class);
                startActivity(intent);
            }
        });
        /*imageButton_cpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),*******.class);
                startActivity(intent);
            }
        }); */
        imageButton_fristAid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),fristAid.class);
                startActivity(intent);
            }
        });

        imageButton_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder spBuilder = new AlertDialog.Builder(menuVolunteer.this);
                spBuilder.setIcon(R.drawable.ic_checked);
                spBuilder.setTitle("คุณต้องการออกจากระบบหรือไม่ ?");
                //spBuilder.setMessage("");
                spBuilder.setCancelable(false); //ทำใต้ห้มันคลิกออกไม่ได้

                spBuilder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),login.class);
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



        imageButton_cpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),CprAid.class);
                startActivity(intent);

            }
        });

    }




}
