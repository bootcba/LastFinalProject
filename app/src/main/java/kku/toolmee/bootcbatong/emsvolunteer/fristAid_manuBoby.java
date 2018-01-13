package kku.toolmee.bootcbatong.emsvolunteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class fristAid_manuBoby extends AppCompatActivity {

    private ImageButton igBtnTotorn, igBtnToScald, igBtnToStab, igBtnToFail, igBtnToOrgan, igBtnToChemical,
            igBtnToBlood, igBtnToBone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristaid_manuboby);

        //ช้อความบน toolbar

        getSupportActionBar().setTitle("ลักษณะอาการ");
        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        igBtnTotorn = (ImageButton) findViewById(R.id.finger1);
        igBtnToScald = (ImageButton) findViewById(R.id.hotwater);
        igBtnToStab = (ImageButton) findViewById(R.id.arm);
        igBtnToFail = (ImageButton) findViewById(R.id.falling);
        igBtnToOrgan = (ImageButton) findViewById(R.id.finger2);
        igBtnToChemical = (ImageButton) findViewById(R.id.chemicla);
        igBtnToBlood = (ImageButton) findViewById(R.id.blood);
        igBtnToBone = (ImageButton) findViewById(R.id.bone);

        igBtnTotorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_torn.class);
                startActivity(intent);
            }
        });
        igBtnToScald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_scald.class);
                startActivity(intent);
            }
        });
        igBtnToStab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_stab.class);
                startActivity(intent);
            }
        });
        igBtnToFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_fail.class);
                startActivity(intent);
            }
        });
        igBtnToOrgan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_organ.class);
                startActivity(intent);
            }
        });
        igBtnToChemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_chemical.class);
                startActivity(intent);
            }
        });
        igBtnToBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_blood.class);
                startActivity(intent);
            }
        });
        igBtnToBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fristAid_boby_bone.class);
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
