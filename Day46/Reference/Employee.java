package Day46.Reference;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
        System.out.println("Employee()...");
    }
    public Employee(int id){
        this.id  =id;
    }
public Employee(int id,String name){
        this.id = id;
        this.name = name;
}
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getDetails(){
        return getId()+"\t\t"+name+"\t"+age+"\t\t"+salary;
    }
    @Override
    public String toString() {
        return getDetails();
    }
}
