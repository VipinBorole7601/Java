import java.util.Arrays;

public class Array {
   public Array() {
   }

   public void waysToPrintNumericArray() {
      int[] var1 = new int[]{5, 6, 1};

      for(int var5 : var1) {
         System.out.println("First Way:- " + var5);
      }

      for(int var6 = 0; var6 < var1.length; ++var6) {
         System.out.println("Second Way:- " + var1[var6]);
      }

      System.out.print("Third Way to print Array: " + Arrays.toString(var1));
   }

   public static void main(String[] var0) {
      int[] var10000 = new int[]{2, 4, 1, 2, 5, 6};
      String[] var6 = new String[]{"test", "data", "week day", " add more data "};
      boolean[] var7 = new boolean[]{true, false};
      char[] var8 = new char[]{'r', 'c', 'a', 'e', 'i', 'o', 'u'};
      Array var5 = new Array();
      var5.waysToPrintNumericArray();
   }
}
