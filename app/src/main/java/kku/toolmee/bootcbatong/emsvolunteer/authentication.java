package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class authentication extends AppCompatActivity {

    private Button button_authen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        //ช้อความบน toolbar
        getSupportActionBar().setTitle("รหัสประจำตัว อฉช.");

        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_authen = (Button)findViewById(R.id.buttonAuthen);

        //เปลี่ยนหน้า
        button_authen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),profileVolunteer.class);
                startActivity(intent);
            }
        });

    }

    //Add back button
   @Override
    public boolean onOptionsItemSelected(MenuItem item){
       int id = item.getItemId();

       if (id == android.R.id.home){
           this.finish();
       }

       return super.onOptionsItemSelected(item);
   }
}
