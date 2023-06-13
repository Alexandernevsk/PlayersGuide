package Week1.Day1.Day32and33;

public enum MenuOptions {

        ROPE {
            @Override
            public void addItem(Pack pack) {
                pack.addItem(new Rope());
            }




        }, ARROW{
            @Override
            public void addItem(Pack pack) {
                pack.addItem(new Arrow());
            }



    }, SWORD{
            @Override
            public void addItem(Pack pack) {
                pack.addItem(new Sword());
            }



    }, FOOD_RATIONS {
            @Override
            public void addItem(Pack pack) {
                pack.addItem(new FoodRations());
            }



    }, WATER{
            @Override
            public void addItem(Pack pack) {
                pack.addItem(new Water());
            }


    }, BOW {
            @Override
            public void addItem(Pack pack) {
                pack.addItem(new Bow());
            }




    };
        public abstract void addItem(Pack pack);

        public static MenuOptions checkMenu(String input){
            for(var option : MenuOptions.values()){
                if(input.equalsIgnoreCase(option.toString())){
                    return option;
                }
            }
            return null;
        }

    @Override
    public String toString() {
            if(this.name().contains("_")){
                String newName = this.name().charAt(0) + name().substring(1, name().indexOf("_")).toLowerCase() +
                        name().charAt(4) + name().charAt(5) + name().substring(6).toLowerCase();
                return newName.replaceAll("_", " ");
            } else return this.name().charAt(0) + name().substring(1).toLowerCase();
    }

}


