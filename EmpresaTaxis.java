import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

/**
 * Classe que cria uma Empresa de Taxis.
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class EmpresaTaxis implements Serializable
{
    /**
     * Variáveis de instância
     */
    
    /**
     * Nome da empresa
     */
    private String nome;
    
    /**
     * Os motoristas que a empresa tem
     */
    private Map<String,Motorista> motoristas;
    
    /**
     * Os veículos que a empresa possui
     */
    private Map<String,Veiculo> veiculos;
    
    /**
     * Construtores
     */
    
    /**
     * Construtor vazio que cria uma instância empresa de taxis
     */
    public EmpresaTaxis(){
        this.nome = "ND";
        this.motoristas = new HashMap<>();
        this.veiculos = new HashMap<>();
    }
    
    /**
     * Construtor por cópia que cria uma nova empresa de taxis a partir do parâmetro dado
     * 
     * @param nome  Nome da empresa
     */
    public EmpresaTaxis(String nome){
        this.nome = nome;
        this.motoristas = new HashMap<>();
        this.veiculos = new HashMap<>();
    }
    
    /**
     * Construtor que cria uma nova empresa de taxis a partir de uma empresa passada como parâmetro
     * 
     * @param e  A empresa de taxis    
     */
    public EmpresaTaxis(EmpresaTaxis e){
        this.nome = e.getNome();
        this.motoristas = e.getMotoristas();
        this.veiculos = e.getVeiculos();
    }
    
    /**
     * Métodos de instância 
     */
    
    /**
     * Método que devolve o nome da empresa de taxis
     * 
     * @return O nome da empresa
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Método que define um nome para a empresa de táxis a partir de uma String passada como parâmetro
     * 
     * @param n    Nome da empres
     */
    public void setNome(String n){
        this.nome = n;
    }
    
    /**
     * Método que devolve os motoristas contratados que a empresa de taxis possui
     * 
     * @return Os motoristas contratados 
     */
    public Map<String,Motorista> getMotoristas(){
       Map<String,Motorista> aux = new HashMap<>();
        
       for(Map.Entry<String,Motorista> m: this.motoristas.entrySet()){
           aux.put(m.getKey(), m.getValue().clone());
       }
       
       return aux;
    }
   
    /**
     * Método que define um hashMap de motoristas a partir de um hashMap passado como parâmetro
     * 
     * @param mot    Os motoristas da empresa
     */
    public void setMotoristas(Map<String,Motorista> mot){
       this.motoristas.clear();
       
       for(Map.Entry<String,Motorista> m: mot.entrySet()){
           this.motoristas.put(m.getKey(), m.getValue().clone());
       }
     }
    
    /**
     * Método que devolve os veículos da empresa de taxis
     * 
     * @return Os veículos da empresa
     */
    public Map<String,Veiculo> getVeiculos(){
       Map<String,Veiculo> aux = new HashMap<>();
        
       for(Map.Entry<String,Veiculo> v: this.veiculos.entrySet()){
           aux.put(v.getKey(), v.getValue().clone());
       }
       
       return aux;
    }
   
    /**
     * Método que define um hashMap de veículos a partir de um hashMap passado como parâmetro
     * 
     * @param vec    Veículos da empresa
     */
    public void setVeiculos(Map<String,Veiculo> vec){
       this.veiculos.clear();
       
       for(Map.Entry<String,Veiculo> v: vec.entrySet()){
           this.veiculos.put(v.getKey(), v.getValue().clone());
       }
    }
    
    /**
     * Devolve uma representação, no formato textual, de uma empresa de táxis 
     * 
     * @return  string com a empresa de táxis 
     */
    public String toString(){
        return "Empresa Taxi: "+this.nome+"\n"+this.motoristas.toString()+"\n"+this.veiculos.toString();
    }
    
    /**
     * Método que cria uma cópia de uma empresa de táxis
     * 
     * @return      A nova empresa de táxis
     */
    public EmpresaTaxis clone(){
        return new EmpresaTaxis(this);
    }
    
    /**
     * Método que testa se um objeto é igual a uma determinada empresa de táxis
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual à empresa, false caso contrário
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        EmpresaTaxis e = (EmpresaTaxis) o;
        return this.nome.equals(e.getNome()) && this.motoristas.equals(e.getMotoristas()) && this.veiculos.equals(e.getVeiculos());
    }
    
    /** 
     * Adiciona um motorista à empresa de táxis
     * 
     * @param m    Motorista a ser adicionado
     */
    public void addMotorista(Motorista m){
        this.motoristas.put(m.getEmail(),m.clone());
    }
    
    /** 
     * Adiciona um veículo à empresa de taxis
     * 
     * @param v    Veículo
     */
    public void addVeiculo(Veiculo v){
        this.veiculos.put(v.getMatricula(),v.clone());
    }
    
    /** 
     * Remove um motorista da empresa de táxis
     * 
     * @param m    Motorista a ser adicionado
     */
    public void removeMotorista(Motorista m){
        this.motoristas.remove(m.getEmail());
    }
   
    /** 
     * Remove um veículo da empresa de taxis
     * 
     * @param v    Veículo
     */
    public void removeVeiculo(Veiculo v){
        this.veiculos.remove(v.getMatricula());
    }
    
    /**
     * Incrementa uma unidade sempre que um motorista efetua uma viagem
     * 
     * @param mot   O motorista
     */
    public void incrementaQtViagensMotorista(Motorista mot){
        Motorista m = this.motoristas.get(mot.getEmail());
        m.setQtViagens(m.getQtViagens()+1);   
    }
    
    /**
     * Altera a classificação de motorista a partir de uma nova classificação atribuida
     * 
     * @param mot            O motorista
     * @param classificacao  A classificação atribuída ao motorista
     */
    public void mudaClassificaoMediaMotorista(Motorista mot, double classificacao){
        Motorista m = this.motoristas.get(mot.getEmail());
        double cla = m.getClassificacaoMedia() * (m.getQtViagens()-1) + classificacao;
        m.setClassificacaoMedia(cla / (m.getQtViagens()));        
    }
    
    /**
     * Atualiza o total de kilometros percorridos por um motorista
     * 
     * @param mot   Motorista
     * @param kms   Número de kilometros a adicionar
     */
    public void mudaKmsTotalMotorista(Motorista mot, double kms){
        Motorista m = this.motoristas.get(mot.getEmail());
        m.setKmsTotal(m.getKmsTotal()+kms);   
    }
    
    /**
     * Altera a disponibilidade do motorista 
     * 
     * @param m     O motorista
     * @param dis   A disponibilidade do motorista
     */
     public void mudaDisponibilidadeMotorista(Motorista m, boolean dis){
        this.motoristas.get(m.getEmail()).setDisponibilidade(dis);
    }
    
    /**
     * Altera a disponibilidade do veículo 
     * 
     * @param v     O veículo
     * @param dis   A disponibilidade do veículo
     */
    public void mudaDisponibilidadeVeiculo(Veiculo v, boolean dis){
        this.veiculos.get(v.getMatricula()).setDisponibilidade(dis);
    }
    
    /**
     * Altera a localização do veículo 
     * 
     * @param v         O veículo
     * @param destino   O destino da viagem que passa a ser a nova localização do veículo
     */
    public void mudaLocalizacaoVeiculo(Veiculo v, Espaco2D destino){
        this.veiculos.get(v.getMatricula()).setLocalizacao(destino);
    }
    
    /**
     * Adiciona uma viagem efetuada ao motorista
     * 
     * @param m     O motorista
     * @param v     A viagem a ser adicionada
     */
    public void addViagemMotorista(Motorista m, Viagem v){
        this.motoristas.get(m.getEmail()).addViagem(v);
    }
    
}
