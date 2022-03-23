package pl.skorpjdk.engineeringproject.account;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperAccount implements Mapper<Account, AccountDto> {
    @Override
    public AccountDto toDto(Account entity) {
        AccountDto account = new AccountDto();
        account.setId(entity.getId());
        account.setEmail(entity.getEmail());
        account.setUsername(entity.getUsername());
        account.setFirstName(entity.getFirstName());
        account.setLastName(entity.getLastName());
        account.setPhone(entity.getPhone());
        account.setLocation(entity.getLocation());
        return account;
    }

    @Override
    public Account toEntity(AccountDto dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setEmail(dto.getEmail());
        account.setUsername(dto.getUsername());
        account.setFirstName(dto.getFirstName());
        account.setLastName(dto.getLastName());
        account.setPhone(dto.getPhone());
        account.setLocation(dto.getLocation());
        return account;
    }
}
