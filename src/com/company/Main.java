package com.company;

import java.util.Scanner;
import java.io.*;


/** --- QUOTESAVE by STINJA  -----------------
Add/Save/Load quotes using a master text file.
To avoid accidental overwrite, have program create a back up file
and save file to a folder called backups.
 ---------------------------------------------  **/

public class Main {

    /** --- Start Menu ------------------------
    Start menu that runs at the beginning of the program.
    Anytime an action is completed display this menu.
    This should be the only way to exit in program.
    -------------------------------------------  **/
    static int startMenu(Scanner menuInput) {
        // output a bunch of text
        System.out.println("QUOTESAVE");
        System.out.println("by STINJA\n\n");
        System.out.println("01. ADD A QUOTE");
        System.out.println("02. SHOW QUOTES");
        System.out.println("03. EDIT QUOTES");
        System.out.println("04. DELETE QUOTES");
        System.out.println("05. QUIT/EXIT");
        System.out.println("\n\nWhat would you like to do?");
        System.out.print("Please enter a number: ");

        // grab menu selection from scanner
        int menuSelect = menuInput.nextInt();

        // reset scanner passed in this method
        menuInput.reset();

        // return the selection as an int
        return menuSelect;
    }

    //TODO refactor and use methods
    /** Methods for later
    static void setIndex() {

    }

    static void setQuote() {

    }

    static void setAuthor() {

    }

    static void writeQuoteToFile(int index, String quote, String author) {

    }

    static void printFileToScreen() {

         // Read the file into a character array
         FileReader fileReader = new FileReader(file);
         char [] someChar = new char[250];
         fileReader.read(someChar); // reads the content to the someChar array

         // Output the file to the screen
         for (char c : someChar) // some sort of "enhanced for loop"
         System.out.print(c);
         fileReader.close();

    } **/

    public static void main(String[] args) throws IOException {


        //TODO create a menu

        File file = new  File("quotesList.txt"); // create the file
        file.createNewFile(); //TODO add check and only run if a quote file doesnt exist

        FileWriter fileWriter = new FileWriter(file, true);

        Scanner input = new Scanner(System.in);

        int menuSelect = startMenu(input); //TODO make menu work and do something with menu selection

        // set index
        System.out.print("Enter quote index: ");
        int quoteIndex = input.nextInt(); //TODO automate and increment based on previous quote index
        input.nextLine(); // advance scanner due to scanner bug

        // write index
        fileWriter.write("Quote #" + quoteIndex);
        fileWriter.flush();

        // set quote
        System.out.print("Enter quote: ");
        String quoteContent = input.nextLine(); //TODO add exception handling for quote input

        // write quote
        fileWriter.write("\n\"" + quoteContent + "\"");
        fileWriter.flush();

        // set author
        System.out.print("Enter author: ");
        String quoteAuthor = input.nextLine(); //TODO add exception handling for author input

        // write author, add line after
        fileWriter.write("\nby " + quoteAuthor + "\n");
        fileWriter.flush();

        // add line and close
        fileWriter.close();

    }
}
