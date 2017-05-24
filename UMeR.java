import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*; //ClassNotFoundException

/**
 * Escreva a descrição da classe UMeR aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class UMeR implements Serializable
{
   private Map<String,EmpresaTaxis> empresas;
   private Map<String,Utilizador> utilizadores;
   
   public UMeR(){
       this.empresas = new HashMap<String,EmpresaTaxis>();
       this.utilizadores = new HashMap<String,Utilizador>();
   }
   
   public UMeR(UMeR u){
       this.empresas = u.getEmpresas();
       this.utilizadores = u.getUtilizadores();
   }

   public Map<String,EmpresaTaxis> getEmpresas(){
       Map<String,EmpresaTaxis> emp = new HashMap<String,EmpresaTaxis>();
       
       for(Map.Entry<String, EmpresaTaxis> e : this.empresas.entrySet()){
           emp.put(e.getKey(), e.getValue().clone());
       }
       
       return emp;
   }
   
   public void setEmpresas(Map<String,EmpresaTaxis> emp){
       this.empresas.clear();
       
       for(Map.Entry<String,EmpresaTaxis> e : emp.entrySet()){
           this.empresas.put(e.getKey(), e.getValue().clone());
       }
   }
   
   public Map<String,Utilizador> getUtilizadores(){
       Map<String,Utilizador> utl = new HashMap<String,Utilizador>();
       
       for(Map.Entry<String, Utilizador> u:this.utilizadores.entrySet()){
           utl.put(u.getKey(), u.getValue().clone());
       }
       
       return utl;
   }
   
   public void setUtilizadores(Map<String,Utilizador> utl){
       this.utilizadores.clear();
       
       for(Map.Entry<String,Utilizador> u: utl.entrySet()){
           this.utilizadores.put(u.getKey(), u.getValue().clone());
       }
   }
   
   public String toString(){
       return this.empresas.toString()+"\n"+this.utilizadores.toString()+"\n";
   }
   
   public UMeR clone(){
       return new UMeR(this);
   }
   
   public boolean equals(Object o){
       if(this == o) return true;
       if((o == null) || (this.getClass() != o.getClass())) return false;
       
       UMeR u = (UMeR) o;
       return  this.empresas.equals(u.getEmpresas()) && this.utilizadores.equals(u.getUtilizadores());
   }
   
   public boolean emailExiste(String email){
       boolean auxUlt = this.utilizadores.containsKey(email);
       boolean auxEmp = false;
       
       for(EmpresaTaxis emp: this.empresas.values()){
           if(auxEmp == false) auxEmp = emp.getMotoristas().containsKey(email);
       }
                                            
       return (auxUlt || auxEmp);
   }
   
   public void addUtilizador(Utilizador u) throws RegistoException{
       if(!emailExiste(u.getEmail())) this.utilizadores.put(u.getEmail(), u.clone());
       else throw new RegistoException("Registo Inválido - email já existente.");
   }
   
   public void removeUtilizador(Utilizador u){
        this.utilizadores.remove(u.getEmail());
   }
   
   public void addEmpresa(EmpresaTaxis emp) throws EmpresaJaExisteException{
       if(!this.empresas.containsKey(emp.getNome())) this.empresas.put(emp.getNome(), emp.clone());
       else throw new EmpresaJaExisteException("Empresa já existente.");
   }
   
   public void removeEmpresa(EmpresaTaxis emp){
        this.empresas.remove(emp.getNome());
   }
   
   public Utilizador novoRegistoCliente(String nome, String email, String pass, String morada, String nascimento) throws RegistoException{
       Cliente c = new Cliente(nome, email, pass, morada, nascimento);
       addUtilizador(c);
       return c.clone();
   }
  
   public Utilizador novoRegistoMotoristaIndependente(String nome, String email, String pass, String morada, String nascimento, Veiculo veiculo) throws RegistoException{
       double grauCump = Math.round(Math.random() * 100);
       
       MotoristaIndependente mi = new MotoristaIndependente(nome, email, pass, morada, nascimento, veiculo.getDisponibilidade(), grauCump, veiculo);
       addUtilizador(mi);
       
       return mi.clone();
   }
   
   public Utilizador novoRegistoMotorista(String nomeEmp, String nome, String email, String pass, String morada, String nascimento, boolean disponibilidade) throws EmpresaNaoExisteException, RegistoException{

       if(!this.empresas.containsKey(nomeEmp)) throw new EmpresaNaoExisteException("A empresa submetida não existe.");
       
       if(emailExiste(email)) throw new RegistoException("Registo Inválido - email já existente.");
       
       double grauCump = Math.round(Math.random() * 100);
       
       Motorista m = new Motorista(nome, email, pass, morada, nascimento, disponibilidade, grauCump);
       this.empresas.get(nomeEmp).addMotorista(m);
       
       return m.clone();
   }
   
   public void removeMotoristaEmpresa(Motorista m){
       for(EmpresaTaxis e: this.empresas.values()){
           if(e.getMotoristas().containsKey(m.getEmail())) e.removeMotorista(m);
       }
   }

   public boolean veiculoExiste(String matricula){
       boolean auxMI = this.utilizadores.values()
                                        .stream()
                                        .filter(u -> u instanceof MotoristaIndependente)
                                        .map(u -> (MotoristaIndependente) u)
                                        .anyMatch(u -> u.getVeiculo().getMatricula().equals(matricula));
       boolean veiEmp = false;
       
       for(EmpresaTaxis emp: this.empresas.values()){
           if(veiEmp == false) veiEmp = emp.getVeiculos().containsKey(matricula);
       }
                                            
       return (auxMI || veiEmp);
   }
   
   public Veiculo tipoVeiculo(String tipo, String matricula, int lugares, double velocidadeMedia, double precoMedio, double x, double y, boolean dis) throws VeiculoInvalidoException, VeiculoJaExisteException{
       Veiculo v;
       
       double fiabilidade = Math.round(Math.random() * 100);
       
       if(tipo.equals("Mota")) v = novoRegistoMota(matricula, lugares, velocidadeMedia, precoMedio, fiabilidade, x, y, dis);
       else if(tipo.equals("Carro")) v = novoRegistoCarro(matricula, lugares, velocidadeMedia, precoMedio, fiabilidade, x, y, dis);
            else if(tipo.equals("Monovolume")) v = novoRegistoMonovolume(matricula, lugares, velocidadeMedia, precoMedio, fiabilidade, x, y, dis);
                 else throw new VeiculoInvalidoException("Classe de veículo inválida, tente novamente.");
       
       return v;
   }
   
   public Veiculo novoRegistoMota(String matricula, int lugares, double velocidadeMedia, double precoMedio, double fiabilidade, double x, double y, boolean dis) throws VeiculoJaExisteException{         
       if(veiculoExiste(matricula)) throw new VeiculoJaExisteException("Matrícula já existente.");
       
       Espaco2D e = new Espaco2D(x,y);
       Mota m = new Mota(matricula, lugares, velocidadeMedia, precoMedio, fiabilidade, e, dis);
       return m.clone();
   }
   
    public Veiculo novoRegistoCarro(String matricula, int lugares, double velocidadeMedia, double precoMedio, double fiabilidade, double x, double y, boolean dis) throws VeiculoJaExisteException{
       if(veiculoExiste(matricula)) throw new VeiculoJaExisteException("Matrícula já existente.");
        
       Espaco2D e = new Espaco2D(x,y);
       Carro c = new Carro(matricula, lugares, velocidadeMedia, precoMedio, fiabilidade, e, dis);
       return c.clone();
   }
   
   public Veiculo novoRegistoMonovolume(String matricula, int lugares, double velocidadeMedia, double precoMedio, double fiabilidade, double x, double y, boolean dis) throws VeiculoJaExisteException{
      if(veiculoExiste(matricula)) throw new VeiculoJaExisteException("Matrícula já existente.");
        
      Espaco2D e = new Espaco2D(x,y);
      Monovolume mv = new Monovolume(matricula, lugares, velocidadeMedia, precoMedio, fiabilidade, e, dis);
      return mv.clone();
   }
   
   public void adicionaVeiculoEmpresa(String nomeEmpresa, Veiculo v) throws EmpresaNaoExisteException, VeiculoJaExisteException{
       if(!this.empresas.containsKey(nomeEmpresa)) throw new EmpresaNaoExisteException("Empresa não existe na nossa base de dados");
       
       if(veiculoExiste(v.getMatricula())) throw new VeiculoJaExisteException("Matrícula já existente.");
       
       EmpresaTaxis e = this.empresas.get(nomeEmpresa);
       e.addVeiculo(v);
   }
   
   public Utilizador validarAcesso(String email, String password) throws LoginException{
       Utilizador utl = new Motorista();
       String nomeEmp = "";
       
       boolean utlUm = this.utilizadores.values().stream().anyMatch(u -> u.getEmail().equals(email) && u.getPassword().equals(password));
       boolean utlEmp = false;
       
       for(EmpresaTaxis e: this.empresas.values()){
           for(Motorista m: e.getMotoristas().values()){
               if(m.getEmail().equals(email) && m.getPassword().equals(password)) {
                   utlEmp = true;
                   nomeEmp = e.getNome();
               }
           }
       }
       
       if(!utlUm && !utlEmp) throw new LoginException("Acesso inválido.");
       
       if(utlUm) return this.utilizadores.get(email).clone();
       else return this.empresas.get(nomeEmp).getMotoristas().get(email);
   }
   
   public Veiculo veiculoMaisProximo(int nrLugares, double x, double y) throws NenhumVeiculoDisponivelException{
       Espaco2D locCliente = new Espaco2D(x,y);
     
       double distancia = -1;
       Espaco2D locVeiculo;
       Veiculo vMI;
       Veiculo v = new Carro();
       MotoristaIndependente mi;
       
       for(Utilizador uti : this.utilizadores.values()){
           if(uti instanceof MotoristaIndependente){
               mi = (MotoristaIndependente) uti;
               if(mi.getDisponibilidade() && mi.getVeiculo().getNrLugares() >= nrLugares){
                   vMI = mi.getVeiculo();
                   locVeiculo = vMI.getLocalizacao();
                   if(distancia == -1){
                       v = vMI;
                       distancia = locVeiculo.distancia(locCliente);
                   }
                   else if(locVeiculo.distancia(locCliente) < distancia){
                       v = vMI;
                       distancia = locVeiculo.distancia(locCliente);
                   }
                }
           }
       }
       
       for(EmpresaTaxis e: this.empresas.values()){
           for(Veiculo vi: e.getVeiculos().values()){
               if(vi.getDisponibilidade() && vi.getNrLugares() >= nrLugares){
                   locVeiculo = vi.getLocalizacao();
                   if(distancia == -1){
                       v = vi;
                       distancia = locVeiculo.distancia(locCliente);
                   }
                   else if(locVeiculo.distancia(locCliente) < distancia){
                       v = vi;
                       distancia = locVeiculo.distancia(locCliente);
                   }
               }
           }
       }
       
       if(distancia==-1) throw new NenhumVeiculoDisponivelException("Não há nenhum veiculo disponivel.");
       return v;
   }
 
   public Veiculo veiculoEspecificoMI(String matricula) throws VeiculoNaoExisteException, MotoristaIndisponivelException{
       Supplier<Stream<MotoristaIndependente>> streamSupplier = () -> this.utilizadores.values()
                                                                                       .stream()
                                                                                       .filter(u -> u instanceof MotoristaIndependente)
                                                                                       .map(u -> (MotoristaIndependente) u)
                                                                                       .filter(u -> u.getVeiculo().getMatricula().equals(matricula));
             
       long auxMI = streamSupplier.get()
                                  .count();
                                           
       if(auxMI==0) throw new VeiculoNaoExisteException("Esse veículo não existe na base de dados.");                                                            
      
       boolean aux = streamSupplier.get()
                                   .findAny().get().getDisponibilidade();
      
       if(!aux) throw new MotoristaIndisponivelException("Motorista indisponível de momento, por favor insira outro veículo.");
      
       return streamSupplier.get()
                            .findAny().get().getVeiculo();
   }
   
   public Veiculo veiculoEspecificoEmpresa(String matricula) throws VeiculoNaoExisteException, VeiculoEmpresaIndisponivelException{
       boolean veiEmp = false;
       String nomeEmp = "";
      
       for(EmpresaTaxis emp: this.empresas.values()){
           if(veiEmp == false) {
               veiEmp = emp.getVeiculos().containsKey(matricula);
               nomeEmp = emp.getNome();
           }
       }
        
       if(!veiEmp) throw new VeiculoNaoExisteException("Esse veículo não existe na base de dados.");
      
       Veiculo vei = this.empresas.get(nomeEmp).getVeiculos().get(matricula);
      
       if(!vei.getDisponibilidade()) throw new VeiculoEmpresaIndisponivelException("Veiculo indisponível de momento, por favor insira outro veículo.");
      
       return vei;
   }
   
   public String nomeEmpresaPeloVeiculo(Veiculo v){
       String nome = null;
       
       for(EmpresaTaxis e: this.empresas.values()){
           if(e.getVeiculos().containsKey(v.getMatricula())) nome = e.getNome();
       }
       
       return nome;
   }
   
   public Motorista motoristaEmpresaDisponivel(String nomeEmpresa) throws MotoristaIndisponivelException{
       EmpresaTaxis emp = this.empresas.get(nomeEmpresa);
       
       Supplier<Stream<Motorista>> streamSupplier = () -> emp.getMotoristas().values()
                                                                             .stream()
                                                                             .filter(mt -> mt.getDisponibilidade());
                                                                                     
       long conta = streamSupplier.get()
                                  .count();
      
       if(conta==0) throw new MotoristaIndisponivelException("Nenhum motorista da empresa disponível de momento.");
       
       Motorista m = streamSupplier.get()
                                   .findAny().get();
      
       return m;
   }
   
   public double tempoEstimado(double xc, double yc, double xd, double yd, Veiculo v){
       Espaco2D cliente = new Espaco2D(xc,yc);
       Espaco2D destino = new Espaco2D(xd,yd);
       
       double distancia1 = v.getLocalizacao().distancia(cliente);
       double distancia2 = cliente.distancia(destino);
       
       return Math.round((distancia1 + distancia2) / v.getVelocidade());
   }
   
   public double tempoReal(double tempoEstimado, Veiculo v, Motorista m){                                       
       double divisor = v.getFiabilidade() * 0.003 + m.getGrauCumprimento() * 0.0035 + probabilidadeChuva() * 0.001 + probabilidadeNevoeiro() * 0.001 + probabilidadeTransito() * 0.0015;
       
       return Math.round(tempoEstimado / divisor);
   }
   
   public double custoEstimado(double xc, double yc, double xd, double yd, Veiculo v){
       Espaco2D cliente = new Espaco2D(xc,yc);
       Espaco2D destino = new Espaco2D(xd,yd);
       
       double distancia = cliente.distancia(destino);
       double tempoEst = tempoEstimado(xc, yc, xd, yd, v);
       
       return Math.round(distancia * v.getPreco() + tempoEst * 0.25 );
   }
   
   public double custoReal(double tempoEstimado, double tempoReal, double custoEstimado){
       double custoReal;
       
       if((tempoReal / tempoEstimado) > 1.25)  custoReal = custoEstimado;
       else custoReal = Math.round(custoEstimado + (tempoReal - tempoEstimado) * 0.25);
       
       return custoReal;
   }
   
   public void efetuarViagem(Veiculo v, Motorista m){
       if (m instanceof MotoristaIndependente){
           MotoristaIndependente mi = (MotoristaIndependente) this.utilizadores.get(m.getEmail());
           mi.setDisponibilidade(false);
           mi.alteraDisponibilidadeVeiculo(false);
       }
       else{
           for(EmpresaTaxis e: this.empresas.values()){
               if(e.getMotoristas().containsKey(m.getEmail())){
                   e.mudaDisponibilidadeMotorista(m, false);
                   e.mudaDisponibilidadeVeiculo(v, false);
               }
           }
       }
   }

   public void viagemFinalizada(Cliente c, int ano, int mes, int dia, int hora, int minutos, double xp, double yp, double xd, double yd, Motorista m, Veiculo veiculo, double kms, 
                                double tempoViagem, double custoReal, double custoEst, int classificacao) throws DataException{
       if(ano < 0 || mes < 1 || mes > 12 || dia < 1 || dia > 31 || hora < 0 || hora > 23 || minutos < 0 || minutos > 59)
           throw new DataException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");

       LocalDate date = LocalDate.of(ano,mes,dia);
       LocalTime time = LocalTime.of(hora,minutos);
       
       Espaco2D partida = new Espaco2D(xp,yp);
       Espaco2D destino = new Espaco2D(xd,yd);
       
       Viagem v;
       Veiculo vAux = new Carro();
       Motorista mAux = new Motorista();
       
       if(this.utilizadores.containsKey(m.getEmail())){
           MotoristaIndependente mi = (MotoristaIndependente) this.utilizadores.get(m.getEmail());

           mi.incrementaQtViagens();
           
           double cla = mi.getClassificacaoMedia() * (mi.getQtViagens()-1) + classificacao;
           mi.setClassificacaoMedia(cla / (mi.getQtViagens()));
       
           mi.setKmsTotal(mi.getKmsTotal()+kms);
       
           mi.setDisponibilidade(true);
           
           mi.alteraLocalizacaoVeiculo(destino);
           mi.alteraDisponibilidadeVeiculo(true);
           vAux = mi.getVeiculo();
           
           v = new Viagem(date, time, partida, destino, vAux, kms, tempoViagem, custoReal, custoEst);
           mi.addViagem(v);
           
           mAux = mi.clone();
       }
       else{
           for(EmpresaTaxis e: this.empresas.values()){
               if(e.getMotoristas().containsKey(m.getEmail())){
                   e.incrementaQtViagensMotorista(m);
                   e.mudaClassificaoMediaMotorista(m, classificacao);
                   e.mudaKmsTotalMotorista(m,kms);
                   e.mudaDisponibilidadeMotorista(m, true);

                   e.mudaLocalizacaoVeiculo(veiculo, destino);
                   e.mudaDisponibilidadeVeiculo(veiculo, true);
                   vAux = e.getVeiculos().get(veiculo.getMatricula());
                   
                   v = new Viagem(date, time, partida, destino, vAux, kms, tempoViagem, custoReal, custoEst);
                   e.addViagemMotorista(m, v);
                   
                   mAux = e.getMotoristas().get(m.getEmail());
               }
           }
       }

       ViagemCliente vc = new ViagemCliente(date, time, partida, destino, vAux, kms, tempoViagem, custoReal, custoEst, mAux.getNome(), classificacao);
       Cliente cli = (Cliente) this.utilizadores.get(c.getEmail());
       cli.addViagemCliente(vc);
   }
   
   public List<Viagem> registoViagens(String Email, int anoI, int mesI, int diaI, int anoF, int mesF, int diaF) throws DataException{
       if(anoI < 0 || mesI < 1 || mesI > 12 || diaI < 1 || diaI > 31 || anoF < 0 || mesF < 1 || mesF > 12 || diaF < 1 || diaF > 31 || anoI > anoF || (anoI == anoF && mesI > mesF) || (anoI == anoF && mesI == mesF && diaI > diaF))
           throw new DataException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
        
       LocalDateTime inicio = LocalDateTime.of(anoI,mesI,diaI,00,00);
       LocalDateTime fim = LocalDateTime.of(anoF,mesF,diaF,23,59);
       List<Viagem> viagens = new ArrayList<Viagem> ();

       if(this.utilizadores.containsKey(Email)){
           Utilizador u = this.utilizadores.get(Email);
           if(u instanceof Cliente){
               Cliente c = (Cliente) u;
           
               for(ViagemCliente v: c.getHistorico()){
                   if((v.getData().isAfter(inicio) || v.getData().equals(inicio)) && (v.getData().isBefore(fim) || v.getData().equals(fim)))
                   viagens.add(v);
               }
           }
           else {
               Motorista m = (Motorista) u;
           
               for(Viagem v: m.getHistorico()){
                   if((v.getData().isAfter(inicio) || v.getData().equals(inicio)) && (v.getData().isBefore(fim) || v.getData().equals(fim)))
                   viagens.add(v);
               }
           }
       }
       else{
           for(EmpresaTaxis e: this.empresas.values()){
               if(e.getMotoristas().containsKey(Email)){
                   Motorista mot = e.getMotoristas().get(Email);
                   for(Viagem v: mot.getHistorico()){
                       if((v.getData().isAfter(inicio) || v.getData().equals(inicio)) && (v.getData().isBefore(fim) || v.getData().equals(fim)))
                       viagens.add(v);
                   }
               }
           }
       }
       
       return viagens;
    }
   
   public double totalFaturadoVeiculoMI(String matricula, int anoI, int mesI, int diaI, int anoF, int mesF, int diaF) throws DataException{
       if(anoI < 0 || mesI < 1 || mesI > 12 || diaI < 1 || diaI > 31 || anoF < 0 || mesF < 1 || mesF > 12 || diaF < 1 || diaF > 31 || anoI > anoF || (anoI == anoF && mesI > mesF) || (anoI == anoF && mesI == mesF && diaI > diaF))
           throw new DataException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
        
       LocalDateTime inicio = LocalDateTime.of(anoI,mesI,diaI,00,00);
       LocalDateTime fim = LocalDateTime.of(anoF,mesF,diaF,23,59);
       
       MotoristaIndependente mi = this.utilizadores.values()
                                                   .stream()
                                                   .filter(u -> u instanceof MotoristaIndependente)
                                                   .map(u -> (MotoristaIndependente) u)
                                                   .filter(u -> u.getVeiculo().getMatricula().equals(matricula))
                                                   .findAny().get();
                                                   
       double precoTotal=0;
       
       for(Viagem v: mi.getHistorico()){
            if((v.getData().isAfter(inicio) || v.getData().equals(inicio)) && (v.getData().isBefore(fim) || v.getData().equals(fim)))
                precoTotal += v.getPrecoRealViagem();
       }
       
       return precoTotal;
   }
   
   public double totalFaturadoEmpresa(String nomeEmpresa, int anoI, int mesI, int diaI, int anoF, int mesF, int diaF) throws DataException, EmpresaNaoExisteException{
       if(anoI < 0 || mesI < 1 || mesI > 12 || diaI < 1 || diaI > 31 || anoF < 0 || mesF < 1 || mesF > 12 || diaF < 1 || diaF > 31 || anoI > anoF || (anoI == anoF && mesI > mesF) || (anoI == anoF && mesI == mesF && diaI > diaF))
           throw new DataException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
        
       if(!this.empresas.containsKey(nomeEmpresa)) throw new EmpresaNaoExisteException("A empresa inserida não existe na nossa base de dados, por favor retifique a informação");
       
       LocalDateTime inicio = LocalDateTime.of(anoI,mesI,diaI,00,00);
       LocalDateTime fim = LocalDateTime.of(anoF,mesF,diaF,23,59);

       EmpresaTaxis e = this.empresas.get(nomeEmpresa);
       double precoTotal = 0;
       
       for(Motorista m: e.getMotoristas().values()){
           for(Viagem v: m.getHistorico()){
               if((v.getData().isAfter(inicio) || v.getData().equals(inicio)) && (v.getData().isBefore(fim) || v.getData().equals(fim)))
                   precoTotal += v.getPrecoRealViagem();
           }
       }
       
       return precoTotal;
   }
   
   public List<Veiculo> listagemVeiculosMI(){ 
       List<Veiculo> veiculos = new ArrayList<Veiculo>();
       
       Utilizador utl;
       MotoristaIndependente mi;
       for(Map.Entry<String,Utilizador> u: this.utilizadores.entrySet()){
           utl = u.getValue();
           if(utl instanceof MotoristaIndependente){
               mi = (MotoristaIndependente) utl;
               veiculos.add(mi.getVeiculo());
           }
       }
       
       return veiculos;
   }
   
   public List<Veiculo> listagemVeiculosEmpresa(String nomeEmpresa) throws EmpresaNaoExisteException{ 
       if(!this.empresas.containsKey(nomeEmpresa)) throw new EmpresaNaoExisteException("A empresa inserida não existe na nossa base de dados, por favor retifique a informação");
       
       List<Veiculo> veiculos = new ArrayList<Veiculo>();
       EmpresaTaxis e = this.empresas.get(nomeEmpresa);
       
       for(Veiculo v: e.getVeiculos().values()){
           veiculos.add(v);
       }
       
       return veiculos;
   }
   
   public List<String> listagemNomesEmpresas(){ 
       List<String> nomes = new ArrayList<String>();
       
       for(EmpresaTaxis emp : this.empresas.values()){
           nomes.add(emp.getNome());
       }
       
       return nomes;
   }
   
   public MotoristaIndependente alterarVeiculoMI(String email, String tipo, String matricula, int lugares, double velocidadeMedia, double precoMedio, double x, double y, boolean dis) throws VeiculoInvalidoException, VeiculoJaExisteException{
       Veiculo v =  tipoVeiculo(tipo, matricula, lugares, velocidadeMedia, precoMedio, x, y, dis);
       
       MotoristaIndependente mi = (MotoristaIndependente) this.utilizadores.get(email);
                                       
       mi.setVeiculo(v);     
       return mi.clone();
   }
   
   public MotoristaIndependente alterarLocalizacaoVeiculoMI(String email, Espaco2D loc){
       MotoristaIndependente mi = (MotoristaIndependente) this.utilizadores.get(email);             
       mi.alteraLocalizacaoVeiculo(loc);   
       return mi.clone();
   }
   
   public Motorista alterarDisponibilidadeMotorista(String email, boolean dis){
       Motorista m = new Motorista();
       
       if(this.utilizadores.containsKey(email)){
           MotoristaIndependente mi = (MotoristaIndependente) this.utilizadores.get(email);
           mi.setDisponibilidade(dis);
           mi.alteraDisponibilidadeVeiculo(dis);
           m = mi.clone();
       }
       else{
           for(EmpresaTaxis e: this.empresas.values()){
               if(e.getMotoristas().containsKey(email)){                   
                   Motorista mot = e.getMotoristas().get(email);
                   e.mudaDisponibilidadeMotorista(mot, dis);
                   m = e.getMotoristas().get(email);
               }
           }
       }
       
       return m;
   }
   
   public List<Cliente> top10clientes(){
       Set<Cliente> clientesOrg = new TreeSet<Cliente>(new OrdenaClientes());
       List<Cliente> clientesLista = new ArrayList<Cliente>(); 
       
       Utilizador utl;
       Cliente c;
       for(Utilizador u: this.utilizadores.values()){
           if(u instanceof Cliente){
               c = (Cliente) u;
               clientesOrg.add(c.clone());
           }
       }
       
       Iterator<Cliente> u = clientesOrg.iterator();
       int i = 0;
       while(u.hasNext() && i<10){
           clientesLista.add(u.next());
           i++;
       }
       
       return clientesLista;
   }
   
   public List<Motorista> top5motoristas(){
       Set<Motorista> motoristasOrg = new TreeSet<Motorista> (new OrdenaMotoristas());
       List<Motorista> motoristasLista = new ArrayList<Motorista>();

       for (EmpresaTaxis e : this.empresas.values()) {
           for (Motorista m: e.getMotoristas().values()) {
               motoristasOrg.add(m);
           }
       }

       for(Utilizador u: this.utilizadores.values()){
           if(u instanceof MotoristaIndependente){
              MotoristaIndependente mi = (MotoristaIndependente) u;
              motoristasOrg.add(mi.clone());
           }
       }

       Iterator<Motorista> u = motoristasOrg.iterator();
       int i = 0;
       while(u.hasNext() && i<5){
           motoristasLista.add(u.next());
           i++;
       }
       
       return motoristasLista;
   }
   
   public double probabilidadeChuva(){
       return Math.round(Math.random() * 100);
   }
   
   public double probabilidadeNevoeiro(){
       return Math.round(Math.random() * 100);
   }
   
   public double probabilidadeTransito(){
       return Math.round(Math.random() * 100);
   }
   
   /**
     * Método que guarda o estado de uma instância num ficheiro de texto.
     * 
     * @param nome do ficheiro
     */
    
   public void escreveEmFicheiroTxt(String nomeFicheiro) throws IOException {
       PrintWriter fich = new PrintWriter(nomeFicheiro);
       fich.println("------- UMeR --------");
       fich.println(this.toString());
       fich.flush();
       fich.close();
   }

   /**
    * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem.
    */
   
   public void guardaEstado(String nomeFicheiro) throws FileNotFoundException,IOException {
       FileOutputStream fos = new FileOutputStream(nomeFicheiro);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(this); //guarda-se todo o objecto de uma só vez
       oos.flush();
       oos.close();
   }
    
   /**
    * Método que recupera uma instância de UMeR de um ficheiro de objectos.
    * Este método tem de ser um método de classe que devolva uma instância já construída de
    * UMeR.
    * 
    * @param nome do ficheiro onde está guardado um objecto do tipo UMeR
    * @return objecto UMeR inicializado
    */
   
   public static UMeR carregaEstado(String nomeFicheiro) throws FileNotFoundException,
                                                                IOException,
                                                                ClassNotFoundException {
       FileInputStream fis = new FileInputStream(nomeFicheiro);
       ObjectInputStream ois = new ObjectInputStream(fis);
       UMeR umer = (UMeR) ois.readObject();
       ois.close();
       return umer;
   }
   
   public static void main(){
       new UMeRApp().run();
   }
}
