package by.zenov.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "heroes")
public class HeroEntity {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String heroName;
}
