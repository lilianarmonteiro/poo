import java.io.Serializable;
/**
 * Classe que cria um carro que é uma subclasse de Veiculo
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Carro extends Veiculo implements Serializable
{
    /**
     * construtores
     */
    
    /**
     * Construtor vazio que cria uma instância carro
     */
    public Carro(){
        super();
    }
    
    /**
     * Construtor por cópia que cria um carro a partir dos parâmetros dados 
     * 
     * @param mat    Matricula 
     * @param l      Número de lugares 
     * @param vm     Velocidade média 
     * @param pm     Preço médio por kilometro
     * @param f      Fiabilidade do veículo
     * @param cord   Coordenadas do veículo  
     * @param dis    Disponibilidade do veículo 
     */
    public Carro(String mat, int l, double vm, double pm, double f, Espaco2D cord, boolean dis){
        super(mat, l, vm, pm, f, cord, dis);
    }
    
    /**
     * Construtor que cria um novo carro a partir de um carro passado como parâmetro
     * 
     * @param c     Carro
     */
    public Carro(Carro c){
        super(c);
    }
    
    /**
     * Métodos de instância
     */
    
    /**
     * Devolve uma representação, no formato textual, de um carro
     * 
     * @return String com o carro
     */
    public String toString(){
        return "Carro:\n"+super.toString();
    }
    
    /**
     * Método que cria uma cópia de um carro
     * 
     * @return      O carro
     */
    public Carro clone(){
        return new Carro(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado carro
     * 
     * @param o     Objeto a ser testado
     * @return      True se o objeto for igual ao carro, false caso contrário
     */
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        Carro c= (Carro) o;
        return super.equals(c);
    }
}
