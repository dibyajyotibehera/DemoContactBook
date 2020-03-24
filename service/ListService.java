package contacts.service;

import contacts.PhoneBook;
import contacts.domain.ContactRecord;

public class ListService {
    private final PhoneBook phoneBook;
    private final RecordService recordService;


    public ListService(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        recordService = new RecordService(phoneBook);
    }

    public String list() {
        phoneBook.showRecordDetails(phoneBook.getRecordList());

        System.out.println("\n[list] Enter action ([number], back):");
        String option = phoneBook.getScanner().nextLine();

        switch (option) {
            case "back":
                return "";
            default:
                if (option.matches("\\d")) {
                    ContactRecord filteredRecord = phoneBook.getRecordList().get(Integer.valueOf(option) - 1);
                    phoneBook.recordDetails(filteredRecord.getId());
                    recordService.recordSubMenu(filteredRecord);
                    break;
                } else {
                    System.out.println("not a valid option");
                    break;
                }
        }
        return "";
    }
}