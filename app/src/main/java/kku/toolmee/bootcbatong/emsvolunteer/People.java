package kku.toolmee.bootcbatong.emsvolunteer;


/**
 * Created by DELL on 13/11/2560.
 */

public class People {
    public String id;
    public String name;
    public String lname;
    public String idgard;
    public String disease;
    public String be_allergic;
    public String drug;
    public String tel;
    public String androidID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getIdgard() {
        return idgard;
    }

    public void setIdgard(String idgard) {
        this.idgard = idgard;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getBe_allergic() {
        return be_allergic;
    }

    public void setBe_allergic(String be_allergic) {
        this.be_allergic = be_allergic;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAndroidID() {
        return androidID;
    }

    public void setAndroidID(String androidID) {
        this.androidID = androidID;
    }

    public People(String id, String name, String lname, String idgard, String disease, String be_allergic, String drug, String tel, String androidID) {
        this.id = id;
        this.name = name;
        this.lname = lname;
        this.idgard = idgard;
        this.disease = disease;
        this.be_allergic = be_allergic;
        this.drug = drug;
        this.tel = tel;
        this.androidID = androidID;
    }

    public People(){}
}
