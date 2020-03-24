package contacts.service;

import contacts.PhoneBook;
import contacts.domain.OrgContactRecord;
import contacts.domain.PersonContactRecord;

import java.io.IOException;
import java.util.List;

public class AddService {
    private final PhoneBook phoneBook;

    public AddService(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String add() {
        String result = "The record added.";
        System.out.println("Enter the type (person, organization): ");

        String type = phoneBook.getScanner().nextLine();
        switch (type) {
            case "person": {
                PersonContactRecord personContactRecord = new PersonContactRecord();
                personContactRecord.setId(String.valueOf(
                        phoneBook.getRecordList().size()));
                List<String> editableFields = personContactRecord.getEditableFields();
                for (String field : editableFields) {
                    System.out.println("Enter the " + field + ": ");
                    String value = phoneBook.getScanner().nextLine();
                    personContactRecord.setFieldByName(field, value);
                }
                phoneBook.getRecordList().add(personContactRecord);

                break;
            }
            case "organization": {
                OrgContactRecord orgContactRecord = new OrgContactRecord();
                orgContactRecord.setId(String.valueOf(
                        phoneBook.getRecordList().size()));
                List<String> editableFields = orgContactRecord.getEditableFields();
                for (String field : editableFields) {
                    System.out.println("Enter the " + field + ": ");
                    String value = phoneBook.getScanner().nextLine();
                    orgContactRecord.setFieldByName(field, value);
                }
                phoneBook.getRecordList().add(orgContactRecord);
                break;
            }
            default:
                result = "invalid type";
                break;
        }
        if (phoneBook.getFilepath().length() > 0) {
            try {
                phoneBook.persistData(phoneBook.getRecordList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}