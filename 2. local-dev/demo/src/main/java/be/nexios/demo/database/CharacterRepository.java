package be.nexios.demo.database;

import be.nexios.demo.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {
    Optional<Character> findOneByNameIgnoreCase(String name);
}
