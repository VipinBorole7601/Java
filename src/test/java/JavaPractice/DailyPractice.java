package JavaPractice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DailyPractice {
    public static void main(String[] args) {


        int a [] = {22,11,2,5,1,6,16,8};
        int temp=0;

        for(int i=0;i<a.length-1;i++)
        {
            for(int j=i+1;j<a.length-1;j++)
            {
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;

                }


            }
            System.out.println("assending order is:-"+a[i]);
        }





    }

}