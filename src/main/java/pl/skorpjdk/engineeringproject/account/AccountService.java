package pl.skorpjdk.engineeringproject.account;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.skorpjdk.engineeringproject.jwt.AuthenticationResponse;
import pl.skorpjdk.engineeringproject.jwt.JwtProvider;
import pl.skorpjdk.engineeringproject.login.LoginRequest;
import pl.skorpjdk.engineeringproject.registration.token.ConfirmationToken;
import pl.skorpjdk.engineeringproject.registration.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public AccountDto getAccount(Long id) {
        Optional<Account> byId = accountRepository.findById(id);

        if (byId.isPresent()) {
            return new MapperAccount().toDto(byId.get());
        } else {
            throw new IllegalArgumentException("The");
        }
    }

    public String singUpUser(Account account) {
        Optional<Account> userOptional = accountRepository.findByEmail(account.getEmail());
        if (userOptional.isPresent()) {
            if(userOptional.get().getEnabled())
                throw new IllegalStateException(String.format("Email %s exist in database", account.getEmail()));
        }

        //Zakodowanie hasła
        String encodePassword = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPassword(encodePassword);

        accountRepository.save(account);

        return getToken(account);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        if (!checkEnabled(loginRequest))
            throw new IllegalStateException("Username don't enable account");
        //Sprawdzanie poprawności danych
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String generateToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(generateToken, loginRequest.getUsername());
    }

    //zwracanie obecnie zalogowanego użytkownika
    public Account getCurrentAccount(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        return accountRepository.findByUsername(loggedInUser.getName()).orElseThrow(() -> new UsernameNotFoundException("User don't found by username"));
    }

    public Account findByUsername(String username){
        return accountRepository.findByUsername(username).orElseThrow(() -> new IllegalStateException("Username exist in database"));
    }

    private boolean checkEnabled(LoginRequest loginRequest) {
        Account user = accountRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new IllegalStateException("Username exist in database"));
        return user.getEnabled();
    }

    private String getToken(Account account) {
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                account
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }


//    public void enableAppUser(String email) {
//        accountRepository.enableUser(email);
//    }
}
