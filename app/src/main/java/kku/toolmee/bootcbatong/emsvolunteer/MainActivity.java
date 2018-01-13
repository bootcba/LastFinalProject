package kku.toolmee.bootcbatong.emsvolunteer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        Button buttonPeople, buttonEmergency;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home);
            init();
            buttonPeople.setOnClickListener(this);
            buttonEmergency.setOnClickListener(this);


            getSupportActionBar().setTitle("หน้าหลัก");
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private void init() {
        buttonPeople = (Button) findViewById(R.id.people_user);
        buttonEmergency = (Button) findViewById(R.id.emergency_user);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.people_user:
                intent = new Intent(getApplicationContext(), Callemergency.class);
                break;
            case R.id.emergency_user:
                intent = new Intent(getApplicationContext(), Emergency.class);
                break;

        }

        startActivity(intent);
    }




    }

