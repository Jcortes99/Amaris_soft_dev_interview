package Amaris.SoftwareInterview.model;

public class User {
    private int id;
    private String employee_name;
    private Long employee_salary;
    private int employee_age;
    private Long employee_anual_salary;

    public User(int id, String name, Long salary, int age){
        this.id = id;
        this.employee_name = name;
        this.employee_salary = salary;
        this.employee_age = age;
//        this.employee_anual_salary = salary * 12;
    }

    public int getId(){ return id; }
    public String getName(){ return employee_name;}
    public Long getEmployee_salary(){ return employee_salary;}
    public int getEmployee_age(){ return employee_age;}
    public Long getEmployee_anual_salary(){ return employee_anual_salary;}

    public void setEmployee_anual_salary(Long anual_salary){ this.employee_anual_salary = anual_salary;}
}
