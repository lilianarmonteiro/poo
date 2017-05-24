import java.io.Serializable;
/**
 * Classe que cria um monovolume que é uma subclasse de Veiculo
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Monovolume extends Veiculo implements Serializable
{
    /**
     * construtores
     */
    
    /**
     * Construtor vazio que cria uma instância monovolume
     */
    public Monovolume(){
        super();
    }
    
    /**
     * Construtor por cópia que cria um monovolume a partir dos parâmetros dados 
     * 
     * @param mat    Matricula 
     * @param l      Número de lugares 
     * @param vm     Velocidade média 
     * @param pm     Preço médio por kilometro
     * @param f      Fiabilidade do veículo
     * @param cord   Coordenadas do veículo  
     * @param dis    Disponibilidade do veículo 
     */
    public Monovolume(String mat, int l, double vm, double pm, double f, Espaco2D cord, boolean dis){
        super(mat, l, vm, pm, f, cord, dis);
    }
    
    /**
     * Construtor que cria um novo monovolume a partir de um monovolume passado como parâmetro
     * 
     * @param m     Monovolume
     */
    public Monovolume(Monovolume m){
        super(m);
    }
    
    /**
     * Métodos de instância
     */
    
    /**
     * Devolve uma representação, no formato textual, de um monovolume
     * 
     * @return String com o monovolume
     */
    public String toString(){
        return "Monovolume:\n"+super.toString();
    }
    
    /**
     * Método que cria uma cópia de um monovolume
     * 
     * @return      O monovolume
     */
    public Monovolume clone(){
        return new Monovolume(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado monovolume
     * 
     * @param o     Objeto a ser testado
     * @return      True se o objeto for igual ao , false caso contrário
     */
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        Monovolume m = (Monovolume) o;
        return super.equals(m);
    }
}
