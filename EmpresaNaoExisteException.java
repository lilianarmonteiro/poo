/**
 * Classe EmpresaNaoExisteException que devolve uma mensagem caso a empresa não exista.
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class EmpresaNaoExisteException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso a empresa não exista
    * 
    * @param msg    A mensagem a ser enviada
    */
   public EmpresaNaoExisteException(String msg){
       super(msg);
   }
}
