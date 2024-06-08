package com.gefshoes.api.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;

import com.gefshoes.api.dto.SendRecoveryCodeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gefshoes.api.dto.RecoveryCodeDto;
import com.gefshoes.api.dto.VerifyRecoveryCodeDto;
import com.gefshoes.api.model.Account;
import com.gefshoes.api.model.RecoveryCode;
import com.gefshoes.api.service.AccountService;
import com.gefshoes.api.service.MailService;
import com.gefshoes.api.service.RecoveryCodeService;
import jakarta.validation.Valid;

/**
 * Classe controller para a classe RecoveryCode.
 *
 * @author João Guedes.
 */
@RestController
@RequestMapping("/gef-shoes/recovery-codes")
public class RecoveryCodeController {

    final RecoveryCodeService recoveryCodeService;
    final AccountService accountService;

    public RecoveryCodeController(RecoveryCodeService recoveryCodeService, AccountService accountService) {
        this.recoveryCodeService = recoveryCodeService;
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid RecoveryCodeDto recoveryCodeDto) {
        if (recoveryCodeService.existsByAccount(recoveryCodeDto.getAccount())) {
            HttpStatus httpStatus = HttpStatus.CONFLICT;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Conta já tem um código de recuperação!"
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        var recoveryCode = new RecoveryCode();
        BeanUtils.copyProperties(recoveryCodeDto, recoveryCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(recoveryCodeService.save(recoveryCode));
    }
    
    @GetMapping("/id")
    public ResponseEntity<Object> findById(@RequestParam UUID id) {
        Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findById(id);
        if (recoveryCodeOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Código de recuperação não encontrado."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        return ResponseEntity.status(HttpStatus.OK).body(recoveryCodeOptional.get());
    }

    // @GetMapping("/account")
    // public ResponseEntity<Object> findByAccount(@RequestParam AccountDto accountDto) {
    //     var account = new Account();
    //     BeanUtils.copyProperties(accountDto, account);
    //     Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findByAccount();
    //     if (recoveryCodeOptional.isEmpty()) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
    //     }
    //     return ResponseEntity.status(HttpStatus.OK).body(recoveryCodeOptional.get());
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody RecoveryCodeDto recoveryCodeDto) {
        Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findById(id);
        if (recoveryCodeOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Código de recuperação não encontrado."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        var recoveryCode = recoveryCodeOptional.get();
        recoveryCode.setCode(recoveryCodeDto.getCode());
        recoveryCode.setGenerationDatetime(Timestamp.from(Instant.now()));
        return ResponseEntity.status(HttpStatus.OK).body(recoveryCodeService.save(recoveryCode));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findById(id);
        if (recoveryCodeOptional.isEmpty()) {
           HttpStatus httpStatus = HttpStatus.NOT_FOUND;
           record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Código de recuperação não encontrado."
            );
           return ResponseEntity.status(httpStatus).body(responseError);
        }
        recoveryCodeService.delete(recoveryCodeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Código de recuperação deletado com sucesso.");
    }

    @PostMapping("/send")
    public ResponseEntity<Object> sendRecoveryCode(@RequestBody @Valid SendRecoveryCodeDto sendRecoveryCodeDto) {
        Optional<Account> accountOptional = this.accountService.findByEmail(sendRecoveryCodeDto.getEmail());
        if (accountOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Código de recuperação não encontrado."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        record ResponseUpdate(String message) {}
        try {
            String code = new MailService().sendRecoveryEmail(sendRecoveryCodeDto.getEmail());
            Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findByAccount(accountOptional.get());
            RecoveryCode recoveryCode = new RecoveryCode();
            if (recoveryCodeOptional.isEmpty()) {
                recoveryCode.setAccount(accountOptional.get());
            }
            else {
                recoveryCode = recoveryCodeOptional.get();
            }
            recoveryCode.setCode(code);
            recoveryCodeService.save(recoveryCode);
            RecoveryCode finalRecoveryCode = recoveryCode;
            new Thread(() -> {
                try {
                    Thread.sleep(300000);
                    this.delete(finalRecoveryCode.getId());
                } catch (InterruptedException ignored) {}
            }).start();
            ResponseUpdate responseUpdate = new ResponseUpdate("O código de recuperação da conta foi enviado para o e-mail.");
            return ResponseEntity.status(HttpStatus.OK).body(responseUpdate);
        } catch (MessagingException e) {
            ResponseUpdate responseUpdate = new ResponseUpdate("Não foi possível enviar o email.");
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseUpdate);
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<Object> verifyRecoveryCode(@RequestBody @Valid VerifyRecoveryCodeDto verifyRecoveryCodeDto) {
        record Response(String message, boolean success) {}
        Optional<Account> accountOptional = this.accountService.findByEmail(verifyRecoveryCodeDto.getEmail());
        if (accountOptional.isPresent()) {
            Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findByAccount(accountOptional.get());
            if (recoveryCodeOptional.isPresent() && verifyRecoveryCodeDto.getToken().equals(recoveryCodeOptional.get().getCode())) {
                Response response = new Response("Código válido.", true);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
        Response response = new Response("Código inválido.", false);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
