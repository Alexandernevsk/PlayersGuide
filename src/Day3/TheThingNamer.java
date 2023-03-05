package Day3;

import java.util.Scanner;
public class TheThingNamer {
    public static void main(String[] args) {
        System.out.println("What kind of things are we talking about?");
        Scanner input = new Scanner(System.in);
        //Variabele veranderd van a naar noun(Zelfstandig Naamwoord)
        String noun = input.next();
        /* Deze is print command is vrij multi-interpretabel (weer!)
           Het ding is moet de Scanner voldoen aan een van de volgende suggesties?
           Zo ja moet hier nog een while-statement bij worden gemaakt.
           Aan de andere kant omdat de verschillende suggesties kwalitatief niet op elkaar lijken
           d.w.z we hebben over verschillende niet vergelijkbare eigenschappen, lijkt het ook niet per se de bedoeling te zijn om if te gebruiken.
           Qua opdracht zou ik voor de while-statement gaan, maar qua interpretatie toch de laatste.
           Als je de while wegghaald werkt het ongeveer hetzelfde als de code in de Players Guide.

           Daarbij heb ik ook de variabele b aangepast naar adject (Bijvoegelijk naamwoord)
         */
        System.out.println("How would you describe it? Big? Azure? Tattered?");
        String adject = input.next();
        while(!adject.contains("Big") && !adject.contains("Azure") && !adject.contains("Tattered") ) {
            System.out.println("Choose one of the following three options: Big, Azure, Tattered");
            adject = input.next();

        }
        /* of weggehaald aangezien het al in het laatste print command staat
           Daarbij ook de naam van variabel c vervangen met fixedAdverb
         */
        String fixedAdverb = "Doom";
        // numb ipv d als naam zou niet per se verwarrend moeten vanwege de string-class ervoor
        String numb = "3000";
        System.out.println("The " + adject + " " + noun + " " + "of " + fixedAdverb + " " + numb + "!");
    }
}
