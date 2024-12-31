package oop_concepts;

public class Customer{
    private String Name;
    private String Address;
    private Integer Age;

    public Customer(String Name, String Address, Integer Age){
        this.Name=Name;
        this.Address=Address;
        this.Age=Age;

    }
    public String getName(){
        return Name;
    }
    public String getAddress(){
        return Address;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
