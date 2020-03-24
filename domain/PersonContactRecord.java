package contacts.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PersonContactRecord extends ContactRecord {
    private String surname;
    private String birthDate = "[no data]";
    private Gender gender;


    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "surname", "birth", "gender", "number");
    }


    @Override
    public void setFieldByName(String fieldName, String value) {
        switch (fieldName) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "birth":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
                break;
            case "number":
                setPhoneNum(value);
                break;
        }
    }

    private void setSurname(String surname) {
        this.surname = surname;
        setEditedTime(new Date());
    }


    private void setBirthDate(String birthDate) {
        if (birthDate.length() == 0) {
            System.out.println("Bad birth date! ");
        } else {
            this.birthDate = birthDate;
            setEditedTime(new Date());
        }
    }


    private void setGender(String gender) {
        switch (gender) {
            case "M":
                this.gender = Gender.M;
                break;
            case "F":
                this.gender = Gender.F;
                break;
            default:
                System.out.println("Bad gender! ");
        }
        setEditedTime(new Date());
    }

    @Override
    public String toString() {
        String genderString = gender != null ? gender.toString() : "[no data]";
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthDate + "\n" +
                "Gender: " + genderString + "\n" +
                "Number: " + phoneNum + "\n" +
                "Time created: " + createdTime + "\n" +
                "Time last edit: " + editedTime;

    }

    @Override
    public String getInfo() {
        return name + " " + surname;
    }

    private enum Gender {
        M, F;
    }

    ;

}