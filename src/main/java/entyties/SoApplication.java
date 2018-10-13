package entyties;

import org.springframework.stereotype.Component;

@Component
public class SoApplication {
    private int applicationID;
    private int authorID;
    private String name;
    private String description;
    private String aim;
    private boolean approved;
    private int status;
    private String rejectedText;
    private int dekanID;
    private int skID;

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