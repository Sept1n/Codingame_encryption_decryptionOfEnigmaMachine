import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (in.hasNextLine()) {
            in.nextLine();
        }
        ArrayList<String> rotors = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            String rotor = in.nextLine();
            rotors.add(rotor);
        }
        String mess = in.nextLine();
        StringBuilder message = new StringBuilder();
        message.append(mess);
        if (operation.equals("ENCODE")) {
            for(int i = 0; i < message.length(); i++) {
                int ascii = message.charAt(i);
                ascii += pseudoRandomNumber;
                while(ascii > 90) {
                    ascii -= 26;
                }
                char c = (char)ascii;
                message.setCharAt(i, c);
                pseudoRandomNumber++;
            }
            for (int i = 0; i < rotors.size(); i++) {
                for (int j = 0; j < message.length(); j++) {
                    int position = alphabet.indexOf(message.charAt(j));
                    message.setCharAt(j, rotors.get(i).charAt(position));
                }
            }
            System.out.println(message);
        }
        else {
            System.err.println(rotors.size());
            for (int i = rotors.size() - 1; i > -1; i--) {
                for (int j = 0; j < message.length(); j++) {
                    int position = rotors.get(i).indexOf(message.charAt(j));
                    message.setCharAt(j, alphabet.charAt(position));
                }
            }
            System.err.println(message);
            for (int i = 0; i < message.length(); i++) {
                int ascii = message.charAt(i);
                ascii -= pseudoRandomNumber;
                while(ascii < 65) {
                    ascii += 26;
                }
                char c = (char)ascii;
                message.setCharAt(i, c);
                pseudoRandomNumber++;
            }
            System.out.println(message);
        }
    }
}