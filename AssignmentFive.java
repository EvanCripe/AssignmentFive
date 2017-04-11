package lab7c202;

import java.io.*;
import java.util.*;

/**
 * AssignmentFive.java Purpose is to read from a file and check if the words in 
 * that file are also in a dictionary using binary search tree. 
 * @author Evan Cripe
 * @version 1.0 2/18/17
 */
public class AssignmentFive {
    BinarySearchTree[] list = new BinarySearchTree[26];
    int wordsFound = 0;
    int wordsNotFound = 0;
    long compsFound = 0;
    long compsNotFound = 0;
    int mostComparisons = 0;
    
    /**
     * Constructor that will load list with the words in "random_dictionary.txt"
     * All words that start with 'a' will be stored in list[0], words starting
     * with 'b' will be stored in list[1], and so on all the way up to words
     * starting with 'z' being stored in list[25]
     */
    public AssignmentFive() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new BinarySearchTree<String>();
        }//fori
        try {
            File file = new File("random_dictionary.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.next().toLowerCase().replaceAll("[^a-z]", "");
                list[line.charAt(0) - 97].insert(line);
            }//while
        }//try
        catch (IOException ex) {
            ex.printStackTrace();
        }//catch
    }//AssignmentFive
    
    /**
     * Method that will read from "oliver.txt", parse each word then compare it
     * to the words in the array of Binary Search Trees called list. It will keep count of the number
     * of words in oliver.txt that are in list, words in oliver.txt that are not in
     * list and finally the number of comparisons it goes through to find those words.
     */
    public void readOliver() {
        try {
            File file = new File("oliver.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String word = input.next().toLowerCase().replaceAll("[^a-z]", "");
                while (word.isEmpty()) {//go to next token (word) until the token is not empty
                    word = input.next().toLowerCase().replaceAll("[^a-z]", "");
                }//while
                if (list[word.charAt(0) - 97].search(word)) {
                    wordsFound++;
                    compsFound += BinarySearchTree.count;
                }//if    
                else {
                    wordsNotFound++;
                    compsNotFound += BinarySearchTree.count;
                }//else 
                if(BinarySearchTree.count > mostComparisons){
                    mostComparisons = BinarySearchTree.count;
                }//if
            }//while
        }//try
        catch (IOException ex) {
            ex.printStackTrace();
        }//catch
    }//readOliver
    
    public static void main(String[] args) {
        AssignmentFive run = new AssignmentFive();
        run.readOliver();
        System.out.println("Words found: " + run.wordsFound);
        System.out.println("Words not found: " + run.wordsNotFound);
        System.out.println("Comparisons found: " + run.compsFound);
        System.out.println("Comparisons not found: " + run.compsNotFound);
        System.out.printf("Average comparisons found: %6.4f\n", (double) run.compsFound / run.wordsFound);
        System.out.printf("Average comparisons not found: %6.4f\n", (double) run.compsNotFound / run.wordsNotFound);
        System.out.printf("Average total comparisons: %6.4f\n", (double) (run.compsNotFound + run.compsFound)/ (run.wordsFound + run.wordsNotFound));
        System.out.println("Most comparisons for a single word: " + run.mostComparisons);
    }//main
}//class
