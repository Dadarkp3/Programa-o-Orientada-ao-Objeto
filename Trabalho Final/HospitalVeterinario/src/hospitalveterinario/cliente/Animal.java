/*
 * Classe dos animais atendidos no Hospital Veterinário
 */
package hospitalveterinario.cliente;
import hospitalveterinario.Data;
import hospitalveterinario.funcionarios.Medico;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import hospitalveterinario.sistemas.SistemaTratamentoErro;
/**
 * @author Daiane Silva e João Felipe Freitas
 */

public class Animal {
    private String nome,especie,raca,pelagem,esterilizacao,infoComplementar;
    private boolean temPedigree,estaVivo = true;
    private Data nascimento;
    private char sexo;//F para feminino, M para masculino
    private ArrayList<Atendimento> arrAtendimento = new ArrayList<>();
    private float peso; 

    public ArrayList<Atendimento> getArrAtendimento() {
        return arrAtendimento;
    }

    public void adicionarAtendimento(Medico medico) {
        this.arrAtendimento.add(new Atendimento(medico));
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    //Sobrecarga, construtores diferentes para uma mesma classe
    public Animal(String nome)
    {
        this.nome = nome;
    }

    public Animal(String nome, float peso, String especie, String raca, String pelagem, String esterilizacao, String infoComplementar, boolean temPedigree, char sexo, int dia, int mes, int ano) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.pelagem = pelagem;
        this.esterilizacao = esterilizacao;
        this.infoComplementar = infoComplementar;
        this.temPedigree = temPedigree;
        this.sexo = sexo;
        this.nascimento = new Data(dia,mes,ano);
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public String getEsterilizacao() {
        return esterilizacao;
    }

    public void setEsterilizacao(String esterilizacao) {
        this.esterilizacao = esterilizacao;
    }

    public String getInfoComplementar() {
        return infoComplementar;
    }

    public void setInfoComplementar(String infoComplementar) {
        this.infoComplementar = infoComplementar;
    }

    public boolean getTemPedigree() {
        return temPedigree;
    }

    public void setTemPedigree(boolean temPedigree) {
        this.temPedigree = temPedigree;
    }

    public boolean getEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public Data getNascimento() {
        return nascimento;
    }
    
    public String getNascimentoString()
    {
        return nascimento.getDiaMesAno();
    }

    public void setNascimento(int dia, int mes, int ano) {
        this.nascimento.setDia(dia);
        this.nascimento.setMes(mes);
        this.nascimento.setAno(ano);
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Animal{" + "nome=" + nome + ", especie=" + especie + ", raca=" + raca + ", pelagem=" + pelagem + ", esterilizacao=" + esterilizacao + ", infoComplementar=" + infoComplementar + ", temPedigree=" + temPedigree + ", estaVivo=" + estaVivo + ", nascimento=" + nascimento + ", sexo=" + sexo + ", Atendimento=" + arrAtendimento + ", peso=" + peso + '}';
    }
    
    public static void adicionarInformacoes(Cliente cliente)
    {   
        if(cliente == null)
        {
            JOptionPane.showMessageDialog(null,"Usuário não encontrado");
        }
        else
        {
            String nomeA = JOptionPane.showInputDialog("Digite o nome do Animal");
            Animal animal = null;
            int i = 0;
            animal = Animal.getAnimal(cliente, nomeA);
            if(animal==null)
            {
                cliente.getArrAnimal().add(new Animal(nomeA));
            }
            else
            {
                JOptionPane.showMessageDialog(null,animal);
                boolean sair = false;
                while(!sair)
                {
                        int entrada = SistemaTratamentoErro.tratamentoErro(0, "- Adicionar Informação a Animal - \n"+
                            "1.  Pelagem\n"+
                                "2.  Espécie\n"+
                                "3.  Raça\n"+
                                    "4.  Informação Complementar\n"+
                                    "5.  Esterilizacao\n"+
                                    "6.  Sexo\n"+
                                    "7.  Pedigree\n"+
                                    "8.  Data de Nascimento\n"+
                                    "9.  Animal está vivo?\n"+
                                    "0. Sair\n");

                    switch(entrada)
                    {
                            case 1:
                                animal.setPelagem(JOptionPane.showInputDialog("Digite a Pelagem:"));
                                break;
                            case 2:
                                animal.setEspecie(JOptionPane.showInputDialog("Digite a Espécie:"));
                                break;
                            case 3:
                                animal.setRaca(JOptionPane.showInputDialog("Digite a raça:"));
                                break;
                            case 4:
                                animal.setInfoComplementar(JOptionPane.showInputDialog("Digite as Informações Adicionais"));
                                break;
                            case 6:
                                animal.setSexo(JOptionPane.showInputDialog("Digite o sexo\nF - feminino ou M - masculino:").charAt(0));
                                break;
                            case 8:
                                int dia = SistemaTratamentoErro.tratamentoErro(0, "Digite o dia:\n");
                                int mes = SistemaTratamentoErro.tratamentoErro(0, "Digite o mes:\n");
                                int ano = SistemaTratamentoErro.tratamentoErro(0, "Digite o ano:\n");
                                animal.setNascimento(dia, entrada, entrada);
                                break;
                            case 7:
                                boolean pedigree = false;
                                int escolha = SistemaTratamentoErro.tratamentoErro(0, "1. Tem pedigree.\n2. Não tem pedigree.\n");
                                if(escolha == 1)
                                    pedigree = true;
                                animal.setTemPedigree(pedigree);
                                break;
                            case 9:
                                boolean morreu = false;
                                escolha =  SistemaTratamentoErro.tratamentoErro(0, "1. Animal morreu.\n2. Animal não morreu.\n");

                                if(escolha == 1)
                                    morreu = true;
                                animal.setTemPedigree(morreu);
                                break;
                            case 0:
                                sair = true;
                                break;
                            case 5:
                                animal.setEsterilizacao(JOptionPane.showInputDialog("O animal já é castrado.\nSim - Não\n"));
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Valor inválido.\n");
                                break;
                    }
                }
            }    
        }       
    }
    
    
    public static Animal getAnimal(Cliente cliente, String nome)
    {
        Animal animal = null;
        for(Animal a : cliente.getArrAnimal())
        {
            if(a.getNome().equals(nome))
                animal = a;
        }
        return animal;
    }
    
    
    
}