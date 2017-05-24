import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * Classe que cria um cliente que é uma subclasse de Utilizador
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Cliente extends Utilizador implements Serializable
{
    /**
     * Variáveis de Instância
     */
    
    /**
     * Histórico das viagens do cliente
     */
    private Set<ViagemCliente> historico; 
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância cliente 
     */
    public Cliente(){
        super();
        this.historico = new TreeSet<ViagemCliente>();
    }
    
    /**
     * Construtor por cópia que cria um novo cliente a partir dos parâmetros dados 
     * 
     * @param n  Nome do cliente
     * @param e  Email do cliente
     * @param p  Password do cliente
     * @param m  Morada do cliente 
     * @param dn Data de nascimento do cliente
     */
    public Cliente(String n, String e, String p, String m, String dn){
        super(n,e,p,m,dn);
        this.historico = new TreeSet<ViagemCliente>();
    }
    
    /**
     * Construtor que cria um novo cliente a partir de um cliente passado como parâmetro
     * 
     * @param c  Cliente    
     */
    public Cliente(Cliente c){
        super(c);
        this.historico = c.getHistorico();
    }
    
    /**
     * Métodos de instância 
     */
    
    /**
     * Método que devolve um histórico de viagens de um cliente
     * 
     * @return O histórico
     */
    public Set<ViagemCliente> getHistorico(){
        Set<ViagemCliente> aux = new TreeSet<>();
      
        for(ViagemCliente v: this.historico){
            aux.add(v.clone());
        }
        return aux;
    }
    
    /**
     * Método que define um histórico de viagens a partir de um histórico passado como parâmetro
     * 
     * @param ts    Histórico de viagens de um cliente
     */
     public void setHistorico(Set<ViagemCliente> ts){
        this.historico.clear();
        for(ViagemCliente v: ts){
            this.historico.add(v.clone());
        }
    }
    
    /**
     * Devolve uma representação do histórico de viagens de um cliente no formato textual 
     * 
     * @return  string com o histórico de viagens do cliente
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("CLIENTE:\n");
        sb.append(super.toString()+"\n");
        sb.append("Historico:\n").append(this.historico.toString()+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de uma identificação de um cliente
     * 
     * @return     O novo cliente
     */
    public Cliente clone(){
        return new Cliente(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado cliente 
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual ao cliente, false se o objeto passado não for igual ao cliente
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Cliente c = (Cliente) o;
        return (super.equals(c) && this.historico.equals(c.getHistorico()));
    }
    
    /** 
     * Adiciona uma viagem ao histórico de viagens de um cliente
     * 
     * @param v    Viagem de um cliente
     */
    public void addViagemCliente(ViagemCliente v){
        this.historico.add(v.clone());
    }
    
    /**
     * Remove uma viagem do histórico de viagens de um cliente
     * 
     * @param v    Viagem de um cliente 
     */
    public void removeViagemCliente(ViagemCliente v){
        this.historico.remove(v);
    }
    
    /**
     * Adiciona um conjunto de viagens ao histórico
     * 
     * @param viagens      TreeSet de viagens a adicionar ao histórico
     */
    public void addViagensCliente(Set<ViagemCliente> viagens){
        
        for(ViagemCliente v : viagens)
            this.historico.add(v.clone());
    }
}
