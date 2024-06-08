package com.gefshoes.api.service;

import com.gefshoes.api.model.Account;
import com.gefshoes.api.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

/**
 * Classe service para a classe Account.
 *
 * @author João Guedes.
 */
@Service
public class AccountService {

    final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Object save(Account account) {
        return this.accountRepository.save(account);
    }

    public Optional<Account> findById(UUID id) {
        return this.accountRepository.findById(id);
    }

    public Optional<Account> findByEmail(String email) {
        return this.accountRepository.findByEmail(email);
    }

    @Transactional
    public void delete(Account account) {
        this.accountRepository.delete(account);
    }

    public boolean existsByEmail(String email) {
        return this.accountRepository.existsByEmail(email);
    }

    public Optional<Account> login(Account account) {
        Optional<Account> accountOptional = this.accountRepository.findByEmail(account.getEmail().toLowerCase());
        if (accountOptional.isPresent() && account.getPassword().equals(accountOptional.get().getPassword())) {
            return accountOptional;
        }
        return Optional.empty();
    }

    @Transactional
    public Object register(Account account) {
        return this.accountRepository.save(account);
    }

    @Transactional
    public Object recovery(Account account) {
        return this.accountRepository.save(account);
    }

}
