package com.gefshoes.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author João Guedes.
 */
@Data
public class SendRecoveryCodeDto {

    @NotBlank
    @Email(message = "Invalid email!")
    private String email;

}
