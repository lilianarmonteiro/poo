import java.io.Serializable;

/**
 * Classe que cria uma mota que é uma subclasse de Veiculo
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Mota extends Veiculo implements Serializable
{
    /**
     * construtores
     */
    
    /**
     * Construtor vazio que cria uma instância mota
     */
    public Mota(){
        super();
    }
    
    /**
     * Construtor por cópia que cria uma mota a partir dos parâmetros dados 
     * 
     * @param mat    Matricula 
     * @param l      Número de lugares 
     * @param vm     Velocidade média 
     * @param pm     Preço médio por kilometro
     * @param f      Fiabilidade do veículo
     * @param cord   Coordenadas do veículo  
     * @param dis    Disponibilidade do veículo 
     */
    public Mota(String mat, int l, double vm, double pm, double f, Espaco2D cord, boolean dis){
        super(mat, l, vm, pm, f, cord, dis);
    }
    
    /**
     * Construtor que cria uma nova mota a partir de uma mota passada como parâmetro
     * 
     * @param m    Mota
     */
    public Mota(Mota m){
        super(m);
    }
    
    /**
     * Métodos de instância
     */
    
    /**
     * Devolve uma representação, no formato textual, de uma mota
     * 
     * @return String com a mota
     */
    public String toString(){
        return "Mota:\n"+super.toString();
    }
    
    /**
     * Método que cria uma cópia de uma mota
     * 
     * @return      A mota
     */
    public Mota clone(){
        return new Mota(this);
    }
    
    /**
     * Método que testa se um objeto é igual a uma determinada mota
     * 
     * @param o     Objeto a ser testado
     * @return      True se o objeto for igual à mota, false caso contrário
     */
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        Mota m = (Mota) o;
        return super.equals(m);
    }
}
