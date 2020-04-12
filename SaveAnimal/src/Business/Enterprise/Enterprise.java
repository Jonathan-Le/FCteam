package Business.Enterprise;

//import business.employee.EmployeeDirectory;
//import business.organization.OrganizationDirectory;
//import business.organization.Organization;
//import business.useraccount.UserAccountDirectory;
import Business.Employee.EmployeeDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.Department.Department;
import Business.Department.DepartmentDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author lhm
 */
public abstract class Enterprise {

    private String enterpriseName;
    private int enterpriseID;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private DepartmentDirectory DepartmentDirectory;
    private EnterpriseType enterpriseType;
    private WorkQueue adoptionQueue;
    private static int counter = 0;

    public enum EnterpriseType {
        RescuOrganization("RescuOrganization Enterprise"), hospital("hospital Enterprise");
        private String value;
        private EnterpriseType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Enterprise(String name, EnterpriseType type) {
        this.enterpriseName = name;
        this.enterpriseType = type;
        this.enterpriseID = ++counter;
        DepartmentDirectory = new DepartmentDirectory();
        userAccountDirectory = new UserAccountDirectory();
        employeeDirectory = new EmployeeDirectory();
        this.adoptionQueue = new WorkQueue();
    }

    public WorkQueue getAdoptionQueue() {
        return adoptionQueue;
    }

    public void setAdoptionQueue(WorkQueue adoptionQueue) {
        this.adoptionQueue = adoptionQueue;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public int getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(int enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public DepartmentDirectory getDepartmentDirectory() {
        return DepartmentDirectory;
    }

    public void setOrganizationDirectory(DepartmentDirectory AppartmentDirectory) {
        this.DepartmentDirectory = AppartmentDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    public abstract ArrayList<Department.DepartmentType> getSupportedOrganization();

    @Override
    public String toString(){
        return this.enterpriseName + " (" + this.enterpriseType + ")";
    }

}
