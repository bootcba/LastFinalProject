package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setPassword extends AppCompatActivity {


    private EditText editText_setPassword1, editText_setPassword2;
    private Button button_password;
    String prePassword, confirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpassword);
        //ช้อความบน toolbar
        getSupportActionBar().setTitle("รหัสผ่าน");
        //ผูก
        button_password = (Button) findViewById(R.id.buttonPassword);
        editText_setPassword1 = (EditText) findViewById(R.id.setPassword1);
        editText_setPassword2 = (EditText) findViewById(R.id.setPassword2);
        //สร้าง dialog
        button_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder spBuilder = new AlertDialog.Builder(setPassword.this);
                spBuilder.setIcon(R.drawable.ic_checked);
                spBuilder.setTitle("เรียบร้อย");
                spBuilder.setMessage("คุณได้ทำการตั้งรหัสเรียบร้อย");
                spBuilder.setCancelable(false); //ทำให้มันคลิกออกไม่ได้

                spBuilder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),login.class);
                        startActivity(intent);
                    }
                });
               /* spBuilder.setNeutralButton("ยกเเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });*/
                AlertDialog alertDialog = spBuilder.create();
                alertDialog.show();
            }
        });

    }
}