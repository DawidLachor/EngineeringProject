package pl.skorpjdk.engineeringproject.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skorpjdk.engineeringproject.announcement.AnnouncementService;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("account")
    public ResponseEntity<?> getAccount(){
        AccountDto account = accountService.getAccount();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("account")
    public ResponseEntity<?> changePassword(@RequestBody ChangePassword changePassword){
        Boolean passwordChange = accountService.changePassword(changePassword);
        return new ResponseEntity<>(passwordChange, HttpStatus.OK);
    }

}
