package contacts;

import contacts.service.*;

public class PhoneBookController {
    private final PhoneBook phoneBook;
    final SearchService searchService;
    final RecordService recordService;
    final ListService listService;
    final AddService addService;
    final EditService editService;

    public PhoneBookController(String filePath) {
        this.phoneBook = new PhoneBook(filePath);
        this.searchService = new SearchService(phoneBook);
        this.recordService = new RecordService(phoneBook);
        this.listService = new ListService(phoneBook);
        this.addService = new AddService(phoneBook);
        this.editService = new EditService(phoneBook);
    }

    public String handleAction(String action) {
        String actionResult = "";
        switch (action) {
            case "count":
                actionResult = phoneBook.count();
                break;
            case "add":
                actionResult = addService.add();
                break;
            case "exit":
                actionResult = "";
                break;
            case "list":
                actionResult = listService.list();
                break;
            case "search":
                actionResult = searchService.search();
                break;
            default:
                actionResult = "Not a valid action";
        }
        ;
        return actionResult;
    }
}