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
 * The doubt is mainly because an optional setPassword to change the current password,
 * will follow the same logic.
 */

    public String getPassword() {
        return "This " + password + " password is a valid one!.";
    }

    public Password() {
        String description =
                "To create a password you need to follow several conditions.\n" +
                "\t1. It must be between the length of 6 and 13 characters.\n" +
                        "\t2. It must contain at least one upper case and lower case letter.\n" +
                        "\t3. It must also contain a number.\n" +
                        "\t4. All white spaces will be automatically removed from the password. Be careful! \n" +
                "\t5. Lastly, for whatever reason it cannot have a ampersand (&) or capital T.\n";
        System.out.println(description);
        System.out.print("Type in your candidate password here, to check whether it is valid.\n");
       while(password == null){
           password = Checker(passwordScanner());
           if(password != null){
               break;
           }
       }
    }
    public static String passwordScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().replaceAll(" ", "");
    }

}
