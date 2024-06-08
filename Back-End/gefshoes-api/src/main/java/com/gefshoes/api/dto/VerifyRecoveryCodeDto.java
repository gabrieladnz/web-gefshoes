package com.gefshoes.api.dto;

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
public class VerifyRecoveryCodeDto {
 
    @Email
    @NotBlank
    @Size(max = 256)
    private String email;
    @NotBlank
    private String token;

}
