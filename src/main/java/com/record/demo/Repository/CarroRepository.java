package com.record.demo.Repository;

import com.record.demo.model.carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<carro, Integer> {
}
