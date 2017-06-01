import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.lang.Comparable;
import java.io.Serializable;
/**
 * Classe que cria uma viagem implementando um comparador
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Viagem implements Comparable<Viagem>, Serializable
{
    /**
     * Variáveis de instância
     */
    
    /**
     * Data e tempo loca
     */
    private LocalDateTime data;
    
    /**
     * Coordenadas do local de partida de uma viagem
     */
    private Espaco2D partida;
    
    /**
     * Coordenadas do destino de uma viagem
     */
    private Espaco2D destino;
    
    /**
     * Veiculo utilizado na viagem
     */
    private Veiculo veiculo;
    
    /**
     * Kilometros percorridos na viagem
     */
    private double kms;
    
    /**
     * Tempo que a viagem demorou
     */
    private double tempo;
    
    /**
     * Preço real da viagem
     */
    private double precoRealViagem;
    
    /**
     * Preço estimado da viagem
     */
    private double precoEstViagem;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância viagem 
     */
    public Viagem(){
        this.data = LocalDateTime.of(1,1,1,0,0);
        this.partida = new Espaco2D();
        this.destino = new Espaco2D();
        this.veiculo = new Carro();
        this.kms = 0.0;
        this.tempo = 0.0;
        this.precoRealViagem = 0.0;
        this.precoEstViagem = 0.0;
    }
    
    /**
     * Construtor por cópia que cria uma viagem a partir dos parâmetros dados 
     * 
     * @param dt    Data 
     * @param t    Tempo
     * @param p    Localização de partida do cliente 
     * @param d    Localização do destino
     * @param v   Veiculo
     * @param k    Kilometros percorridos na viagem
     * @param time Tempo da viagem
     * @param pr   Preço real da viagem
     * @param pr   Preço estimado da viagem
     */
    public Viagem(LocalDate dt, LocalTime t, Espaco2D p, Espaco2D d, Veiculo v, double k, double time, double pr, double pe){
        this.data = LocalDateTime.of(dt,t);
        this.partida = new Espaco2D(p);
        this.destino = new Espaco2D(d);
        this.veiculo = v.clone();
        this.kms = k;
        this.tempo = time;
        this.precoRealViagem = pr;
        this.precoEstViagem = pe;
    }
    
    /**
     * Construtor que cria uma nova viagem a partir de um cliente passado como parâmetro
     * 
     * @param v  Viagem    
     */
    public Viagem(Viagem v){
        this.data = v.getData();
        this.partida = v.getPartida();
        this.destino = v.getDestino();
        this.veiculo = v.getVeiculo();
        this.kms = v.getKms();
        this.tempo = v.getTempo();
        this.precoRealViagem = v.getPrecoRealViagem();
        this.precoEstViagem = v.getPrecoEstViagem();
    }
    
    /**
     * Métodos de Instância
     */
    
    /**
     * Método que devolve a data e o tempo de uma viagem
     * 
     * @return O a data da viagem
     */
    public LocalDateTime getData(){
        return this.data;
    }
    
    /**
     * Método que define a data de uma viagem através de um LocalDateTime passado como parâmetro
     * 
     * @param d    Data da viagem
     */
    public void setData(LocalDateTime d){
        this.data = d;
    }
    
    /**
     * Método que devolve a localização de partida da viagem
     * 
     * @return A localização de partida de uma viagem
     */
    public Espaco2D getPartida(){
        return this.partida.clone();
    }
    
    /**
     * Método que define a localização de partida de uma viagem através de um Espaco2D passado como parâmetro
     * 
     * @param p    Localização de partida
     */
    public void setPartida(Espaco2D p){
        this.partida = p.clone();
    }
    
    /**
     * Método que devolve a localização do destino da viagem
     * 
     * @return O destino da viagem
     */
    public Espaco2D getDestino(){
        return this.destino.clone();
    }
    
    /**
     * Método que define a localização do destino da viagem através de um Espaco2D passado como parâmetro
     * 
     * @param d    Destino da viagem
     */
    public void setDestino(Espaco2D d){
        this.destino = d.clone();
    }
    
    /**
     * Método que devolve o veiculo utilizado na viagem
     * 
     * @return O veiculo 
     */
    public Veiculo getVeiculo(){
        return this.veiculo.clone();
    }
    
    /**
     * Método que define o veículo utilizado numa viagem através de um Veiculo passada como parâmetro
     * 
     * @param v    O veículo
     */
    public void setVeiculo(Veiculo v){
        this.veiculo = v.clone();
    }
    
    /**
     * Método que devolve os kilometros percorridos
     * 
     * @return Os kilometros percorridos
     */
    public double getKms(){
        return this.kms;
    }
    
    /**
     * Método que define o número de kilometros percorridos através de um double passado como parâmetro
     * 
     * @param k    Kilometros percorridos
     */
    public void setKms(double k){
        this.kms = k;
    }
    
    /**
     * Método que devolve o tempo da viagem
     * 
     * @return O tempo da viagem
     */
    public double getTempo(){
        return this.tempo;
    }
    
    /**
     * Método que define o tempo de uma viagem através de um double passado como parâmetro
     * 
     * @param t    O tempo de uma viagem
     */
    public void setTempo(double t){
        this.tempo = t;
    }
    
    /**
     * Método que devolve o preço real da viagem
     * 
     * @return O preço real da viagem
     */
    public double getPrecoRealViagem(){
        return this.precoRealViagem;
    }
    
    /**
     * Método que define o preço real de uma viagem através de um double passado como parâmetro
     * 
     * @param p    O preço real da viagem
     */
    public void setPrecoRealViagem(double p){
        this.precoRealViagem = p;
    }
    
    /**
     * Método que devolve o preço estimado da viagem
     * 
     * @return O preço estimado da viagem
     */
    public double getPrecoEstViagem(){
        return this.precoEstViagem;
    }
    
    /**
     * Método que define o preço estimado de uma viagem através de um double passado como parâmetro
     * 
     * @param p    O preço estimado da viagem
     */
    public void setPrecoEstViagem(double p){
        this.precoEstViagem = p;
    }
    
    /**
     * Devolve uma representação da viagem no formato textual 
     * 
     * @return  string com a viagem e todas as suas componentes
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Data e Hora: ").append(this.data.toString()+"\n");
        sb.append("Partida: ").append(this.partida.toString()+"\n");
        sb.append("Destino: ").append(this.destino.toString()+"\n");
        sb.append("Veiculo:\n").append(this.veiculo.toString());
        sb.append("Kms da viagem: ").append(this.kms+"\n");
        sb.append("Tempo da viagem: ").append(this.tempo+"\n");
        sb.append("Preco real da Viagem: ").append(this.precoRealViagem+"\n");
        sb.append("Preco estimado da Viagem: ").append(this.precoEstViagem+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de uma viagem 
     * 
     * @return     A viagem 
     */
    public Viagem clone(){
        return new Viagem(this);
    }
    
    
    /**
     * Método que testa se um objeto é igual a uma determinada viagem
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual à viagem, false caso contrário
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Viagem v = (Viagem) o;
        return (this.data.equals(v.getData()) && this.partida.equals(v.getPartida()) && this.destino.equals(v.getDestino()) && this.veiculo.equals(v.getVeiculo()) && this.kms==v.getKms() 
                && this.tempo == v.getTempo() && this.precoRealViagem==v.getPrecoRealViagem() && this.precoEstViagem==v.getPrecoEstViagem());
    }
    
    /**
     * Comparador de datas 
     * 
     * @param v A viagem
     * @return  0 se as datas forem iguais, 1 se a data da viagem estiver antes e -1 se estiver depois
     */
    public int compareTo(Viagem v){
        if(this.data.isAfter(v.getData())) return 1;
        
        if(this.data.isBefore(v.getData())) return -1;
        
        return 0;
    }
}