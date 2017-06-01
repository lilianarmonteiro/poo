 /**
 * Classe VeiculoEmpresaIndisponivelException que devolve uma mensagem caso o veiculo da empresa esteja indesponivel
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class VeiculoEmpresaIndisponivelException extends Exception
{
   /**
    * Método de instância
    */
   
   /**
    * Método que define a mensagem caso o veiculo da empresa esteja indesponivel
    * 
    * @param msg    A mensagem a ser enviada
    */
   public VeiculoEmpresaIndisponivelException(String msg){
       super(msg);
   }
}
