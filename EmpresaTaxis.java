import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

/**
 * Escreva a descrição da classe EmpresaTaxis aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class EmpresaTaxis implements Serializable
{
    private String nome;
    
    private Map<String,Motorista> motoristas;
    
    private Map<String,Veiculo> veiculos;
    
    public EmpresaTaxis(){
        this.nome = "ND";
        this.motoristas = new HashMap<>();
        this.veiculos = new HashMap<>();
    }
    
    public EmpresaTaxis(String nome){
        this.nome = nome;
        this.motoristas = new HashMap<>();
        this.veiculos = new HashMap<>();
    }
    
    public EmpresaTaxis(EmpresaTaxis e){
        this.nome = e.getNome();
        this.motoristas = e.getMotoristas();
        this.veiculos = e.getVeiculos();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public Map<String,Motorista> getMotoristas(){
       Map<String,Motorista> aux = new HashMap<>();
        
       for(Map.Entry<String,Motorista> m: this.motoristas.entrySet()){
           aux.put(m.getKey(), m.getValue().clone());
       }
       
       return aux;
    }
   
    public void setMotoristas(Map<String,Motorista> mot){
       this.motoristas.clear();
       
       for(Map.Entry<String,Motorista> m: mot.entrySet()){
           this.motoristas.put(m.getKey(), m.getValue().clone());
       }
    }
    
    public Map<String,Veiculo> getVeiculos(){
       Map<String,Veiculo> aux = new HashMap<>();
        
       for(Map.Entry<String,Veiculo> v: this.veiculos.entrySet()){
           aux.put(v.getKey(), v.getValue().clone());
       }
       
       return aux;
    }
   
    public void setVeiculos(Map<String,Veiculo> vec){
       this.veiculos.clear();
       
       for(Map.Entry<String,Veiculo> v: vec.entrySet()){
           this.veiculos.put(v.getKey(), v.getValue().clone());
       }
    }
    
    public String toString(){
        return "Empresa Taxi: "+this.nome+"\n"+this.motoristas.toString()+"\n"+this.veiculos.toString();
    }
    
    public EmpresaTaxis clone(){
        return new EmpresaTaxis(this);
    }
    
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        
        EmpresaTaxis e = (EmpresaTaxis) o;
        return this.nome.equals(e.getNome()) && this.motoristas.equals(e.getMotoristas()) && this.veiculos.equals(e.getVeiculos());
    }
    
    public void addMotorista(Motorista m){
        this.motoristas.put(m.getEmail(),m.clone());
    }
    
    public void addVeiculo(Veiculo v){
        this.veiculos.put(v.getMatricula(),v.clone());
    }
    
    public void removeMotorista(Motorista m){
        this.motoristas.remove(m.getEmail());
    }
    
    public void removeVeiculo(Veiculo v){
        this.veiculos.remove(v.getMatricula());
    }
    
    public void incrementaQtViagensMotorista(Motorista mot){
        Motorista m = this.motoristas.get(mot.getEmail());
        m.setQtViagens(m.getQtViagens()+1);   
    }
    
    public void mudaClassificaoMediaMotorista(Motorista mot, double classificacao){
        Motorista m = this.motoristas.get(mot.getEmail());
        double cla = m.getClassificacaoMedia() * (m.getQtViagens()-1) + classificacao;
        m.setClassificacaoMedia(cla / (m.getQtViagens()));        
    }
    
    public void mudaKmsTotalMotorista(Motorista mot, double kms){
        Motorista m = this.motoristas.get(mot.getEmail());
        m.setKmsTotal(m.getKmsTotal()+kms);   
    }
    
     public void mudaDisponibilidadeMotorista(Motorista m, boolean dis){
        this.motoristas.get(m.getEmail()).setDisponibilidade(dis);
    }
    
    public void mudaDisponibilidadeVeiculo(Veiculo v, boolean dis){
        this.veiculos.get(v.getMatricula()).setDisponibilidade(dis);
    }

    public void mudaLocalizacaoVeiculo(Veiculo v, Espaco2D destino){
        this.veiculos.get(v.getMatricula()).setLocalizacao(destino);
    }
                   
    public void addViagemMotorista(Motorista m, Viagem v){
        this.motoristas.get(m.getEmail()).addViagem(v);
    }
    
}
