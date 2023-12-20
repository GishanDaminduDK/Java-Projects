import java.util.*;

public class deque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> uniqueSet = new HashSet<>();

        int n = 6;//in.nextInt();
        int m = 3;//in.nextInt();
        int maxUniqueCount = 0;
        //int[] numbers=new int[6];
        int[] numbers={5,3,5,2,3,2};


        for (int num:numbers) {
            //int num = in.nextInt();

            // Add the current element to the deque and set
            deque.addLast(num);
            uniqueSet.add(num);

            // Maintain the size of the deque as 'm'
            if (deque.size() > m) {
                int removedElement = deque.removeFirst();
                if (!deque.contains(removedElement)) {
                    uniqueSet.remove(removedElement);
                }
            }

            // Update the maximum unique count
            if (deque.size() == m && uniqueSet.size() > maxUniqueCount) {
                maxUniqueCount = uniqueSet.size();
            }
        }

        System.out.println(maxUniqueCount);
    }
}
