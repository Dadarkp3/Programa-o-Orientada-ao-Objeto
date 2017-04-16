package hospitalveterinario.funcionarios;


/*
 * Classe bolsista é um tipo especial de Funcionario
 */

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Bolsista extends Funcionario {
    
    public Bolsista(String nome, String endereco, String cpf, String rg, String telefone, String celular, String email, String login, String senha, double salario) {
        super(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario);
    }
    
}
