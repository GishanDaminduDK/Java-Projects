import java.util.*;

public class deque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> uniqueSet = new HashSet<>();

        int n = 10;//in.nextInt();
        int m = 5;//in.nextInt();
        int maxUniqueCount = 0;
        //int[] numbers=new int[6];
        int[] numbers={1,2,3,4,5,5,5,5,2,2};


        for (int num:numbers) {
            //int num = in.nextInt();//

            // Add the current element to the deque and set
            deque.addLast(num);
            uniqueSet.add(num);

            // Maintain the size of the deque as 'm'
            if (deque.size() > m) {
                int removedElement = deque.removeFirst();
                // if (!deque.contains(removedElement)) {
                //     uniqueSet.remove(removedElement);
                //     for (int no:uniqueSet){
                //       System.out.println(no);
                //     }

            }

            // Update the maximum unique count
            if (deque.size() == m && uniqueSet.size() > maxUniqueCount) {
                maxUniqueCount = uniqueSet.size();
                int k=maxduplicateval(deque);
                if (k>maxUniqueCount){
                    maxUniqueCount=k;
                }
            }
        }
        System.out.println(maxUniqueCount);
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