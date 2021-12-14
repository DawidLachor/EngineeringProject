package pl.skorpjdk.engineeringproject.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountDto getAccount(Long id) {
        Optional<Account> byId = accountRepository.findById(id);

        if (byId.isPresent()) {
            return new MapperAccount().toDto(byId.get());
        } else {
            throw new IllegalArgumentException("The");
        }
    }
}
