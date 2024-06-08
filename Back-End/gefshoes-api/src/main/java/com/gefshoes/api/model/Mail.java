package com.gefshoes.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author João Guedes.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Mail {

    private String emailFrom;
    private String ownerPassword;
    private String emailTo;
    private String subject;
    private String text;

}
