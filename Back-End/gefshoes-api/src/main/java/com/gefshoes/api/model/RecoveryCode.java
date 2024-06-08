package com.gefshoes.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Classe responsável por representar a entidade recovery_codes (códigos de recuperação).
 *
 * @author João Guedes.
 */
@Entity
@Table(name = "recovery_codes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecoveryCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = false, length = 19)
    private String code;
    @CreationTimestamp
    @Column(name = "generation_datetime", nullable = false, unique = false)
    private Timestamp generationDatetime;
    @OneToOne()
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

}
