import java.util.ArrayList;
import java.util.HashMap;

public class MailDetailsExample {
    public static void main(String[] args) {
        // Creating the HashMap
        HashMap<String, ArrayList<String>> mailDetails_hashmap = new HashMap<>();
        HashMap<String, ArrayList<String>> usersprofiles= new HashMap<>(0);
        ArrayList<String> savindu=new ArrayList<>();
        savindu.add("12");
        savindu.add("67");
        savindu.add("789");
        usersprofiles.put("1", savindu);

        // Adding values to the HashMap
        ArrayList<String> aliceEmails = new ArrayList<>();
        aliceEmails.add("alice@example.com");
        aliceEmails.add("alice@gmail.com");
        mailDetails_hashmap.put("Alice", aliceEmails);

        ArrayList<String> bobEmails = new ArrayList<>();
        bobEmails.add("bob@example.com");
        bobEmails.add("bob1999@gmail.com");
        //mailDetails_hashmap.put("Bob", bobEmails);
        mailDetails_hashmap.put("Bob", bobEmails);
        mailDetails_hashmap.put("1", savindu);
        ArrayList<String> ghy = mailDetails_hashmap.get("1");
        System.out.println("savindu" + ghy);
        System.out.println(savi)

        // Accessing values from the HashMap
        ArrayList<String> aliceEmailList = mailDetails_hashmap.get("Alice");
        System.out.println("Alice's emails: " + aliceEmailList);
        ArrayList<String> bobEmailLists=mailDetails_hashmap.get("Bob");
        System.out.println("Bob's emails: " + bobEmailLists);

    }
}

