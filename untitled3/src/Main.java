//Be nanm khoda
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    /* class Globals{
        static HashMap<String,Integer> Chars_Mapping = new HashMap<>();
        Chars_Mapping.put("X",0);
        Chars_Mapping.put()
     }*/
    static int min_move=-1;
    static int zaman;
    static void f(StringBuilder main,StringBuilder kise,int number_of_plays) {
        //System.out.println(main + " " + kise + " " + number_of_plays);
        if (main.length() == 0) {
            if (min_move == -1 && number_of_plays<=zaman) {
                min_move = number_of_plays;
            } else if (min_move > number_of_plays && number_of_plays<=zaman) {
                min_move = number_of_plays;
                return;
            }
        }
        for (int i = 0; i < main.length(); i++) {
            // System.out.println("main= "+ main + " " +i+ " + i");
            if (i != 0 && i != main.length() - 1) {
                //System.out.println("first if at all " + main.length());
                if (main.charAt(i - 1) == main.charAt(i) && main.charAt(i + 1) == main.charAt(i)) {
                    //   System.out.println("first if");
                    int temp = 1;
                    char temp_ch = main.charAt(i);
                    while ((i+temp)<main.length() && main.charAt(i + temp) == temp_ch) {
                        main.deleteCharAt(i + temp);
                    }
                    temp = 0;
                    while ((i+temp)<main.length() && main.charAt(i + temp) == temp_ch) {
                        main.deleteCharAt(temp + i);
                        if(temp+i != 0) --temp;
                    }
                    i = i + temp;
                    //System.out.println(main);
                    f(main,kise,number_of_plays);
                } else if ((i + 1) < main.length() && main.charAt(i + 1) == main.charAt(i) && ((i + 2) >= main.length() || main.charAt(i + 2) != main.charAt(i))) {
                    //System.out.println("second if");
                    int j;
                    for (j = 0; j < kise.length(); j++) {
                        if (kise.charAt(j) == main.charAt(i)) {
                            break;
                        }
                    }
                    if (j != (kise.length() )) {
                        StringBuilder main_temp=new StringBuilder(main);
                        StringBuilder kise_temp=new StringBuilder(kise);
                        kise_temp.deleteCharAt(j);
                        main_temp.deleteCharAt(i + 1);
                        main_temp.deleteCharAt(i);
                        //     System.out.println("main= "+main+" "+"main_temp= "+main_temp);
                        //  i -= 1;
                        f(main_temp, kise_temp, number_of_plays + 1);
                    }

                }
                else {
                    int counter = 0;
                    int first = -1;
                    int j;
                    for (j = 0; j < kise.length(); j++) {
                        if (main.charAt(i) == kise.charAt(j)) {
                            ++counter;
                            if (counter == 1) {
                                first = j;
                            } else {
                                break;
                            }
                        }
                    }
                    if (counter == 2) {
                        //   System.out.println("main= "+main);
                        StringBuilder main_temp=new StringBuilder(main);
                        StringBuilder kise_temp=new StringBuilder(kise);
                        kise_temp.deleteCharAt(j);
                        kise_temp.deleteCharAt(first);
                        main_temp.deleteCharAt(i);
                        //     System.out.println("main= "+main+" "+"main_temp= "+main_temp);
                        f(main_temp, kise_temp, number_of_plays + 2);
                    }
                }

            } else if (i != main.length()-1) {
                if ((i + 1) < main.length() && main.charAt(i + 1) == main.charAt(i) && ((i + 2) >= main.length() || main.charAt(i + 2) != main.charAt(i))) {
                    //   System.out.println("second if");
                    int j;
                    for (j = 0; j < kise.length(); j++) {
                        if (kise.charAt(j) == main.charAt(i)) {
                            break;
                        }
                    }
                    if (j != (kise.length() )) {
                        StringBuilder main_temp=new StringBuilder(main);
                        StringBuilder kise_temp=new StringBuilder(kise);
                        kise_temp.deleteCharAt(j);
                        main_temp.deleteCharAt(i + 1);
                        main_temp.deleteCharAt(i);
                        //  System.out.println("main= "+main+" "+"main_temp= "+main_temp);
                        //   i -= 1;
                        f(main_temp, kise_temp, number_of_plays + 1);
                    }

                }else{
                    int counter = 0;
                    int first = -1;
                    int j;
                    for (j = 0; j < kise.length(); j++) {
                        if (main.charAt(i) == kise.charAt(j)) {
                            ++counter;
                            if (counter == 1) {
                                first = j;
                            } else {
                                break;
                            }
                        }
                    }
                    if (counter == 2) {
                        StringBuilder main_temp=new StringBuilder(main);
                        StringBuilder kise_temp=new StringBuilder(kise);
                        kise_temp.deleteCharAt(j);
                        kise_temp.deleteCharAt(first);
                        main_temp.deleteCharAt(i);
                        //System.out.println("main= "+main+" "+"main_temp= "+main_temp);

                        f(main_temp, kise_temp, number_of_plays + 2);
                    }
                }

            } else {
                int counter = 0;
                int first = -1;
                int j;
                for (j = 0; j < kise.length(); j++) {
                    if (main.charAt(i) == kise.charAt(j)) {
                        ++counter;
                        if (counter == 1) {
                            first = j;
                        } else {
                            break;
                        }
                    }
                }
                if (counter == 2) {
                    StringBuilder main_temp=new StringBuilder(main);
                    StringBuilder kise_temp=new StringBuilder(kise);
                    kise_temp.deleteCharAt(j);
                    kise_temp.deleteCharAt(first);
                    main_temp.deleteCharAt(i);
                    //System.out.println("main= "+main+" "+"main_temp= "+main_temp);

                    f(main_temp, kise_temp, number_of_plays + 2);
                }
            }

        }

        return;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        StringBuilder main_text= new StringBuilder("");
        main_text.append(sc.nextLine());
        StringBuilder kise = new StringBuilder("");
        kise.append(sc.nextLine());
        int minutes=sc.nextInt();
        zaman=minutes;
        f(main_text,kise,0);
        System.out.println(min_move);

    }
}
/*
SLSMM
SLMLL
2
SXSSM
XXMM
10
SXXSS
SSXXSS
5
SXSSMMSXXSS
SSMSXX
5
SSMMSMMSS
MM
10
 */