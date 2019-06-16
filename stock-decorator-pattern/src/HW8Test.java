
import java.util.*;

public class HW8Test {
   private static String filename;
   private static int outlook;
   private static List<Integer> analysts = new ArrayList<>();
   
   public static void main(String[] args) {
      initializeAnalysts(); 
      StockInfo si = new StockInfo(filename);     
      StockAnalyst a = (outlook == 0) ? new Neutral(si) :
                       (outlook == 1) ? new Bearish(si) : new Bullish(si);
      for (int i : analysts) 
         a = (i == 1) ? new SegmentAnalyst(a) :
             (i == 2) ? new PEratioAnalyst(a) : new NameAnalyst(a);

      System.out.println("Confidence level is " + a.confidenceLevel());
      System.out.println("Reasoning: " + a.reasons());
   }
   
   private static void initializeAnalysts() {
      Scanner sc = new Scanner(System.in);
      System.out.print("File name: ");
      filename = sc.next();
      System.out.print("General outlook (0=neutral, 1=bearish, 2=bullish): ");
      outlook = sc.nextInt();
      while (true) {
         System.out.print("Analyst: (0=done, 1=segment, 2=PEratio, 3=name): ");
         int analyst = sc.nextInt();
         if (analyst == 0)
            break;
         analysts.add(analyst);
      }
      System.out.println();
      sc.close();
   }
}
