package DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PrintAlphabeticallyCharacters {


    public static void main(String[] args) {


        char a[] = {'t','a','y','e','p'};
        TreeSet<Character> d = new TreeSet<>();
        for(char w:a)
        {
            d.add(w);
        }
        for(char t:d) {
            System.out.println(t);
        }

    }


}
