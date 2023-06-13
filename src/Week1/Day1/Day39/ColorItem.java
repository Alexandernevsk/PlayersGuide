package Week1.Day1.Day39;

import java.awt.*;

public class ColorItem <T> {
    T item;
    enum ItemColor {
        ANSI_RESET ("\u001B[0m"),
        ANSI_BLACK ( "\u001B[30m"),
        ANSI_RED ( "\u001B[31m"),
        ANSI_GREEN ( "\u001B[32m"),
        ANSI_YELLOW ("\u001B[33m"),
        ANSI_BLUE ("\u001B[34m"),
        ANSI_PURPLE ("\u001B[35m"),
        ANSI_CYAN ("\u001B[36m"),
        ANSI_WHITE("\u001B[37m"),
        ANSI_RED_BOLD("\033[1;31m"),
        ANSI_YELLOW_UNDERLINED("\033[4;33m");
        private final String ansiColor;

        ItemColor(String ansiColor) {
            this.ansiColor = ansiColor;
        }

        @Override
        public String toString() {
            return ansiColor;
        }
    }

    public ColorItem() {
    }

    public ColorItem(T item) {
        this.item = item;
    }

    public String colorItem(T item, ItemColor color){
        return color + "" + item;
    }

    public String colorItem(T item){
        if(item instanceof Room){
            if(item instanceof FountainRoom){
             return ItemColor.ANSI_BLUE + this.item.toString();
            }else if(item instanceof EntranceAndExitRoom){
                return ItemColor.ANSI_YELLOW + this.item.toString();
            }
        }else if(item instanceof Player){
            return ItemColor.ANSI_PURPLE + this.item.toString();
        }else if(item instanceof Controller){
            return ItemColor.ANSI_CYAN + this.item.toString();
        }
        return null;
    }
}
