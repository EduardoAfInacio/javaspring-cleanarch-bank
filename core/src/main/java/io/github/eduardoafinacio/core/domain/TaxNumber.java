package io.github.eduardoafinacio.core.domain;

public class TaxNumber {
    private String value;

    public TaxNumber() {}

    public TaxNumber(String taxNumber) throws Exception{
        setValue(taxNumber);
    }

    public void setValue(String value) throws Exception {
        if(!isValid(value)) throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    private Boolean isValid(String taxNumber) {
        String normalized = taxNumber.replaceAll("[^0-9]", "");

        if (normalized.length() == 11) {
            return isCpfValid(normalized);
        } else if (normalized.length() == 14) {
            return isCnpjValid(normalized);
        } else {
            throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        }
    }

    private Boolean isCpfValid(String cpf) {
        // CPF inválido se todos os dígitos forem iguais (ex.: 111.111.111-11)
        if (cpf.chars().distinct().count() == 1) return false;

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) firstDigit = 0;
        if ((cpf.charAt(9) - '0') != firstDigit) return false;

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) secondDigit = 0;

        return (cpf.charAt(10) - '0') == secondDigit;
    }


    private boolean isCnpjValid(String cnpj) {
        // CNPJ inválido se todos os dígitos forem iguais
        if (cnpj.chars().distinct().count() == 1) return false;

        int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights1[i];
        }
        int firstDigit = sum % 11;
        firstDigit = firstDigit < 2 ? 0 : 11 - firstDigit;
        if ((cnpj.charAt(12) - '0') != firstDigit) return false;

        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights2[i];
        }
        int secondDigit = sum % 11;
        secondDigit = secondDigit < 2 ? 0 : 11 - secondDigit;

        return (cnpj.charAt(13) - '0') == secondDigit;
    }

}

