package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class login extends AppCompatActivity {

    private ImageView imageView_logo;
    private EditText editText_userName;
    private EditText editText_password;
    private Button button_login;
    private Button button_fristLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //เอาtitle ออก
       /* this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/

        //ผูก ใช้findViewID
      //  editText_userName = (EditText)findViewById(R.id.userNameVolunteer);
      //  editText_password = (EditText)findViewById(R.id.passwordVolunteer);
        button_login = (Button)findViewById(R.id.loginVolunteer);
        button_fristLogin = (Button)findViewById(R.id.fristLoginVolunteer);

        //เปลี่ยนหน้า
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),menuVolunteer.class);
                startActivity(intent);

            }
        });

        button_fristLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),authentication.class);
                startActivity(intent);
            }
        });






    }
}
