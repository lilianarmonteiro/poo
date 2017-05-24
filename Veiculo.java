import java.io.Serializable;

/**
 * Classe que cria um veiculo
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public abstract class Veiculo implements Serializable
{
    /**
     * variáveis de instância
     */
    
    /**
     * Matricula do veiculo
     */
    private String matricula;
    
    /**
     * Número de lugares
     */
    private int nrLugares;
    
    /**
     * Velocidade média por kilometros percorridos
     */
    private double velocidadeMediaKm;
    
    /**
     * Preço médio por kilometro
     */
    private double precoMedioKm;
    
    /**
     * Fiabilidade do veículo
     */
    private double fiabilidade;
    
    /**
     * Localização do veículo
     */
    private Espaco2D localizacao;
    
    /**
     * Disponibilidade do veículo
     */
    private boolean disponibilidade;
    
    /**
     * construtores
     */
    
    /**
     * Construtor vazio que cria uma instância veículo 
     */
    public Veiculo(){
        this.matricula="ND";
        this.nrLugares=0;
        this.velocidadeMediaKm=0.0;
        this.precoMedioKm=0.0;
        this.fiabilidade=0;
        this.localizacao=new Espaco2D();
        this.disponibilidade=false;
    }
    
     /**
     * Construtor por cópia que cria um veículo a partir dos parâmetros dados 
     * 
     * @param mat    Matricula 
     * @param l      Número de lugares 
     * @param vm     Velocidade média 
     * @param pm     Preço médio por kilometro
     * @param f      Fiabilidade do veículo
     * @param cord   Coordenadas do veículo  
     * @param dis    Disponibilidade do veículo
     */
    public Veiculo(String mat, int l, double vm, double pm, double f, Espaco2D cord, boolean dis){
        this.matricula=mat;
        this.nrLugares=l;
        this.velocidadeMediaKm=vm;
        this.precoMedioKm=pm;
        this.fiabilidade=f;
        this.localizacao=new Espaco2D(cord);
        this.disponibilidade=dis;
    }
    
    /**
     * Construtor que cria um novo veículo através de um veículo passado como parâmetro
     * 
     * @param v     O veículo
     */
    public Veiculo(Veiculo v){
        this.matricula=v.getMatricula();
        this.nrLugares=v.getNrLugares();
        this.velocidadeMediaKm=v.getVelocidade();
        this.precoMedioKm=v.getPreco();
        this.fiabilidade = v.getFiabilidade();
        this.localizacao=v.getLocalizacao();
        this.disponibilidade=v.getDisponibilidade();
    }
    
    /**
     * métodos de instância
     */
    
    /**
     * Método que devolve a matricula do veículo
     * 
     * @return A matricula do veículo
     */
    public String getMatricula(){
        return this.matricula;
    }
    
    /**
     * Método que define a matricula de um veículo através de uma String passada como parâmetro
     * 
     * @param mat    A matricula do veículo
     */
    public void setMatricula(String mat){
        this.matricula=mat;
    }
    
    /**
     * Método que devolve o número de lugares que o veículo possui
     * 
     * @return O número de lugares 
     */
    public int getNrLugares(){
        return this.nrLugares;
    }
    
    /**
     * Método que define o número de lugares de um veículo através de um int passado como parâmetro
     * 
     * @param l    Número de lugares 
     */
    public void setNrLugares(int l){
        this.nrLugares = l;
    }
    
    /**
     * Método que devolve a velocidade média por kilometros de um veículo 
     * 
     * @return A velocidade média de um veículo
     */
    public double getVelocidade(){
        return this.velocidadeMediaKm;
    }
    
    /**
     * Método que define a velocidade média de um veículo através de um double passado como parâmetro
     * 
     * @param v    A velocidade média de um veículo
     */
    public void setVelocidade(double v){
        this.velocidadeMediaKm=v;
    }
    
    /**
     * Método que devolve o preço médio por kilometro
     * 
     * @return O preço médio
     */
    public double getPreco(){
        return this.precoMedioKm;
    }
    
    /**
     * Método que define o preço médio por kilometro efetuado por um determinado veículo através de um double passado como parâmetro
     * 
     * @param p    O preço médio por kilometro
     */
    public void setPreco(double p){
        this.precoMedioKm=p;
    }
    
    /**
     * Método que devolve a fiabilidade de um veículo
     * 
     * @return A fiabilidade de um veículo
     */
    public double getFiabilidade(){
        return this.fiabilidade;
    }
    
    /**
     * Método que define a fiabilidade de um veículo através de um double passado como parâmetro
     * 
     * @param f    A fiabilidade do veículo
     */
    public void setFiabilidade(double f){
        this.fiabilidade = f;
    }
    
    /**
     * Método que devolve a localização do veículo
     * 
     * @return A localização de um veículo
     */
    public Espaco2D getLocalizacao(){
        return this.localizacao.clone();
    }
    
    /**
     * Método que define a localização de um veículo através de um Espaco2D passado como parâmetro
     * 
     * @param cord    A localização do veículo
     */
    public void setLocalizacao(Espaco2D cord){
        this.localizacao=cord.clone();
    }
    
    /**
     * Método que devolve a disponibilidade do veiculo
     * 
     * @return A disponibilidade
     */
    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }
    
    /**
     * Método que define a disponibilidade de um veículo através de um boolean passado como parâmetro
     * 
     * @param dis    Nova disponibilidade
     */
    public void setDisponibilidade(boolean dis){
        this.disponibilidade = dis;
    }
    
    /**
     * Devolve uma representação, no formato textual, de um veículo, apresentando todas as suas caracteristicas 
     * 
     * @return  string com o veículo e todas as suas componentes
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Matricula: ").append(this.matricula+"\t");
        sb.append("Numero de Lugares: ").append(this.nrLugares+"\t");
        sb.append("Velocidade Media /km: ").append(this.velocidadeMediaKm+"\t");
        sb.append("Preco Medio /km: ").append(this.precoMedioKm+"\t");
        sb.append("Fiabilidade: ").append(this.fiabilidade+"\t");
        sb.append("Localizacao: ").append(this.localizacao.toString()+"\t");
        sb.append("Disponibilidade: ").append(this.disponibilidade+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de um veículo
     * 
     * @return     O veículo
     */
    public abstract Veiculo clone();
    
    /**
     * Método que testa se um objeto é igual a um determinado veículo
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual ao veículo, false caso contrário
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Veiculo v = (Veiculo) o;
        return (this.matricula.equals(v.getMatricula()) && this.nrLugares==v.getNrLugares() && this.velocidadeMediaKm==v.getVelocidade() && this.precoMedioKm==v.getPreco() 
                && this.fiabilidade == v.getFiabilidade() && this.localizacao.equals(v.getLocalizacao()) && this.disponibilidade == v.getDisponibilidade());
    }
}
