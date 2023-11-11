package com.record.demo.Repository;

import com.record.demo.model.Usercars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usercars, Integer> {
    Usercars findByUsername(String username);
}
