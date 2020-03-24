package contacts.service;

import contacts.PhoneBook;
import contacts.domain.ContactRecord;

public class RecordService {
    private final PhoneBook phoneBook;
    private final EditService editService;

    public RecordService(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        this.editService = new EditService(phoneBook);
    }

    public void recordSubMenu(ContactRecord filteredRecord) {
        String option = "";
        do {
            System.out.println("\n[record] Enter action (edit, delete, menu):");
            option = phoneBook.getScanner().nextLine();

            switch (option) {
                case "edit":
                    editService.edit(filteredRecord);
                    break;
                case "delete":
                    phoneBook.remove(filteredRecord);
                    break;
                case "menu":
                    return;
                default:
                    System.out.println("not a valid option");
            }
        } while (true);
    }
}