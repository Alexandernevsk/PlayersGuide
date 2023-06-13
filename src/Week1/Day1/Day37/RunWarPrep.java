package Week1.Day1.Day37;

public class RunWarPrep {
    public static void main(String[] args) {
        ExcaliburSword basicSword = new ExcaliburSword();
        var modifiedSword = basicSword.swordWithMaterial(null);
        var modifiedSword1 = basicSword.swordWithGems(Gem.SAPPHIRE);
        ExcaliburSword enhancedSword = new ExcaliburSword(100,50, Gem.SAPPHIRE, Material.STEEL);
        ExcaliburSword otherSword = new ExcaliburSword(50,0, Gem.SAPPHIRE, Material.STEEL);
        System.out.println(otherSword);
        System.out.println(basicSword);
        System.out.println(enhancedSword);
        System.out.println(modifiedSword1);
        System.out.println(modifiedSword);
    }
}
