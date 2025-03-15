/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.model.entity.Finance;

import code.model.enums.TipoLancamento;
import code.model.enums.TiposDeBancos;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author jpssa
 */
public class Lancamento {
    
    private LocalDateTime dataLanc;
    private Double valor;
    private String descricao;
    private String observacao;
    
    private TiposDeBancos tiposDeBancos;
    private TipoLancamento tipoLancamento;

    public Lancamento(LocalDateTime dataLanc, Double valor, String descricao, String observacao, TiposDeBancos tiposDeBancos, TipoLancamento tipoLancamento) {
        this.dataLanc = dataLanc;
        this.valor = valor;
        this.descricao = descricao;
        this.observacao = observacao;
        this.tiposDeBancos = tiposDeBancos;
        this.tipoLancamento = tipoLancamento;
    }
    
    

    public TiposDeBancos getTiposDeBancos() {
        return tiposDeBancos;
    }

    public void setTiposDeBancos(TiposDeBancos tiposDeBancos) {
        this.tiposDeBancos = tiposDeBancos;
    }
    
    public LocalDateTime getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(LocalDateTime dataLanc) {
        this.dataLanc = dataLanc;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    @Override
    public String toString() {
    return "Lancamento{" +
            "dataLanc=" + dataLanc +
            ", valor=" + valor +
            ", descricao='" + descricao + '\'' +
            ", observacao='" + observacao + '\'' +
            ", tiposDeBancos=" + tiposDeBancos +
            ", tipoLancamento=" + tipoLancamento +
            '}';
    }

    
}
