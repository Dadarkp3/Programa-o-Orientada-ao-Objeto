/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.sistemas;

import hospitalveterinario.cliente.Animal;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.HospitalVeterinario;
import javax.swing.JOptionPane;

/**
 *
 * @author queenregina
 */
public class SistemaSenha {
        
    public static void main(HospitalVeterinario h)
    {
        JOptionPane.showMessageDialog(null,"\n - Sistema de Senha -\n");
        String cpf = SistemaTratamentoErro.tratamentoErro(" ", "Digite o numero do CPF", "Erro: \nSomente Números devem ser adicionados.\nEscreva o CPF sem pontos,hífen ou espaço");     
        Cliente cliente = Cliente.getCliente(h.getArrPessoa(),cpf);
        if(cliente != null)
        {
            if(cliente.isInadimplente())
            {
                JOptionPane.showMessageDialog(null,"Por favor dirija-se ao caixa antes de pegar sua senha");
            }
            else
            {
                String nomeAnimal = JOptionPane.showInputDialog(null,"Digite o nome do animal:");
                if(cliente.getAnimal(nomeAnimal) == null)
                {
                    cliente.getArrAnimal().add(new Animal(nomeAnimal));
                }
                h.getSenhaInicial().adicionarSenha();
            }
        }
        else
        {
            String nome = JOptionPane.showInputDialog(null,"Digite o seu nome:");
            String nomeAnimal = JOptionPane.showInputDialog(null,"Digite o nome do animal:");
            h.getArrPessoa().add(new Cliente(nome,cpf,nomeAnimal));
            h.getSenhaInicial().adicionarSenha();
        }
    }
}
