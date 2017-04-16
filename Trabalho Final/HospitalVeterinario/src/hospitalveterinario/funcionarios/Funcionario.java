/*
 * Classe para a criação dos Objetos Funcionarios
 */
package hospitalveterinario.funcionarios;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Funcionario extends Pessoa {
    private String login, senha;
    private double salario;
    
    public Funcionario(String nome, String cpf, String login, String senha)
    {
        super(nome,cpf);
        this.login = login;
        this.senha = senha;
    }
    
    public Funcionario(String nome, String endereco, String cpf, String rg, String telefone, String celular, String email, String login, String senha, double salario) {
        super(nome, endereco, cpf, rg, telefone, celular, email);
        this.login = login;
        this.senha = senha;
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    //Esse método retorna o valor do Salário com Bônus

    public double getSalarioComBonus()
    {
        return salario;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\n" + "login=" + login + ", senha=" + senha + ", salario=" + salario;
    }
    
}
