import java.util.Arrays;

public class iop {
    public static void main(String[] args) {
        int arr1[] = {8, 19, 89}; // {8,9}
        int arr2[] = {1,2,3,4,8,10,0}; // {3,4} {0,0,0,0,0,0,0}
        int num1 = arr1.length + arr2.length;
        int result[] = new int[arr1.length + arr2.length];
        result[0]=arr2[0];
        result[1]=arr2[1];
        result[2]=arr2[2];
        result[3]=arr2[3];
        int num2 = arr2.length;
        int h=7;
        for (int i=0;i<num2;i++){
            if (h<arr2[i]){
                int k=i+1;
                for (int p=0;p<2;p++){
                    arr2[k+1]=arr2[k];
                    k=k-1;
                }
                arr2[i]=h;
                break;

            }








        }
        for (int i = 0; i < 7; i++) {
            System.out.println(result[i]);

        }


//
    }
}