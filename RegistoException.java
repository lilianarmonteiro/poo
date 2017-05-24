
/**
 * Classe RegistoException que devolve uma mensagem caso o registo esteja incorreto
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class RegistoException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o registo seja inválido
    * 
    * @param msg    A mensagem a ser enviada
    */
   public RegistoException(String msg){
       super(msg);
   }
}
