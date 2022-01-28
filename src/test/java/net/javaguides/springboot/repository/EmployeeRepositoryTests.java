package net.javaguides.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;
import net.javaguides.springboot.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @DisplayName("JUnit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        //given
        Employee employee = Employee.builder()
                .firstName("Luis")
                .lastName("Oliveira")
                .email("luis@mail.com")
                .build();

        //when
        Employee savedEmployee = employeeRepository.save(employee);

        //then
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);

    }

   //JUnit test for get all employees operation
   @DisplayName("Junit to get all employees operation")
   @Test
   public void givenEmployeesList_whenFindAll_thenEmployeesList(){
      // given - precondition or setup
       Employee employee = Employee.builder().firstName("Luis").lastName("Oliveira").email("luis@mail.com").build();
       Employee employee1 = Employee.builder().firstName("Felipe").lastName("Miranda").email("felipe@mail.com").build();

       employeeRepository.save(employee);
       employeeRepository.save(employee1);
      // when - action or the behavior that are going to test
       List<Employee> employeesList = employeeRepository.findAll();


      // then - verify the output
       assertThat(employeesList).isNotNull();
       assertThat(employeesList.size()).isEqualTo(2);
   }

   //JUnit test for get an employee by id
   @Test
   public void givenEmployeeObject_whenFindById_thenEmployeeObject(){
       // given - precondition or setup
       Employee employee = Employee.builder().firstName("Luis").lastName("Oliveira").email("luis@mail.com").build();
       employeeRepository.save(employee);
       // when - action or the behavior that are going to test
       Employee findedEmployeeByID = employeeRepository.findById(employee.getId()).get();

       // then - verify the output
       assertThat(findedEmployeeByID).isNotNull();
   }

   //JUnit test for get employee by email operation
    @DisplayName("JUnit test for get employee by email operation")
   @Test
   public void givenEmployeeEmail_whenFindByEmail_thenEmployeeObject(){
       // given - precondition or setup
       Employee employee = Employee.builder().firstName("Luis").lastName("Oliveira").email("luis@mail.com").build();
       employeeRepository.save(employee);

       // when - action or the behavior that are going to test
       Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();

       // then - verify the output
       assertThat(employeeDB).isNotNull();
   }
}
