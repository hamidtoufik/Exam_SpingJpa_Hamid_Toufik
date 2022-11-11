package com.example.examspringjpa.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employeeProfile")

public class EmployeeProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @javax.validation.constraints.NotNull
    @NotEmpty
    @NotBlank
    @Lob
    @Size(max = 65)
    @Column(name = "position", nullable = false)
    private String position;

    @Lob
    @NotBlank
    @NotEmpty
    @Size(max = 65)
    @Column(name = "departement", nullable = false)
    private String departement;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Employee employee;
    public EmployeeProfile() {
    }
public EmployeeProfile(String departement, String lastname, String postion){
        this.id = id;
        this.employee = new Employee();
        this.departement = departement;
        this.position= postion;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeProfile that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
