/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.model.entity.Finance;

import code.model.enums.TipoLancamento;
import code.model.enums.TiposDeBancos;
import java.time.LocalDateTime;

/**
 *
 * @author jpssa
 */
public class Receita extends Lancamento{

    public Receita(LocalDateTime dataLanc, Double valor, String descricao, String observacao, TiposDeBancos tiposDeBancos, TipoLancamento tipoLancamento) {
        super(dataLanc, valor, descricao, observacao, tiposDeBancos, tipoLancamento.RECEITA);
    } 
    
    
}
