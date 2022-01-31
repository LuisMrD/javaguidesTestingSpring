package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Employee2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTests2 {

    @Autowired
    EmployeeRepository2 repository;

    @DisplayName("Saving an Employee")
    //JUnit test for
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnSavedEmployee(){
        // given - precondition or setup
        Employee2 employee = Employee2.builder()
                .firstName("Luis")
                .lastName("Oliveira")
                .email("luisoliveira@mail.com")
                .build();


        // when - action or the behavior that are going to test
        Employee2 savedEmployee = repository.save(employee);

        // then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }

    //JUnit test for
    @Test
    public void givenEmployeeObject_whenGetEmployeeById_thenEmployee(){
        // given - precondition or setup
        Employee2 employee = Employee2.builder()
                .firstName("Luis")
                .lastName("Oliveira")
                .email("luisoliveira@mail.com")
                .build();

        repository.save(employee);
        // when - action or the behavior that are going to test
        Employee2 employeeSaved = repository.getById(employee.getId());

        // then - verify the output
        Assertions.assertThat(employeeSaved).isNotNull();
        Assertions.assertThat(employeeSaved.getId()).isGreaterThan(0);
    }

    //JUnit test for
    @Test
    public void givenTwoEmployeeObjects_whenFindAll_thenReturnEmployeeList(){
        // given - precondition or setup
        Employee2 employee = Employee2.builder()
                .firstName("Luis")
                .lastName("Oliveira")
                .email("luisoliveira@mail.com")
                .build();

        Employee2 employee1 = Employee2.builder()
                .firstName("Felipe")
                .lastName("Miranda")
                .email("felipemiranda@mail.com")
                .build();

        repository.save(employee);
        repository.save(employee1);
        // when - action or the behavior that are going to test

        List<Employee2> savedEmployees = repository.findAll();
        // then - verify the output

        Assertions.assertThat(savedEmployees.size()).isEqualTo(2);
    }

    //JUnit test for
    @Test
    public void givenEmployeeObject_whenGetByEmail_thenReturnEmployee(){
        // given - precondition or setup
        Employee2 employee = Employee2.builder()
                .firstName("Luis")
                .lastName("Oliveira")
                .email("luisoliveira@mail.com")
                .build();

        repository.save(employee);

        // when - action or the behavior that are going to test
        Employee2 employeeDB = repository.getByEmail(employee.getEmail()).get();

        // then - verify the output
        Assertions.assertThat(employeeDB).isNotNull();
    }
}
