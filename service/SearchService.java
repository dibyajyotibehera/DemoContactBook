package contacts.service;

import contacts.PhoneBook;
import contacts.domain.ContactRecord;

import java.util.ArrayList;

public class SearchService {
    private final PhoneBook phoneBook;
    private final RecordService recordService;

    public SearchService(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        this.recordService = new RecordService(phoneBook);
    }

    public String search() {
        System.out.println("Enter search query:");
        String query = phoneBook.getScanner().nextLine();
        ArrayList<ContactRecord> matchedRecords = new ArrayList<ContactRecord>();
        for (ContactRecord cr :
                phoneBook.getRecordList()) {
            if (cr.toString().toLowerCase().contains(query.toLowerCase())) {
                matchedRecords.add(cr);
            }
        }
        System.out.println("Found " + matchedRecords.size() + " results");
        phoneBook.showRecordDetails(matchedRecords);

        System.out.println("\n[search] Enter action ([number], back, again):");
        String option = phoneBook.getScanner().nextLine();
        switch (option) {
            case "again":
                search();
                break;
            case "back":
                return "";
            default:
                if (option.matches("\\d")) {
                    ContactRecord filteredRecord = matchedRecords.get(Integer.valueOf(option) - 1);
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