package Service;

import Department.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private final List<Department> departmentList = new ArrayList<>();

    public void addDepartment(String nameCommunity){
        departmentList.add(new Department(nameCommunity));
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
