package kku.toolmee.bootcbatong.emsvolunteer;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DELL on 13/11/2560.
 */

public class Datapeople extends AppCompatActivity {
    private Button buttonOkpeople;
    List<People> peopleList;
    ListView listViewPeople;
    private EditText editText_name, editText_lname, editText_idgard,
            editText_disease, editText_be_allergic, editText_drug, editText_tel;
   private DatabaseReference databasePeople;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_people);

        databasePeople = FirebaseDatabase.getInstance().getReference("people");
        peopleList = new ArrayList<>();//การแสดงข้อมูล


        buttonOkpeople = (Button) findViewById(R.id.data_userok);
        editText_name = (EditText) findViewById(R.id.edit_name);
        editText_lname = (EditText) findViewById(R.id.edit_lname);
        editText_idgard = (EditText) findViewById(R.id.edit_idgard);
        editText_disease = (EditText) findViewById(R.id.edit_disease);
        editText_be_allergic = (EditText) findViewById(R.id.edit_be_allergic);
        editText_drug = (EditText) findViewById(R.id.edit_drug);
        editText_tel = (EditText) findViewById(R.id.edit_tel);
        listViewPeople = (ListView) findViewById(R.id.listViewPeople);

        //หัวข้อบนหน้าแอปพลิเคชัน
        getSupportActionBar().setTitle("ข้อมูลผู้ใช้เบื้องต้น");
        //Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ปุ่มบันทึกข้อมูลผู้ประสบเหตุ
        buttonOkpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataPeopleInformation();
            }
        });

        listViewPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                People people = peopleList.get(i);
                ShowUpdateDataPeople(people.getId(), people.getName(), people.getLname(), people.getIdgard(), people.getDisease(), people.getBe_allergic(), people.getDrug(), people.getTel());
                return;
            }
        });


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
    //ชื่อหน้า
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }
    //Insert ข้อมูล-----------------------------------------------------------
    private void DataPeopleInformation() {
        String name = editText_name.getText().toString().trim();
        String lname = editText_lname.getText().toString().trim();
        String idgard = editText_idgard.getText().toString().trim();
        String disease = editText_disease.getText().toString().trim();
        String be_allergic = editText_be_allergic.getText().toString().trim();
        String drug = editText_drug.getText().toString().trim();
        String tel = editText_tel.getText().toString().trim();
        String androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        if (TextUtils.isEmpty(name)) {
            editText_name.setError("กรุณาใส่ชื่อของท่าน");
            return;
        } else if (!CheckName(name)) {
            editText_name.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;
        } else if (TextUtils.isEmpty(lname)) {
            editText_lname.setError("กรุณาใส่นามสกุลของท่าน");
            return;
        } else if (!CheckLname(lname)) {
            editText_lname.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;
        } else if (idgard.length() != 13) {
            editText_idgard.setError("กรุณากรอกรหัสประจำตัวของท่านให้ถูกต้อง");
            return;
        } else if (!ChekID(idgard)) {
            editText_idgard.setError("กรุณากรอกรหัสประจำตัวของท่านให้ถูกต้อง");
            return;
        /**} else if (!TextUtils.isEmpty(disease)) {
            editText_disease.setError("กรุณาใส่นามสกุลของท่าน");
            return;
        } else if (!CheckTel(disease)) {
            editText_disease.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;

        } else if (!TextUtils.isEmpty(be_allergic)) {
            editText_be_allergic.setError("กรุณาใส่นามสกุลของท่าน");
            return;
        } else if (!CheckTel(be_allergic)) {
            editText_be_allergic.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;

        } else if (!TextUtils.isEmpty(drug)) {
            editText_drug.setError("กรุณาใส่นามสกุลของท่าน");
            return;
        } else if (!CheckTel(drug)) {
            editText_drug.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;*/

        } else if (TextUtils.isEmpty(tel)) {
            editText_tel.setError("กรุณากรอกเบอร์โทรศัพท์ของท่านให้ถูกต้อง");
            return;
        } else if (tel.length() < 9 || tel.length() > 10) {
            editText_tel.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;
        } else if (!CheckTel(tel)) {
            editText_tel.setError("รูปแบบข้อมูลไม่ถูกต้อง");
            return;

        }
        String id = databasePeople.push().getKey();
        People people = new People(id, name, lname, idgard, disease, be_allergic, drug, tel, androidID);
        databasePeople.child(id).setValue(people);
        Toast.makeText(this, "บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_LONG).show();
    }

    public static boolean CheckName(String name) {
        while (true) {

            while (true) {
                if (!checkName(name)) break;
                if (!checkvowel(name)) break;
                if (!checkcon(name)) break;

                return true;
            }
            return false;
        }
    }
    public static boolean checkvowel(String name) {
        int numv = 0, conv = 0, length = name.length();
        char c;
        int i;
        char[] vowel = {'ะ', 'า', 'ิ', 'ี', 'ไ', 'โ', '์', 'ํ', 'ใ', 'ำ', '\0'};
        for (i = 0; i < length; i++) {
            c = name.charAt(i);
            for (char test : vowel) {


                if (test == c) //If current char is a vowel
                {
                    numv++;
                    conv++; //Increase counters
                    if (conv > 10 || numv > 11) //Invalid name detected
                        return false;
                    break;
                }
                if (test == '\0') conv = 0;
                else {
                    numv = conv = 0;
                    break;
                } //New word. So reset counters
            }
        }
        numv = conv = 0;
        return true;
    }
    /*Checks if both strings contain more than 2 consecutive same consonants. Also checks if they contain more than 4 consonants. Both are done in each word*/
    //ตรวนสอบพยัญชนะว่ามีมากกว่า 2 ตัว
    public static boolean checkcon(String name) {
        int num = 0, length = name.length(), con = 0;
        char c, tmp = 'ะ';
        int i;
        for (i = 0; i < length; i++) {
            if ((c = name.charAt(i)) != 'ะ' && c != 'า' && c != 'ิ' && c != 'ี' && c != 'ไ' && c != 'โ' && c != '์' && c != 'ํ' && c != 'ใ' && c != 'ำ') //If current character is not a vowel or a space
            {
                num++;
                if (tmp != 'ะ' && c == tmp)
                    con++;
                if (num > 10 || con > 11) //Invalid name
                    return false;
                tmp = c;
                continue;
            }
            num = 0;
            con = 0;
            tmp = 'ะ';
        }
        num = 0;
        con = 0;
        tmp = 'ะ'; //Reset everything

        {

            return true;
        }
    }
    public static boolean checkName(String name) {
        int length = 0, length2 = 0, i = 0;
        char c;
        String Fullname;
        {
            c = name.charAt(i);
            if (!((c >= 'ก' && c <= 'ฮ' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        for (i = 0; i < length2; i++)    //Check for `Lastname`
        {
        }
        return true;
    }
    //******************************************************************
    public static boolean CheckLname(String lname) {
        while (true) {

            while (true) {
                if (!checkLname(lname)) break;
                if (!checkvowels(lname)) break;
                if (!checkcons(lname)) break;

                return true;
            }
            return false;
        }
    }
    public static boolean checkvowels(String lname) {
        int numv = 0, conv = 0, length = lname.length();
        char c;
        int i;
        char[] vowel = {'ะ', 'า', 'ิ', 'ี', 'ไ', 'โ', '์', 'ํ', 'ใ', 'ำ', '\0'};
        for (i = 0; i < length; i++) {
            c = lname.charAt(i);
            for (char test : vowel) {


                if (test == c) //If current char is a vowel
                {
                    numv++;
                    conv++; //Increase counters
                    if (conv > 10 || numv > 11) //Invalid name detected
                        return false;
                    break;
                }
                if (test == '\0') conv = 0;
                else {
                    numv = conv = 0;
                    break;
                } //New word. So reset counters
            }
        }
        numv = conv = 0;
        return true;
    }

    /*Checks if both strings contain more than 2 consecutive same consonants. Also checks if they contain more than 4 consonants. Both are done in each word*/
    //ตรวนสอบพยัญชนะว่ามีมากกว่า 2 ตัว
    public static boolean checkcons(String lname) {
        int num = 0, length = lname.length(), con = 0;
        char c, tmp = 'ะ';
        int i;
        for (i = 0; i < length; i++) {
            if ((c = lname.charAt(i)) != 'ะ' && c != 'า' && c != 'ิ' && c != 'ี' && c != 'ไ' && c != 'โ' && c != '์' && c != 'ํ' && c != 'ใ' && c != 'ำ') //If current character is not a vowel or a space
            {
                num++;
                if (tmp != 'ะ' && c == tmp)
                    con++;
                if (num > 10 || con > 11) //Invalid name
                    return false;
                tmp = c;
                continue;
            }
            num = 0;
            con = 0;
            tmp = 'ะ';
        }
        num = 0;
        con = 0;
        tmp = 'ะ'; //Reset everything
        {
            return true;
        }
    }
    public static boolean checkLname(String lname) {
        int length = 0, length2 = 0, i = 0;
        char c;
        String Fullname;
        {
            c = lname.charAt(i);
            if (!((c >= 'ก' && c <= 'ฮ' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        for (i = 0; i < length2; i++)    //Check for `Lastname`
        {
        }

        return true;
    }


    //********************************************************************เช็คนามสกุล











    public static boolean CheckTel(String tel) {
        Pattern pattern = Pattern.compile("((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{8,20}");
        Matcher matcher = pattern.matcher(tel);

        if (matcher.matches()) return true;


        return false;
    }







    //เช็ครหัสประจำตัวประชาชน
    private boolean ChekID(String id) {
        boolean chk = true;
        int sum =0;char vvv;
        String a = new String(id);
        String[] idArray = id.split("");
        for(int i=1;  i < 13; i++) {
            sum += Integer.parseInt(idArray[i])* (14 - i);
        }

        int x= 11-(sum%11);
        if (String.valueOf(x).length() >= 2){
            String aa = new String(String.valueOf(x));
            x = Integer.parseInt(String.valueOf(aa.charAt(1)));
        }
        if (x != Integer.parseInt(idArray[13])){
            chk =  false;
        }

        return chk;
    }

    //แสดงข้อมูล
    @Override
    protected void  onStart(){
        super.onStart();
        databasePeople.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                peopleList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren ()) {
                    People people = artistSnapshot.getValue(People.class);

                    peopleList.add(people);
                }

                PeopleList adapters = new PeopleList(Datapeople.this, peopleList);
                listViewPeople.setAdapter(adapters);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private boolean UpdateData(String id, String name, String lname,String idgard, String disease, String be_allergic, String drug,String tel,String androidID){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("people").child(id);
        People people = new People( id,name,lname,idgard,  disease, be_allergic, drug,tel,androidID);
        databaseReference.setValue(people);
        Toast.makeText(getApplicationContext(), "แก้ไขแล้ว", Toast.LENGTH_LONG).show();
        return true;
    }
}
