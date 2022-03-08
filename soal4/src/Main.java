//be name khoda
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
 class Task {
     //String start;
     int deletetask;
     int ignore;
     int changeplace;
     Task(int deletetasks,int ignores,int changeplaces)
     {
         deletetask=deletetasks; ignore=ignores; changeplace=changeplaces;
     }
    String id;
    String username;
    String isvalid;
    String name;
    String address;
    String year;
    String month;
    String day;
    String info;
    String price;

}
public class Main {
     static ArrayList<Task> main_jobs = new ArrayList<Task>();
     public static void newtask(Task current_task)
     {
         boolean flag=true;
         for (int i = 0; i < main_jobs.size(); i++){

             // Printing and display the elements in ArrayList
             if(main_jobs.get(i).id.equals(current_task.id)) flag=false;
             if(main_jobs.get(i).month.equals(current_task.month) && main_jobs.get(i).year.equals(current_task.year) && main_jobs.get(i).day.equals(current_task.day) ) {flag=false;}
             //  System.out.println(current_task.isvalid);


         }
         if(current_task.isvalid.equals("yes")){}
         else {flag=false;}

         if(Integer.valueOf(current_task.month)<=12 && Integer.valueOf(current_task.month)>0 && Integer.valueOf(current_task.day)<=30 && Integer.valueOf(current_task.day) > 0 ){}
         else{flag=false;}
         if(flag)main_jobs.add(current_task);
     }
    public static void change_address(Task current_task)
    {
        boolean flag=false;
        int i;
        for (i = 0; i < main_jobs.size(); i++){

            // Printing and display the elements in ArrayList
            if(main_jobs.get(i).id.equals(current_task.id)) {flag=true;break;}

        }
        if(flag)main_jobs.get(i).address=current_task.address;
    }
    public static void deletetask(Task current_task)
    {
        for (int i = 0; i < main_jobs.size(); i++){

            // Printing and display the elements in ArrayList
            if(main_jobs.get(i).id.equals(current_task.id)) {main_jobs.remove(i);break;}

        }

    }

    public static TreeMap<Integer, Task> sortbykey(HashMap map)
    {
        // TreeMap to store values of HashMap
        TreeMap<Integer, Task> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(map);

        // Display the TreeMap which is naturally sorted
        //for (Map.Entry<Integer, Task> entry : sorted.entrySet())
          //  System.out.println("Key = " + entry.getKey() +
            //        ", Value = " + entry.getValue().ignore + entry.getValue().changeplace + entry.getValue().deletetask);
        return sorted;
    }

