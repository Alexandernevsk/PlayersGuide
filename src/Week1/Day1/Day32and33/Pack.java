package Week1.Day1.Day32and33;

import java.util.*;


public class Pack {
    private List<Item> pack = new ArrayList<>();
    private static final double MAX_VOLUME_CAPACITY = 12;
    private static final double MAX_WEIGHT_CAPACITY = 12;
    private static final int MAX_NUMBER_OF_ITEMS = 7;


    public void addItem(Item item) {
        if(possibleAdd(item)) {
            pack.add(item);
        }else System.out.println("\nOVER-CAPACITY\n");
    }



    public String showPackContents(){
        var stringBuilder = new StringBuilder();
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (Item item : pack) {
            String itemName = item.toString();
            int currentCounter = frequencyMap.getOrDefault(itemName, 0);
            frequencyMap.put(itemName, currentCounter + 1);
        }

        for(var value : frequencyMap.entrySet()) {
            stringBuilder.append(("%s : %d\n").formatted(value.getKey(), value.getValue()));
        }

        stringBuilder.append(("%s : %d\n").formatted("current total items", pack.size()));
        return stringBuilder.toString();
    }

    public List<Item> getPack() {
        return pack;
    }

    public double getCurrentWeightCapacity(){
        double weightCapacity = 0;
        for(Item items: pack){
            weightCapacity += items.getDECIMAL_WEIGHT();
        }
        return weightCapacity;
    }

    public double getCurrentVolumeCapacity(){
        double volumeCapacity = 0;
        for(Item items: pack){
            volumeCapacity += items.getDECIMAL_VOLUME();
        }
        return volumeCapacity;
    }


    public boolean possibleAdd(Item item) {
      if(pack.size() < MAX_NUMBER_OF_ITEMS){
          return item.getDECIMAL_VOLUME() + getCurrentVolumeCapacity() <= MAX_VOLUME_CAPACITY
                  && item.getDECIMAL_WEIGHT() + getCurrentWeightCapacity() <= MAX_WEIGHT_CAPACITY;
      }else return false;
    }



    @Override
    public String toString() {
        return "Your pack consists of: \n\n" +
                ("%s : %.2f\n").formatted("Max Weight-Capacity", MAX_WEIGHT_CAPACITY) +
                ("%s : %.2f\n").formatted("Max Volume-Capacity", MAX_VOLUME_CAPACITY) +
                ("%s : %d\n").formatted("Max Item-Capacity", MAX_NUMBER_OF_ITEMS) +
                "\n\n" +
                ("%s : %.2f\n").formatted("Weight-Capacity", getCurrentWeightCapacity()) +
                ("%s : %.2f\n").formatted("Volume-Capacity", getCurrentVolumeCapacity()) +
                showPackContents();
    }
}




