/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Department.Department;
import Business.Department.Department.DepartmentType;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class Employee {
    
   
    private String name;
    private DepartmentType depType;
    private int id;
    private int age;
    private String sex;
    private String location;
    private Date registerTime;
    private Date leaveTime;
    private int level;
    private double salary;
    private static int count = 0;

    public Employee(String name, DepartmentType dep ) {
        this.name = name;
        this.depType = dep;
        if (depType == DepartmentType.HospitalAdminOrg) {
            this.salary = 1000;
        }
        if (depType == DepartmentType.OrganizationAdminOrg) {
            this.salary = 1200;
        }
        if (depType == DepartmentType.SystemOrg) {
            this.salary = 1300;
        }
        if (depType == DepartmentType.WorkerOrg) {
            this.salary = 1500;
        }

        this.registerTime = new Date();
        id = ++count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentType getDepType() {
        return depType;
    }

    public void setDepType(DepartmentType depType) {
        this.depType = depType;
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }
    
}
