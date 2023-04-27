package Week1.Day1.Day27;

import java.util.Scanner;

public class Password extends Validator{
    private String password;

    public static void main(String[] args) {
        Password password = new Password();
        System.out.println(password.getPassword());

    }

/* I don't know whether this is the best way of doing it.
 * But essentially I made this constructor ask for a valid input with the validator,
 * before any other methods may manipulate or use the password,
 * such that the password always follows the standard requirements.
 */

    public String getPassword() {
        return password;
    }

    public Password() {
       while(password == null){
           password = Checker(passwordScanner());
           if(password != null){
               break;
           }
       }
    }
    public static String passwordScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
