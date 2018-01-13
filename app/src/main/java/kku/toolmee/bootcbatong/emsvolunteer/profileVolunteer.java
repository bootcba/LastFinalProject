package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profileVolunteer extends AppCompatActivity {

    private EditText editName,editLastname,editidCard,editTel,editAddress;
    private Button button_toSetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_volunteer);
        //ช้อความบน toolbar
        getSupportActionBar().setTitle("ข้อมูลส่วนตัวของ อฉช.");


        //ผูก
        button_toSetPassword = (Button) findViewById(R.id.toSetPassword);

        //เปลี่ยนหน้า
        button_toSetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),setPassword.class);
                startActivity(intent);
                //toast
                Toast.makeText(profileVolunteer.this, "บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_LONG).show();
            }
        });



    }
}
