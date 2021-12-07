package pl.skorpjdk.engineeringproject.transmission;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class TransmissionDto {
    private Long id;
    private String type;
    private int numberOfGears;
}
