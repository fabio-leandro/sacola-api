package me.dio.sacola.repositories;

import me.dio.sacola.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SacolaRepository extends JpaRepository<Sacola,Long> {
}
