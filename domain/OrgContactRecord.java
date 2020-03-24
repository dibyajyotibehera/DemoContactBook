package contacts.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrgContactRecord extends ContactRecord {
    private String address;

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "address", "number");
    }


    @Override
    public void setFieldByName(String fieldName, String value) {
        switch (fieldName) {
            case "name":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setPhoneNum(value);
                break;
        }
    }


    public void setAddress(String address) {
        this.address = address;
        setEditedTime(new Date());
    }

    @Override
    public String toString() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + phoneNum + "\n" +
                "Time created: " + createdTime + "\n" +
                "Time last edit: " + editedTime + "\n";

    }

    @Override
    public String getInfo() {
        return name;
    }

}
