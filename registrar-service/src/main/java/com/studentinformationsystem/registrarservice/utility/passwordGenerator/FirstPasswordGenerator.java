package com.studentinformationsystem.registrarservice.utility.passwordGenerator;

public class FirstPasswordGenerator {
    public static String generate() {
        String lowerCases = "abcdefghijklmnoprstuvyzxwq";
        String upperCases = "ABCDEFGHIJKLMNPRSTUVYZXWQ";
        String numbers = "0123456789";
        String specialCharacters = "?*-_=/&%+!.";

        String createdPassword = "";

        for (int i = 0; i < 12; i++) {
            int rand = (int) (4 * Math.random());
            int position = 1;
            switch (rand) {
                case 0:
                    position = (int) (lowerCases.length() * Math.random());
                    createdPassword += String.valueOf(lowerCases.charAt(position));
                    break;
                case 1:
                    position = (int) (upperCases.length() * Math.random());
                    createdPassword += String.valueOf(upperCases.charAt(position));
                    break;
                case 2:
                    position = (int) (numbers.length() * Math.random());
                    createdPassword += String.valueOf(numbers.charAt(position));
                    break;
                case 3:
                    position = (int) (specialCharacters.length() * Math.random());
                    createdPassword += String.valueOf(specialCharacters.charAt(position));
                    break;
            }
        }
        return createdPassword;
    }
}
