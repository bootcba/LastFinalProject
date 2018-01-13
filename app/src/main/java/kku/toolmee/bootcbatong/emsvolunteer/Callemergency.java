package kku.toolmee.bootcbatong.emsvolunteer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 13/11/2560.
 */

public class Callemergency extends AppCompatActivity {
    Button buttonDatapeople, buttonCallemergency;
    People people;
    List<People> peopleList;
    String checkReg;
    private int i;
    private DatabaseReference databasePeople;
    ListView listViewPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_emergency);
        databasePeople = FirebaseDatabase.getInstance().getReference("people");
        buttonDatapeople = (Button) findViewById(R.id.button_datapeople);
        buttonCallemergency = (Button) findViewById(R.id.buttoncall_emergency);
        peopleList = new ArrayList<>();
        databasePeople.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot snapshot) {
                peopleList.clear();
                for (DataSnapshot artistSnapshot : snapshot.getChildren ()) {
                    People people = artistSnapshot.getValue(People.class);
                    peopleList.add(people);
                }
                // People people = snapshot.getValue(People.class);
                // peopleList.add(people);


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //init();
        buttonDatapeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckFirebase();

                /**Intent intent = null;
                 intent = new Intent(getApplicationContext(), Datapeople.class);
                 startActivity(intent);*/

            }
        });

        buttonCallemergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Showdialog();


            }
        });

        getSupportActionBar().setTitle("เรียกอาสาฉุกเฉิน");
        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /*private void init() {
        buttonDatapeople = (Button) findViewById(R.id.button_datapeople);
    }*/

    /*@Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button_datapeople:
                intent = new Intent(getApplicationContext(), Datapeople.class);
                break;


        }

        startActivity(intent);
    }*/

    private void Showdialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_callemergency, null);
        dialogBuilder.setView(dialogView);
        Button buttonOkCall = (Button) dialogView.findViewById(R.id.button_OkCallEmergency);
        Button buttonCancle = (Button) dialogView.findViewById(R.id.button_CancleCallEmergency);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonOkCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDialogCallOk();

            }
        });

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(getApplicationContext(), Callemergency.class);
                startActivity(intent);

            }
        });

    }


    public void ShowUpdate(int i) {
        People people = peopleList.get(i);
        ShowUpdateDataPeople(people.getId(), people.getName(), people.getLname(), people.getIdgard(), people.getDisease(), people.getBe_allergic(), people.getDrug(), people.getTel());
        return;
    }



    public void CheckFirebase() {
        try {

            people = peopleList.get(i);
            String name = people.getName();
            String lname = people.getLname();
            String Idgard = people.getIdgard();
            String disease = people.getDisease();
            String be_allergic = people.getBe_allergic();
            String drug = people.getDrug();
            String tel = people.getTel();
            ShowUpdate(i);
            /*Intent intent = null;
            intent = new Intent(getApplicationContext(), Update.class);
            startActivity(intent);*/



        } catch (Exception e) {
            if (people == null) {
                Toast.makeText(this, "กรุณาลงทะเบียน", Toast.LENGTH_LONG).show();
                Intent intent = null;
                intent = new Intent(getApplicationContext(), Datapeople.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }

    }


    private void ShowDialogCallOk() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_okcallemergency, null);
        dialogBuilder.setView(dialogView);
        Button buttonokCalls = (Button) dialogView.findViewById(R.id.button_OkCallEmergencyAm);
        //ค่าที่แสดงใน Dialog
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


        buttonokCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(getApplicationContext(), CallAmbulance.class);
                startActivity(intent);
            }

        });
    }


    private boolean UpdateData(String id, String name, String lname, String idgard, String disease, String be_allergic, String drug, String tel, String androidID) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("people").child(id);
        People people = new People(id, name, lname, idgard, disease, be_allergic, drug, tel, androidID);
        databaseReference.setValue(people);
        Toast.makeText(getApplicationContext(), "แก้ไขแล้ว", Toast.LENGTH_LONG).show();
        return true;
    }

    private void ShowUpdateDataPeople(final String id, String name, String lname, String idgard, String disease, String be_allergic, String drug, String tel) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_update, null);
        dialogBuilder.setView(dialogView);
        final EditText editText_nameUpdate = (EditText) dialogView.findViewById(R.id.edit_nameEdit);
        final EditText editText_lnameUpdate = (EditText) dialogView.findViewById(R.id.edit_lnameEdit);
        final EditText editText_idgardUpdate = (EditText) dialogView.findViewById(R.id.edit_idgardEdit);
        final EditText editText_diseaseUpdate = (EditText) dialogView.findViewById(R.id.edit_diseaseEdit);
        final EditText editText_be_allergicUpdate = (EditText) dialogView.findViewById(R.id.edit_be_allergicEdit);
        final EditText editText_drugUpdate = (EditText) dialogView.findViewById(R.id.edit_drugEdit);
        final EditText editText_telUpdate = (EditText) dialogView.findViewById(R.id.edit_telEdit);

        Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);

        dialogBuilder.setTitle("แก้ไขข้อมูล " + name); //ค่าที่แสดงใน Dialog
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        editText_nameUpdate.setText(name);
        editText_lnameUpdate.setText(lname);
        editText_idgardUpdate.setText(idgard);
        editText_diseaseUpdate.setText(disease);
        editText_be_allergicUpdate.setText(be_allergic);
        editText_drugUpdate.setText(drug);
        editText_telUpdate.setText(tel);


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_nameUpdate.getText().toString().trim();
                String lname = editText_lnameUpdate.getText().toString().trim();
                String idgard = editText_idgardUpdate.getText().toString().trim();
                String disease = editText_diseaseUpdate.getText().toString().trim();
                String be_allergic = editText_be_allergicUpdate.getText().toString().trim();
                String drug = editText_drugUpdate.getText().toString().trim();
                String tel = editText_telUpdate.getText().toString().trim();
                String androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                if (TextUtils.isEmpty(name)) {
                    editText_nameUpdate.setError("กรุณาใส่ชื่อ");
                    return;
                }
                UpdateData(id, name, lname, idgard, disease, be_allergic, drug, tel, androidID);
                alertDialog.dismiss();


            }
        });



    }


}














