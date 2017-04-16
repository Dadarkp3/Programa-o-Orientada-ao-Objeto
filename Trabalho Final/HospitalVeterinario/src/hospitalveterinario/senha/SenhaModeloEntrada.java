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
public class SenhaModeloEntrada implements ISenha {

    private static int senha;
    private static int qtdClienteNormal;
    private char c = 'R';
    
    public SenhaModeloEntrada() {
        SenhaModeloEntrada.senha = 0;
        SenhaModeloEntrada.qtdClienteNormal = 0;
    }
    
    @Override
    public void chamarSenha() {
        if(qtdClienteNormal > 0)
        {
            SenhaModeloEntrada.senha++;
            qtdClienteNormal--;
            JOptionPane.showMessageDialog(null,"S"+c+SenhaModeloEntrada.senha);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaModeloEntrada.senha = 0;
    }

    @Override
    public void adicionarSenha() {
        SenhaModeloEntrada.qtdClienteNormal++;
        JOptionPane.showMessageDialog(null,"S"+c+SenhaModeloEntrada.qtdClienteNormal);
    }

    
}
