package contacts.domain;

import contacts.util.PhoneValidator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class ContactRecord implements Serializable {
    protected String id;
    protected String phoneNum;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm");
    protected String createdTime = simpleDateFormat.format(new Date());
    protected String editedTime = simpleDateFormat.format(new Date());
    protected String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected void setName(String name) {
        this.name = name;
        setEditedTime(new Date());
    }

    protected void setPhoneNum(String phoneNum) {
        this.phoneNum = "[no number]";
        validatePhoneNum(phoneNum);
        this.phoneNum = phoneNum;
        setEditedTime(new Date());
    }

    protected void setEditedTime(Date date) {
        editedTime = simpleDateFormat.format(date);
    }

    public abstract List<String> getEditableFields();

    public abstract void setFieldByName(String fieldName, String value);

    public abstract String toString();

    public abstract String getInfo();

    private void validatePhoneNum(String phoneNum) {
        PhoneValidator.validatePhoneNum(phoneNum);
    }
}
