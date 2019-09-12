package com.example.cosmetics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cosmetics.entity.Cosmetics;

public interface CosmeticRepository extends JpaRepository<Cosmetics, Long>{

}
