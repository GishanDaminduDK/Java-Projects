import java.util.Arrays;

public class iop {
    public static int[] insertNumbersortedArray(int[] arr2,int insertvalue){
        int num2 = arr2.length;
        int h=insertvalue;
        for (int i=0;i<num2;i++){
            if (h<arr2[i] && i!=0){
                int k=num2-2;
                for (int p=0;p<num2-i-1;p++){
                    arr2[k+1]=arr2[k];
                    k=k-1;
                }
                arr2[i]=h;
                break;
            }
            else if(h<arr2[i]){
                int k=num2-2;
                for (int p=0;p<num2-i-1;p++){
                    arr2[k+1]=arr2[k];
                    k=k-1;
                }
                arr2[i]=h;
                break;
            }
        }
        return arr2;

    }
    public static void main(String[] args) {
        int arr2[] = {12,15,33,44,98,100,0}; // {3,4} {0,0,0,0,0,0,0}

//        int num2 = arr2.length;
//        int h=40;
//        for (int i=0;i<num2;i++){
//            if (h<arr2[i] && i!=0){
//                int k=num2-2;
//                for (int p=0;p<num2-i-1;p++){
//                    arr2[k+1]=arr2[k];
//                    k=k-1;
//                }
//                arr2[i]=h;
//                break;
//            }
//            else if(h<arr2[i]){
//                int k=num2-2;
//                for (int p=0;p<num2-i-1;p++){
//                    arr2[k+1]=arr2[k];
//                    k=k-1;
//                }
//                arr2[i]=h;
//                break;
//            }
//        }
        for (int i = 0; i < 7; i++) {
            System.out.println(arr2[i]);

        }



//
    }
}