/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package code.model.enums;

/**
 *
 * @author jpssa
 */
public enum TiposDeBancos {
    BANCO_DO_BRASIL("001", "Banco do Brasil"),
    CAIXA_ECONOMICA_FEDERAL("104", "Caixa Econômica Federal"),
    ITAU("341", "Itaú Unibanco"),
    BRADESCO("237", "Banco Bradesco"),
    SANTANDER("033", "Banco Santander"),
    BANCO_INTER("077", "Banco Inter"),
    NUBANK("260", "Nubank"),
    BTG_PACTUAL("208", "BTG Pactual"),
    SAFRA("422", "Banco Safra"),
    BANCO_ORIGINAL("212", "Banco Original");

    private final String codigo;
    private final String nome;

    TiposDeBancos(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static TiposDeBancos getPorCodigo(String codigo) {
        for (TiposDeBancos banco : values()) {
            if (banco.getCodigo().equals(codigo)) {
                return banco;
            }
        }
        throw new IllegalArgumentException("Código de banco inválido: " + codigo);
    }
}
