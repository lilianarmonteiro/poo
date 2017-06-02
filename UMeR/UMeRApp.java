import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*; //Classe exceção

/**
 * Classe que cria o menu da aplicação UMeRApp, onde estão definidos os métodos que gerem a interação entre a aplicação e os utilizadores
 * 
 * @author Isabel Sofia Pereira
 * @author Liliana Monteiro
 * @author Maria de La Salete Teixeira
 */
public class UMeRApp
{
   /**
    * Variáveis de Instância
    */
   
   /**
    * Variável que contém todos os dados e métodos da aplicação
    */
   private UMeR log;
   
   /**
    * Menu interativo
    */
   private Menu menu;
   
   /**
    * Construtores
    */
   
   /**
    * Construtor vazio que cria uma instância UMeRApp e insere as opções do menu principal
    */
   public UMeRApp(){

       try{
           log = new UMeR();
           log = log.carregaEstado("umerBaseDeDadosBinario");
       }
       catch(FileNotFoundException e){
           System.out.println(e.getMessage());
       }
       catch(IOException e){
           System.out.println(e.getMessage());
       }
       catch(ClassNotFoundException e){
           System.out.println(e.getMessage());
       }

       String[] s = {"Novo Registo Cliente", "Novo Registo Motorista Independente", "Area Empresarial", "Login"};
       menu = new Menu(s);
   }
   
   /**
    * Métodos de Instância
    */
   
   /**
    * Método que inicia a aplicação no menu principal
    */
   public void run(){
       int op = 0;
       
       do{
           menu.executa();
           op = menu.getOpcao();
           
           switch(op){
               case 1: adicionaCliente();
                       break;
               case 2: adicionaMotoristaIndependente();
                       break;
               case 3: areaEmpresa();
                       break;     
               case 4: confirmarLogin();
                       break;
           }
       }
       while(op != 0);
       
       try{
           log.escreveEmFicheiroTxt("umerBaseDeDados");
           log.guardaEstado("umerBaseDeDadosBinario");
       }
       catch(FileNotFoundException e){
           System.out.println(e.getMessage());
       }
       catch(IOException e){
           System.out.println(e.getMessage());
       }
   }
   
   /**
    * Método que adiciona um cliente à aplicação, requisitando a inserção dos seus dados
    */
   public void adicionaCliente(){
       Scanner input = new Scanner(System.in);
       String nome, email, password, confirmarPassword, morada, nascimento;
       
       try{
           System.out.println("Nome: ");
           nome = input.nextLine();
       
           System.out.println("Email: ");
           email = input.nextLine();
       
           do{
               System.out.println("Password: ");
               password = input.nextLine();
           
               System.out.println("Confirmar Password: ");
               confirmarPassword = input.nextLine();
           
               if(!password.equals(confirmarPassword)) System.out.println("Password incorreta.");
           }
           while(!password.equals(confirmarPassword));
       
           System.out.println("Morada: ");
           morada = input.nextLine();
       
           System.out.println("Data de Nascimento: [dd-mm-aaaa]");
           nascimento = input.nextLine();
       
           Cliente c = (Cliente) log.novoRegistoCliente(nome, email, password, morada, nascimento);
           areaPessoalCliente(c);
       }
       catch (RegistoException e){
           System.out.println(e.getMessage()); 
       }
       
       input.close();
   }
   
