package DSA;

public class ArrayToFindMinAndMaxValue {


    public static void main(String[] args) {
        int a[] = {2,1,5,1,66,22};
        int max =0;
        int min =0;
        for(int i=0;i<a.length-1;i++)
        {
            if(a[max]>a[i])
            {
                max=a[i];
            }
        }
        System.out.println(max);

        for(int i=0;i<a.length-1;i++)
        {
            if(a[min]<a[i])
            {
                min=a[i];
            }
        }

        System.out.println(min);

    }
}
