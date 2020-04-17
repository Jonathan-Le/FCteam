/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Department.Department;
import Business.Pet.Pet;
import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author raunak
 */
public class Employee {
    
   
    private String name;
    private int id;
    private int age;
    private String sex;
    private String location;
    private Date registerTime;
    private Date leaveTime;
    private int level;
    private double salary;
    private ArrayList<Pet> PetList;
//    private static int count = 0;

    public Employee(String name ) {
        this.name = name; 
        this.registerTime = new Date();
        id = getUUID();
    }
     public int getUUID(){
        String id = null;
        UUID uuid = UUID.randomUUID();
        id=uuid.toString();
        
        id=id.replace("-", "");
        int num= id.hashCode();
        num=Math.abs(num);
        return  num;      
    }
    public ArrayList<Pet> getPetList() {
        return PetList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
}
