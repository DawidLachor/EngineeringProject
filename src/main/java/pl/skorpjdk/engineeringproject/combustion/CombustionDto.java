package pl.skorpjdk.engineeringproject.combustion;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class CombustionDto {

    private Long id;
    private Integer city;
    private Integer outOfTower;
    private Integer mixed;
}
