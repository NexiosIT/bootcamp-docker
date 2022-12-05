package be.nexios.demo.controller;

import be.nexios.demo.domain.Character;
import be.nexios.demo.rest.CreateCharacterRequest;
import be.nexios.demo.rest.CharacterResponse;
import be.nexios.demo.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public List<CharacterResponse> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PutMapping("/characters")
    public Character createCharacter(@RequestBody CreateCharacterRequest createCharacterRequest) {
        return characterService.createCharacter(createCharacterRequest);
    }
}
