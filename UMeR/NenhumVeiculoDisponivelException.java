/**
 * Classe NenhumVeiculoDisponivelException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class NenhumVeiculoDisponivelException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso nenhum veiculo esteja disponivel de momento
    * 
    * @param msg    A mensagem a ser enviada
    */
   public NenhumVeiculoDisponivelException(String msg){
       super(msg);
   }
}

