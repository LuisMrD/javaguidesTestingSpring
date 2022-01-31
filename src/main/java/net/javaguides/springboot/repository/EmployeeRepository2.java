package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository2 extends JpaRepository<Employee2, Long> {

    Optional<Employee2> getByEmail(String email);
}
