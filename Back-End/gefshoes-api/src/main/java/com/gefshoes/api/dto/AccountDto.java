package com.gefshoes.api.dto;

import com.gefshoes.api.dto.validation.constraints.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Classe DTO para classe Account.
 *
 * @author João Guedes.
 */
@Data
public class AccountDto {
 
    @Email
    @NotBlank
    @Size(max = 256)
    private String email;
    @NotBlank
    @Size(min = 8, max = 100)
    private String password;
    @CPF
    private String cpf;

}
