package com.gefshoes.api.controller;

import com.gefshoes.api.dto.AccountDto;
import com.gefshoes.api.model.Account;
import com.gefshoes.api.model.RecoveryCode;
import com.gefshoes.api.service.AccountService;
import com.gefshoes.api.service.RecoveryCodeService;
import jakarta.validation.Valid;
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
import java.util.Optional;
import java.util.UUID;

/**
 * Classe controller para a classe Account.
 *
 * @author João Guedes.
 */
@RestController
@RequestMapping("/gef-shoes/accounts")
public class AccountController {

    final AccountService accountService;
    final RecoveryCodeService recoveryCodeService;

    public AccountController(AccountService accountService, RecoveryCodeService recoveryCodeService) {
        this.accountService = accountService;
        this.recoveryCodeService = recoveryCodeService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AccountDto accountDto) {
        accountDto.setEmail(accountDto.getEmail().toLowerCase());
        if (accountService.existsByEmail(accountDto.getEmail())) {
            HttpStatus httpStatus = HttpStatus.CONFLICT;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "O e-mail já está sendo usado!"
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        var account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account));
    }
    
    @GetMapping("/id")
    public ResponseEntity<Object> findById(@RequestParam UUID id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (accountOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Conta não encontrada."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountOptional.get());
    }

    @GetMapping("/email")
    public ResponseEntity<Object> findByEmail(@RequestParam String email) {
        Optional<Account> accountOptional = accountService.findByEmail(email.toLowerCase());
        if (accountOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Conta não encontrada."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid AccountDto accountDto) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (accountOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Conta não encontrada."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        var account = accountOptional.get();
        account.setPassword(accountDto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(accountService.save(account));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (accountOptional.isEmpty()) {
            HttpStatus httpStatus = HttpStatus.NOT_FOUND;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Conta não encontrada."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        accountService.delete(accountOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AccountDto accountDto) {
        var account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        Optional<Account> accountOptional = accountService.login(account);
        if (accountOptional.isEmpty()){
            HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Credenciais inválidas. Por favor, verifique seu e-mail e senha."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        record ResponseLogin(UUID id){}
        ResponseLogin responseLogin = new ResponseLogin(accountOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(responseLogin);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid AccountDto accountDto) {
        accountDto.setEmail(accountDto.getEmail().toLowerCase());
        if (accountService.existsByEmail(accountDto.getEmail())) {
            HttpStatus httpStatus = HttpStatus.CONFLICT;
            record ResponseError (int status, String error, String message) {}
            ResponseError responseError = new ResponseError(
                    httpStatus.value(),
                    httpStatus.getReasonPhrase(),
                    "Email em uso. Tente com outro."
            );
            return ResponseEntity.status(httpStatus).body(responseError);
        }
        var account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        accountService.register(account);
        record ResponseRegister(UUID id){}
        ResponseRegister responseRegister = new ResponseRegister(account.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseRegister);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Valid AccountDto accountDto) {
        record Response(String message, boolean success) {}
        Optional<Account> accountOptional = accountService.findByEmail(accountDto.getEmail());
        if (accountOptional.isEmpty()) {
            Response response = new Response("Conta não encontrada.", false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        var account = accountOptional.get();
        account.setPassword(accountDto.getPassword());
        accountService.recovery(account);
        Optional<RecoveryCode> recoveryCodeOptional = recoveryCodeService.findByAccount(account);
        recoveryCodeOptional.ifPresent(recoveryCodeService::delete);
        Response response = new Response("Conta atualizada com sucesso.", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
