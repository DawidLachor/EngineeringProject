package pl.skorpjdk.engineeringproject.account;

import pl.skorpjdk.engineeringproject.mapper.Mapper;

public class MapperAccount implements Mapper<Account, AccountDto> {
    @Override
    public AccountDto toDto(Account entity) {
        AccountDto account = new AccountDto();
        account.setId(entity.getId());
        account.setName(entity.getName());
        account.setSurname(entity.getSurname());
        account.setPhone(entity.getPhone());
        account.setLocation(entity.getLocation());
        return account;
    }

    @Override
    public Account toEntity(AccountDto dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setName(dto.getName());
        account.setSurname(dto.getSurname());
        account.setPhone(dto.getPhone());
        account.setLocation(dto.getLocation());
        return account;
    }
}
