package com.gefshoes.api.dto;

import com.gefshoes.api.model.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Classe DTO para classe RecoveryCode.
 *
 * @author João Guedes.
 */
@Data
public class RecoveryCodeDto {
 
    @NotBlank
    @Size(max = 19)
    private String code;
    @NotNull
    Account account;

}