    public static void main(String[] args) {
        //String regex="newTask{ taskId\"(\\d{1,4})\", username\"(\\w[^bahmanBAHMAN\\W]{6,15}\\d)\", isValid\"(\\w+)\", name\"([ A-Za-z]+)\", address\"([ A-Za-z]+-\\d{8,10})\", date\"\\d{4}\\d{2}\\d{2}\", info\"([^\"]+)\", price\"(\\d*\.?\\d*)\" }"
//        Pattern pattern1= Pattern.compile("newTask\\{ taskId\"(\\d{1,4})\", username\"([A-Za-z][^bhman]{6,15}\\d)\", isValid\"(yes|no)\", name\"([^\"]+)\", address\"([ A-Za-z]+-\\d{8,10})\", date\"(\\d{4})(\\d{2})(\\d{2})\", info\"([^\"]+)\", price\"(\\d+\\.\\d{1,2}|\\d+(?!\\.))\" \\}");
        Pattern pattern_taskId= Pattern.compile("username\"([A-Za-z][C-GI-LO-Zc-gi-lo-z0-9_]{6,15}\\d)");
        Pattern pattern1= Pattern.compile("[ ]*newTask[{][ ]*taskId\"(\\d{1,4})\"[ ]*,[ ]*username\"([A-Za-z][C-GI-LO-Zc-gi-lo-z0-9_]{6,15}\\d)\"[ ]*,[ ]*isValid\"(yes|no)\"[ ]*,[ ]*name\"([A-Za-z ]*)\"[ ]*,[ ]*address\"([A-Za-z ]+-\\d{8,10})\"[ ]*,[ ]*date\"(\\d{4})(\\d{2})(\\d{2})\"[ ]*,[ ]*info\"([^\"]*)\"[ ]*,[ ]*price\"(\\d+\\.\\d{1,2}|\\d+(?!\\.))\"[ ]*[}][ ]*");
        Pattern pattern2= Pattern.compile("changePlace\\{ taskId\"(\\d{1,4})\", newAddress\"([A-Za-z ]+-\\d{8,10})\" \\}");
        Pattern pattern3= Pattern.compile("deleteTask\\{ taskId\"(\\d{1,4})\" \\}");
        Pattern pattern4= Pattern.compile("ignore\\{ count\"(\\d{1,4})\" \\}");
        Scanner sc=new Scanner(System.in);
        String orders=new String(sc.nextLine());
        float salary_now= sc.nextFloat();
        Matcher matcher = pattern_taskId.matcher(orders);
        Matcher matcher1 = pattern1.matcher(orders);
        Matcher matcher2=  pattern2.matcher(orders);
        Matcher matcher3 = pattern3.matcher(orders);
        Matcher matcher4=  pattern4.matcher(orders);
        HashMap <Integer,Task> order_map=new HashMap<Integer,Task>();
        int index=0;
        while (matcher.find())
        {
      //      System.out.println(1/0);
        }
        while (matcher1.find()) {
          //  System.out.println(1/0);
            Task current_task=new Task(0,0,0);

         //   System.out.println(matcher1.group(1));
            current_task.id=matcher1.group(1);
           // System.out.println(matcher1.group(2));
            current_task.username=matcher1.group(2);
          //  System.out.println(matcher1.group(3));
            current_task.isvalid=matcher1.group(3);
           // System.out.println(matcher1.group(4));
            current_task.name=matcher1.group(4);
          //  System.out.println(matcher1.group(5));
            current_task.address=matcher1.group(5);
          //  System.out.println(matcher1.group(6));
            current_task.year=matcher1.group(6);
           // System.out.println(matcher1.group(7));
            current_task.month=matcher1.group(7);
          //  System.out.println(matcher1.group(8));
            current_task.day=matcher1.group(8);
          //  System.out.println(matcher1.group(9));
            current_task.info=matcher1.group(9);
          //  System.out.println(matcher1.group(10));
            current_task.price=matcher1.group(10);

            ///////////////validation///////////////////////////////////////////////////////////////////
            boolean flag=true;
            String numberOnly = current_task.address.replaceAll("[^0-9]", "");
            if( numberOnly.length() == 9)flag=false;
           if(flag)order_map.put(matcher1.start(), current_task);
            ////////////////////////////////////////////////////////////////////////////////////////////
              //  System.out.println("isvalid = " + order_map.get(matcher1.start()).username + " "+matcher1.start()+" "+task.id);

           // System.out.println(Integer.parseInt(numberOnly));
        }
        //System.out.println("index = "+ order_map.size());
        while (matcher2.find())
        {

           // System.out.println(2/0);
            Task task=new Task(0,0,1);
          //  System.out.println(matcher2.group(1));
            task.id=matcher2.group(1);
         //   System.out.println(matcher2.group(2));
            task.address=matcher2.group(2);
            order_map.put(matcher2.start(),task);
        }
          while (matcher3.find())
          {

            //  System.out.println(1/0);
          //    System.out.println(1/0);

              Task task=new Task(1,0,0);
           //   System.out.println(matcher3.group(1));
              task.id=matcher3.group(1);
              order_map.put(matcher3.start(),task);
          }
        while (matcher4.find())
        {
        //    System.out.println(1/0);
           // System.out.println(1/0);
            Task task=new Task(0,1,0);
          //  System.out.println(matcher4.group(1));
            task.ignore=Integer.parseInt(matcher4.group(1));
            order_map.put(matcher4.start(),task);
        }
        TreeMap<Integer,Task> sorted = sortbykey(order_map);
        int number_of_ignores=0;
        for (Map.Entry<Integer, Task> entry : sorted.entrySet())
        {

            if(number_of_ignores != 0)
            {
                --number_of_ignores;
                continue;
            }
            if(entry.getValue().ignore != 0)
            {
                if(entry.getValue().ignore>0)number_of_ignores=entry.getValue().ignore;
            }
            else if( entry.getValue().changeplace != 0)
            {

                   change_address(entry.getValue());
            }
            else if( entry.getValue().deletetask != 0){
                       deletetask(entry.getValue());
            }
            else {
             //   System.out.println("price= "+entry.getValue().price);
                float salary_now_float=Float.parseFloat(entry.getValue().price);
                if(salary_now_float > salary_now){ newtask(entry.getValue());}

            }
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue().ignore + entry.getValue().changeplace + entry.getValue().deletetask);
        }
        for (int i = 0; i < main_jobs.size()-1; i++)

