/*
 * Classe de Médico, tipo especial de Funcionario
 */
package hospitalveterinario.funcionarios;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Medico extends Funcionario{
    
    private String crmv, especializacao;

    public Medico(String nome, String endereco, String cpf, String rg, String telefone, String celular, String email, String login, String senha, double salario, String crmv, String especializacao) {
        super(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario);
        this.crmv = crmv;
        this.especializacao = especializacao;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrm(String crmv) {
        this.crmv = crmv;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    

    
}
