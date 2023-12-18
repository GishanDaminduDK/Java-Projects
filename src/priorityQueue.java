package javaCollection;
import java.util.*;
class Student implements Comparable<Student>{
    private int rank;
    private String name;
    public Student(String name, int rank){ // constructor to set name and rank of student
        this.name=name;
        this.rank=rank;
    }
    @Override
    public int compareTo(Student st) {
        if (rank <st.rank)
            return -1;
        else if (rank > st.rank)
            return 1;
        return 0;
    }
    @Override
    public String toString(){
        String result ="Student name: "+name+",rank"+rank;
        return result;

    }
}
public class priorityQueue{
    public static void main(String[] args) {
        PriorityQueue<Student> studentQ=new PriorityQueue<>();
        // inser students into the priority queue
        studentQ.add(new Student("Ashish",5));
        studentQ.add(new Student("Muthumala",3));
        studentQ.add(new Student("Madusa",1));
        studentQ.add(new Student("Didula",4));
        studentQ.add(new Student("Moshi",2));
        System.out.println("Size of the queue: " + studentQ.size());
        Iterator<Student> it=studentQ.iterator();// iterator to iterate through queue
        while(it.hasNext()){
            //delete and display the first element from the queue
            System.out.println("The item of thr queue: "+ studentQ.poll().toString());
        }
    }
}