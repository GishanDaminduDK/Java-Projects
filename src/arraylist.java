class User {
    public double transaction;
    String name;
    int Age;
    double AccountBalance;
    public User(String name,Integer Age,double AccountBalance){
        this.name=name;
        this.Age=Age;
        this.AccountBalance=AccountBalance;
    }
    public double transaction(){
        if (AccountBalance>4000){
            AccountBalance=(AccountBalance*110)/(100);
            return AccountBalance;
        }
        else{
            AccountBalance=(95*AccountBalance)/(100);
            return AccountBalance;
        }


    }
    public String status(){
        if (AccountBalance<100 & Age>18){
            AccountBalance=0;
            return "Account is closed";
        }
        else{
            AccountBalance=AccountBalance+1000;
            return "Immediately update the your account";
        }
    }
}


public class arraylist {
    public static void main(String[] args){
        User u1=new User("Alex",23,200000);
        User u2=new User("Bob",13,250000);
        User u3=new User("Sofia",26,900000);

        System.out.println(u1.transaction());
        System.out.println(u1.status());


    }


}
