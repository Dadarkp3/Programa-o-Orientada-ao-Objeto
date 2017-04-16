/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.senha;

import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class SenhaInicial extends SenhaModeloEntrada implements ISenha {
    static int senha;
    private static int qtdClienteNormal;
    private final char c = 'R';
    
    public SenhaInicial() {
        SenhaInicial.senha = 0;
        SenhaInicial.qtdClienteNormal = 0;
    }
    
    @Override
    public void chamarSenha() {
        if(qtdClienteNormal > 0)
        {
           SenhaInicial.senha++;
            qtdClienteNormal--;
            JOptionPane.showMessageDialog(null,"S"+c+SenhaInicial.senha);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaInicial.senha = 0;
    }

    @Override
    public void adicionarSenha() {
        SenhaInicial.qtdClienteNormal++;
        JOptionPane.showMessageDialog(null,"S"+c+SenhaInicial.qtdClienteNormal);
    }

   
}
