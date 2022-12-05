package be.nexios.demo.rest;

import be.nexios.demo.domain.Character;

import java.util.UUID;

public record CharacterResponse(UUID id, String name) {
    public static CharacterResponse fromCharacter(Character u) {
        return new CharacterResponse(u.getId(), u.getName());
    }
}
