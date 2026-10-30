package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchInventoryApp {

    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Product> inventory = new ArrayList<>();
        inventory = getInventory(inventory);
        menu();

        for (Product currentProduct : inventory) {
            currentProduct.display();
        }

    }

    public static void menu () {
        String answer = "0";
        do {
            System.out.println("""
                    What do you want to do?
                    1- List all products
                    2- Lookup a product by its id
                    3- Find all products within a price range
                    4- Add a new product
                    5- Quit the application
                    Enter command:
                    """);
            answer = userInput.nextLine();
        } while (!isNumberOnMenu(answer));
        System.out.println("yippe!");
    }

    public static boolean isNumberOnMenu (String answer) {
        int menuLength = 5;
        String menuNumber;
        HashMap<String, Boolean> number = new HashMap<>();
        for (int i = 1; i <= menuLength; i++) {
            menuNumber = String.format("%d", i);
            number.put(menuNumber, true);
        }
        if (number.get(answer) == null) {
            return false;
        } else {
            return number.get(answer);
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
