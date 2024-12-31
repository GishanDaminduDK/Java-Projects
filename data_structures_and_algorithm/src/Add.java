import java.util.Arrays;

public class Add {
    public static void main(String[] args) {
        int arr1[] = {8, 19, 89}; // {8,9}
        int arr2[] = {10, 15, 67, 800}; // {3,4} {0,0,0,0,0,0,0}
        int num1 = arr1.length + arr2.length;
        int result[] = new int[arr1.length + arr2.length];
        int num2 = arr2.length;
        int k = 0;
        for (int item : arr1) {

            while (k < num2){
                if (item < arr2[k]) {
                    int y = 0;
                    int temp = 0;
                    while (y <4-k) {
                        result[num2 + k - y] = arr2[num2 - 1 - y];
                        y = y + 1;
                    }
                    break;
                }
                    result[k] = item;
                k = k + 1;

            }

        }
        for (int i = 0; i < 7; i++) {
            System.out.println(result[i]);

        }
        // Create a new array with a length equal to the sum of the lengths of arr1 and arr2
//        int result[] = new int[arr1.length + arr2.length];
//        int j=0;
//        String status="non";
//        for (int i=0; i<2; i++){
//
//            if (arr1[i]<arr2[j+i]) {// separate easily
//                //result[i] = arr1[i];
//                status="false";
//                result[0]=arr1[0];
//                result[1]=arr1[1];
//                result[2]=arr2[0];
//                result[3]=arr2[1];
//            } else if (arr1[i]>arr2[j+i+1]){
//                result[0]=arr2[0];
//                result[1]=arr2[1];
//                result[2]=arr1[0];
//                result[3]=arr1[1];
//                status="true";
//                //break;
//                //result[1]
//            } else if (arr1[i+j]<arr2[i]){ // this method not suitable for that
//                //result[i]=arr1[i+j];
//                //System.out.println("op");
//                status="true";
//                //result[1]{
//
//            }
//
//            j=j-1;
//        }

//        if (status=="false"){
//            result[2]=arr2[0];
//            result[3]=arr2[1];
//        }
//        if (status=="true"){
//            result[2]=arr1[1];
//            result[3]=arr2[1];
//        }


        // Copy elements from arr1 to result
        //System.arraycopy(arr1, 0, result, 0, arr1.length);

        // Copy elements from arr2 to result, starting from the end of arr1
        //System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        // System.out.println(result[0]+result[1]+result[2]+result[3]);


        // Print the result
        //System.out.println(Arrays.toString(result));
    }
}

