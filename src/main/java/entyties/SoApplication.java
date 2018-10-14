package entyties;

import jdk.internal.jline.internal.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Component
public class SoApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int applicationID;
    private int authorID;
    private String name;
    private String description;
    private String aim;
    private boolean approved;
    private int status;
    private String rejectedText;
    @Nullable
    private int dekanID;
    @Nullable
    private int skID;

    public SoApplication(int authorID, String name, String description, String aim, boolean approved, int status) {
        this.authorID = authorID;
        this.name = name;
        this.description = description;
        this.aim = aim;
        this.approved = approved;
        this.status = status;
    }

    public SoApplication() {
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRejectedText() {
        return rejectedText;
    }

    public void setRejectedText(String rejectedText) {
        this.rejectedText = rejectedText;
    }

    public int getDekanID() {
        return dekanID;
    }

    public void setDekanID(int dekanID) {
        this.dekanID = dekanID;
    }

    public int getSkID() {
        return skID;
    }

    public void setSkID(int skID) {
        this.skID = skID;
    }
}