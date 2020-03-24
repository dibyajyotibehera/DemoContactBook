package contacts.util;

import java.util.regex.Pattern;

public final class PhoneValidator {
    private static Pattern regexPattern = Pattern.compile("^\\+?([\\da-zA-Z]{1,}[\\s-]?)?(\\([\\da-zA-Z]{2,}(\\)[\\s-]|\\)$))?([\\da-zA-Z]{2,}[\\s-]?)*([\\da-zA-Z]{2,})?$");

    public static void validatePhoneNum(String phoneNum) {
        if (!regexPattern.matcher(phoneNum).matches()) {
            System.out.println("Wrong number format!");
        }
    }
}
