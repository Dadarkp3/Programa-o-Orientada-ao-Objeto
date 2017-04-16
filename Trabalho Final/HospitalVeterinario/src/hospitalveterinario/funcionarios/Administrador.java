/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.funcionarios;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Administrador extends Funcionario {
    
    
    public Administrador(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha);
    }

    public Administrador(String nome, String endereco, String cpf, String rg, String telefone, String celular, String email, String login, String senha, double salario) {
        super(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario);
    }

    
    
}
