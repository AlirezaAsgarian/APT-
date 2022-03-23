import java.util.ArrayList;
import java.util.*;
public class Main {
   public static ArrayList<String> justify(String[] words,int maxWidth)
   {
       ArrayList<String> res = new ArrayList<>();
       int n = words.length;
       int index = 0;
       while (index<n)
       {
           int totalChars = words[index].length();
           int last = index + 1;
           while (last < n)
           {
               if((totalChars + 1 + words[last].length())>maxWidth) break;
               totalChars += 1 + words[last].length();
               ++last;
           }
           int gaps = last - index - 1;
           StringBuilder sb = new StringBuilder();

           if(last == n || gaps == 0)
           {
               for (int i = index; i < last; i++) {
                   sb.append(words[i]);
                   sb.append(" ");
               }
               sb.deleteCharAt(sb.length() - 1);
               while (sb.length() < maxWidth)
               {
                   sb.append(" ");
               }
           } else {
               int spaces = (maxWidth - totalChars)/gaps;
               int rest = (maxWidth - totalChars)%gaps;
               for (int i = index; i < last-1; i++) {
                   sb.append(words[i]);
                   sb.append(" ");
                   for (int j = 0; j < spaces+(i - index < rest ? 1 : 0); j++) {

                       sb.append(" ");
                   }
               }
               sb.append(words[last - 1]);
           }
           res.add(sb.toString());
           index = last;
       }
       return res;
   }
    public static ArrayList<String> left(String[] words,int maxWidth)
    {
        ArrayList<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while (index<n)
        {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n)
            {
                if((totalChars + 1 + words[last].length())>maxWidth) break;
                totalChars += 1 + words[last].length();
                ++last;
            }
            StringBuilder sb = new StringBuilder();
            if(last == n)
            {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth)
                {
                    sb.append(" ");
                }
            } else {
                for (int i = index; i < last-1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = new String("");
        String first_input = scanner.nextLine();
        String sizeoflines = first_input.replaceAll("[^0-9]", "");

        while ( scanner.hasNextLine()) {
            input+=scanner.nextLine();
            input +=" ";
        }
        String[] words= input.split(" ");
        int max_width=Integer.parseInt(sizeoflines);
        int index=0;
        //int max_width_copy=max_width;
        char temp='J';
        ArrayList<String> finall = new ArrayList<>();

        if(first_input.charAt(0) == temp) {
         finall = justify(words,max_width);
            for (String lines: finall) {
                System.out.println(lines);
            }
        }
        else {
            finall = left(words,max_width);
            for (String lines: finall) {
                System.out.println(lines);
            }
        }




    }
}
