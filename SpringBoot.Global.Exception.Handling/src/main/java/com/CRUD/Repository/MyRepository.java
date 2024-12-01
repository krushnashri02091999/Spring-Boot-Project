package com.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.model.Product;
@Repository
public interface MyRepository extends JpaRepository<Product, Integer> {
//	@Query("select p from Product p where p.ename=:n")
//	Product findbyname(@Param("n") String pname);
//	Product findbyname(String pname);

}
