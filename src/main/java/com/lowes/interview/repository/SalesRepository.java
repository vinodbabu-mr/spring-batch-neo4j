package com.lowes.interview.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.lowes.interview.model.Salesdata;

@Repository
public interface SalesRepository extends Neo4jRepository<Salesdata, Long>{

}
