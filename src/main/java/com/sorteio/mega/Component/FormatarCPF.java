package com.sorteio.mega.Component;

import org.springframework.stereotype.Component;

@Component
public class FormatarCPF {

    public String formatarCPF(String cpf) throws Exception{
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos.");
        }

        // Verifica se todos os dígitos são iguais, o que invalida o CPF
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException("CPF inválido: todos os dígitos são iguais.");
        }

        // Calcula e verifica os dígitos verificadores
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }
        if (primeiroDigito != Integer.parseInt(String.valueOf(cpf.charAt(9))) ||
                segundoDigito != Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
            throw new IllegalArgumentException("CPF inválido: dígitos verificadores inválidos.");
        }

        // Formata o CPF usando expressões regulares
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