   /**
    * Método que adiciona um motorista independente à aplicação, requisitando a inserção dos seus dados e dos dados do seu veículo
    */
   public void adicionaMotoristaIndependente(){
       Scanner input = new Scanner(System.in);
       String nome, email, password, confirmarPassword, morada, nascimento, aux, tipoVeiculo, matricula;
       boolean disponibilidade;
       int lugares;
       double velocidadeMedia, precoMedio, x, y;
       
       try{
           System.out.println("Nome: ");
           nome = input.nextLine();
       
           System.out.println("Email: ");
           email = input.nextLine();
       
          do{
               System.out.println("Password: ");
               password = input.nextLine();
           
               System.out.println("Confirmar Password: ");
               confirmarPassword = input.nextLine();
           
               if(!password.equals(confirmarPassword)) System.out.println("Password incorreta.");
           }
           while(!password.equals(confirmarPassword));
       
           System.out.println("Morada: ");
           morada = input.nextLine();
       
           System.out.println("Data de Nascimento: [dd-mm-aaaa]");
           nascimento = input.nextLine();
       
           System.out.println("Está disponível para trabalhar neste momento?[sim/nao] ");
           aux = input.nextLine();
           if(aux.equals("sim")) disponibilidade = true;
           else disponibilidade = false;
       
           System.out.println("Que tipo de veículo pretende registar?[Mota/Carro/Monovolume] ");
           tipoVeiculo = input.nextLine();
       
           System.out.println("Matricula: [xx-xx-xx]");
           matricula = input.nextLine();
       
           System.out.println("Número de lugares do veículo: ");
           lugares = input.nextInt();
       
           System.out.println("Velocidade média do veículo: ");
           velocidadeMedia = input.nextDouble();
       
           System.out.println("Preço base por km: ");
           precoMedio = input.nextDouble();
       
           System.out.println("Coordenada x onde se encontra: ");
           x = input.nextDouble();
       
           System.out.println("Coordenada y onde se encontra: ");
           y = input.nextDouble();
       
           Veiculo veiculo = log.tipoVeiculo(tipoVeiculo, matricula, lugares, velocidadeMedia, precoMedio, x, y, disponibilidade);
           MotoristaIndependente mi = (MotoristaIndependente) log.novoRegistoMotoristaIndependente(nome, email, password, morada, nascimento, veiculo);
           areaPessoalMotoristaIndependente(mi);
       }
       catch (VeiculoInvalidoException e){
           System.out.println(e.getMessage()); 
       }
       catch (VeiculoJaExisteException e){
           System.out.println(e.getMessage()); 
       }
       catch (RegistoException e){
           System.out.println(e.getMessage()); 
       }
       
       input.close();
   }
   
   /**
    * Menu das empresas de táxis, onde é possível registar uma nova empresa, um novo veículo ou um novo motorista numa empresa específica
    */
   public void areaEmpresa(){
       String s[] = {"Novo Registo Empresa", "Novo Registo Veiculo", "Novo Registo Motorista"};
       Menu m = new Menu(s);
       int op = 0;

       do{
           m.executa();
           op = m.getOpcao();
               
           switch(op){
               case 1: adicionaEmpresa();
                       break;
               case 2: adicionaVeiculo();
                       break;
               case 3: adicionaMotorista();
                       break;
           }
       }
       while(op != 0);
   }
   
   
   /**
    * Método que adiciona uma nova empresa de táxis à aplicação, requisitando a inserção dos dados da empresa
    */
   public void adicionaEmpresa(){
       Scanner input = new Scanner(System.in);
       String nomeEmpresa;
       
       try{
           System.out.println("Digite o nome da empresa: ");
           nomeEmpresa = input.nextLine();
           
           EmpresaTaxis emp = new EmpresaTaxis(nomeEmpresa);
           
           log.addEmpresa(emp);
       }
       catch (EmpresaJaExisteException e){
           System.out.println(e.getMessage()); 
       }
       
       input.close();
   }
   
   
   /**
    * Método que adiciona um veículo numa determinada empresa de táxis, requisitando a inserção do nome da empresa desejada e dos dados do veículo
    */
   public void adicionaVeiculo(){
       Scanner input = new Scanner(System.in);
       String nomeEmpresa, aux, tipoVeiculo, matricula;
       boolean disponibilidade;
       int lugares;
       double velocidadeMedia, precoMedio, x, y;
       
       try{
           System.out.println("Digite o nome da empresa no qual pretende registar o veículo: ");
           nomeEmpresa = input.nextLine();
           
           System.out.println("Que tipo de veículo pretende registar?[Mota/Carro/Monovolume] ");
           tipoVeiculo = input.nextLine();
       
           System.out.println("Matricula: [xx-xx-xx]");
           matricula = input.nextLine();
       
           System.out.println("Número de lugares do veículo: ");
           lugares = input.nextInt();
       
           System.out.println("Velocidade média do veículo: ");
           velocidadeMedia = input.nextDouble();
       
           System.out.println("Preço base por km: ");
           precoMedio = input.nextDouble();
           
           System.out.println("Coordenada x onde o veículo se encontra: ");
           x = input.nextDouble();
       
           System.out.println("Coordenada y onde o veículo se encontra: ");
           y = input.nextDouble();
           
           System.out.println("O veículo está disponível neste momento?[sim/nao] ");
           aux = input.next();
           if(aux.equals("nao")) disponibilidade = false;
           else disponibilidade = true;
       
           Veiculo veiculo = log.tipoVeiculo(tipoVeiculo, matricula, lugares, velocidadeMedia, precoMedio, x, y, disponibilidade);
           log.adicionaVeiculoEmpresa(nomeEmpresa,veiculo);
       }
       catch (EmpresaNaoExisteException e){
           System.out.println(e.getMessage()); 
       }
       catch (VeiculoInvalidoException e){
           System.out.println(e.getMessage()); 
       }
       catch (VeiculoJaExisteException e){
           System.out.println(e.getMessage()); 
       }
       
       input.close();
   }
   
