package com.gefshoes.api.repository;

import com.gefshoes.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface repository para a classe Account.
 *
 * @author João Guedes.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    boolean existsByEmail(String email);

    Optional<Account> findByEmail(String email);

}
