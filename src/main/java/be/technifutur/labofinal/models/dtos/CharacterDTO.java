package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.Character;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterDTO {
    private Long id;
    private String name;
    private Integer level;
    private Integer hp;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private String player;
    private String job;
    private String subclass;
    private String scenario;

    public static CharacterDTO toDTO(Character entity) {
        if (entity == null) {
            return null;
        }

        if (entity.getScenario() == null) {
            return CharacterDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .level(entity.getLevel())
                    .hp(entity.getHp())
                    .strength(entity.getStrength())
                    .dexterity(entity.getDexterity())
                    .constitution(entity.getConstitution())
                    .intelligence(entity.getIntelligence())
                    .wisdom(entity.getWisdom())
                    .charisma(entity.getCharisma())
                    .player(entity.getPlayer().getName())
                    .job(entity.getJob().getName())
                    .subclass(entity.getSubclass().getName())
                    .scenario("Scénario non attribué")
                    .build();
        }

        return CharacterDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .level(entity.getLevel())
                .hp(entity.getHp())
                .strength(entity.getStrength())
                .dexterity(entity.getDexterity())
                .constitution(entity.getConstitution())
                .intelligence(entity.getIntelligence())
                .wisdom(entity.getWisdom())
                .charisma(entity.getCharisma())
                .player(entity.getPlayer().getName())
                .job(entity.getJob().getName())
                .subclass(entity.getSubclass().getName())
                .scenario(entity.getScenario().getName())
                .build();
    }
}
