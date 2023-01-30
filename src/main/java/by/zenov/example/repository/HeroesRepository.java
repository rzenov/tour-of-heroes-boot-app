package by.zenov.example.repository;

import by.zenov.example.model.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends JpaRepository<HeroEntity, String> {
}
