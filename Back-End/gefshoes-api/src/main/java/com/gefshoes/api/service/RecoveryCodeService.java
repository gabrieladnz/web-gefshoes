package com.gefshoes.api.service;

import com.gefshoes.api.model.Account;
import com.gefshoes.api.model.RecoveryCode;
import com.gefshoes.api.repository.RecoveryCodeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

/**
 * Classe service para a classe RecoveryCode.
 *
 * @author João Guedes.
 */
@Service
public class RecoveryCodeService {

    final RecoveryCodeRepository recoveryCodeRepository;

    public RecoveryCodeService(RecoveryCodeRepository recoveryCodeRepository) {
        this.recoveryCodeRepository = recoveryCodeRepository;
    }

    @Transactional
    public Object save(RecoveryCode recoveryCode) {
        return this.recoveryCodeRepository.save(recoveryCode);
    }

    public Optional<RecoveryCode> findById(UUID id) {
        return this.recoveryCodeRepository.findById(id);
    }

    public Optional<RecoveryCode> findByAccount(Account account) {
        return this.recoveryCodeRepository.findByAccount(account);
    }

    @Transactional
    public void delete(RecoveryCode recoveryCode) {
        this.recoveryCodeRepository.delete(recoveryCode);
    }

    public boolean existsByAccount(Account account) {
        return this.recoveryCodeRepository.existsByAccount(account);
    }

}
