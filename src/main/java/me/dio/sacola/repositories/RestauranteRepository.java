package me.dio.sacola.repositories;

import me.dio.sacola.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
