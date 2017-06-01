import java.io.Serializable;
/**
 * Classe que cria a identificação de um utilizador do programa
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public abstract class Utilizador implements Serializable
{
    /**
     * Variáveis de instância
     */
    
    /**
     * Nome do utilizador
     */
    private String nome;
    /**
     * Email do utilizador
     */
    private String email;
    /**
     * Password do utilizador
     */
    private String password;
    /**
     * Morada do utilizador
     */
    private String morada;
    /**
     * Data de nascimento do utilizador
     */
    private String nascimento;
    
    /**
     * Contrutores
     */
    
    /**
     * Construtor vazio que cria um utilizador sem dados
     */
    public Utilizador(){
        this.nome="ND";
        this.email="ND";
        this.password="ND";
        this.morada="ND";
        this.nascimento="ND";
    }
    
    /**
     * Construtor que cria um novo utilizador a partir dos parâmetros dados
     * 
     * @param n  Nome do utilizador
     * @param e  Email do utilizador
     * @param p  Password do utilizador
     * @param m  Morada do utilizador
     * @param dn Data de nascimento do utilizador
     */
    
    public Utilizador(String n, String e, String p, String m, String dn){
        this.nome=n;
        this.email=e;
        this.password=p;
        this.morada=m;
        this.nascimento=dn;
    }
    
    /**
     * Construtor que cria um novo utilizador a partir de uma identificação passada como parâmetro
     * 
     * @param id    Identificador do utilizador
     */
    public Utilizador(Utilizador id){
        this.nome=id.getNome();
        this.email=id.getEmail();
        this.password=id.getPassword();
        this.morada=id.getMorada();
        this.nascimento=id.getNascimento();
    }
    
    
    /**
     * Métodos de instância
     */
    
    /**
     * Método que devolve o nome de um utilizador
     * 
     * @return  Nome do utilizador
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Método que define o nome de um utilizador a partir de uma String passada como parâmetro
     * 
     * @param var   nome do utilizador a ser aplicado
     */
    
    public void setNome(String var){
        this.nome=var;
    }
    
    /**
     *Método que devolve o email de um utilizador
     *
     *@return   Email do utilizador
     */
    
    public String getEmail(){
        return this.email;
    }
    
    /**
     * Método que define o email de um utilizador a partir de uma String passada como parâmetro
     * 
     * @param var   Email do utilizador a ser aplicado
     */
    public void setEmail(String var){
        this.email=var;
    }
    
    /**
     * Método que devolve a password de um utilizador
     * 
     * @return  Password do utilizador
     */
    public String getPassword(){
        return this.password;
    }
    
     /**
     * Método que define a password de um utilizador a partir de uma String passada como parâmetro
     * 
     * @param var   Password do utilizador a ser aplicado
     */
    public void setPassword(String var){
        this.password=var;
    }
    
    /**
     * Método que devolve a morada de um utilizador
     * 
     * @return  Morada do utilizador
     */
    public String getMorada(){
        return this.morada;
    }
    
     /**
     * Método que define a morada de um utilizador a partir de uma String passada como parâmetro
     * 
     * @param var   Morada do utilizador a ser aplicado
     */
    public void setMorada(String var){
        this.morada=var;
    }
    
    /**
     * Método que devolve a data de nascimento de um utilizador
     * 
     * @return  Data de nascimento do utilizador
     */
    public String getNascimento(){
        return this.nascimento;
    }
    
     /**
     * Método que define a data de nascimento de um utilizador a partir de uma String passada como parâmetro
     * 
     * @param var   Data de nascimento do utilizador a ser aplicado
     */
    public void setNascimento(String var){
        this.nascimento=var;
    }
    
    
    /**
     * Método que converte uma identificação numa string
     * 
     * @return  string com a identificação do utilizador
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Nome: ").append(this.nome+"\t");
        sb.append("Email: ").append(this.email+"\t");
        sb.append("Password: ").append(this.password+"\t");
        sb.append("Morada: ").append(this.morada+"\t");
        sb.append("Nascimento: ").append(this.nascimento+"\n");
        
        return sb.toString();
    }
    
    /**
     * Método que cria uma cópia de uma identificação de um utilizador
     */
    public abstract Utilizador clone();
    
    /**
     * Método que testa se um objeto é igual a uma determinada identificação
     * 
     * @param o     objeto a ser testado
     * @return      true se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
     */
    public boolean equals(Object o){
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Utilizador id = (Utilizador) o;
        return (this.nome.equals(id.getNome()) && this.email.equals(id.getEmail()) && this.password.equals(id.getPassword()) && this.morada.equals(id.getMorada()) 
                && this.nascimento.equals(id.getNascimento()));
    }
}