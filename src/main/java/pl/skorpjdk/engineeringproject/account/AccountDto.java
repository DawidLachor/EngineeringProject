package pl.skorpjdk.engineeringproject.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Getter
@Setter
public class AccountDto {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String location;
}
