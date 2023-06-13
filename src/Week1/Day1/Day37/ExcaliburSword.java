package Week1.Day1.Day37;



public record ExcaliburSword(double bladeLength, double crossguardWidth, Gem gem, Material material) {
    //Added a validation check, to ensure length and width can't go negative.
    public ExcaliburSword {
        if (bladeLength < 0) {
            throw new IllegalArgumentException("Blade length cannot be negative");
        }
        if (crossguardWidth < 0) {
            throw new IllegalArgumentException("Crossguard width cannot be negative");
        }
    }

    //No-Args-Constructor for the basic Sword;

    public ExcaliburSword() {
        this(0,0, null, Material.IRON);
    }

    public ExcaliburSword swordWithMaterial(Material material){
        return new ExcaliburSword(this.bladeLength, this.crossguardWidth(), this.gem, material);
   }

   public ExcaliburSword swordWithGems(Gem gem){

       return new ExcaliburSword(this.bladeLength, this.crossguardWidth(), gem, this.material);
   }

   //Different strings for the ToString Method of the ExcaliburSword record;
   //Point is to remove the text if any of these fields is null or zero;
   //Doesn't work as fluently as I wanted to, but at this point I settle for mediocrity.

    public String crossguardWidthName(){
        return String.format(" a crossguard width of %.2f centimetres", crossguardWidth);
   }
    public String bladeLengthName(){
        return String.format(" of %.2f centimetres long", bladeLength);
    }
    public String gemName(){
       return String.format(" an embedded %s", gem);
    }

    /** TODO make classification system, where different lengths of swords correspond with certain types of swords.
     *      For example bastard sword corresponds to certain length of 120 cm;
     *      Different types of crossguard also get a type-name;
     *      Suggestions: I could, don't know whether it is a good design pattern, create a Enum for placeholder swords.
     *                      By which I mean the different lengths and cross guards.
     *                      Else it will be custom by design.
     */

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(material != null){
            stringBuilder.append(("%s ").formatted(material));
        }

        stringBuilder.append("sword");

        if (crossguardWidth != 0 && bladeLength != 0) {
            stringBuilder.append(("%s,%s").formatted(bladeLengthName(), crossguardWidthName()));
        }else if(crossguardWidth == 0 && bladeLength != 0){
            stringBuilder.append(("%s").formatted(bladeLengthName()));
        }else if(crossguardWidth != 0) {
            stringBuilder.append((" with%s").formatted(crossguardWidthName()));
        }


        if (gem != null) {
            stringBuilder.append(" and").append(gemName());
        }

        stringBuilder.append(".");

        return Character.toUpperCase(stringBuilder.toString().charAt(0)) + stringBuilder.substring(1);
    }

}




