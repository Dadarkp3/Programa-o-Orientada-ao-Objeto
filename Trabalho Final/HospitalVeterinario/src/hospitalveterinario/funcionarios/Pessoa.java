/*
 * Classe Genérica para criação de Pessoa
 */
package hospitalveterinario.funcionarios;

import java.util.ArrayList;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Pessoa {
    private String nome, endereco, cpf, rg, telefone, celular, email;
    
    public Pessoa(String nome, String cpf)
    {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Pessoa(String nome, String endereco, String cpf, String rg, String telefone, String celular, String email) {
        this(nome,cpf);
        this.endereco = endereco;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n" + "nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email;
    }
    
    public static boolean validarPessoa(ArrayList<Pessoa> arrPessoa, String cpf)
    {
        boolean resposta = false;
        for(Pessoa p : arrPessoa)
        {
            if(p.getCpf().equals(cpf))
                resposta = true;
        }
        return resposta;
    }
}
