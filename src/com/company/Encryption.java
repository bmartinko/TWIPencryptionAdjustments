package com.company;

import java.util.Random;
/**
 * Created by dpennebacker on 10/28/16.
 */
public class Encryption {
    /*
     * keygen returning function By default, length is 32 characters
     * Will generate "access keys" for each user
     */

    private Random rand = new Random();

    public String keygen(){
        char a[] = new char[32];
        for(int i=0;i<32;i++){
            a[i] = (char) (rand.nextInt((90 - 48) + 1) + 48);
        }
        return new String(a);
    }

    /*
     * Takes a string seed and runs encryption algorithm on it. This allows for the creation of an array that has the amount
     * of characters the word is (while being less than 32). This then calculates the random character that will be display
     * using ASCII as the basis, and it returns the new array as the key.
     */
    public String encrypt(String seed, String key){
        int count = 0;
        char a[] = new char[seed.length()];

        for(int i=0;i<seed.length();i++){
            a[i] = seed.charAt(i);
        }

        for(int i=0;i<seed.length();i++){
            if(count > 31){
                count = 0;
            }
            a[i] = (char) (a[i] * key.charAt(count));
            count++;
        }
        return new String(a);
    }
    /*
    Seed represents the word being inputted into the array. Key represents the key at which is assigned to each user. This takes
    the amount of characters in the input, and makes an array with that amount of characters. Then it makes sure that for each
    character, the new encrypted character is generated. This also prevents counting higher than 32. Once the encryption is
    generated, it is displayed.
     */
}
