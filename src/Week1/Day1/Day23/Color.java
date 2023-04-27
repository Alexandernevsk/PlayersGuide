package Week1.Day1.Day23;



public class Color {
    /*Wat me tot nu toe niet is gelukt is om verschillende constructors te creëren.
      De  verschillende constructors waren voor mij handig geweest in het makkelijk invoeren van verschillende inputs
      voor de verschillende kleuren. De volgende constructors had ik graag willen creëeren.
      1. zwart, deze is wel gelukt. Dit is de no-args constructor, en ik dacht deze is handig omdat deze de standaard kleur aangeeft
      2. wit, had ik graag ook als een no-args constructor willen maken, maar dat kan niet omdat zwart dat al is.
                    Ik heb deze met een argument gegeven waar alle waardes gelijk zijn aan 255.
      3. Een kleur, het probleem is dat de manier waarop ik wit heb gedefinieerd heb, ervoor zorgt
      dat ik geen ander constructor met een argument kan geven.
      Ik had rondgespeeld met de een argument constructor, maar dan kan ik die alleen aanmaken voor een kleur,
      en dan vallen de andere kleuren weg.
      4. Twee kleuren, weer hetzelfde probleem als met 3. Als ik eenmaal twee kleuren kies, dan valt er een weg.
      Ik weet niet of ik dit met this-keyword kan verhelpen.
      5. Alle kleuren, deze constructor is wel gelukt, maar vind ik onhandig als je bijvoorbeeld verschillende tinten van rood wilt
      zonder dat je de waardes van de andere kleuren wil veranderen. Het is gebruiksvriendelijk als je dan slechts met een constructor hoeft te werken
      met een argument.
     */
    private int green;
    private int red;
    private int blue;
    private Color color;

    public final static Color Black = new Color();
    public final static Color GREEN = new Color(128,0,0);
    public final static Color ORANGE = new Color(165,255,0);
    public final static Color PURPLE = new Color(0,128,128);
    public final static Color YELLOW = new Color(128,255,0);
    public final static Color RED = new Color(0, 255,0);
    public final static Color BLUE = new Color(0,0,255);
    private final static Color WHITE = new Color(255);




    /* De verschillende kleuren
    * Oranje rood: 255  groen: 165: blauw: 0
    * Rood  rood: 255 groen: 0 blauw: 0
    * Geel rood 255 groen: 128 blauw:0
    * Paars rood: 128 groen: 0 blauw: 128
     */
    public static void main(String[] args) {
        System.out.println(Color.WHITE.toString());
        Color color1 = new Color(100,200,50);
        System.out.println(color1);
    }
    public Color() {
        green = 0;
        red = 0;
        blue = 0;
    }
    public Color(int all) {
       green = blue = red = all;
       checkBounds();
    }


    public Color(int green, int red, int blue) {
        this.green = green;
        this.red = red;
        this.blue = blue;
        checkBounds();
    }

    public void checkBounds(){
        if(green < 0 || green > 255) {
            throw new IllegalArgumentException("Number must be in between 0 and 255.");
        }
        if(red < 0 || red > 255) {
            throw new IllegalArgumentException("Number must be in between 0 and 255.");
        }
        if(blue < 0 || blue > 255) {
            throw new IllegalArgumentException("Number must be in between 0 and 255.");
        }
    }
    @Override
    public String toString() {
        return "Color{" +
                "green=" + green +
                ", red=" + red +
                ", blue=" + blue +
                '}';
    }
}


