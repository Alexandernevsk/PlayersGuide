package Week1.Day1.Day27;

public class Validator {
    final static int MAX = 13;
    final static int MIN = 6;

    public String Checker(String password){
        if(checkLength(password)){
           if(checkForCapitalTAndAmperSand(password)){
               if(checkUpperCase(password)){
                   if(checkLowerCase(password)){
                       if(checkForNumber(password)) {
                           return password;
                       }
                   }
               }
           }
        }
        return null;
    }
    public boolean checkLength(String password){
        if(!(password.length() >= MIN && password.length() <= MAX)){
            System.out.println("Length must be between 6 and 13 letters.");
            return false;
        } else return true;
    }
    public boolean checkUpperCase(String password) {
        for (Character e : password.toCharArray()) {
            if(Character.isUpperCase(e)){
                    return true;
            }
        }
        System.out.println("Character must have at least one upper case letter.");
        return false;
    }
    public boolean checkLowerCase(String password) {
        for (Character e : password.toCharArray()) {
            if(Character.isLowerCase(e)){
                return true;
            }
        }
        System.out.println("Character must have at least one lower case letter.");
        return false;
    }
    public boolean checkForCapitalTAndAmperSand(String password){
      if(password.contains("&") || password.contains("T")){
          System.out.println("No ampersands or capital T's.");
          return false;
      } else return true;
    }
    public boolean checkForNumber(String password){
        for(Character e : password.toCharArray()){
            if(Character.isDigit(e)){
                return true;
            }
        }
        System.out.println("Must have at least one number.");
        return false;
    }
}
