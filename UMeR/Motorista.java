import java.util.Set;
import java.util.TreeSet;
import java.lang.Math;
import java.io.Serializable;
/**
 * Classe que cria um motorista que é uma subclasse de Utilizador
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Motorista extends Utilizador implements Serializable
{   
    /**
     * Variáveis de Instância
     */
    
    /**
     * Histórico das viagens de um motorista
     */
    private Set<Viagem> historico;
    
    /**
     * Total de kilometros percorridos
     */
    private double kmsTotal;
    
    /**
     * Disponibilidade de um motorista
     */
    private boolean disponibilidade;
    
    /**
     * Quantidade de viagens que um motorista efetuou
     */
    private int qtViagens;
    
    /**
     * Classificação Média de um motorista
     */
    private double classificacaoMedia;
    
    /**
     * Grau de cumprimento de um motorista
     */
    private double grauCumprimento;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância motorista
     */
    public Motorista(){
        super();
        this.historico = new TreeSet<Viagem>();
        this.kmsTotal = 0;
        this.disponibilidade = false;
        this.qtViagens = 0;
        this.classificacaoMedia = 0;
        this.grauCumprimento = 0;
    }
    
    /**
     * Construtor por cópia que cria um novo motorista a partir dos parâmetros dados 
     * 
     * @param n  Nome do motorista
     * @param e  Email do motorista
     * @param p  Password do motorista
     * @param m  Morada do motorista 
     * @param dn Data de nascimento do motorista
     * @param d  Disponibilidade do motorista
     * @param g  Grau de cumprimento do motorista
     */
    public Motorista(String n, String e, String p, String m, String dn, boolean d, double g){
        super(n,e,p,m,dn);
        this.historico = new TreeSet<Viagem>();
        this.kmsTotal = 0;
        this.disponibilidade = d;
        this.qtViagens = 0;
        this.classificacaoMedia = 0;
        this.grauCumprimento = g;
    }
    
    /**
     * Construtor que cria um novo motorista a partir de um cliente passado como parâmetro
     * 
     * @param c  Motorista   
     */
    public Motorista(Motorista m){
        super(m);
        this.historico = m.getHistorico();
        this.kmsTotal = m.getKmsTotal();
        this.disponibilidade = m.getDisponibilidade();
        this.qtViagens = m.getQtViagens();
        this.classificacaoMedia = m.getClassificacaoMedia();
        this.grauCumprimento = m.getGrauCumprimento();
    }
    
     /**
     * Métodos de instância 
     */
    
    /**
     * Método que devolve um histórico de viagens de um motorista
     * 
     * @return O histórico
     */
    public Set<Viagem> getHistorico(){
        Set<Viagem> aux = new TreeSet<>();
      
        for(Viagem v: this.historico){
            aux.add(v.clone());
        }
        return aux;
    }
    
    /**
     * Método que define um histórico de viagens a partir de um histórico passado como parâmetro
     * 
     * @param ts    Histórico de viagens de um motorista
     */
    public void setHistorico(Set<Viagem> viagens){
        this.historico.clear();
        for(Viagem v: viagens){
            this.historico.add(v.clone());
        }
    }
    
    /**
     * Método que devolve o total de kilometros percorridos por um motorista
     * 
     * @return  Total de kilometros do motorista
     */
    public double getKmsTotal(){
        return this.kmsTotal;
    }
    
    /**
     * Método que define o total de kilometros percorridos por um motorista a partir de um long passado como parâmetro
     * 
     * @param k   Total de kilometros percorridos pelo motorista
     */
    public void setKmsTotal(double k){
        this.kmsTotal = k;
    }
    
    /**
     * Método que devolve a disponibilidade de um motorista
     * 
     * @return  True se o motorista estiver disponivel, false caso contrário
     */
    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }
    
    /**
     * Método que define a disponibilidade de um motorista a partir de um boolean passado como parâmetro
     * 
     * @param d   Disponibilidade de um motorista
     */
    public void setDisponibilidade(boolean d){
        this.disponibilidade = d;
    }
    
    /**
     * Método que devolve a quantidade de viagens feitas por um motorista
     * 
     * @return  Quantidade de viagens de um motorista
     */
    public int getQtViagens(){
        return this.qtViagens;
    }
    
    /**
     * Método que define a quantidade de viagens feitas por um motorista a partir de um int passado como parâmetro
     * 
     * @param v   Quantidade de viagens de um motorista
     */
    public void setQtViagens(int v){
        this.qtViagens = v;
    }
    
    /**
     * Método que devolve a classificação média de um motorista
     * 
     * @return  Classificação média de um motorista
     */
    public double getClassificacaoMedia(){
        return this.classificacaoMedia;
    }
    
    /**
     * Método que define a classificação média de um motorista a partir de um double passado como parâmetro
     * 
     * @param c   Classificação media de um motorista
     */
    public void setClassificacaoMedia(double c){
        this.classificacaoMedia = c;
    }
    
    /**
     * Método que devolve o grau de cumprimento de um motorista
     * 
     * @return  Grau de cumprimento
     */
    public double getGrauCumprimento(){
        return this.grauCumprimento;
    }
    
    /**
     * Método que define o grau de cumprimento de um motorista a partir de um double passado como parâmetro
     * 
     * @param g   Grau de cumprimento
     */
    public void setGrauCumprimento(double g){
        this.grauCumprimento = g;
    }
    
    /**
     * Devolve uma representação do histórico de viagens e com as informações de um motorista no formato textual 
     * 
     * @return  string com o histórico de viagens e com as informaçẽs do motorista
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("MOTORISTA:\n");
        sb.append(super.toString());
        sb.append("Historico:\n").append(this.historico.toString()+"\n");
        sb.append("KmsTotal:").append(this.kmsTotal+"\n");
        sb.append("Disponibilidade:").append(this.disponibilidade+"\n");
        sb.append("Nr de Viagens Efetuadas:").append(this.qtViagens+"\n");
        sb.append("Classificacao Media:").append(this.classificacaoMedia+"\n");
        sb.append("Grau de Cumprimento:").append(this.grauCumprimento+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de uma identificação de um motorista
     * 
     * @return     O novo motorista
     */
    public Motorista clone(){
        return new Motorista(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado motorista 
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual ao motorista, false caso contrário 
     */
     public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Motorista m = (Motorista) o; //FALTA O RESTO
        return (super.equals(m) && this.historico.equals(m.getHistorico()) && this.kmsTotal == m.getKmsTotal() 
                && this.disponibilidade == m.getDisponibilidade() && this.qtViagens == m.getQtViagens() && this.classificacaoMedia == m.getClassificacaoMedia() && 
                this.grauCumprimento == m.getGrauCumprimento());
    }
    
    /** 
     * Adiciona uma viagem ao histórico de viagens de um motorista
     * 
     * @param v    Viagem de um motorista
     */
    public void addViagem(Viagem v){
        this.historico.add(v.clone());
    }
    
    /**
     * Remove uma viagem do histórico de viagens de um motorista
     * 
     * @param v    Viagem de um motorista 
     */
    public void removeViagem(Viagem v){
        this.historico.remove(v);
    }
    
    /**
     * Adiciona um conjunto de viagens ao histórico
     * 
     * @param viagens      TreeSet de viagens a adicionar ao histórico
     */
    public void addViagens(Set<Viagem> viagens){
        
        for(Viagem v : viagens)
            this.historico.add(v.clone());
    }
    
    /**
     * Incrementa a quantidade de viagens de um motorista
     */
    public void incrementaQtViagens(){
        this.qtViagens += 1;
    }
}
