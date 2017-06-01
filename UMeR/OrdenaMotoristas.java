import java.util.Comparator;
/**
 * Classe OrdenaMotoristas que impõem uma ordem quando se quer adicionar um motorista a uma coleção
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class OrdenaMotoristas implements Comparator<Motorista>
{
    /**
    * Métodos de instância
    */
   
    /**
    * Método que define a ordem pela qual os motoristas serão organizados, consoante o desvio total no custo real e estimado da viagens
    * 
    * @param m1     Um motorista 
    * @param m2     Um motorista
    * @return       Devolve - 1 caso o desvio de c1 seja maior ou igual que o de c2, 1 caso contrário
    */
    public int compare(Motorista m1, Motorista m2){
        double desvio1 = desvio(m1); 
        double desvio2 = desvio(m2);
        
        if(desvio1 >= desvio2) return -1;
        return 1;
    }

    /**
    * Método que calcula o devio entre o total faturado e o estimado de um motorista
    * 
    * @param m      O motorista   
    * @return       O desvio associado a um motorista
    */
    public double desvio(Motorista m){
        double qtV = m.getQtViagens();
        double total = 0;
        
        if(qtV != 0) {
            for(Viagem v : m.getHistorico()){
                total+= Math.abs(v.getPrecoEstViagem() - v.getPrecoRealViagem());
            }
            return total/qtV;
        }
        else return 0;
    }
}