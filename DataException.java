 /**
 * Classe DataException que devolve uma mensagem caso o formato da data esteja incorreto
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class DataException extends Exception
{
    /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o formato da data esteja incorreto
    * 
    * @param msg    A mensagem a ser enviada
    */
    public DataException(String msg){
        super(msg);
    }
}
