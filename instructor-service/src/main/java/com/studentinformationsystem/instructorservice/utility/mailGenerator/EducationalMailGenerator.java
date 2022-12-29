package com.studentinformationsystem.instructorservice.utility.mailGenerator;

import org.springframework.stereotype.Component;

@Component
public class EducationalMailGenerator {
    public static String generate(String firstName, String lastName) {
        String eduMail = firstName.toLowerCase() + "." + lastName.toLowerCase()+"@deu.edu.tr";
        return replaceCharsTrToEn(eduMail);
    }

    public static String replaceCharsTrToEn(String mail) {
        String result = mail;
        char[] turkishChars = new char[]{'ç', 'ğ', 'ı', 'ö', 'ş', 'ü'};
        char[] englishChars = new char[]{'c', 'g', 'i', 'o', 's', 'u'};
        for (int i = 0; i < turkishChars.length; i++) {
            result = result.replace(turkishChars[i], englishChars[i]);
        }
        return result;
    }
}
