package be.technifutur.labofinal.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subclass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subclass_id", nullable = false)
    private Long id;

    @Column(name = "subclass_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "subclass_class")
    private CharacterClass characterClass;
}
