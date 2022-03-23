//be name khoda
import java.lang.reflect.Array;
import java.util.*;
public class Main {

    static Map<String, ArrayList<Integer>> map_of_search = new HashMap<String, ArrayList<Integer>>();
    static void add_id(String[] words,int id)
    {
        for(String entry : words)
        {
            entry=entry.toLowerCase();
            if(map_of_search.containsKey(entry))
            {
                if(!map_of_search.get(entry).contains(id)) map_of_search.get(entry).add(id);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                map_of_search.put(entry,temp);
                map_of_search.get(entry).add(id);
            }
        }
    }


    public static void main(String[] args) {
        int n;
        int m;
        Scanner sc =new Scanner(System.in);
        n=Integer.parseInt(sc.nextLine()); m= Integer.parseInt(sc.nextLine());

        ArrayList<String[]> words= new ArrayList<String[]>();
        for (int j = 0; j < n; j++) {
            String temp = new String(sc.nextLine());
            // System.out.println("temp= "+temp);
            String[] temp_arr= temp.split(" ");
            // words.add(temp_arr);
            add_id(temp_arr,j+1);
        }
        Outer :
        for (int i = 0; i < m; i++) {
            String temp = new String(sc.nextLine());
            String[] temp_arr= temp.split(" ");
            ArrayList<Integer> selected_lines= new ArrayList<>();
            int k=0;
            for (String word: temp_arr) {
                word=word.toLowerCase();
                if(map_of_search.containsKey(word))
                {
                    if(k == 0)
                    {
                        for (Integer l: map_of_search.get(word)) {
                            selected_lines.add(l);
                        }
                        ++k;
                    } else{
                        selected_lines.retainAll(map_of_search.get(word));
                    }
                }
                else
                {
                    System.out.println("-1"); continue Outer;
                }
                if (selected_lines.size() == 0){
                    System.out.println("-1");
                    continue Outer;
                }
            }
            StringBuilder fin= new StringBuilder("");

            for(int u=0;u< selected_lines.size();++u)
            {
                fin.append(selected_lines.get(u));
                fin.append(" ");
            }
            System.out.println(fin);
        }









    }
}
/*
3
4
hello Andras im erfan big fan of you from Iran
andras Bassani migholi
andrAS how are you today message by arash
aras erfan
andra
anDRa fan
how are
2
2
Folan aaa aaa aaa aaa
Folan bbb bbb bbb bbb
Aaa
Bbb
 */