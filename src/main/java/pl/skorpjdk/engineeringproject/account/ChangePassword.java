package pl.skorpjdk.engineeringproject.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangePassword {
    private String oldPassword;
    private String newPassword;
}
