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

    @Column(name = "job_name", nullable = false)
    private String name;

    @Column(name = "job_description")
    private String description;

    @OneToMany(mappedBy = "job")
    private Set<Subclass> AvailableSubclasses;
}
