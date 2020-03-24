package contacts;

import contacts.domain.ContactRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private ArrayList<ContactRecord> recordList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String filepath;
    ObjectOutputStream oos = null;

    public PhoneBook(String filepath) {
        this.filepath = filepath;
        if (filepath.length() > 0) {
            this.initialiseRecordList();
        }
    }

    private void initialiseRecordList() {
        File file = null;
        try {
            file = new File(filepath);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            recordList = (ArrayList<ContactRecord>) ois.readObject();
        } catch (EOFException e) {

        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String remove(ContactRecord filteredRecord) {
        recordList.remove(filteredRecord);
        return "The record removed! \n";
    }

    public void recordDetails(String selectedRecordNum) {
        System.out.println(recordList.get(Integer.valueOf(selectedRecordNum)).toString());
    }

    public void showRecordDetails(ArrayList<ContactRecord> recordList) {
        for (int i = 1; i <= recordList.size(); i++) {
            String record = i + ". " + recordList.get(i - 1).getInfo().toString();
            System.out.println(record);
        }
    }


    public void persistData(ArrayList<ContactRecord> recordList) throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(filepath));
        if (filepath.length() > 0) {
            oos.writeObject(recordList);
        }
    }

    public String count() {
        return "The Phone Book has " + recordList.size() + " records";
    }

    public ArrayList<ContactRecord> getRecordList() {
        return recordList;
    }

    public Scanner getScanner() {
        return scanner;
    }


    public String getFilepath() {
        return filepath;
    }
}
