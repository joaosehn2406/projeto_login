/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.model.entity.Finance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpssa
 */
public class GestaoLancamentos {
    
    private List<Lancamento> lancamentos;

    public GestaoLancamentos(){
        lancamentos = new ArrayList<>();
    }
    
    public void adicionarLancamento(Lancamento lancamento) {
        lancamentos.add(lancamento);
    }
    
    public void removerLancamento(Lancamento lancamento) {
        lancamentos.remove(lancamento);
    }
    
    public static <T extends GestaoLancamentos> void mostrarLancamentos(List<? extends Lancamento> lancamentos){
        
        for(Lancamento l : lancamentos) {
            l.toString();
        }
        System.out.println("========================");
    }
    
    public double somarSaldo(List<Lancamento> lancamentos){
        
    }
}
