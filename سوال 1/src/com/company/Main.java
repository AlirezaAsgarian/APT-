package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first_input = new String();
        String main_text = new String();
        ArrayList<String> words = new ArrayList<>();
    //    first_input = scanner.nextLine();
        String sizeoflines = first_input.replaceAll("[^0-9]", "");

        while (scanner.hasNext()) {
            String temp1 = scanner.nextLine();
           // System.exit(0);
           /* String[] splitStr = temp1.split("\\s+");
            for (String strTemp : splitStr) {
                words.add(strTemp);
               // System.out.println(strTemp);
            }
            //words.add(scanner.nextLine());
            //System.out.println(words.get(0));

            */
        }

        int max_width = Integer.parseInt(sizeoflines);
        int index = 0;
        int max_width_copy = max_width;
        char temp = 'J';
/*if(first_input.charAt(0) == temp) {
    while (words.size() > 1) {

        //words.add(scanner.next());
        if (words.get(index).length() <= max_width_copy) {
            max_width_copy -= (words.get(index).length() + 1);
            //System.out.println("words "+index+" = "+words.get(index));
        } else {
            // System.out.println("index= "+index);
            int gaps = index - 1;
            if (index == 1 || gaps == 0) {
                System.out.println(words.get(index - 1));
                words.remove(index - 1);
                index = 0;
                max_width_copy = max_width - words.get(index).length() - 1;
            } else {
                // System.out.println(max_width_copy);
                max_width_copy += index;
                int number_spaces = max_width_copy / gaps;
                int rest = max_width_copy % gaps;
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < index; i++) {
                    line.append(words.get(i));
                    for (int j = 0; j < number_spaces; j++) {
                        line.append(" ");
                    }
                    if (rest != 0) {
                        line.append(" ");
                        --rest;
                    }
                }
                for (int i = 0; i < index; i++) {
                    //System.out.println(words.get(i)+"hello bacheha\n");
                    words.remove(0);

                }
                System.out.println(line);
                index = 0;
                // System.out.println("words "+index+" = "+words.get(index));
                max_width_copy = max_width - (words.get(index).length() + 1);
            }
        }

        // if(index != 0){words[index].deleteCharAt(0);}
        //System.out.println(words);
        ++index;
        //System.out.println(fmt.format("heeey |%-15s|\n", main_text));
    }
    if (index == 1) {
        System.out.println(words.get(index - 1));
    }

}
else {
    while (words.size() > 1) {

       // words.add(scanner.next());
        if (words.get(index).length() <= max_width_copy) {
            max_width_copy -= (words.get(index).length() + 1);
            //System.out.println("words "+index+" = "+words.get(index));
        } else {
            // System.out.println("index= "+index);
            int gaps = index - 1;
            if (index == 1 || gaps == 0) {
                System.out.println(words.get(index - 1));
                words.remove(index - 1);
                index = 0;
                max_width_copy = max_width - words.get(index).length() - 1;
            } else {
                // System.out.println(max_width_copy);
                max_width_copy += index;
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < index; i++) {
                    line.append(words.get(i));
                    line.append(" ");
                }
                for (int i = 0; i < index; i++) {
                    //System.out.println(words.get(i)+"hello bacheha\n");
                    words.remove(0);

                }
                System.out.println(line);
                index = 0;
                // System.out.println("words "+index+" = "+words.get(index));
                max_width_copy = max_width - (words.get(index).length() + 1);
            }
        }

        // if(index != 0){words[index].deleteCharAt(0);}
        //System.out.println(words);
        ++index;
    }
}
if(index == 1){
    System.out.println(words.get(index));}
    }
    */

    }
}
/*
L15
Both are equally immoral.
observed one of the guests, for they both have the same object to take away life.
The State is not God.
It has not the right to take away what it cannot restore.
J40
Both are equally immoral.
observed one of the guests, for they both have the same object to take away life.
The State is not God.
It has not the right to take away what it cannot restore.
*/
