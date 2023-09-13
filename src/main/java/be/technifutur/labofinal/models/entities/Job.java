package be.technifutur.labofinal.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column(name = "job_name", nullable = false, unique = true)
    private String name;

    @Column(name = "job_description", length = 1000)
    private String description;

    @Column(name = "job_hp_dice_value")
    private Integer hpDiceValue;

    @OneToMany(mappedBy = "job")
    private Set<Subclass> AvailableSubclasses;
}
