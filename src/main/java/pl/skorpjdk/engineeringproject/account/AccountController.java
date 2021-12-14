package pl.skorpjdk.engineeringproject.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skorpjdk.engineeringproject.announcement.AnnouncementService;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("account/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id){
        AccountDto account = accountService.getAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

}
