import java.time.LocalDate;
import java.time.Period;

class Person {
    
String name;
LocalDate birthdate;
double height;
double weight;
String address;

public Person(String name, LocalDate birthdate,double height, double weight ,String address)
{
    this.name=name;
    this.birthdate=birthdate;
    this.height=height;
    this.weight=weight;
    this.address=address;
}
public int CalculateAge()
{
    LocalDate today = LocalDate.now();
    return Period.between(birthdate,today).getYears();
}
}

class Student extends Person
{
    int rollno;
    double[] marks;

public Student(String name, LocalDate birthdate,double height, double weight ,String address,int rollno,double[] marks)
{
    super(name,birthdate,height,weight,address);
    this.rollno=rollno;
    this.marks=marks;
}
public double CalculateAvg()
{
    double sum=0;
    for(double mark:marks)
    {
        sum+=mark;
    }
    return sum/marks.length;
   
}
}

class Employee extends Person
{
    int empid;
    double salary;
    double homeloanInterest;
    double LIC;
    double Insurance;
    double TotalSalary;
  
public Employee(String name, LocalDate birthdate,double height, double weight ,String address,int empid, double salary, double homeloanInterest, double LIC,double Insurance )
{
    super(name,birthdate,height,weight,address);
    this.empid=empid;
    this.salary=salary;
    this.LIC =LIC;
    this.Insurance=Insurance;
    TotalSalary =salary*12;
}

public double CalculateTax()
{
    //assume tax is 5% of the salary
    
    double taxableSalary = TotalSalary -(homeloanInterest+LIC + Insurance);
    return taxableSalary*0.05;

}
}


public class InheritenceTest
{
    public static void main(String[] args)
    {
        Student student = new Student("sakshi", LocalDate.of(2005,1,1), 155, 45,"Ichalkaranji", 11, new double[]{91,90,89,95,88});
        System.out.println("The student name is "+student.name);
        System.out.println("The age of student is "+student.CalculateAge());
        System.out.println("The Averge marks of students are "+student.CalculateAvg());
        
        Employee employee = new Employee("Sneha",LocalDate.of(2004,3,31),156, 40, "Ich", 19, 50000,50000,10000,40000);
        System.out.println("Employee name is "+ employee.name);
        System.out.println("Emplyee age is "+employee.CalculateAge());
        System.out.println("Employee's monthly salary is "+employee.salary);
        System.out.println("Employee's annual salary is "+employee.TotalSalary);
        System.out.println("Employee's Total yearly tax is "+employee.CalculateTax());

    }
}


