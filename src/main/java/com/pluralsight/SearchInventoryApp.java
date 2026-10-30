package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SearchInventoryApp {

    public static void main(String[] args) {

        ArrayList<Product> inventory = new ArrayList<>();
        inventory = getInventory(inventory);

        for (Product currentProduct : inventory) {
            currentProduct.display();
        }

    }


    public static ArrayList<Product> getInventory (ArrayList<Product> inventory) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] arguments = line.split(Pattern.quote("|"));
                inventory.add(new Product(Integer.parseInt(arguments[0]), arguments[1], Double.parseDouble(arguments[2])));
            }
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return inventory;
    }

}
