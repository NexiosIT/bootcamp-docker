package be.nexios.demo.service;

import be.nexios.demo.database.CharacterRepository;
import be.nexios.demo.domain.Character;
import be.nexios.demo.rest.CreateCharacterRequest;
import be.nexios.demo.rest.CharacterResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character createCharacter(CreateCharacterRequest createCharacterRequest) {
        Character character = new Character();
        character.setId(UUID.randomUUID());
        character.setName(createCharacterRequest.name());
        return characterRepository.save(character);
    }

    public List<CharacterResponse> getAllCharacters() {
        return characterRepository.findAll().stream().map(CharacterResponse::fromCharacter).toList();
    }
}
