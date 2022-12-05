package be.nexios.demo.database;

import be.nexios.demo.domain.Character;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CharacterRepositoryTest {

    @Container
    public static PostgreSQLContainer<?> postgresDB = new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("postgres");

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",postgresDB::getJdbcUrl);
        registry.add("spring.datasource.username", postgresDB::getUsername);
        registry.add("spring.datasource.password", postgresDB::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("spring.datasource.hikari.connection-timeout", () -> "250");
    }

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void testFindByNameIgnoreCaseSingle() {
        Character character = new Character();
        character.setName("someName");
        Character expectedCharacter = characterRepository.save(character);

        Optional<Character> maybeActualCharacter = characterRepository.findOneByNameIgnoreCase("somename");

        assertTrue(maybeActualCharacter.isPresent());
        assertEquals(expectedCharacter, maybeActualCharacter.get());
    }

    @Test
    public void testFindByNameIgnoreCaseNone() {
        Optional<Character> maybeActualCharacter = characterRepository.findOneByNameIgnoreCase("somename");

        assertFalse(maybeActualCharacter.isPresent());
    }

    @Test
    public void testFindByNameIgnoreCaseMultiple() {
        Character character1 = new Character();
        character1.setName("someName");
        characterRepository.save(character1);
        Character character2 = new Character();
        character2.setName("someName");
        characterRepository.save(character2);

        assertThrows(IncorrectResultSizeDataAccessException.class,
                () -> characterRepository.findOneByNameIgnoreCase("somename"));
    }
}