package entyties;

import jdk.internal.jline.internal.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Component
public class SO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int soID;
    private int applicationID;
    private String name;
    private String description;
    private String aim;
    private String head;
    private String address;
    private String tel_num;
    @Nullable
    private String email;
    @Nullable
    private String facebook;

    public SO(int applicationID, String name, String description, String aim, String head,
              String tel_num, String email) {
        this.applicationID = applicationID;
        this.name = name;
        this.description = description;
        this.aim = aim;
        this.head = head;
        this.tel_num = tel_num;
        this.email = email;
    }

    public SO() {
    }

    public int getSoID() {
        return soID;
    }

    public void setSoID(int soID) {
        this.soID = soID;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
}