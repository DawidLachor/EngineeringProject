package pl.skorpjdk.engineeringproject.login;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skorpjdk.engineeringproject.account.AccountService;
import pl.skorpjdk.engineeringproject.jwt.AuthenticationResponse;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class LoginController {

    private final AccountService userService;

    @PostMapping()
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }
}
