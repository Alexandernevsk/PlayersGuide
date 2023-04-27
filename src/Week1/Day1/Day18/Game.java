package Week1.Day1.Day18;

public class Game {
    private int manticoreHealthPoints = 10;
    private int consolasHealthPoints = 15;

    public int displayConsolas (){
        return consolasHealthPoints;
    }
    public void reduceConsolasHp(){
        consolasHealthPoints--;

    }
    public int displayManticoreHp(){
        return manticoreHealthPoints;
    }
    public void reduceManticoreHp(int i){
        if(i % 15 == 0){
            manticoreHealthPoints -= 10;
        }else if(i % 5 == 0){
           manticoreHealthPoints -= 3;
        }else if (i % 3 == 0){
          manticoreHealthPoints -= 3;
        }else manticoreHealthPoints--;
    }
}

