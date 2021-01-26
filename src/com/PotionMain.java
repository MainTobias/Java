package com;

public class PotionMain {
    public static void main(String[] args) {
        // Zutaten werden erstellt
        Ingredient ingredient1 = new Ingredient("Toad");
        Ingredient ingredient2 = new Ingredient("Lizard");
        Ingredient ingredient3 = new Ingredient("Spider");
        // set name of ingredient1 to "Fly "
        ingredient1.setName("Fly");
        // Zaubertrank wird mit 2 Zutaten erstellt
        Potion potion = new Potion(ingredient1, ingredient2, ingredient3);
        // Zaubertrank wird dreimal umger ¨uhrt
        potion.stir();
        potion.stir();
        potion.stir();
        // Information ¨u ber den Zaubertrank wird ausgegeben
        System.out.println(potion);
        // Ingredients : Fly , Lizard , Spider
        // Power : 15
        // Ready : no

        // Zaubertrank wird noch zwei mal umger ¨uhrt
        potion.stir();
        potion.stir();
        // Informationen über Zaubertrank wird erneut ausgegeben
        System.out.println(potion);
        // Ingredients : Fly , Lizard , Spider
        // Power : 30
        // Ready : yes
        System.out.println(potion.ingredients);
    }
}
