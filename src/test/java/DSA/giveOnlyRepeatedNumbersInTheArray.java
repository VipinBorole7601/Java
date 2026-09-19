package DSA;

import java.util.HashMap;
import java.util.Map;

public class giveOnlyRepeatedNumbersInTheArray {

    public static void main(String[] args) {


        int [] num = {3,2,1,1,6,6,8,2,1};

        HashMap<Integer,Integer> g = new HashMap<>();
        for(int n:num)
        {
            if(g.containsKey(n))
            {
                int count = g.get(n)+1;
                g.put(n,count);
            }
            else {
                g.put(n,1);
            }
        }
        for(Map.Entry<Integer,Integer> data:g.entrySet())
        {

            System.out.println("this is number "+data.getKey()+" "+" this is the count "+data.getValue());


        }
    }


}
