import java.util.*;

public class duplicatevalue {
    public static void main(String[] args){
        int[] numbers={2,3,11,11,3,3,3,3,3,6,3,6,6,7,9};
        int y=maxduplicateval(numbers);
        System.out.println(y);



    }

    public static int maxduplicateval(int[] numbers) {

        int max = 0;
        int count = 0;
        Set<Integer> unqset = new HashSet<>();
        for (int i : numbers) {
            unqset.add(i);
        }
        for (int k : unqset) {
            for (int i = 0; i < numbers.length; i++) {
                if (k == numbers[i]) {
                    count += 1;
                }
                if (count > max) {
                    max = count;
                }
            }
            count = 0;


        }
        return max;
    }
}
