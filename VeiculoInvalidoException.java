/**
 * Classe VeiculoInvalidoException que devolve uma mensagem caso o veículo seja inválido.
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class VeiculoInvalidoException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o veículo não seja válido
    * 
    * @param msg    A mensagem a ser enviada
    */
    public VeiculoInvalidoException(String msg){
        super(msg);
    }
}
