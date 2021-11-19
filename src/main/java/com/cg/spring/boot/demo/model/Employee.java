package com.cg.spring.boot.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.springframework.stereotype.Component;

//@Component
@Entity
@Table(name = "emp_table2")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	@Column
//	@Size(min = 3, max = 16, message = "firstName should be between %min and %max characters.")
	private String name;
	
	@Column
	private  double salary;
	
	@ManyToOne
	@JoinColumn(name = "did")
	private Department department;
	
	public Employee() {
		super();
	}
	public Employee(int eid, String name, double salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
	}
	public Employee(int eid, String name, double salary, Department department) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ "]";
	}
	
	

}
