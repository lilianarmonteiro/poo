/**
 * Classe LoginException que devolve uma mensagem caso o login esteja errado.
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class LoginException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o login esteja errado
    * 
    * @param msg    A mensagem a ser enviada
    */
   public LoginException(String msg){
       super(msg);
   }
}
