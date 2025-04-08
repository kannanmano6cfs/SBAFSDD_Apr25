package com.example.firstdemo.firstdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface respositoryDB extends JpaRepository<model,Integer> {
}
