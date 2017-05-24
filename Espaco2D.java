import java.io.Serializable;
/**
 * Classe que define a posição no espaço xOy de um objeto.
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class Espaco2D implements Serializable
{
    /**
     * Variáveis de instância
     */
    
    /**
     * Coordenada x do espaço
     */
    private double x;
    /**
     * Coordenada y do espaço
     */
    private double y;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria o ponto (0,0)
     */
    public Espaco2D(){
        this.x=0.0;
        this.y=0.0;
    }    
    
     /**
     * Construtor que cria um ponto a partir de parâmetros dados
     * 
     * @param nx    coordenada x do ponto
     * @param ny    coordenada y do ponto
     */
    public Espaco2D (double nx , double ny){
        this.x = nx;
        this.y = ny;
    }
    
     /**
     * Construtor que cria um novo ponto a partir de um ponto passado como parâmetro
     * 
     * @param esp   ponto do espaço xOy
     */
    public Espaco2D (Espaco2D esp){
        this.x = esp.getX();
        this.y = esp.getY();
    }
    
    
    /**
     * Métodos de instância
     */
    
    /**
     * Método que devolve a coordenada x de um ponto
     * 
     * @return  coordenada x do ponto
     */
    public double getX(){
        return this.x;
    }
    
    /**
     * Método que define a coordenada x de um ponto a partir de um double recebido como parâmetro
     * 
     * @param xx    coordenada x a ser aplicada
     */
    public void setX(double xx){
        this.x=xx;
    }
    
    /**
     * Método que devolve a coordenada y de um ponto
     * 
     * @return  coordenada y do ponto
     */
    public double getY(){
        return this.y;
    }
    
    /**
     * Método que define a coordenada y de um ponto a partir de um double recebido como parâmetro
     * 
     * @param yy    coordenada y a ser aplicada
     */
    public void setY(double yy){
        this.y=yy;
    }
    
    /**
     * Método que converte um ponto numa string
     * 
     * @return  string com as coordenadas do objeto
     */
    public String toString(){
        return ("("+this.x+", "+this.y+")");
    }
    
    /**
     * Método que cria uma cópia de um ponto
     * 
     * @return  cópia do ponto
     */
    public Espaco2D clone(){
        return new Espaco2D(this);
    }
    
    /**
     * Método que testa se um objeto é igual a um determinado ponto
     * 
     * @param o     objeto a ser testado
     * @return      true se as coordenadas forem iguais, false se o objeto passado não for igual ao ponto
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Espaco2D p = (Espaco2D) o;
        return (this.x==p.getX() && this.y==p.getY());
    }
    
    /**
     * Método que determina a distância euclidiana entre dois pontos
     * 
     * @param p2    ponto para determinar a distância
     * @return      distância entre os pontos
     */
    public double distancia(Espaco2D p2){
        double param1 = (p2.getX()-this.x) * (p2.getX()-this.x);
        double param2 = (p2.getY()-this.y) * (p2.getY()-this.y);
        return (Math.sqrt(param1 + param2));
    }
}