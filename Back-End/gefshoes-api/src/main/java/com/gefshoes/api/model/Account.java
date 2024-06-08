package com.gefshoes.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe responsável por representar a entidade accounts (contas).
 *
 * @author João Guedes.
 */
@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 256)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(unique = true, length = 11)
    private String cpf;
    @OneToOne(mappedBy = "account")
    @Cascade({CascadeType.REMOVE, CascadeType.MERGE})
    @JsonIgnore
    private RecoveryCode recoveryCode;

}
