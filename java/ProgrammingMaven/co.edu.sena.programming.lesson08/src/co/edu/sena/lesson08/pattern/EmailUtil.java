package co.edu.sena.lesson08.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EmailUtil {


    public static boolean validateEmail(String email, EmailUtilPattern patron) throws PatternSyntaxException {
        try {
            // Compila la expresión regular.
            Pattern pattern = Pattern.compile(patron.expresionRegular);
            // crea un patrón a partir de la expresión regular
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } catch (PatternSyntaxException e) {
            return false;
        }

    }

    public enum EmailUtilPattern {
        PATTERN_EMAIL("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
        PATTERN_EMAIL_SENA("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@misena.edu.co$");

        private String expresionRegular;

        EmailUtilPattern(String expresionRegular) {
            this.expresionRegular = expresionRegular;
        }

        public String getExpresionRegular() {
            return expresionRegular;
        }
    }

}
