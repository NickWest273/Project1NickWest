//Nick West Project 1
//9/21/2021
package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1NickWest {

    public static void main(String[] args) throws IOException {

        var fileName = "Inventory.txt"; //Product Inventory
        var productFile = Paths.get(fileName);
        var productName = new ArrayList<String>(); //Product Name List
        var productPrice = new ArrayList<Float>(); //Product Price List
        var numberAvailable = new ArrayList<Integer>(); //The Amount Of How Much Product Is Left
        var productLines = Files.readAllLines(productFile); //Reads through the Inventory.txt file
        for (var line : productLines) {
            var splitLine = line.split(",");
            productName.add(splitLine[0]);
            var productCost = Float.parseFloat(splitLine[1]);
            productPrice.add(productCost);
            var numberAmount = Integer.parseInt(splitLine[2]);
            numberAvailable.add(numberAmount);
        }
        var reader = new Scanner(System.in);
        var userResponse = "";
        //
        while (!userResponse.equals("done")) {
            System.out.print("Type in the name of a product or 'done to exit:");
            userResponse = reader.nextLine();
            if (userResponse.equals("done")) {
                break;
            }
            boolean found = false;
            for (int i = 0; i< productName.size(); i++){
                if (userResponse.equals(productName.get(i))) {
                    found = true;
                     System.out.println("Product: "+ productName.get(i) + " Price: " + productPrice.get(i)   + " num: " +  numberAvailable.get(i));
                }
            }
            // If user enters a product that isn't in inventory, a response comes back with "not found".
            if (found == false) {
                System.out.println("Product: " + userResponse + " not found");
            }
        }


    }
}