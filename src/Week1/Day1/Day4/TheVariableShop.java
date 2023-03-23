package Week1.Day1.Day4;

public class TheVariableShop {
    public static void main(String[] args) {
        //Zijn de verschillende literals van de numbers ook nodig? Als Hexadecimaal, octogonaal naast decimaal?
        int integer = 10;
        double doubleNum = 1.2;
        float floatingNum = 1.1f;
        long longerNum = (long)Math.pow(10,10);
        short shortNum = 22;
        byte numbOne = 01;
        char letA = 'a';
        boolean shopOpen = false;
        String shopSign = "Shop is open!";
        System.out.println(integer + " Int " + doubleNum + " Double " + floatingNum + " Float " + longerNum +
                " Long "  + shortNum + " Short " + numbOne + " Byte " + letA + " Char " +
                shopOpen + " Boolean " + shopSign + " Text Type");
        //Hieronder de veranderende waarde
        integer += 1;
        doubleNum += 1.1;
        floatingNum += 1.3;
        longerNum += 100000;
        shortNum += 1;
        //byte verandert nu in twee
        numbOne += 1;
        letA = 'b';
        shopOpen = false;
        shopSign = "Shop is Closed!";
        System.out.println(integer + " Int " + doubleNum + " Double " + floatingNum + " Float " + longerNum +
                " Long "  + shortNum + " Short " + numbOne + " Byte " + letA + " Char " +
                shopOpen + " Boolean " + shopSign + " Text Type");
    }
}
