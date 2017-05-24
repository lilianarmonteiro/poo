
/**
 * Classe MotoristaIndisponivelException que devolve uma mensagem caso o motorista esteja indisponível
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class MotoristaIndisponivelException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o motorista não esteja disponível
    * 
    * @param msg    A mensagem a ser enviada
    */
    public MotoristaIndisponivelException(String msg){
        super(msg);
    }
}
