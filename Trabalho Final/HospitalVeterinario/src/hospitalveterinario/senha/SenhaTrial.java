/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.senha;

import javax.swing.JOptionPane;

/**
 *
 * @author queenregina
 */
public class SenhaTrial extends SenhaModeloEntrada implements ISenha{
    private static int senha;
    private static int qtdClienteNormal;
    char c = 'T';
    
    public SenhaTrial() {
        SenhaTrial.senha = 0;
        SenhaTrial.qtdClienteNormal = 0;
    }
    
    @Override
    public void chamarSenha() {
        if(qtdClienteNormal > 0)
        {
           SenhaTrial.senha++;
            qtdClienteNormal--;
            JOptionPane.showMessageDialog(null,"S"+c+SenhaTrial.senha);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaTrial.senha = 0;
    }

    @Override
    public void adicionarSenha() {
        SenhaTrial.qtdClienteNormal++;
        JOptionPane.showMessageDialog(null,"S"+c+SenhaTrial.qtdClienteNormal);
    }
}

