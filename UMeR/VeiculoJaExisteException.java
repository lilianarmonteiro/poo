/**
 * Classe VeiculoJaExisteException que devolve uma mensagem caso o veículo já exista
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class VeiculoJaExisteException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o veículo já exista
    * 
    * @param msg    A mensagem a ser enviada
    */
    public VeiculoJaExisteException(String msg){
        super(msg);
    }
}
