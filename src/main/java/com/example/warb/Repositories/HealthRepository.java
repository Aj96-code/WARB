package com.example.warb.Repositories;

import com.example.warb.JPAEntities.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<Health, Integer> {
}