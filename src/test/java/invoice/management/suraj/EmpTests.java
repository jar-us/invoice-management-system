package invoice.management.suraj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmpTests {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Test
    public void test_if_employee_is_persisted(){

        Employee employee = new Employee();
        Department department = new Department();
        employee.setDepartment(department);

//        departmentRepo.save(department);

        Employee savedEmployee = employeeRepo.save(employee);

        System.out.println(savedEmployee);

    }

}
