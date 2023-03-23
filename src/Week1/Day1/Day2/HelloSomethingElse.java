package Week1.Day1.Day2;
import java.util.Scanner;
public class HelloSomethingElse {
    /*opdracht is een beetje onduidelijk
  "Objective: Change your program to say something besides "Hello, World!""
  interpretatie a) laat het iets anders zeggen d.w.z. verander iets in de print command
  interpretatie b1) gebruik methode voor variabele input of b2) maak een Scanner zodat gebruiker zelf iets kan invoeren.
 */
    public class HelloSomethingelse {
        public static void main(String[] args) {
            //interpretatie c kan ook nog het onderstaande zijn!
            System.out.println("Something Besides Hello, World!");
            //interpretatie a
            System.out.println("No");
            // interpretatie b1
            Scanner somethingelse = new Scanner(System.in);
            System.out.println("Hello " + somethingelse.nextLine());
            System.out.println(SomethingElse("Hello There!"));
        }
        //Interpretatie b1
        public static String SomethingElse(String toSay){
            return toSay;
        }
    }
}
