/**
 * Classe VeiculoNaoExisteException que devolve uma mensagem caso o veículo não exista
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class VeiculoNaoExisteException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o veículo não exista
    * 
    * @param msg    A mensagem a ser enviada
    */
    public VeiculoNaoExisteException(String msg){
        super(msg);
    }
}
