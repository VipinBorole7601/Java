package DSA;

import java.util.HashMap;
import java.util.Map;

public class StringCountRepetedCharecter {

    public static void main(String[] args) {

        String a="Engineer";


        Map<Character,Integer> d = new HashMap<>();

        for(char r:a.toCharArray())
        {
            if(d.containsKey(r))
            {
                int count = d.get(r)+1;
                d.put(r,count);
            }
            else {
                d.put(r,1);
            }
        }

        for(Map.Entry<Character,Integer> print:d.entrySet())
        {

            System.out.println(print.getKey()+" - "+print.getValue());

        }

    }

}
