import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.Serializable;
/**
 * Classe que cria uma viagem de um cliente que é subclasse de Viagem
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class ViagemCliente extends Viagem implements Serializable
{
    /**
     * Variáveis de Instância
     */
    
    /**
     * Nome do motorista
     */
    private String nomeMotorista;
    
    /**
     * Classificação atribuida a um motorista pelo cliente
     */
    private int classificacaoAtribuida;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância viagem de cliente
     */
    public ViagemCliente(){
        super();
        this.nomeMotorista = "ND";
        this.classificacaoAtribuida = 0;
    }
    
    /**
     * Construtor por cópia que cria uma viagem do cliente a partir dos parâmetros dados 
     * 
     * @param dt    Data 
     * @param t    Tempo
     * @param p    Localização de partida do cliente 
     * @param d    Localização do destino
     * @param v   Veiculo
     * @param k    Kilometros percorridos na viagem
     * @param time Tempo da viagem
     * @param pr   Preço real da viagem
     * @param pe   Preço estimado da viagem
     * @param n    Nome do motorista
     * @param ca   Classificação atribuida ao motorista
     */
    public ViagemCliente(LocalDate dt, LocalTime t, Espaco2D p, Espaco2D d, Veiculo v, double k, double time, double pr, double pe, String n, int ca){
        super(dt, t, p, d, v, k, time, pr, pe);
        
        this.nomeMotorista = n;
        this.classificacaoAtribuida = ca;
    }
    
    /**
     * Construtor que cria uma nova viagem de um cliente a partir de um cliente passado como parâmetro
     * 
     * @param v  Viagem de um cliente    
     */
    public ViagemCliente(ViagemCliente v){
        super(v);
        this.nomeMotorista = v.getNomeMotorista();
        this.classificacaoAtribuida = v.getClassificacaoAtribuida();
    }
    
    /**
     * Métodos de Instância
     */
    
    /**
     * Método que devolve o nome de um motorista
     * 
     * @return O nome do motorista
     */
    public String getNomeMotorista(){
        return this.nomeMotorista;
    }
    
    /**
     * Método que define o nome de um motorista através de uma String passada como parâmetro
     * 
     * @param n    Nome do motorista
     */
    public void setNomeMotorista(String n){
        this.nomeMotorista = n;
    }
    
    /**
     * Método que devolve a classificação de um motorista atribuida por um cliente
     * 
     * @return Classificação de um motorista
     */
    public int getClassificacaoAtribuida(){
        return this.classificacaoAtribuida;
    }
    
    /**
     * Método que define a classificação atribuida a partir de um int passado como parâmetro
     * 
     * @param c    Classificação atribuida
     */
    public void setClassificacaoAtribuida(int c){
        this.classificacaoAtribuida = c;
    }
    
    /**
     * Devolve uma representação da viagem de um cliente no formato textual 
     * 
     * @return  string com a viagem do cliente
     */
    public String toString(){
        return super.toString()+"Nome do Motorista: "+this.nomeMotorista+"\nClassificacao Dada: "+this.classificacaoAtribuida+"\n";
    }
    
    /**
     * Método que cria uma cópia de uma viagem de um cliente
     * 
     * @return     Viagem de um cliente
     */
    public ViagemCliente clone(){
        return new ViagemCliente(this);
    }
    
    /**
     * Método que testa se um objeto é igual a uma determinada viagem de cliente 
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual à viagem do cliente, false caso contrário
     */
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        ViagemCliente v = (ViagemCliente) o;
        return super.equals(v) && this.nomeMotorista.equals(v.getNomeMotorista()) && this.classificacaoAtribuida==v.getClassificacaoAtribuida();
    }
}
