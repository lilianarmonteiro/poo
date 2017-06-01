/**
 * Classe EmpresaJaExisteException que devolve uma mensagem caso a empresa já exista.
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class EmpresaJaExisteException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso a empresa já exista.
    * 
    * @param msg    A mensagem a ser enviada
    */
    public EmpresaJaExisteException(String msg){
        super(msg);
    }
}