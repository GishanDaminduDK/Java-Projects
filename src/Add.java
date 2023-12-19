import java.util.Arrays;

public class Add {
    public static void main(String[] args) {
        int arr1[] = {3, 17}; // {8,9}
        int arr2[] = {8, 9}; // {3,4}

        // Create a new array with a length equal to the sum of the lengths of arr1 and arr2
        int result[] = new int[arr1.length + arr2.length];
        int j=0;
        String status="non";
        for (int i=0; i<2; i++){

            if (arr1[i]<arr2[j+i]) {
                result[i] = arr1[i];
                status="false";
            } else if (arr1[i]>arr2[j+i+1]){
                result[3]=arr2[i+j];
                status="true";
                //result[1]
            } else if (arr1[i]>arr2[j+i]){
                result[i]=arr2[i+j];
                status="true";
                //result[1]{

            }

            j=j-1;
        }

        if (status=="false"){
            result[2]=arr2[0];
            result[3]=arr2[1];
        }
        if (status=="true"){
            result[2]=arr1[1];
            result[3]=arr2[1];
        }


        for (int i=0;i<4;i++){
            System.out.println(result[i]);

        }
        // Copy elements from arr1 to result
        //System.arraycopy(arr1, 0, result, 0, arr1.length);

        // Copy elements from arr2 to result, starting from the end of arr1
        //System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        // System.out.println(result[0]+result[1]+result[2]+result[3]);


        // Print the result
        //System.out.println(Arrays.toString(result));
    }
}

