package co.edu.sena.lesson08.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Ejemplo02 {
    public static void main(String[] args){
        String email = "hemoreno3 3.l.l.l.l.l@misena.edu.co";



            if (EmailUtil.validateEmail(email,EmailUtil.EmailUtilPattern.PATTERN_EMAIL_SENA)) {
                System.out.println("el correo correcto");
            }else {
                System.out.println("el correo no es correcto ");

            }

    }
}
