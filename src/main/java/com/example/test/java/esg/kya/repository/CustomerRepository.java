package com.example.test.java.esg.kya.repository;

import com.example.test.java.esg.kya.entity.Customer;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(schema = "customer")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
