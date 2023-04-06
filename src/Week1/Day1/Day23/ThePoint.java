package Week1.Day1.Day23;
public class ThePoint {
    /*Ik dacht dat final wel goed was vanwege de vraag of die onveranderbaar waren.
     * De waardes, nadat ze zijn geinitialiseerd, worden niet verandered en representeren allemaal een punt op een
     * Coordinaten-stelsel.
     */
final int x;
final int y;

    public ThePoint() {
        x = 0;
        y = 0;
    }
/*Constructor, zoals uitgelegd, werkt volgens auto-identificatie. Als de parameters worden geinitialiseerd,
 * Dan krijgt het object alle waardes die worden geinitialiseerd anders dan gaat die automatisch naar nul.
 * In deze opdracht heb je dus twee constructors nodig, want anders kun je geen nieuwe coordinaten toevoegen met een
 * constructor.
 */
    public ThePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        ThePoint point = new ThePoint();
        System.out.println(point.x + ", " + point.y);
        ThePoint point1 = new ThePoint(2,-4);
        ThePoint point2 = new ThePoint(2,3);
        System.out.println(point1.x + ", " + point1.y);
        System.out.println(point2.x + ", " + point2.y);

    }

}
