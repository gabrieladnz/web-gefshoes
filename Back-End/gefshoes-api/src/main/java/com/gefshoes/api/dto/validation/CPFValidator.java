package com.gefshoes.api.dto.validation;

import com.gefshoes.api.dto.validation.constraints.CPF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Validator para o campo CPF.
 *
 * @author João Guedes.
 */
public class CPFValidator implements ConstraintValidator<CPF, String> {

    /**
     * Verifica se um CPF é válido.
     * 
     * @param cpf
     * 
     * @param constraintValidatorContext
     */
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return cpf == null || (
                cpf.length() == 11 &&
                this.isDigit(cpf) &&
                this.containsDifferentDigits(cpf) &&
                this.firstDigitCheck(cpf) &&
                this.secondDigitCheck(cpf)
        );
    }

    /**
     * Verifica se uma String pode ser considerada um dígito.
     *
     * @param s
     *
     * @return retorna true caso a String possa ser considerada dígito ou false caso não possa.
     */
    public boolean isDigit(String s) {
        for(char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se uma string contém dígitos diferentes. Ex.: 11111111111 (retorna false), 11111111112 (retorna true).
     *
     * @param s
     *
     * @return retorna true caso a string contenha dígitos diferentes.
     */
    public boolean containsDifferentDigits(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o primeiro dígito verificador é valido. Para verificar basta multiplicarmos o resultado da soma da
     * multiplição dos 9 primeiros dígitos pela sequência decrescente de números de 10 à 2 por 10 e dividirmos por 11.
     * O resto dessa divisão dever ser igual ao primeiro dígito verificador.
     *
     * @param cpf
     *
     * @return true caso o primeiro dígito verificador seja válido ou false caso não.
     */
    private boolean firstDigitCheck(String cpf) {
        int r = this.firstNDigitsSum(cpf, 9) * 10 % 11;
        System.out.println(r);
        return Character.getNumericValue(cpf.charAt(9)) == r;
    }

    /**
     * Verifica se o segundo dígito verificador é valido. Para verificar basta multiplicarmos o resultado da soma da
     * multiplição dos 10 primeiros dígitos pela sequência decrescente de números de 11 à 2 por 10 e dividirmos por 11.
     * O resto dessa divisão dever ser igual ao segundo dígito verificador.
     *
     * @param cpf
     *
     * @return true caso o segundo dígito verificador seja válido ou false caso não.
     */
    private boolean secondDigitCheck(String cpf) {
        int r = this.firstNDigitsSum(cpf, 10) * 10 % 11;
        return Character.getNumericValue(cpf.charAt(10)) == r;
    }

    /**
     * Multiplica os n primeiros dígitos pela sequência decrescente de números de n+1 à 2, soma os resultados e
     * retornando o valor final.
     *
     * @param s
     *
     * @param n
     *
     * @return
     */
    private int firstNDigitsSum(String s, int n) {
        int digit;
        int[] mult = new int[n];
        for (int i = 0; i < mult.length; i++) {
            digit = Character.getNumericValue(s.charAt(i));
            mult[i] = digit * (n+1-i);
        }
        return Arrays.stream(mult).sum();
    }

}
