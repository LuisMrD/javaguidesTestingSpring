package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository2  extends JpaRepository<Employee2, Long> {
}
