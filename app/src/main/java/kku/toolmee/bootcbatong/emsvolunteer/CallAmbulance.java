package kku.toolmee.bootcbatong.emsvolunteer;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by DELL on 13/11/2560.
 */

public class CallAmbulance extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_ambulance);
        getSupportActionBar().setTitle("เรียกรถพยาบาล");
        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonCallAm = (Button) findViewById(R.id.buttonCallAmbulance);
        buttonCallAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Showdialog();

            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private  void  Showdialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_callambulance, null);
        dialogBuilder.setView(dialogView);
        Button buttonOkCallAm = (Button) dialogView.findViewById(R.id.button_OkCallAmbbulance);
        Button buttonCancleAm = (Button) dialogView.findViewById(R.id.button_CancleCallAmbulance);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog .show();

        buttonOkCallAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

              //เรียกรถพยาบาล


            }
        });

        buttonCancleAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(getApplicationContext(), CallAmbulance.class);
                startActivity(intent);

            }
        });

    }





}
