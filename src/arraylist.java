class User {
    String name;
    int Age;
    double AccountBalance;
    public User(String name,Integer Age,double AccountBalance){
        this.name=name;
        this.Age=Age;
        this.AccountBalance=AccountBalance;
    }
    public void transaction(){
        if (AccountBalance>4000){
            AccountBalance=(AccountBalance*110)/(100);
        }
        else{
            AccountBalance=(95*AccountBalance)/(100);
        }

    }
    public void status(){
        if (AccountBalance<100 & Age>18){
            AccountBalance=0;
        }
        else{
            AccountBalance=AccountBalance+1000;
        }
    }
}


public class arraylist {
    public static void main(){
        User u1=new User("Alex",23,200000);
        User u2=new User("Bob",13,250000);
        User u3=new User("Sofia",26,900000);

        System.out.println(u1.);


    }


}
