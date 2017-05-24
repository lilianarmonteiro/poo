import java.util.Comparator;
/**
 * Classe OrdenaClientes que impõem uma ordem quando se quer adicionar um cliente a uma coleção
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class OrdenaClientes implements Comparator<Cliente>
{
    /**
    * Métodos de instância
    */
   
    /**
    * Método que define a ordem pela qual os clientes serão organizados, consoante o gasto total de um cliente
    * 
    * @param c1     Um cliente    
    * @param c2     Um cliente
    * @return       Devolve - 1 caso o gasto de c1 seja maior ou igual que o de c2, 1 caso contrário
    */
    public int compare(Cliente c1, Cliente c2){
        int soma1 = somaViagens(c1);
        int soma2 = somaViagens(c2);
        
        if(soma1 >= soma2) return -1;
        return 1;
    }
    
    /**
    * Método que calcula o total gasto por um cliente
    * 
    * @param c      O cliente    
    * @return       O total gasto pelo cliente
    */
    public int somaViagens(Cliente c){
        int total = 0;
        for(ViagemCliente v : c.getHistorico()){
            total+=v.getPrecoRealViagem();
        }
        return total;
    }
}