            // Last i elements are already in place
            for (int j = 0; j < main_jobs.size()-i-1; j++)
                if ( Integer.valueOf(main_jobs.get(j).id) >  Integer.valueOf(main_jobs.get(j+1).id)) {
                    Collections.swap(main_jobs, j, j+1);

                }
        for (int i = 0; i < main_jobs.size(); i++) {
            System.out.println("**********");
            //System.out.println("\n");
            System.out.println("id: "+main_jobs.get(i).id);
            System.out.println("date: "+main_jobs.get(i).year+"/"+main_jobs.get(i).month+"/"+main_jobs.get(i).day);
            System.out.println("place: "+main_jobs.get(i).address);
            System.out.println("info: "+main_jobs.get(i).info);
        }


       // System.out.println(main_jobs.size());
       if(main_jobs.size() != 0) System.out.format("**********");
       else {
       }
    //   else {while(true){}}

    }
    }
/*
newTask\{ taskId"(\d{1,4})", username"(\w[^bahmanBAHMAN\W]{6,15}\d)", isValid"(\w+)", name"([ A-Za-z]+)", address"([ A-Za-z]+-\d{8,10})", date"\d{4}\d{2}\d{2}", info"([^"]+)", price"(\\d*\.?\\d*)" \}
newTask{ taskId"1", username"A1234564", isValid"yes", name" m i cah ", address"Kalj liini nG rad-12345678", date"19390127", info"do@lj;i;; the t@_ll_ll_LL-ll-.ajfei...ask", price"12" }
newTask{ taskId"9998", username"ItWorks14", isValid"yes", name"mi cah", address"LeninGrad-12345678", date"19410008", info"@@@\\\ajfeli0392%%$@@", price"1.57" }ignore{ count"1" } deleteTask{ taskId"1" } newTask{ taskId"9999", username"tWore44k4s4", isValid"yes", name"", address"LeninGrad-12345678", date"19410928", info"do the task", price"1.58" }fjaiefj209421-84-j rqpjopqj o newTask{ taskId"8999", username"tWo8e44k4s4", isValid"yes", name"", address"LeninGrad-12345678", date"19410928", info"do the task", price"1.5d
deleteTask{ taskId"1000" } salnewTask{ taskId"1000", username"ItWorks14", isValid"yes", name"mi bahamncah", address" -12345678", date"19410928", info"@@@\\\ajfeli0392%%$@@", price"1.57" }ignore{ count"1" } deleteTask{ taskId"1" } newTask{ taskId"1000", username"tWore44k4s4", isValid"yes", name"", address"LeninGbahmanrad-12345678", date"19410928", info"do the task", price"1.58" }fjaiefj209421-84-j rqpjopqj o newTask{ taskId"8999", username"tWo8e44k4s4", isValid"yes", name"", address"LeninGrad-12345678", date"19410928", info"do the task", price"1.5" }d
meee
newTask{   taskId"14", username"ItWorks14", isValid"yes", name"reza", address"VolgoGrad-12345678", date"19210210", info"", price"1.55" } newTask{        taskId"12", username"ItWorks14", isValid"yes", name"reza", address"VolgoGrad-12345678", date"19210210", info"do the task", price"1.5" } newTask{     taskId"134", username"ItWorks14", isValid"yes", name"reza", address"VolgoGrad-12345678", date"19259410", info"do the task", price"1.5" } newTask{         taskId"164", username"ItWorks14", isValid"yes", name"reza", address"VolgoGrad-12345678", date"19250411", info"do the task", price"1.5" }


1.1
1.57
1
*/
