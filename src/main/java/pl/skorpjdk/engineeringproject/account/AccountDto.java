package pl.skorpjdk.engineeringproject.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AccountDto {

    private Long id;
    private String name;
    private String surname;
    private String location;
    private Integer phone;
}