    /**
    * Método que adiciona um motorita numa determinada empresa de táxis, requisitando a inserção do nome da empresa desejada e dos dados do motorista
    */
   public void adicionaMotorista(){
       Scanner input = new Scanner(System.in);
       String nomeEmpresa, nome, email, password, confirmarPassword, morada, nascimento, aux, tipoVeiculo, matricula;
       boolean disponibilidade;
       
       try{
           System.out.println("Digite o nome da empresa na qual pretende registar-se: ");
           nomeEmpresa = input.nextLine();
           
           System.out.println("Nome motorista: ");
           nome = input.nextLine();
       
           System.out.println("Email: ");
           email = input.nextLine();
       
           do{
               System.out.println("Password: ");
               password = input.nextLine();
           
               System.out.println("Confirmar Password: ");
               confirmarPassword = input.nextLine();
           
               if(!password.equals(confirmarPassword)) System.out.println("Password incorreta.");
           }
           while(!password.equals(confirmarPassword));
       
           System.out.println("Morada: ");
           morada = input.nextLine();
       
           System.out.println("Data de Nascimento: [dd-mm-aaaa]");
           nascimento = input.nextLine();
       
           System.out.println("Está disponível para trabalhar neste momento?[sim/nao] ");
           aux = input.nextLine();
           if(aux.equals("sim")) disponibilidade = true;
           else disponibilidade = false;
       
           Motorista m = (Motorista) log.novoRegistoMotorista(nomeEmpresa, nome, email, password, morada, nascimento, disponibilidade);
           areaPessoalMotorista(m);
       }
       catch (EmpresaNaoExisteException e){
           System.out.println(e.getMessage());
       }
       catch (RegistoException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
    /**
    * Método que realiza o login de um utilizador na aplicação, requisitando a inserção do seu email e password
    */
   public void confirmarLogin(){
       Scanner input = new Scanner(System.in);
       String email, password;
       
       try{
           System.out.println("Email: ");
           email = input.nextLine();
       
           System.out.println("Password: ");
           password = input.nextLine();
       
           Utilizador u = log.validarAcesso(email, password);
       
           if(u instanceof Cliente) areaPessoalCliente((Cliente) u);
           else if(u instanceof MotoristaIndependente) areaPessoalMotoristaIndependente((MotoristaIndependente) u);
           else areaPessoalMotorista((Motorista) u);
       }
       catch (LoginException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Menu da área pessoal de um cliente, com as opções que este pode efetuar na aplicação
    * 
    * @param c    Cliente com sessão iniciada na aplicação
    */
   public void areaPessoalCliente(Cliente c){
       String s[] = {"Requisitar Viagem", "Histórico de Viagens", "Listagem de Veículos Parceiros da UMeR", "Empresas", "Top 10 clientes mais fieis", "Top 5 motoristas com maiores desvios de preços", "Eliminar Perfil"};
       Menu m = new Menu(s);
       int opcaoTS = 0;
       int opcaoEP = 0;
       int op = 0;

       do{
           m.executa();
           op = m.getOpcao();
               
           switch(op){
               case 1: novaViagem(c);
                       break;
               case 2: acederHistorico(c);
                       break;
               case 3: listaVeiculosUMeR();
                       break;
               case 4: empresas();
                       break;
               case 5: top10Clientes();
                       break;
               case 6: top5Motoristas();
                       break;
               case 7: opcaoEP = eliminarPerfil(c);
                       break;
           }
       }
       while(op != 0 && opcaoTS==0 && opcaoEP == 0);
   }
   
   
   /**
    * Menu da área pessoal de um motorista independente, com as opções que este pode efetuar na aplicação
    * 
    * @param mi    Motorista independente com sessão iniciada na aplicação
    */
   public void areaPessoalMotoristaIndependente(MotoristaIndependente mi){
       String s[] = {"Histórico de Viagens", "Total faturado", "Alterar Veículo", "Alterar Localização Veiculo", "Alterar Disponibilidade", "Top 10 clientes mais fieis", "Top 5 motoristas com maiores desvios de preços", "Eliminar perfil"};
       Menu m = new Menu(s);
       int opcaoTS = 0;
       int opcaoEP = 0;
       int op = 0;
       
       do{
           m.executa();
           op = m.getOpcao();
             
           switch(op){
               case 1: acederHistorico(mi);
                       break;
               case 2: totalFaturado(mi);
                       break;
               case 3: mi = alterarVeiculo(mi);
                       break;
               case 4: mi = alterarLocalizacaoVeiculo(mi);
                       break;
               case 5: mi = (MotoristaIndependente) alterarDisponibilidade(mi);
                       break;
               case 6: top10Clientes();
                       break;
               case 7: top5Motoristas();
                       break;
               case 8: opcaoEP = eliminarPerfil(mi);
                       break;
           }
       }
       while(op != 0 && opcaoTS==0 && opcaoEP == 0);
   }
   
   
   /**
    * Menu da área pessoal de um motorita de uma empresa de táxis, com as opções que este pode efetuar na aplicação
    * 
    * @param mot    Motorista com sessão iniciada na aplicação
    */
   public void areaPessoalMotorista(Motorista mot){
       String s[] = {"Histórico de Viagens", "Alterar Disponibilidade", "Empresas", "Top 10 clientes mais fieis", "Top 5 motoristas com maiores desvios de preços", "Eliminar perfil"};
       Menu m = new Menu(s);
       int opcaoTS = 0;
       int opcaoEP = 0;
       int op = 0;
       
       do{
           m.executa();
           op = m.getOpcao();
             
           switch(op){
               case 1: acederHistorico(mot);
                       break;
               case 2: mot = alterarDisponibilidade(mot);
                       break;
               case 3: empresas();
                       break;
               case 4: top10Clientes();
                       break;
               case 5: top5Motoristas();
                       break;
               case 6: opcaoEP = eliminarPerfil(mot);
                       break;
           }
       }
       while(op != 0 && opcaoTS==0 && opcaoEP == 0);
   }
   
   /**
    * Menu que apresenta ao cliente as opções que ele pode escolher na realização de uma nova viagem
    * 
    * @param c    Cliente que requisitou uma viagem
    */
   public void novaViagem(Cliente c){
       String[] s = {"Escolher o veículo mais próximo.", "Escolher um veículo UMeR específico.", "Escolher um veículo empresarial específico."};
       Menu m = new Menu(s);
       int opt = 0;
       
       do{
           m.executa();
           opt = m.getOpcao();
           
           switch(opt){
               case 1: viagemVeiculoMaisProximo(c);
                       break;
               case 2: viagemVeiculoEspecificoMI(c);
                       break;
               case 3: viagemVeiculoEspecificoEmpresa(c);
                       break;
           }
       }
       while(opt != 0);
   }
   
   /**
    * Método que disponibiliza a um utilizador o seu histórico de viagens no período de tempo considerado
    * 
    * @param u    Utilizador que requisitou o seu histórico
    */
   public void acederHistorico(Utilizador u){
       Scanner input = new Scanner(System.in);
       int diaI, mesI, anoI, anoF, mesF, diaF;
       
       System.out.println("Data de início que pretende considerar.[aaaa mm dd]");
       anoI = input.nextInt();
       mesI = input.nextInt();
       diaI = input.nextInt();
       
       System.out.println("Data final que pretende considerar.[aaaa mm dd]");
       anoF = input.nextInt();
       mesF = input.nextInt();
       diaF = input.nextInt();
       
       try{
           List<Viagem> historico = log.registoViagens(u.getEmail(), anoI, mesI, diaI, anoF, mesF, diaF);
           
           System.out.println("Durante o período submetido efetuou as seguintes viagens:\n"+historico.toString());
       }
       catch (DataException e){
           System.out.println(e.getMessage());
       }
        
       input.close();
   }
   
   /**
    * Método que elimina o perfil de um determinado utilizador da aplicação 
    * 
    * @param u    Utilizador com sessão iniciada
    * @return   Retorna 1 para permitir voltar ao menu principal, caso o perfil não tenha sido possível eliminar o perfil do utilizador retorna 0
    */
   public int eliminarPerfil(Utilizador u){
       Scanner input = new Scanner(System.in);
       String aux, password;
       
       System.out.println("Tem a certeza que deseja eliminar o seu perfil permanentemente?[sim/nao] ");
       aux = input.nextLine();
       if(aux.equals("sim")){
           System.out.println("Password: ");
           password = input.nextLine();
           
           if(password.equals(u.getPassword())){
               if(u instanceof MotoristaIndependente || u instanceof Cliente) log.removeUtilizador(u);
               else log.removeMotoristaEmpresa((Motorista) u);
               
               System.out.println("Perfil eliminado.");
               input.close();
               return 1;
           }
           else{
               System.out.println("Password incorreta.");
               input.close();
               return 0;
           }
       }
       
       input.close();
       return 0;
   }
   
   /**
    * Método que seleciona o veículo mais próximo da localização do cliente para a realização de uma viagem
    * 
    * @param c    Cliente com sessão iniciada
    */
   public void viagemVeiculoMaisProximo(Cliente c){
       Scanner input = new Scanner(System.in);
       double x, y;
       int nrLugares;
       String nomeEmpresa;
       Veiculo v;
       
       System.out.println("Digite a coordenada x onde se encontra,");
       x = input.nextDouble();
       
       System.out.println("Digite a coordenada y onde se encontra,");
       y = input.nextDouble();
       
       System.out.println("Necessita de lugares para quantos passageiros?");
       nrLugares = input.nextInt();
       
       try{
           v = log.veiculoMaisProximo(nrLugares+1, x, y);
           nomeEmpresa = log.nomeEmpresaPeloVeiculo(v);

           if(nomeEmpresa == null){
               MotoristaIndependente mi = log.getUtilizadores().values().stream()
                                                               .filter(u -> u instanceof MotoristaIndependente)
                                                               .map(u -> (MotoristaIndependente) u)
                                                               .filter(u -> u.getVeiculo().getMatricula().equals(v.getMatricula()))
                                                               .findAny().get();
               viagem(c,mi,v);
           }
           else{
               Motorista m = log.motoristaEmpresaDisponivel(nomeEmpresa);
               viagem(c,m,v);
           }
       }
       catch (NenhumVeiculoDisponivelException e){
           System.out.println(e.getMessage());
       }
       catch (MotoristaIndisponivelException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Método que seleciona o veículo específico de um motorista independente requisitado pelo cliente para a realização de uma viagem
    * 
    * @param c    Cliente com sessão iniciada
    */
   public void viagemVeiculoEspecificoMI(Cliente c){
       Scanner input = new Scanner(System.in);
       String matricula;
       
       System.out.println("Digite a matrícula do veículo que deseja. [xx-xx-xx]");
       matricula = input.nextLine();
       
       try{
           Veiculo v = log.veiculoEspecificoMI(matricula);
           
           MotoristaIndependente mi = log.getUtilizadores().values()
                                                           .stream()
                                                           .filter(u -> u instanceof MotoristaIndependente)
                                                           .map(u -> (MotoristaIndependente) u)
                                                           .filter(u -> u.getVeiculo().getMatricula().equals(matricula))
                                                           .findAny().get();
           
           viagem(c,mi,v);
       }
       catch (VeiculoNaoExisteException e){
           System.out.println(e.getMessage());
       }
       catch (MotoristaIndisponivelException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Método que seleciona o veículo específico de uma empresa de táxis requisitado pelo cliente para a realização de uma viagem
    * 
    * @param c    Cliente com sessão iniciada
    */
   public void viagemVeiculoEspecificoEmpresa(Cliente c){
       Scanner input = new Scanner(System.in);
       String matricula;
       
       System.out.println("Digite a matrícula do veículo que deseja. [xx-xx-xx]");
       matricula = input.nextLine();
       
       try{
           Veiculo v = log.veiculoEspecificoEmpresa(matricula);
           
           String nomeEmpresa = log.nomeEmpresaPeloVeiculo(v);
           
           Motorista m = log.motoristaEmpresaDisponivel(nomeEmpresa);
           
           viagem(c,m,v);
       }
       catch (VeiculoNaoExisteException e){
           System.out.println(e.getMessage());
       }
       catch (VeiculoEmpresaIndisponivelException e){
           System.out.println(e.getMessage());
       }
       catch (MotoristaIndisponivelException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Método que efetua uma viagem requisitada pelo cliente
    * 
    * @param c    Cliente que requisitou a viagem
    * @param m    Motorista que vai realizar a viagem
    * @param v    Veículo usado na viagem
    */
   public void viagem(Cliente c, Motorista m, Veiculo v){
       Scanner input = new Scanner(System.in);
       double xp, yp, xd, yd, tempoEstimado, custoEstimado, tempoReal, custoReal;
       int dia, mes, ano, hora, minutos, classificacao;
       
       System.out.println("Data de quando deseja efetuar a viagem.[aaaa mm dd]");
       ano = input.nextInt();
       mes = input.nextInt();
       dia = input.nextInt();
       
       System.out.println("Hora de quando deseja efetuar a viagem.[hh mm]");
       hora = input.nextInt();
       minutos = input.nextInt();
       
       System.out.println("Digite a coordenada x onde se encontra,");
       xp = input.nextDouble();
       System.out.println("Digite a coordenada y onde se encontra,");
       yp = input.nextDouble();
       Espaco2D inicio = new Espaco2D(xp,yp);
       
       System.out.println("Digite a coordenada x do seu destino,");
       xd = input.nextDouble();
       System.out.println("Digite a coordenada y do seu destino,");
       yd = input.nextDouble();
       Espaco2D fim = new Espaco2D(xd,yd);
       
       double kms = Math.round(inicio.distancia(fim));
       
       tempoEstimado = log.tempoEstimado(xp,yp,xd,yd,v);
       System.out.println("O tempo estimado de chegada ao destino pretendido é "+tempoEstimado+" minutos.");
       
       custoEstimado = log.custoEstimado(xp,yp,xd,yd,v);
       System.out.println("O custo estimado da viagem é "+custoEstimado+" euros.");
       
       log.efetuarViagem(v, m);
       System.out.println("O seu pedido foi efetuado, esperamos que tenha uma viagem agradável.");
       
       tempoReal = log.tempoReal(tempoEstimado, v, m);
       
       custoReal = log.custoReal(tempoEstimado, tempoReal, custoEstimado);
      
       System.out.println("Classifique o motorista que efetuou a sua viagem numa escala de 0 a 100.");
       classificacao = input.nextInt();
       
       try{
           log.viagemFinalizada(c, ano, mes, dia, hora, minutos, xp, yp, xd, yd, m, v, kms, tempoReal, custoReal, custoEstimado, classificacao);
           System.out.println("Viagem finalizada, relembramos que pode aceder ao seu histórico de viagens na área pessoal. Obrigada por utilizar o serviço UMeR.");
       }
       catch (DataException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Método que fornece ao cliente uma lista com todos os veículos de motorista independentes registados na aplicação
    */
   public void listaVeiculosUMeR(){
       List<Veiculo> veiculos = log.listagemVeiculosMI();
       System.out.println("De momento estão inscritos na nossa aplicação os seguintes veículos:\n"+veiculos.toString());
   }
   
   /**
    * Método que fornece a um motorista independente o seu total faturado num determinado período de tempo
    * 
    * @param mi   Motorista independente com sessão iniciada
    */
   public void totalFaturado(MotoristaIndependente mi){
       Scanner input = new Scanner(System.in);
       int diaI, mesI, anoI, anoF, mesF, diaF;
       double total=0;
       
       System.out.println("Data de início que pretende considerar.[aaaa mm dd]");
       anoI = input.nextInt();
       mesI = input.nextInt();
       diaI = input.nextInt();
       
       System.out.println("Data final que pretende considerar.[aaaa mm dd]");
       anoF = input.nextInt();
       mesF = input.nextInt();
       diaF = input.nextInt();
       
       try{
           total=log.totalFaturadoVeiculoMI(mi.getVeiculo().getMatricula(), anoI, mesI, diaI, anoF, mesF, diaF);
           
           System.out.println("Durante o período apresentado faturou "+total+" euros ao colaborar com a UMeR. Parabéns.");
       }
       catch (DataException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Método que permite a um motorista independente alterar o seu veículo, requisitando a inserção dos dados do novo veículo
    * 
    * @param mi   Motorista independente com sessão iniciada
    * @return   O motorista Independente
    */
   public MotoristaIndependente alterarVeiculo(MotoristaIndependente mi){
       Scanner input = new Scanner(System.in);
       String aux, tipoVeiculo, matricula;
       int lugares;
       double velocidadeMedia, precoMedio, x, y;
       
       System.out.println("Seu veiculo atual:\n"+mi.getVeiculo().toString());
       System.out.println("Tem a certeza que deseja alterar o seu veiculo?[sim/nao] ");
       aux = input.nextLine();
       if(aux.equals("sim")){
           try{
               System.out.println("Que tipo de veículo pretende registar?[Mota/Carro/Monovolume] ");
               tipoVeiculo = input.nextLine();
           
               System.out.println("Matricula: [xx-xx-xx]");
               matricula = input.nextLine();
           
               System.out.println("Número de lugares do veículo: ");
               lugares = input.nextInt();
           
               System.out.println("Velocidade média a que costuma conduzir: ");
               velocidadeMedia = input.nextDouble();
           
               System.out.println("Preço base por km que pretende cubrar: ");
               precoMedio = input.nextDouble();
           
               System.out.println("Coordenada x onde se encontra: ");
               x = input.nextDouble();
           
               System.out.println("Coordenada y onde se encontra: ");
               y = input.nextDouble();
           
               mi = log.alterarVeiculoMI(mi.getEmail(), tipoVeiculo, matricula, lugares, velocidadeMedia, precoMedio, x, y, mi.getDisponibilidade());
               System.out.println("Seu novo veiculo:\n"+mi.getVeiculo().toString());
           }
           catch (VeiculoInvalidoException e){
           System.out.println(e.getMessage());
           }
           catch (VeiculoJaExisteException e){
           System.out.println(e.getMessage());
           }
       }

       input.close();
       return mi;
   }
   
   /**
    * Método que permite a um motorista independente alterar a localização do seu veículo
    * 
    * @param mi   Motorista independente com sessão iniciada
    * @return   O motorista Independente
    */
   public MotoristaIndependente alterarLocalizacaoVeiculo(MotoristaIndependente mi){
       Scanner input = new Scanner(System.in);
       String aux;
       double x, y;
       
       System.out.println("A localização atual do seu veiculo: "+mi.getVeiculo().getLocalizacao().toString());
       System.out.println("Tem a certeza que deseja alterar a localizacao do seu veiculo?[sim/nao] ");
       aux = input.nextLine();
       if(aux.equals("sim")){
           System.out.println("Coordenada x onde se encontra: ");
           x = input.nextDouble();
       
           System.out.println("Coordenada y onde se encontra: ");
           y = input.nextDouble();

           Espaco2D loc = new Espaco2D(x,y);
           mi = log.alterarLocalizacaoVeiculoMI(mi.getEmail(), loc);
           System.out.println("Localização alterada com sucesso. Nova localização: "+mi.getVeiculo().getLocalizacao().toString());
       }

       input.close();
       return mi;
   }
   
   /**
    * Método que permite a um motorista independente ou de uma empresa de táxis alterar a sua disponibilidade para trabalhar no momento
    * 
    * @param mEmI   Motorista com sessão iniciada
    * @return   O motorista 
    */
   public Motorista alterarDisponibilidade(Motorista mEmI){
       Scanner input = new Scanner(System.in);
       String aux;
       double x, y;
       
       System.out.println("A sua disponibilidade atual é "+mEmI.getDisponibilidade());
       System.out.println("Tem a certeza que deseja alterar a sua disponibilidade?[sim/nao] ");
       aux = input.nextLine();
       if(aux.equals("sim")){
           
           if(mEmI.getDisponibilidade() == true)  mEmI = log.alterarDisponibilidadeMotorista(mEmI.getEmail(),false);
           else mEmI = log.alterarDisponibilidadeMotorista(mEmI.getEmail(),true);
           
           System.out.println("Disponibilidade alterada com sucesso.");
       }
       
       input.close();
       return mEmI;
   }
   
   /**
    * Método que fornece uma lista com os 10 clientes que mais dinheiro gastaram na UMeR até ao momento
    */
   public void top10Clientes(){
       List<Cliente> cli = log.top10clientes();
       
       System.out.println("De momento estes são os 10 clientes mais fieis à aplicação:");
       for(Cliente c : cli){
           System.out.println(c.getNome());
       }
   }
   
   /**
    * Método que fornece uma lista com os 5 motoristas que apresentam mais desvios entre o valor estimado e o valor real faturado nas viagens
    */
   public void top5Motoristas(){
       List<Motorista> mot = log.top5motoristas();
       
       System.out.println("De momento estes são os 5 motoristas com mais desvio nos preços:");
       for(Motorista m : mot){
           System.out.println(m.getNome());
       }
   }
   
   /**
    * Menu que fornece aos utilizadores opções para aceder a determinadas informações das empresas de táxis
    */
   public void empresas(){
       String[] s = {"Lista de Empresas.", "Listagem de Veículos de uma Empresa", "Total faturado por empresa."};
       Menu m = new Menu(s);
       int opt = 0;
       
       do{
           m.executa();
           opt = m.getOpcao();
           
           switch(opt){
               case 1: listaEmpresas();
                       break;
               case 2: listaVeiculosEmpresa();
                       break; 
               case 3: totalFaturadoEmpresa();
                       break;
           }
       }
       while(opt != 0);
   }
   
   /**
    * Método que fornece uma lista com todos os nomes das empresas de táxis registadas na aplicação
    */
   public void listaEmpresas(){
       System.out.println("Empresas parceiras da UMeR: "+log.listagemNomesEmpresas().toString());
   }
   
   /**
    * Método que fornece uma lista com todos os veículos registados numa determinada empresa de táxis
    */
   public void listaVeiculosEmpresa(){
       Scanner input = new Scanner(System.in);
       String nomeEmpresa;
       
       try{
           System.out.println("Digito o nome da empresa que pretende consultar.");
           nomeEmpresa = input.nextLine();
           
           List<Veiculo> veiculos = log.listagemVeiculosEmpresa(nomeEmpresa);
           System.out.println("De momento, em nome da empresa "+nomeEmpresa+", estão inscritos na nossa aplicação os seguintes veículos:\n"+veiculos.toString());
       }
       catch (EmpresaNaoExisteException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
   
   /**
    * Método que fornece o total faturado por uma empresa de táxis num determinado período 
    */
   public void totalFaturadoEmpresa(){
       Scanner input = new Scanner(System.in);
       String nomeEmpresa;
       int anoI, mesI, diaI, anoF, mesF, diaF;
       
       System.out.println("Data de início que pretende considerar.[aaaa mm dd]");
       anoI = input.nextInt();
       mesI = input.nextInt();
       diaI = input.nextInt();
       
       System.out.println("Data final que pretende considerar.[aaaa mm dd]");
       anoF = input.nextInt();
       mesF = input.nextInt();
       diaF = input.nextInt();
       
       try{
           System.out.println("Digito o nome da empresa que pretende consultar.");
           nomeEmpresa = input.nextLine();
           
           double totalFaturado = log.totalFaturadoEmpresa(nomeEmpresa, anoI, mesI, diaI, anoF, mesF, diaF);
           
           System.out.println("No período submetido a empresa "+nomeEmpresa+" faturou "+totalFaturado+" sendo parceira da UMeR.");
       }
       catch (EmpresaNaoExisteException e){
           System.out.println(e.getMessage());
       }
       catch (DataException e){
           System.out.println(e.getMessage());
       }
       
       input.close();
   }
}