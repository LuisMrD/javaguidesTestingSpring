package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Entity
@Table(name = "tb_employee")
public class Employee2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "emp_name", nullable = false, length = 500)
    private String name;

    @Column(name = "emp_email", nullable = false)
    private String email;
}
