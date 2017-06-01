import java.io.Serializable;
/**
 * Classe que cria um motorista independente, isto é, um motorista que possui um
 * veículo, que é uma subclasse de Motorista
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class MotoristaIndependente extends Motorista implements Serializable
{
    /**
     * Variáveis de Instância
     */
    
    /**
     * Veículo do motorista
     */
    private Veiculo veiculo;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância motorista independente
     */
    public MotoristaIndependente(){
        super();
        this.veiculo = new Carro();
    }
    
    /**
     * Construtor por cópia que cria um novo motorista independente a partir dos parâmetros dados 
     * 
     * @param n  Nome do motorista
     * @param e  Email do motorista
     * @param p  Password do motorista
     * @param m  Morada do motorista 
     * @param dn Data de nascimento do motorista
     * @param d  Disponibilidade do motorista
     * @param g  Grau de cumprimento do motorista
     * @param v  Veículo do motorista
     */
    public MotoristaIndependente(String n, String e, String p, String m, String dn, boolean d, double g, Veiculo v){
        super(n,e,p,m,dn,d,g);
        this.veiculo = v.clone();
    }
    
     /**
     * Construtor que cria um novo motorista independente a partir de um motorista independente passado como parâmetro
     * 
     * @param mp  Motorista independente   
     */
    public MotoristaIndependente(MotoristaIndependente mp){
        super(mp);
        this.veiculo = mp.getVeiculo();
    }
    
    /**
     * Métodos de Instância
     */
    
    /**
     * Método que devolve o veículo dum motorista
     * 
     * @return  Veículo do motorista
     */
    public Veiculo getVeiculo(){
        return this.veiculo.clone();
    }
    
    /**
     * Método que define o veículo dum motorista a partir de um Veiculo passado como parâmetro
     * 
     * @param v   Veículo do motorista
     */
    public void setVeiculo(Veiculo v){
        this.veiculo = v.clone();
    }
    
    /**
     * Devolve uma representação no formato textual de que veículo o motorista tem
     * 
     * @return  string com o veículo do motorista
     */
    public String toString(){
        return super.toString()+"Veiculo:\n"+this.veiculo.toString()+"\n";
    }
    
    /**
     * Método que cria uma cópia de uma identificação de um motorista independente
     * 
     * @return     O novo motorista independente
     */
    public MotoristaIndependente clone(){
        return new MotoristaIndependente(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado motorista independente 
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual ao motorista, false caso contrário 
     */
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        MotoristaIndependente mp = (MotoristaIndependente) o;
        return super.equals(mp) && this.veiculo.equals(mp.getVeiculo());
    }
    
    /**
     * Método que altera a localização do veiculo do motorista independente
     * 
     * @param coord     As coordenadas da nova localização
     */
    public void alteraLocalizacaoVeiculo(Espaco2D coord){
        this.veiculo.setLocalizacao(coord);
    }
    
    /**
     * Método que altera a disponibilidade do veiculo do motorista independente
     * 
     * @param b     A nova disponibilidade
     */
    public void alteraDisponibilidadeVeiculo(boolean b){
        this.veiculo.setDisponibilidade(b);
    }
}
