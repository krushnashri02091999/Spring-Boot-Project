package com.CRUD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CRUD.Model.Employee;
@Repository
public interface MyRepository extends JpaRepository<Employee, Integer>{
	@Query("select e from Employee e where e.ename=:n")
	public List<Employee> byname(@Param("n") String ename);
}
