import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;

public class substring {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest ="";
        String largest = "";
        Deque<Integer> arr1=new LinkedList<>();
        ArrayList<String> arr2=new ArrayList<>();
        int total=0;
        int max=0;
        int min=1000;

        for (int i=0;i<s.length();i++){
            int x=(int) s.charAt(i);
            String l= String.valueOf(s.charAt(i));
            arr1.addLast(x);
            arr2.add(l);
            int g=arr1.size();

            if (arr1.size()==k){
                for (int y:arr1){

                    total=total+y;
                    //System.out.println(y);

                    //System.out.println(x);
                }
                if(total>max){
                    max=total;
                    largest="";
                    for (String h:arr2){
                        largest+=h;
                    }
                }
                if (total<min){
                    min=total;
                    smallest="";
                    for (String t:arr2){
                        smallest+=t;
                    }
                }
                total=0;
                arr1.removeFirst();
                arr2.remove(0);
            }

        }
        //System.out.println(largest);




        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //String s = scan.next();
        String s="welcometojava";
        int k=3;
        //int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}