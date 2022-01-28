package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepository2Tests {

    @Autowired
    private EmployeeRepository2 employeeRepo;

    @DisplayName("Testando salvar funcionarios no banco")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        //given
        Employee2 employee = Employee2.builder()
                .name("Luis Oliveira")
                .email("luis@mail.com")
                .build();

        Employee2 savedEmployeer = employeeRepo.save(employee);

        Assertions.assertThat(savedEmployeer).isNotNull();
        Assertions.assertThat(savedEmployeer.getId()).isGreaterThan(0);


    }

    //JUnit test for
        @Test
        public void given_when_then(){
            // given - precondition or setup

            // when - action or the behavior that are going to test

            // then - verify the output
        }
}
