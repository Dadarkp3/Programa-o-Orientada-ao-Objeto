/*
 * Classe criada para os clientes do Hospital Veterinario
 */
package hospitalveterinario.cliente;
import hospitalveterinario.Data;
import hospitalveterinario.funcionarios.Pessoa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import hospitalveterinario.sistemas.SistemaTratamentoErro;

/**
 * @author Daiane Silva e João Felipe Freitas
 */

 //Herança
public class Cliente extends Pessoa {
    private boolean ufba;

    public boolean isUfba() {
        return ufba;
    }

    public void setUfba(boolean ufba) {
        this.ufba = ufba;
    }
    

    public static boolean validarCliente(ArrayList<Pessoa> arrPessoa, String cpf) {
        boolean resposta = false;
        for(Pessoa p : arrPessoa)
        {
            if(p instanceof Cliente)
            {
                Cliente temporario = (Cliente)p;
                if(temporario.getCpf().equals(cpf))
                {
                    resposta = true;
                }
            }
        }
        return resposta;
    }

    public static Cliente getCliente(ArrayList<Pessoa> arrPessoa, String cpf) {
        Cliente c = null;
        for(Pessoa p : arrPessoa)
        {
            if(p instanceof Cliente)
            {
                if(p.getCpf().equals(cpf))
                {
                    Cliente temporario =(Cliente)p;
                    c = temporario;
                }
            }
        }
        return c;
    }
    
    private boolean inadimplente = false;
    private String outrasInformacoes;
    private ArrayList<Animal> arrAnimal = new ArrayList<>();

    
    //Sobrecarga
    public Cliente(String nome, String cpf, String nomeAnimal)
    {
        super(nome,cpf);
        arrAnimal.add(new Animal(nomeAnimal));
    }

    public Cliente(String nome, String endereco, String cpf, String rg, String telefone, String celular, String email, String outrasInformacoes, boolean ufba) {
        super(nome, endereco, cpf, rg, telefone, celular, email);
        this.outrasInformacoes = outrasInformacoes;
        this.ufba = ufba;
    }
    
    public boolean isInadimplente() {
        return inadimplente;
    }

    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }

    public void setOutrasInformacoes(String outrasInformacoes) {
        this.outrasInformacoes = outrasInformacoes;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" + "inadimplente=" + inadimplente + ", outrasInformacoes=" + outrasInformacoes;
    }

    
    public void setAnimal(String nome, float peso, String especie, String raca, String pelagem, String esterilizacao, String infoComplementar, boolean temPedigree, char sexo, int dia, int mes, int ano)
    {
        this.arrAnimal.add(new Animal(nome,peso,especie,raca,pelagem,esterilizacao,infoComplementar, temPedigree,sexo,dia,mes,ano));
    }

    public ArrayList<Animal> getArrAnimal() {
        return arrAnimal;
    }
    
    public Animal getAnimal(String nome)
    {
        Animal a = null;
        for(Animal animal : this.arrAnimal)
        {
            if(animal.getNome().equals(nome))
            {
                a = animal;
            }
        }
        return a;
    }
    
    public static String CLientesInadimplentes(ArrayList<Pessoa> arrPessoa)
    {
        String cliente = "";
        for(Pessoa p : arrPessoa)
        {
            if(p instanceof Cliente)
            {
               Cliente temporario = (Cliente)p;
               temporario.clienteInadimplente();
               if(temporario.isInadimplente())
                   cliente += "\n"+temporario.getNome()+"está inadimplente. Telefone:"+temporario.getTelefone();
            }
        }    
        return cliente;
    }
    
    public void clienteInadimplente()
    {
        Data hoje = new Data();
        for(Animal a : this.arrAnimal)
        {
            for(Atendimento atendimento : a.getArrAtendimento())
            {
                if(atendimento.getDataRetorno().getDia()+1 == hoje.getDia() && atendimento.getDataRetorno().getMes() == hoje.getMes() && atendimento.getDataRetorno().getAno() == hoje.getAno())
                {
                        if(atendimento.getConta().isContaAberta())
                        {
                            this.inadimplente = true;
                        }
                } 
                else 
                {
                   this.inadimplente = false; 
                }
            }
        }
    }
    
        public static void criarCliente(ArrayList<Pessoa> arrPessoa)
    {
        JOptionPane.showMessageDialog(null,"- Criação de Usuário -");
        String cpf =  SistemaTratamentoErro.tratamentoErro(" ", "Digite o cpf:");

        if(Cliente.validarCliente(arrPessoa, cpf))
        {
            JOptionPane.showMessageDialog(null, "Usuário já existe.");
        }
        else
        {
            String nome = JOptionPane.showInputDialog(null,"Digite o Nome:");
            String endereco = JOptionPane.showInputDialog(null,"Digite o Endereço:");
            String rg = JOptionPane.showInputDialog(null,"Digite o RG:");
            String telefone = JOptionPane.showInputDialog(null,"Digite o telefone:");
            String celular = JOptionPane.showInputDialog(null,"Digite o celular:");
            String email = JOptionPane.showInputDialog(null,"Digite o e-mail:");
            String outrasInformacoes = JOptionPane.showInputDialog(null,"Digite o e-mail:");
            int ufba = SistemaTratamentoErro.tratamentoErro(0, "Estudande ou Funcionário da UFBA?\n1.Sim\n2.Não");
            boolean uf = false;
            if(ufba == 1) uf = true;
            arrPessoa.add(new Cliente(nome, endereco, cpf, rg, telefone, celular, email,outrasInformacoes,uf));
        }
    }
}
