package com.gefshoes.api.repository;

import com.gefshoes.api.model.Account;
import com.gefshoes.api.model.RecoveryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface repository para a classe RecoveryCode.
 *
 * @author João Guedes.
 */
@Repository
public interface RecoveryCodeRepository extends JpaRepository<RecoveryCode, UUID> {

    boolean existsByAccount(Account account);

    Optional<RecoveryCode> findByAccount(Account account);

}
