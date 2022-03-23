//be name khoda
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Main {
   static public class Sheepherd {
       int id_sheepcote= -1;
       String name=new String();
       Sheepherd(String _name)
       {
           name = _name;
       }
   }
   static public class Sheep{
       int have_sheepcote=-1;
       String name=new String("N/A");
       int id;
       String birth_date=new String();
       int forage;
       int year;
       int month;
       int day;
       String sheepherd=new String("N/A");
       Sheep(int _id,int _year,int _month,int _day,int _forage,String _name)
       {
           this.id=_id; this.year=_year; this.month=_month; this.day=_day; this.forage=_forage; this.name=_name;
       }
   }
   static public class Sheepcote{
       ArrayList<Sheep> sheeps= new ArrayList<>();
       String sheepherd=new String("N/A");
       int current_forage=0;
       int sheeps_using_forages=0;
       int capacity;
       int id;
       Sheepcote(int _capacity ,int _id)
       {
           capacity= _capacity; id= _id;
       }

   }
   static public class Farm{
       ArrayList<Sheepherd> sheepherds=new ArrayList<>();
       ArrayList<Sheep> sheeps= new ArrayList<>();
       ArrayList<Sheepcote> sheepcotes=new ArrayList<>();
       int date_year= -1;
       int date_month;
       int date_day;
   }
    public static void main(String[] args) {
        //String regex="newTask{ taskId\"(\\d{1,4})\", username\"(\\w[^bahmanBAHMAN\\W]{6,15}\\d)\", isValid\"(\\w+)\", name\"([ A-Za-z]+)\", address\"([ A-Za-z]+-\\d{8,10})\", date\"\\d{4}\\d{2}\\d{2}\", info\"([^\"]+)\", price\"(\\d*\.?\\d*)\" }"
//        Pattern pattern1= Pattern.compile("newTask\\{ taskId\"(\\d{1,4})\", username\"([A-Za-z][^bhman]{6,15}\\d)\", isValid\"(yes|no)\", name\"([^\"]+)\", address\"([ A-Za-z]+-\\d{8,10})\", date\"(\\d{4})(\\d{2})(\\d{2})\", info\"([^\"]+)\", price\"(\\d+\\.\\d{1,2}|\\d+(?!\\.))\" \\}");
        Farm farm=new Farm();
        Pattern pattern_init= Pattern.compile("^[ ]*init[ ]*$");
        Pattern pattern_addsheep= Pattern.compile("^[ ]*add[ ]*sheep[ ]*([1-9]+)[ ]*(\\S+)[ ]*(\\d{2})/(\\d{2})/(\\d{2})[ ]*(\\d+)[ ]*$");
        Pattern pattern_addsheepcote= Pattern.compile("^[ ]*add[ ]*sheepcote[ ]*(\\d+)[ ]*(\\d+)[ ]*$");
        Pattern pattern_addsheepherd= Pattern.compile("^[ ]*add[ ]*shepherd[ ]*(\\S+)[ ]*$");
        Pattern pattern_today=  Pattern.compile("^[ ]*today[ ]*(\\d{2})/(\\d{2})/(\\d{2})[ ]*$");
        Pattern pattern_start=  Pattern.compile("^[ ]*start[ ]*$");
        Pattern pattern_pause=  Pattern.compile("^[ ]*pause[ ]*$");
        Pattern pattern_unpause=Pattern.compile("^[ ]*unpause[ ]*$");
        Pattern pattern_assign=Pattern.compile("^[ ]*assign[ ]*(\\S+)[ ]*(\\d+)[ ]*$");
        Pattern pattern_addforage=Pattern.compile("^[ ]*add[ ]*forage[ ]*(\\d+)[ ]*(\\d+)[ ]*$");
        Pattern pattern_move=Pattern.compile("^[ ]*move[ ]*(\\d+)[ ]*(\\d+)[ ]*$");
        Pattern pattern_feed=Pattern.compile("^[ ]*feed[ ]*$");
        Pattern pattern_infosheep=Pattern.compile("^[ ]*info[ ]*sheep[ ]*(\\d+)[ ]*$");
        Pattern pattern_infosheepcote=Pattern.compile("^[ ]*info[ ]*sheepcote[ ]*(\\d+)[ ]*$");
        Pattern pattern_elapseday=Pattern.compile("^[ ]*elapse[ ]*day[ ]*$");
        Pattern pattern_end=Pattern.compile("^[ ]*end[ ]*$");
        Scanner sc=new Scanner(System.in);
        String order = new String();
        boolean flag=false;
        boolean start=false;
        boolean pause=true;
        boolean daily_feed=true;
        Outer : while(true) {
    order=sc.nextLine();
    if(order.equals("")){continue;}
    Matcher matcher_init = pattern_init.matcher(order);
    if(matcher_init.find())
    {
        flag=true; continue;
    }
    if(flag) {
        /////////////////////start////////////////////////////////////
        Matcher matcher_start = pattern_start.matcher(order);
        if(matcher_start.find())
        {
           if(farm.date_year != -1) start=true;
           else System.out.println("error: system date is not set");
           continue;
        }



        //////////////////////////////////////////////////////////////////
        if(start && pause && farm.date_year != -1) {
            ///////////////////////////////pause////////////////////////////
            Matcher matcher_pause = pattern_pause.matcher(order);
            if(matcher_pause.find())
            {
                pause=false;
                continue ;
            }
            /////////////////////////////assign////////////////////////////////
            Matcher matcher_assign = pattern_assign.matcher(order);
            if(matcher_assign.find())
            {
                boolean flag1=false;
                int i;
                for (i = 0; i<farm.sheepherds.size(); i++) {
                    if(farm.sheepherds.get(i).name.equals(matcher_assign.group(1))){flag1=true; break;}
                }
                if(!flag1){
                    System.out.println("error: name does not exist");
                    continue ;
                }
                boolean flag2=false;
                int j;
                for (j = 0; j<farm.sheepcotes.size(); j++) {
                    if(farm.sheepcotes.get(j).id == Integer.parseInt(matcher_assign.group(2))){flag2=true; break;}
                }
                if(!flag2){
                    System.out.println("error: id does not exist");
                    continue ;
                }
                if(farm.sheepherds.get(i).id_sheepcote != -1 && farm.sheepherds.get(i).id_sheepcote != Integer.parseInt(matcher_assign.group(2))){
                    System.out.println("error: already assigned");
                    continue ;
                }
                         if(farm.sheepcotes.get(j).sheepherd.equals("N/A")) {
                             farm.sheepcotes.get(j).sheepherd = matcher_assign.group(1);
                             farm.sheepherds.get(i).id_sheepcote = Integer.parseInt(matcher_assign.group(2));
                             continue;
                         }
                         else
                         {
                             for (int k = 0; k < farm.sheepcotes.size(); k++) {

                                 if(farm.sheepcotes.get(j).sheepherd.equals(farm.sheepherds.get(k).name))
                                 {
                                     farm.sheepherds.get(k).id_sheepcote = -1;
                                     break ;
                                 }
                             }
                             farm.sheepcotes.get(j).sheepherd = matcher_assign.group(1);
                             farm.sheepherds.get(i).id_sheepcote = Integer.parseInt(matcher_assign.group(2));
                             continue ;
                         }
            }
            ////////////////////////////////addforage////////////////////////////////////////////
            Matcher matcher_addforage = pattern_addforage.matcher(order);
            if(matcher_addforage.find() && Integer.parseInt(matcher_addforage.group(1))>0)
            {
                int i;
                for ( i = 0; i < farm.sheepcotes.size(); i++) {
                   if(farm.sheepcotes.get(i).id == Integer.parseInt(matcher_addforage.group(2)))
                    {
                      break;
                    }
                }
                if(i == farm.sheepcotes.size()){
                    System.out.println("error: id does not exist");
                    continue ;
                }
                else{
                    farm.sheepcotes.get(i).current_forage+=Integer.parseInt(matcher_addforage.group(1));
                    continue ;
                }
            }
            ///////////////////////////////////////////////////move//////////////////////////////////

            Matcher matcher_move = pattern_move.matcher(order);
            if(matcher_move.find())
            {
                int i;
                for ( i = 0; i < farm.sheepcotes.size(); i++) {
                    if(farm.sheepcotes.get(i).id == Integer.parseInt(matcher_move.group(2)))
                    {
                        break;
                    }
                }
                int j;
                for ( j = 0; j <farm.sheeps.size() ; j++) {
                    if(farm.sheeps.get(j).id == Integer.parseInt(matcher_move.group(1)))
                    {
                        break;
                    }

                }
                if(i == farm.sheepcotes.size() || j == farm.sheeps.size()){
                    System.out.println("error: id does not exist");
                    continue ;
                }
                else {

                    if( farm.sheepcotes.get(i).sheeps.size() == farm.sheepcotes.get(i).capacity ){
                        if (farm.sheepcotes.get(i).sheeps.contains(farm.sheeps.get(j))){
                            continue ;
                        }
                        System.out.println("error: capacity limit exceeded");
                        continue ;
                    }
                    else
                    {
                        farm.sheepcotes.get(i).sheeps.add(farm.sheeps.get(j));
                        Birooni :
                        for (int k = 0; k < farm.sheepcotes.size(); k++) {
                            if( farm.sheeps.get(j).have_sheepcote == farm.sheepcotes.get(k).id)
                            {
                                for (int l = 0; l < farm.sheepcotes.get(k).sheeps.size(); l++) {
                                    if(farm.sheepcotes.get(k).sheeps.get(l).id == farm.sheeps.get(j).id)
                                    {
                                        farm.sheepcotes.get(k).sheeps_using_forages -= farm.sheeps.get(j).forage;
                                        farm.sheepcotes.get(k).sheeps.remove(l);
                                        break Birooni;
                                    }
                                }
                            }
                        }
                        farm.sheepcotes.get(i).sheeps_using_forages+=farm.sheeps.get(j).forage;
                        farm.sheeps.get(j).have_sheepcote= farm.sheepcotes.get(i).id;
                        farm.sheeps.get(j).sheepherd= farm.sheepcotes.get(i).sheepherd;
                        continue ;
                    }
                }
            }

            //////////////////////////////////////////////////feed////////////////////////
            Matcher matcher_feed = pattern_feed.matcher(order);
            if(matcher_feed.find()){
                if(daily_feed) {
                    for (int i = 0; i < farm.sheeps.size(); i++) {
                        if (farm.sheeps.get(i).have_sheepcote == -1) {
                            System.out.println("error: one or more sheep left out");
                            continue Outer;
                        }
                    }
                    for (int i = 0; i < farm.sheepcotes.size(); i++) {

                        if (farm.sheepcotes.get(i).current_forage < farm.sheepcotes.get(i).sheeps_using_forages) {
                            System.out.println("error: insufficient forage");
                            continue Outer;
                        }
                    }
                    for (int i = 0; i < farm.sheepcotes.size(); i++) {
                        farm.sheepcotes.get(i).current_forage -= farm.sheepcotes.get(i).sheeps_using_forages;
                    }
                    for (int i = 0; i < farm.sheepcotes.size(); i++) {
                       if(farm.sheepcotes.get(i).sheeps.size() != 0) farm.sheepcotes.get(i).current_forage=0;
                    }
                    daily_feed=false;
                    continue;
                }
              else{
                    System.out.println("error: you cannot feed sheep more than once");
                    continue ;
                }
            }
            //////////////////////////////infosheep////////////////////////////////
            Matcher matcher_infosheep = pattern_infosheep.matcher(order);
            if(matcher_infosheep.find())
            {
                int i;
                for (i = 0; i < farm.sheeps.size(); i++) {
                    if(Integer.parseInt(matcher_infosheep.group(1)) == farm.sheeps.get(i).id)
                    {
                        break;
                    }
                }
                if(i == farm.sheeps.size()){
                    System.out.println("error: id does not exist");
                    continue;
                }
                else
                {
                    System.out.println("id: "+farm.sheeps.get(i).id);
                    System.out.println("name: "+farm.sheeps.get(i).name);
                    System.out.print("age: ");
                    if(((farm.date_day+farm.date_month*30+farm.date_year*360) - (farm.sheeps.get(i).day+farm.sheeps.get(i).month*30 + farm.sheeps.get(i).year*360))%360 != 0)System.out.printf("%d\n",((((farm.date_day+farm.date_month*30+farm.date_year*360) - (farm.sheeps.get(i).day+farm.sheeps.get(i).month*30 + farm.sheeps.get(i).year*360))/360)+1));
                    else {
                        System.out.printf("%d\n",((((farm.date_day+farm.date_month*30+farm.date_year*360) - (farm.sheeps.get(i).day+farm.sheeps.get(i).month*30 + farm.sheeps.get(i).year*360))/360)));
                    }
                    //System.out.println((farm.date_day+farm.date_month*30+farm.date_year*360) + " "+  (farm.sheeps.get(i).day+farm.sheeps.get(i).month*30 + farm.sheeps.get(i).year*360));
                    if(farm.sheeps.get(i).have_sheepcote != -1)
                       System.out.println("sheepcote: "+farm.sheeps.get(i).have_sheepcote);
                    else
                        System.out.println("sheepcote: N/A");
                    for (int j = 0; j < farm.sheepcotes.size(); j++) {
                        if(farm.sheepcotes.get(j).id == farm.sheeps.get(i).have_sheepcote)
                        {
                            farm.sheeps.get(i).sheepherd= farm.sheepcotes.get(j).sheepherd;
                        }
                    }

                    System.out.println("shepherd: "+farm.sheeps.get(i).sheepherd);
                    continue ;
                }
            }
            //////////////////////////infosheepcote///////////////////////////////////////
            Matcher matcher_infosheepcote = pattern_infosheepcote.matcher(order);
            if(matcher_infosheepcote.find())
            {
                int i;
                for (i = 0; i < farm.sheepcotes.size(); i++) {
                    if(farm.sheepcotes.get(i).id == Integer.parseInt(matcher_infosheepcote.group(1)))
                    {
                        break;
                    }

                }
                if(i == farm.sheepcotes.size()){
                    System.out.println("error: id does not exist");
                }
                else
                {
                    System.out.println("id: "+farm.sheepcotes.get(i).id);
                    System.out.println("number of sheep: "+farm.sheepcotes.get(i).sheeps.size());
                    System.out.println("capacity: "+farm.sheepcotes.get(i).capacity);
                    if(farm.sheepcotes.get(i).current_forage > farm.sheepcotes.get(i).sheeps_using_forages)
                    {
                        System.out.println("forage balance: +"+(farm.sheepcotes.get(i).current_forage - farm.sheepcotes.get(i).sheeps_using_forages));
                    }
                    else
                    {
                        System.out.println("forage balance: "+(farm.sheepcotes.get(i).current_forage - farm.sheepcotes.get(i).sheeps_using_forages));
                    }
                    System.out.println("shepherd: "+farm.sheepcotes.get(i).sheepherd);
                }
                continue ;
            }
            ///////////////////////////////////elapseday////////////////////////////////////////////
            Matcher matcher_elapseday = pattern_elapseday.matcher(order);
            if(matcher_elapseday.find()) {
                if(!daily_feed) {
                 //   System.out.println(farm.date_day);
                    ++farm.date_day;
                  //  System.out.println(farm.date_day);
                    if (farm.date_day > 30) {
                        farm.date_day = 1;
                        ++farm.date_month;
                        if (farm.date_month > 12) {
                            farm.date_month = 1;
                      //      System.out.println(farm.date_year);
                            ++farm.date_year;
                        //    System.out.println(farm.date_year);
                        }
                    }

                    System.out.print("today: ");
                    if (farm.date_year < 10) {
                        System.out.print("0" + farm.date_year);
                    } else {
                        System.out.print(farm.date_year);
                    }
                    System.out.print("/");
                    if (farm.date_month < 10) {
                        System.out.print("0" + farm.date_month);
                    } else {
                        System.out.print(farm.date_month);
                    }
                    System.out.print("/");
                    if (farm.date_day < 10) {
                        System.out.println("0" + farm.date_day);
                    } else {
                        System.out.println(farm.date_day);
                    }
                    daily_feed=true;

                    continue;
                }
                else {
                    System.out.println("error: poor sheep are not fed");
                    continue ;
                }
            }
            ////////////////////////////////////////end////////////////////////////////
            Matcher matcher_end = pattern_end.matcher(order);
            if(matcher_end.find())
            {
                System.exit(0);
            }
        } else {
            //////////////////////set today date///////////////////////////
            Matcher matcher_today = pattern_today.matcher(order);
            if (matcher_today.find()) {
                if(Integer.parseInt(matcher_today.group(3)) != 0 && Integer.parseInt(matcher_today.group(3))<=30) {farm.date_day=Integer.parseInt(matcher_today.group(3));}
                else {System.out.println("error: invalid command"); continue;}
                if(Integer.parseInt(matcher_today.group(2)) != 0 && Integer.parseInt(matcher_today.group(2))<=12){farm.date_month=Integer.parseInt(matcher_today.group(2));}
                else{ System.out.println("error: invalid command"); continue;}
                farm.date_year=Integer.parseInt(matcher_today.group(1));
                continue ;
            }
            ///////////////////addsheep////////////////////////////////////////
            Matcher matcher_addsheep = pattern_addsheep.matcher(order);
            if (matcher_addsheep.find()) {
                for (int i = 0; i < farm.sheeps.size(); i++) {
                    if(farm.sheeps.get(i).id == Integer.parseInt(matcher_addsheep.group(1))){
                        System.out.println("error: already exists");
                        continue Outer;
                    }
                }
                Sheep sheep = new Sheep(Integer.parseInt(matcher_addsheep.group(1)), Integer.parseInt(matcher_addsheep.group(3)),Integer.parseInt(matcher_addsheep.group(4)),Integer.parseInt(matcher_addsheep.group(5)), Integer.parseInt(matcher_addsheep.group(6)), matcher_addsheep.group(2));
                farm.sheeps.add(sheep);
                continue;
            }
            /////////////////addsheepcote//////////////////////////////////////
            Matcher matcher_addsheepcote = pattern_addsheepcote.matcher(order);
            if (matcher_addsheepcote.find() &&  Integer.parseInt(matcher_addsheepcote.group(1)) != 0 && Integer.parseInt(matcher_addsheepcote.group(2)) != 0 ) {
                for (int i = 0; i < farm.sheepcotes.size(); i++) {
                    if(farm.sheepcotes.get(i).id == Integer.parseInt(matcher_addsheepcote.group(1))){
                        System.out.println("error: already exists");
                        continue Outer;
                    }
                }
                Sheepcote sheepcote=new Sheepcote(Integer.parseInt(matcher_addsheepcote.group(2)),Integer.parseInt(matcher_addsheepcote.group(1)));
                farm.sheepcotes.add(sheepcote);
                continue;
            }
            ///////////////////////addsheepherd//////////////////////////////////////////////
            Matcher matcher_addsheepherd = pattern_addsheepherd.matcher(order);
            if (matcher_addsheepherd.find()) {
                for (int i = 0; i < farm.sheepherds.size(); i++) {
                    if(farm.sheepherds.get(i).name.equals(matcher_addsheepherd.group(1))){
                        System.out.println("error: already exists");
                        continue Outer;
                    }
                }
                Sheepherd sheepherd=new Sheepherd(matcher_addsheepherd.group(1));
                farm.sheepherds.add(sheepherd);
                continue;
            }
        }

        Matcher matcher_unpause = pattern_unpause.matcher(order);
        if(matcher_unpause.find())
        {
            pause=true;
            continue ;
        }
       if(pause)System.out.println("error: invalid command");
    }


}

      //   else {while(true){}}



    }
}
/*
baaaaaaa
init
add sheep 0 Dolly 05/01/24 24
add sheep 1 Dolly 05/01/24 24
add sheep 2 Rosette 03/06/03 20
add sheep     3 Chex 12/07/12 25
add shep 4 Dutch 09/10/11 33
add sheep 3 Dutch 09/10/11 33
add sheep 4 Dutch 09/10/11 33
add sheep 5 Margaret 12/11/12 20
add sheepcote 1 2
add sheepcote 2 4
add sheepcote 3 2
add shepherd John
add shepherd Marry
add shepherd Jade
end
start
today 12/13/05
today 12/12/05
start
pause
I have a really good life here
They feed me every day
My shepherd Jade is very kind
She kisses me on the nose ^_^
Oh-oh the sysadmin is back
gotta go ...
unpause
assign Jade 1
assign Jade 2
assign Marry 1
assign Jade 2
assign John 3
move 1 1
move 2 1
move 3 1
move 3 3
move 4 3
move 5 2
add forage 100 1
add forage 100 2
feed
add forage 100 3
elapse day
feed
add forage 100 3
elapse day
info sheepcote 3
info sheep 5
error: invalid command
error: invalid command
error: already exists
error: invalid command
error: system date is not set
error: invalid command
error: already assigned
error: capacity limit exceeded
error: insufficient forage
error: poor sheep are not fed
today: 12/12/06
id: 3
number of sheep: 2
capacity: 2
forage balance: +42
shepherd: John
id: 5
name: Margaret
age: 1
sheepcote: 2
shepherd: Jade
end

init
add sheep 1 Dolly 05/01/24 24
add sheep 2 Rosette 03/06/03 20
add sheepcote 2 1
add sheepcote 1 1
start
today 03/11/30
start
add forage 100 1
add forage 100 2
feed
move 1 1
move 2 2
feed
elapse day
add shepherd Ali
add shepherd Agha
assign Agha 1
assign Ali 1
assign Agha 2
assign Ali 2
assign Ali 1
info sheepcote 1
info sheepcote 2
info sheep 1

init
add sheep 1 bee 01/01/01 24
add sheep 2 bee 01/01/01 20
add sheep 3 bee 01/01/01 25
add sheep 4 bee 01/01/01 33
add sheep 5 bee 01/01/01 20
add sheepcote 1 2
add sheepcote 2 4
add sheepcote 3 2
add shepherd (avali)
add shepherd (dovomi)
add shepherd (sevomi)
add shepherd (chaharomi)
today 13/11/12
start
assign (dovomi) 1
assign (sevomi) 1
assign (avali) 2
move 8 85
move 1 1
move 2 1
move 3 3
move 4 3
move 5 2
add forage 100 85
add forage 100 1
add forage 100 3
feed
add forage 100 2
feed
add forage 100 2
elapse day
info sheepcote 2
add forage 100 1
add forage 100 3
feed
feed
elapse day
pause
add forage 10 1
add forage 100 2
add bbbb
unpause
feed
add forage 100 2
add forage 100 1
add beeeeeee
feed
assign (chaharomi) 2
assign (sevomi) 1
assign (dovomi) 2
info sheepcote 2
info sheepcote 1
info sheep 5
assign (sevomi) 1
feed
elapse day
end
*/
