package pl.skorpjdk.engineeringproject.registration.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skorpjdk.engineeringproject.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "account_id"
    )
    private Account account;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Account account) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.account = account;
    }
}
