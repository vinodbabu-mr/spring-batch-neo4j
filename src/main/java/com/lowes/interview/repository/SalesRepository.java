package com.lowes.interview.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.lowes.interview.model.Sales;

@Repository
public interface SalesRepository extends Neo4jRepository<Sales, Long>{
	
	List<Sales> findByOrderId(long orderId); 
	@Query("MATCH (n:Sales) RETURN n LIMIT 10")
	public List<Sales> findSalesData();
}
