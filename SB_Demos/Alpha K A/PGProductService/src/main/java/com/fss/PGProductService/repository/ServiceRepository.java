package com.fss.PGProductService.repository;

import com.fss.PGProductService.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
