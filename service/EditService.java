package contacts.service;

import contacts.PhoneBook;
import contacts.domain.ContactRecord;

import java.io.IOException;

public class EditService {
    private final PhoneBook phoneBook;

    public EditService(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String edit(ContactRecord filteredRecord) {
        String result = "";
        System.out.println("Select a field (" + String.join(", ", filteredRecord.getEditableFields()) + "):");
        String fieldToUpdate = phoneBook.getScanner().nextLine();

        System.out.println("Enter " + fieldToUpdate + ": ");
        String value = phoneBook.getScanner().nextLine();
        filteredRecord.setFieldByName(fieldToUpdate, value);
        if (phoneBook.getFilepath().length() > 0) {
            try {
                phoneBook.persistData(phoneBook.getRecordList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Saved");
        phoneBook.recordDetails(filteredRecord.getId());
        return result;
    }
}