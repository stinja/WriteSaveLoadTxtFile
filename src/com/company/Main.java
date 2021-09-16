package com.company;

import java.util.Scanner;
import java.io.*;


public class Main {

    /* ---- Quote listing -------------------------------------------
    Add/Save/Load quotes using a master text file.
    To avoid accidental overwrite, have program create a back up file
    and save file to a folder called backups.
    ------------------------------------------------------------  **/

    public static void main(String[] args) throws IOException {

        File file = new  File("quotesList.txt"); // create the file
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);

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
        // write author
        fileWriter.write("\nby " + quoteAuthor);
        fileWriter.flush();

        fileWriter.close();

        // Read the file into a character array
        FileReader fileReader = new FileReader(file);
        char [] someChar = new char[250];
        fileReader.read(someChar); // reads the content to the someChar array

        // Output the file to the screen
        for (char c : someChar) // some sort of "enhanced for loop"
            System.out.print(c);
        fileReader.close();

    }
}
