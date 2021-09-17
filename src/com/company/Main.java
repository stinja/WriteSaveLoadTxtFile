package com.company;

import java.util.Scanner;
import java.io.*;


public class Main {

    /* ---- Quote listing -------------------------------------------
    Add/Save/Load quotes using a master text file.
    To avoid accidental overwrite, have program create a back up file
    and save file to a folder called backups.
    ------------------------------------------------------------  **/

    /* ---- Start Menu -----------------------------------------
    Start menu that runs at the beginning of the program.
    Anytime an action is completed display this menu.
    This should be the only way to exit in program.
    ------------------------------------------------------------  **/
    static int startMenu() {

        Scanner menuInput = new Scanner(System.in);

        System.out.println("QUOTESAVE");
        System.out.println("by STINJA\n\n");
        System.out.println("01. ADD A QUOTE");
        System.out.println("02. SHOW QUOTES");
        System.out.println("03. EDIT QUOTES");
        System.out.println("04. DELETE QUOTES");
        System.out.println("05. QUIT/EXIT");
        System.out.println("\n\nWhat would you like to do?");
        System.out.print("Please enter a number: ");

        int menuItem = menuInput.nextInt();

        return menuItem;
    }

    public static void main(String[] args) throws IOException {

        //TODO refactor and use methods
        //TODO add exception handling
        //TODO create a menu

        startMenu();

        File file = new  File("quotesList.txt"); // create the file
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file, true);

        Scanner input = new Scanner(System.in);

        // set index
        System.out.print("Enter quote index: ");
        int quoteIndex = input.nextInt();
        input.nextLine(); // advance scanner due to scanner bug

        // write index
        fileWriter.write("Quote #" + quoteIndex);
        fileWriter.flush();

        // set quote
        System.out.print("Enter quote: ");
        String quoteContent = input.nextLine();

        // write quote
        fileWriter.write("\n\"" + quoteContent + "\"");
        fileWriter.flush();

        // set author
        System.out.print("Enter author: ");
        String quoteAuthor = input.nextLine();

        // write author, add line after
        fileWriter.write("\nby " + quoteAuthor + "\n");
        fileWriter.flush();

        // add line and close
        fileWriter.close();

        // Read the file into a character array
        FileReader fileReader = new FileReader(file);
        char [] someChar = new char[250];
        fileReader.read(someChar); // reads the content to the someChar array

        /**
        // Output the file to the screen
        for (char c : someChar) // some sort of "enhanced for loop"
            System.out.print(c);
        fileReader.close(); **/

    }
}
