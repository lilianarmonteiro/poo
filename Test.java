import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String[] args){
               
        /**
        * ESPACO2D
        */
        System.out.println("\n\t \t \t ESPAÇO 2D");
       
        Espaco2D e1 = new Espaco2D(); 
        Espaco2D e2 = new Espaco2D(12.4,88.9999);
        Espaco2D e3 = new Espaco2D(e1);
    
        boolean q = e3.equals(e1);
        boolean qq = e2.equals(e3);
        Espaco2D e4 = e2.clone();
        e4.setX(2);
        e4.setY(2);
    
        System.out.println("(0.0, 0.0): "+e1.toString());
        System.out.println("(12.4,88.9999): "+e2.toString());
        System.out.println("(0.0, 0.0): "+e3.toString());
        System.out.println("(2, 2): "+e4.toString());
        System.out.println("equal (true): "+q+"\nequal (false): "+qq);  
        System.out.println("distancia entre (0,0) e (2,2): "+e4.distancia(e1)+" (2.8284)");
        
        
        /**
        * VEICULO carro + mota + monovolume
        */
        System.out.println("\n\t \t \t VEICULO");
       
        Carro car1 = new Carro();
        Carro car2 = new Carro("12-OO-12", 5, 50.4, 1.5, 90, e4, true);
        Carro car3 = new Carro(car1);

        q = car3.equals(car1);
        qq = car2.equals(car3);
        Carro car4 = car2.clone();
        car4.setMatricula("23-TT-44");
        car4.setVelocidade(46.1);
        car4.setLocalizacao(e2);
        car4.setNrLugares(4);
        boolean qqq = car2.equals(car4);
        
        System.out.println("ND:\n"+car1.toString());
        System.out.println("12-OO-12, 5, 50.4, 1.5, 90, (2,2):\n"+car2.toString());
        System.out.println("23-TT-44, 4, 46.1, 1.5, 90, (12.4,88.9999):\n"+car4.toString());
        System.out.println("equal (true): "+q+"\nequal (false): "+qq+"\nequal (false): "+qqq);      
        
        /**
        * VIAGEM
        */
        System.out.println("\n\t \t \t VIAGENS");
       
        Viagem vi1 = new Viagem();
        Viagem vi2 = new Viagem(LocalDate.of(2017,4,26),LocalTime.of(21,15),e2,e4,car2,11,5,14.5,51);
        Viagem vi3 = new Viagem(vi1);
    
        q = vi3.equals(vi1);
        qq = vi2.equals(vi3);
        Viagem vi4 = vi2.clone();
        vi4.setData(LocalDateTime.of(2017,5,12,22,24));
        vi4.setVeiculo(new Mota());
        vi4.setKms(12.5);
        vi4.setPartida(e4);
        vi4.setPrecoEstViagem(14);
           
        System.out.println("ND:\n"+vi1.toString());
        System.out.println("(2017,4,26), (21,15), (12.4,88.9999), (2,2), car2, 11, 5, 14.5, 51:\n"+vi2.toString());
        System.out.println("(2017,5,12), (22,24), (2,2), (2,2), motaND, 12.5, 5, 14.5, 14:\n"+vi4.toString());
        System.out.println("equal (true): "+q+"\nequal (false): "+qq);
        
        Veiculo v1 = vi2.getVeiculo();
        System.out.println("car2:\n"+v1.toString());
        Veiculo v2 = vi4.getVeiculo();
        System.out.println("motaND:\n"+v2.toString());
        
        
        /**
        * VIAGEM DO CLIENTE
        */
        System.out.println("\n\t \t \t VIAGENS DO CLIENTE");
       
        ViagemCliente vc1 = new ViagemCliente();
        ViagemCliente vc2 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,14.5,51,"Alberto",77);
        ViagemCliente vc3 = new ViagemCliente(vc1);
       
        q = vc3.equals(vc1);
        qq = vc2.equals(vc3);
        ViagemCliente vc4 = vc2.clone();
        vc4.setData(LocalDateTime.of(2019,5,12,22,24));
        vc4.setNomeMotorista("Joao");
        vc4.setPrecoRealViagem(50);
        
        System.out.println("ND:\n"+vc1.toString());
        System.out.println("(2017,5,22), (22,30), (12.4,88.9999), (2,2), car2, 11, 5, 14.5, 51, Alberto, 77:\n"+vc2.toString());
        System.out.println("(2019,5,22), (22,30), (12.4,88.9999), (2,2), car2, 11, 5, 50, 51, Joao, 77:\n"+vc4.toString());
        System.out.println("equal (true): "+q+"\nequal (false): "+qq);
        
        /**
        * CLIENTE
        */
        System.out.println("\n\t \t \t CLIENTE");
        
        Set<ViagemCliente> auxC = new TreeSet<>();
        auxC.add(vc4);
        auxC.add(vc1);
        auxC.add(vc2);
       
        Cliente cl1 = new Cliente();
        Cliente cl2 = new Cliente("Joel","joca@hotmail.com","joquinha97","Rua dos Padres nº3, Amares","06-09-1997");
        Cliente cl3 = new Cliente(cl1);
        cl2.setHistorico(auxC);
    
        q = cl3.equals(cl1);
        qq = cl2.equals(cl3);
        Cliente cl4 = cl2.clone();
        cl4.setPassword("aaaaahhy");
        cl4.setNascimento("22-04-1658");
        
        vc3.setData(LocalDateTime.of(2019,6,23,21,15));
        vc3.setVeiculo(car2);
        vc3.setNomeMotorista("Joao RICARDO");
        vc3.setPartida(e4);
        
        cl3.addViagemCliente(vc3);
        cl2.addViagemCliente(vc2); //nao add porque ja existe
        cl2.removeViagemCliente(vc1);
        cl3.addViagensCliente(auxC);
           
        System.out.println("ND:\n"+cl1.toString());
        System.out.println("Joel, joca@hotmail.com, joquinha97, Rua dos Padres nº3 Amares, 06-09-1997, [vc2,vc4]:\n"+cl2.toString());
        System.out.println("ND, [viagem:vc1,vc2,vc4,JoaoRicardo]:\n"+cl3.toString());
        System.out.println("Joel, joca@hotmail.com, aaaaahhy, Rua dos Padres nº3 Amares, 22-04-1658, [vc1,vc2,vc4]:\n"+cl4.toString());
        System.out.println("equal (true): "+q+"\nequal (false): "+qq);
        
        
        /**
        * MOTORISTA
        */
        System.out.println("\n\t \t \t MOTORISTA");
        
        Set<Viagem> auxM = new TreeSet<>();
        auxM.add(vi4);
        auxM.add(vi1);
        auxM.add(vi2);
       
        Motorista m1 = new Motorista();
        Motorista m2 = new Motorista("Alberto","aaaaa@hotmail.com","a55555","Rua dos Padres nº20, Ferreiros","06-10-1990",true,50);
        Motorista m4 = m2.clone();
        m4.setNome("Pedro");
        m4.setDisponibilidade(false);
        
        
        m2.setHistorico(auxM);
        m2.setQtViagens(auxM.size());
        double kmT=0;
        for(Viagem v: auxM){
            kmT += v.getKms();
        }
        m2.setKmsTotal(kmT); //23.5
        m2.setClassificacaoMedia(86);
        
        Motorista m3 = new Motorista(m2);
        q = m3.equals(m1);
        qq = m2.equals(m3);
        
           
        System.out.println("ND:\n"+m1.toString());
        System.out.println("Alberto, aaaaa@hotmail.com, a55555, Rua dos Padres nº20 Ferreiros, 06-10-1990, [vi1,vi2,vi4], 23.5, true, 3, 86, 50:\n"+m2.toString());
        System.out.println("Pedro, aaaaa@hotmail.com, a55555, Rua dos Padres nº20 Ferreiros, 06-10-1990, ND, 0, false, 0, 0, 50:\n"+m4.toString());
        System.out.println("equal (false): "+q+"\nequal (true): "+qq);
        
        
        /**
        * MOTORISTA INDEPENDENTE
        */
        System.out.println("\n\t \t \t MOTORISTA INDEPENDENTE");
        
        MotoristaIndependente mi1 = new MotoristaIndependente();
        MotoristaIndependente mi2 = new MotoristaIndependente("Joel","joca@hotmail.com","joquinha97","Rua dos Padres nº3, Amares","06-09-1997",true,45,car2);
        MotoristaIndependente mi4 = mi2.clone();
        mi4.setVeiculo(car4);
        mi4.setDisponibilidade(false);
            
        mi2.setHistorico(auxM);
        mi2.setQtViagens(auxM.size());
        kmT=0;
        for(Viagem v: auxM){
            kmT += v.getKms();
        }
        mi2.setKmsTotal(kmT); //23.5
        mi2.setClassificacaoMedia(86);
        
        MotoristaIndependente mi3 = new MotoristaIndependente(mi2);
        q = mi3.equals(mi1);
        qq = mi2.equals(mi3);
           
        System.out.println("ND:\n"+mi1.toString());
        System.out.println("Joel, joca@hotmail.com, joquinha97, Rua dos Padres nº3 Amares, 06-09-1997, [vi1,vi2,vi4], 23.5, true, 3, 86, 45, car2"+mi2.toString());
        System.out.println("Joel, joca@hotmail.com, joquinha97, Rua dos Padres nº3 Amares, 06-09-1997, ND, 0, false, 0, 0, 45, car4:\n"+mi4.toString());
        System.out.println("equal (false): "+q+"\nequal (true): "+qq);
        
        /**
        * EMPRESA DE TAXIS
        */
        System.out.println("\n\t \t \t EMPRESA DE TAXIS");
        
        EmpresaTaxis emp1 = new EmpresaTaxis();
        EmpresaTaxis emp2 = new EmpresaTaxis("Taxis Ricardo");

        //Hash Motoristas
        Map<String,Motorista> motEmp = new HashMap<String,Motorista>();
        Motorista mEmp1 = new Motorista("Carlos","calitos@hotmail.com","a55555","Rua dos Padres nº20, Ferreiros","06-10-1990",true,50);
        motEmp.put(mEmp1.getEmail(),mEmp1.clone());
        Motorista mEmp2 = new Motorista("Rita", "ritinha@hotmail.com","a55555","Rua dos Padres nº20, Ferreiros","06-10-1990",true,50);
        motEmp.put(mEmp2.getEmail(),mEmp2.clone());
        
        //Hash Veiculos
        Map<String,Veiculo> veiEmp = new HashMap<String,Veiculo>();
        Espaco2D eEmp = new Espaco2D(12,6);
        Carro carEmp = new Carro("24-CC-12", 4, 50.4, 1.5, 90, eEmp, true);
        veiEmp.put(carEmp.getMatricula(),carEmp.clone());
        Monovolume monoEmp = new Monovolume("24-MN-12", 9, 50.4, 1.5, 90, eEmp, true);
        veiEmp.put(monoEmp.getMatricula(),monoEmp.clone());
        Mota motaEmp = new Mota("24-MT-12", 2, 50.4, 1.5, 90, eEmp, true);
        veiEmp.put(motaEmp.getMatricula(),motaEmp.clone());
        
        emp2.setVeiculos(veiEmp);
        emp2.setMotoristas(motEmp);
        
        EmpresaTaxis emp3 = new EmpresaTaxis(emp2);
        EmpresaTaxis emp4 = emp2.clone();
        
        q = emp3.equals(emp2);
        qq = emp4.equals(emp2);
        
        emp4.setNome("Taxis Aventura");
        Motorista mEmp4 = new Motorista("Gira","gira@hotmail.com","a55555","Rua dos Padres nº20, Ferreiros","06-10-1990",true,50);
        emp4.addMotorista(mEmp4);
        Carro carEmp4 = new Carro("24-IS-12", 4, 50.4, 1.5, 90, eEmp, true);
        emp4.addVeiculo(carEmp4);
        emp4.removeMotorista(mEmp1);
        emp4.removeMotorista(mEmp2);
        emp4.removeVeiculo(carEmp);
        emp4.removeVeiculo(monoEmp);
        emp4.removeVeiculo(motaEmp);
        
        qqq = emp4.equals(emp2);
           
        System.out.println("ND:\n"+emp1.toString());
        System.out.println("Taxis Ricardo: carlos, rita, CC, MN, MT;\n"+emp2.toString());
        System.out.println("Taxis Aventura: gira, IS;\n"+emp4.toString());
        System.out.println("equal (true): "+q+"\nequal (true): "+qq+"\nequal (false): "+qqq);
        
        
        /**
        * UMeR
        */
        System.out.println("\n\t \t \t UMER");
        
        UMeR listaND = new UMeR();
        UMeR lista = new UMeR();
        
        //associa empresas
        Map<String,EmpresaTaxis> emp = new HashMap<String,EmpresaTaxis>();
        emp.put(emp2.getNome(),emp2.clone());
        emp.put(emp4.getNome(),emp4.clone());
        lista.setEmpresas(emp);
        
        //associa utilizadores
        Map<String,Utilizador> utl = new HashMap<String,Utilizador>();
        Cliente utl1 = new Cliente("Joel","joca@hotmail.com","joquinha97","Rua dos Padres nº3, Amares","06-09-1997");
        Cliente utl2 = new Cliente("Joana","joaninha@hotmail.com","joquinha97","Rua dos Padres nº3, Amares","06-09-1997");
        Carro carroUtl3 = new Carro("12-CC-12", 4, 50, 4, 90, e4, true);
        MotoristaIndependente utl3 = new MotoristaIndependente("Ana","aninhas@hotmail.com","aninhas97","Rua dos Padres nº3, Amares","06-09-1997",true,20,carroUtl3);
        Mota motaUtl4 = new Mota("12-MT-12", 2, 40, 4, 75, e4, true);
        MotoristaIndependente utl4 = new MotoristaIndependente("Jorge","jorge@hotmail.com","joca","Rua dos Padres nº3, Amares","06-09-1997",true,66,motaUtl4);
        utl.put(utl1.getEmail(),utl1.clone());
        utl.put(utl2.getEmail(),utl2.clone());
        utl.put(utl3.getEmail(),utl3.clone());
        utl.put(utl4.getEmail(),utl4.clone());
        lista.setUtilizadores(utl);

        //System.out.println(listaND.toString());
        //System.out.println(lista.toString());

        listaND = lista.clone();
        q = listaND.equals(lista);
        System.out.println("equal (true): "+q);
        
        listaND = new UMeR(lista);
        q = listaND.equals(lista);
        System.out.println("equal (true): "+q);
        
        Cliente utl5 = new Cliente("Luisa","joaninha@hotmail.com","luisinha97","Rua dos Padres nº3, Amares","06-09-1997");
        try{
            lista.addUtilizador(utl5); //erro - email cliente
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        try{
            utl5.setEmail("aninhas@hotmail.com");
            lista.addUtilizador(utl5); //erro - email MI
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        try{
            utl5.setEmail("gira@hotmail.com");
            lista.addUtilizador(utl5); //erro - email M
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        try{
            utl5.setEmail("luisinha@hotmail.com"); //funciona
            lista.addUtilizador(utl5);
            }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(lista.toString());
          
        lista.removeUtilizador(m2); //nao existe, nao remove
        lista.removeUtilizador(utl5); //exite, remove
        //System.out.println(lista.toString());
        
        EmpresaTaxis emp5 = new EmpresaTaxis("Taxis Ricardo");
        Motorista mEmp5 = new Motorista("Sara","sarinha@hotmail.com","a55555","Rua dos Padres nº20, Ferreiros","06-10-1990",true,50);
        emp5.addMotorista(mEmp5);
        Carro carEmp5 = new Carro("33-33-33", 4, 50.4, 1.5, 90, eEmp, true);
        emp5.addVeiculo(carEmp5);
        
        try{
            lista.addEmpresa(emp5); //nao funciona
        }
        catch (EmpresaJaExisteException e) {
            System.out.println(e.getMessage());
        }
        try{
            emp5.setNome("Taxis Ribeiro");
            lista.addEmpresa(emp5); //funciona
        }
        catch (EmpresaJaExisteException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(lista.toString());

        
        lista.removeEmpresa(emp5);
        //System.out.println(lista.toString());
        
        
        Cliente novoCl = new Cliente();
        try{
            novoCl = (Cliente) lista.novoRegistoCliente("Laura","lau@hotmail.com","24134","Rua das laus nº20","2019-22-33");
            //vai funcionar
            }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        try{
            novoCl = (Cliente) lista.novoRegistoCliente("LaurAAAA","gira@hotmail.com","24134","Rua das laus nº20","2019-22-33");
            //vai dar erro
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(lista.toString());
        
        
        MotoristaIndependente novoMI = new MotoristaIndependente();
        try{
            novoMI = (MotoristaIndependente) lista.novoRegistoMotoristaIndependente("LauraMI","lauMI@hotmail.com","24134","Rua das laus nº20","2019-22-33",car2);
            //vai funcionar
            }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        try{
            novoMI = (MotoristaIndependente) lista.novoRegistoMotoristaIndependente("LaurAAAA","gira@hotmail.com","24134","Rua das laus nº20","2019-22-33",car2);
            //vai dar erro
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(lista.toString());
        
        
        Motorista novoM = new Motorista();
        try{
            novoM = (Motorista) lista.novoRegistoMotorista("Taxis Ricardo","Teresa","tes@hotmail.com","24134","Rua das laus nº20","2019-22-33", true);
            //vai funcionar
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        catch (EmpresaNaoExisteException e) {
            System.out.println(e.getMessage());
        }
        try{
            novoM = (Motorista) lista.novoRegistoMotorista("Taxis China","Teresa","tes@hotmail.com","24134","Rua das laus nº20","2019-22-33", true);//vai dar erro
            //erro 2
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        catch (EmpresaNaoExisteException e) {
            System.out.println(e.getMessage());
        }
        try{
            novoM = (Motorista) lista.novoRegistoMotorista("Taxis Ricardo","Teresa","joca@hotmail.com","24134","Rua das laus nº20","2019-22-33", false);//vai dar erro
            //erro 1
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage());
        }
        catch (EmpresaNaoExisteException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(lista.toString());
        
        
        lista.removeMotoristaEmpresa(novoM); //exite, remove
        lista.removeMotoristaEmpresa(m2); //nao existe, nao remove
        //System.out.println(lista.toString());
        
        
         try{
            lista.tipoVeiculo("Mot12039", "22-11-24", 2, 60, 2.1, 3.1, 5.6, false); //erro 1ºe
        }
        catch (VeiculoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        catch (VeiculoJaExisteException e) {
            System.out.println(e.getMessage());
        }
        
        try{
            lista.tipoVeiculo("Mota", "12-OO-12", 2, 60, 2.1, 3.1, 5.6, false); //erro 2ºe
        }
        catch (VeiculoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        catch (VeiculoJaExisteException e) {
            System.out.println(e.getMessage());
        }
        Mota veiAux = new Mota();
        try{
            veiAux = (Mota) lista.tipoVeiculo("Mota", "44-MT-44", 2, 60, 2.1, 3.1, 5.6, false);
            //System.out.println(veiAux.toString());
            lista.adicionaVeiculoEmpresa("Taxis YOLO",veiAux);
            //erro 3
        }
        catch (VeiculoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        catch (VeiculoJaExisteException e) {
            System.out.println(e.getMessage());
        }
        catch (EmpresaNaoExisteException e) {
            System.out.println(e.getMessage());
        }

        try{
            veiAux = (Mota) lista.tipoVeiculo("Mota", "44-MT-44", 2, 60, 2.1, 3.1, 5.6, true);
            lista.adicionaVeiculoEmpresa("Taxis Aventura",veiAux);
            //System.out.println(veiAux.toString());
            //funciona
        }
        catch (VeiculoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        catch (VeiculoJaExisteException e) {
            System.out.println(e.getMessage());
        }
        catch (EmpresaNaoExisteException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(lista.toString());
        

        try{
            lista.validarAcesso("brincadeira@ggg.com", "24134");
            //erro - mail mal
        }  
        catch (LoginException e){
            System.out.println(e.getMessage());
        }
        try{
            lista.validarAcesso("lau@hotmail.com", "34");
            //erro - pass mal
        }  
        catch (LoginException e){
            System.out.println(e.getMessage());
        }
        try{
            Utilizador u = lista.validarAcesso("lau@hotmail.com", "24134");
            //System.out.println(u.toString());
            //System.out.println(lista.validarAcesso("calitos@hotmail.com","a55555"));
            //System.out.println(lista.validarAcesso( "jorge@hotmail.com","joca"));
            //funciona
        }  
        catch (LoginException e){
            System.out.println(e.getMessage());
        }


        try{
            Veiculo v = lista.veiculoMaisProximo(1,12,6); //funciona
            //System.out.println(v.toString());
            //testado dps com todos dis=false, da o erro 1
        }  
        catch (NenhumVeiculoDisponivelException e){
            System.out.println(e.getMessage());
        }
        try{
            lista.veiculoMaisProximo(10,20,20); //erro
        }  
        catch (NenhumVeiculoDisponivelException e){
            System.out.println(e.getMessage());
        }
        

        try{
            Veiculo vAux = lista.veiculoEspecificoMI("12-CC-12"); //funciona
            //System.out.println(vAux.toString());
        }  
        catch (VeiculoNaoExisteException e){
            System.out.println(e.getMessage());   
        }      
        catch (MotoristaIndisponivelException e){
            System.out.println(e.getMessage()); 
        }         
        
        try{
            Veiculo vAux = lista.veiculoEspecificoMI("22-XX-24"); //erro 1ºe
        }  
        catch (VeiculoNaoExisteException e){
            System.out.println(e.getMessage());   
        }      
        catch (MotoristaIndisponivelException e){
            System.out.println(e.getMessage()); 
        }   
        
        try{
            Mota mot = (Mota) lista.tipoVeiculo("Mota", "22-XX-24", 2, 60, 2.1, 3.1, 5.6, true);
            MotoristaIndependente novoMI3 = (MotoristaIndependente) lista.novoRegistoMotoristaIndependente("Ricardo","riMI@hotmail.com","24134","Rua das laus nº20","2019-22-33",mot);
            Veiculo vAux = lista.veiculoEspecificoMI("22-XX-24"); //erro 2ºe
        }  
        catch (VeiculoNaoExisteException e){
            System.out.println(e.getMessage());   
        }      
        catch (MotoristaIndisponivelException e){
            System.out.println(e.getMessage()); 
        }   
        catch (VeiculoInvalidoException e) {
            System.out.println(e.getMessage()); 
        }
        catch (VeiculoJaExisteException e) {
            System.out.println(e.getMessage()); 
        }
        catch (RegistoException e) {
            System.out.println(e.getMessage()); 
        }
        
        
        try{
            Veiculo vAux = lista.veiculoEspecificoEmpresa("24-CC-12"); //funciona
            System.out.println(vAux.toString());
            //testado dps com dis=false, da erro 2
        }  
        catch (VeiculoNaoExisteException e){
            System.out.println(e.getMessage());   
        }      
        catch (VeiculoEmpresaIndisponivelException e){
            System.out.println(e.getMessage()); 
        }         
        
        try{
            Veiculo vAux = lista.veiculoEspecificoEmpresa("22-XX-24"); //erro 1ºe
        }  
        catch (VeiculoNaoExisteException e){
            System.out.println(e.getMessage());   
        }      
        catch (VeiculoEmpresaIndisponivelException e){
            System.out.println(e.getMessage()); 
        }         
        
        
        try{
            Motorista m = lista.motoristaEmpresaDisponivel("Taxis Ricardo"); //funciona
            System.out.println(m.toString());
        }
        catch (MotoristaIndisponivelException e){
            System.out.println(e.getMessage()); 
        }  
        try{
            Motorista m = lista.motoristaEmpresaDisponivel("Taxis Aventura"); //funciona
            System.out.println(m.toString());
            //dps testado tds a false, erro 1
        }
        catch (MotoristaIndisponivelException e){
            System.out.println(e.getMessage()); 
        } 
        
        
        System.out.println(lista.nomeEmpresaPeloVeiculo(car2)); //null
        System.out.println(lista.nomeEmpresaPeloVeiculo(motaEmp));
        System.out.println(lista.nomeEmpresaPeloVeiculo(carEmp4));
        
        
        lista.efetuarViagem(carEmp4, mEmp4);
        lista.efetuarViagem(carEmp, mEmp1);
        lista.efetuarViagem(motaEmp, mEmp1);
        lista.efetuarViagem(carroUtl3, utl3);
        //System.out.println(lista.toString());
        
        
        //double tempoEst = lista.tempoEstimado(2, 2, 4, 4,car2);
        //double tempoReal = lista.tempoReal(tempoEst,car2);
        //double custoEst = lista.custoEstimado(2, 2, 4, 4,car2);
        //double custoReal = lista.custoReal(tempoEst, tempoReal, custoEst);
        try{
            lista.viagemFinalizada(utl1, 2020,4,26,21,15, 4, 4, 7, 7, utl3, carroUtl3, 10, 15, 15, 20, 70);
            lista.viagemFinalizada(utl1, 2020,5,06,14,06, 77, 77, 7, 7, mEmp4, carEmp4, 100, 150, 130, 150, 75);
            lista.viagemFinalizada(utl2, 2020,12,12,21,15, 2,2, 13, 21, mEmp1, carEmp, 10, 15, 15, 15, 70);
            lista.viagemFinalizada(utl2, 2021,01,12,21,15, 2,2, 13, 21, mEmp1, motaEmp, 10, 15, 15, 15, 80);
        }
        catch(DataException e){
            System.out.println(e.getMessage()); 
        }
        //System.out.println(lista.toString());
   
        
        try{
            List<Viagem> aux = lista.registoViagens(utl1.getEmail(),2014,5,22, 2021,5,22);
            //System.out.println("\n\n\n"+aux.toString());
            aux = lista.registoViagens(utl3.getEmail(),2017,5,22, 2021,5,22);
            //System.out.println("\n\n\n"+aux.toString());
            aux = lista.registoViagens(mEmp1.getEmail(),2017,5,22, 2021,5,22);
            //System.out.println("\n\n\n"+aux.toString());
            aux = lista.registoViagens(mEmp4.getEmail(), 2017,5,22, 2021,5,22);
            //System.out.println("\n\n\n"+aux.toString());
            aux = lista.registoViagens(novoMI.getEmail(), 2017,5,22, 2021,5,22);
            //System.out.println("\n\n\n"+aux.toString());
        }
        catch(DataException e){
            System.out.println(e.getMessage()); 
        }

        
        try{
            System.out.println(lista.totalFaturadoVeiculoMI("12-CC-12", 2017,5,22, 2021,5,22));
            //funciona
        }
        catch(DataException e){
            System.out.println(e.getMessage()); 
        }
        
        
        try{
            System.out.println(lista.totalFaturadoEmpresa("Taxis China", 2017,5,22, 2021,5,22));
            //erro 2
        }
        catch(DataException e){
            System.out.println(e.getMessage()); 
        }
        catch(EmpresaNaoExisteException e){
            System.out.println(e.getMessage()); 
        }
        
        try{
            System.out.println(lista.totalFaturadoEmpresa("Taxis Ricardo", 2017,5,22, 2017,2,22));
            //erro 1
        }
        catch(DataException e){
            System.out.println(e.getMessage()); 
        }
        catch(EmpresaNaoExisteException e){
            System.out.println(e.getMessage()); 
        }
        
        try{
            System.out.println(lista.totalFaturadoEmpresa("Taxis Ricardo", 2017,5,22, 2021,5,22));
            //funciona
        }
        catch(DataException e){
            System.out.println(e.getMessage()); 
        }
        catch(EmpresaNaoExisteException e){
            System.out.println(e.getMessage()); 
        }
        
        
        System.out.println(lista.listagemVeiculosMI());
        
        
        try{
            System.out.println(lista.listagemVeiculosEmpresa("Taxis Aventura"));
            //funciona
        }
        catch(EmpresaNaoExisteException e){
            System.out.println(e.getMessage()); 
        }
        
        
        System.out.println(lista.listagemNomesEmpresas().toString());
        
        
        try{
            lista.alterarVeiculoMI("jorge@hotmail.com","Monovolume", "44-PP-24", 9, 44, 1.5, 10, 9.5, true);
        }
        catch (VeiculoInvalidoException e) {
            System.out.println("Classe de veículo inválida, tente novamente.");
        }
        catch (VeiculoJaExisteException e) {
            System.out.println("Matrícula já existente.");
        }
        try{
            lista.alterarVeiculoMI("jorge@hotmail.com","Mlume", "44-PP-24", 9, 44, 1.5, 10, 9.5, true);
            //erro 1ºe
        }
        catch (VeiculoInvalidoException e) {
            System.out.println("Classe de veículo inválida, tente novamente.");
        }
        catch (VeiculoJaExisteException e) {
            System.out.println("Matrícula já existente.");
        }
        try{
            lista.alterarVeiculoMI("jorge@hotmail.com","Monovolume", "22-XX-24", 9, 44, 1.5, 10, 9.5, true);
            //erro 2ºe
        }
        catch (VeiculoInvalidoException e) {
            System.out.println("Classe de veículo inválida, tente novamente.");
        }
        catch (VeiculoJaExisteException e) {
            System.out.println("Matrícula já existente.");
        }
        //System.out.println(lista.toString());
        
        
        Espaco2D locNova = new Espaco2D(3020,100);
        lista.alterarLocalizacaoVeiculoMI(utl3.getEmail(), locNova);
        //System.out.println(lista.toString());
        
        
        lista.alterarDisponibilidadeMotorista(utl3.getEmail(), false);
        lista.alterarDisponibilidadeMotorista(mEmp4.getEmail(), false);
        System.out.println(lista.toString());
        
        
        System.out.println(lista.top10clientes().toString());
        System.out.println(lista.top5motoristas().toString());
        
        /*
        List<Cliente> listaCliente = lista.top10clientes();
        //System.out.println(listaCliente.toString());
        
        UMeR listaVazia = new UMeR();
        Map<String,Utilizador> utlVazio = new HashMap<String,Utilizador>();
        listaCliente = listaVazia.top10clientes();
        //System.out.println(listaCliente.toString());
        
        UMeR listaTop = new UMeR();
        Map<String,Utilizador> utlTop = new HashMap<String,Utilizador>();
        Set<Viagem> auxTop = new TreeSet<>();
        
        Cliente cliente1 = new Cliente("1","J1","J","J","06-09-1997");
        ViagemCliente vcliente1 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,10,50,"Alberto",77);
        auxTop.add(vcliente1);
        cliente1.setHistorico(auxTop);
        auxTop.remove(vcliente1);
        
        Cliente cliente2 = new Cliente("2","J2","J","J","06-09-1997");
        ViagemCliente vcliente2 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,20,50,"Alberto",77);
        auxTop.add(vcliente2);
        cliente2.setHistorico(auxTop);
        auxTop.remove(vcliente2);
        
        Cliente cliente3 = new Cliente("3","J3","J","J","06-09-1997");
        ViagemCliente vcliente3 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,30,50,"Alberto",77);
        auxTop.add(vcliente3);
        cliente3.setHistorico(auxTop);
        auxTop.remove(vcliente3);
        
        Cliente cliente4 = new Cliente("4","J4","J","J","06-09-1997");
        ViagemCliente vcliente4 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,40,50,"Alberto",77);
        auxTop.add(vcliente4);
        cliente4.setHistorico(auxTop);
        auxTop.remove(vcliente4);
        
        Cliente cliente5 = new Cliente("5","J5","J","J","06-09-1997");
        ViagemCliente vcliente5 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,50,50,"Alberto",77);
        auxTop.add(vcliente5);
        cliente5.setHistorico(auxTop);
        auxTop.remove(vcliente5);
        
        Cliente cliente6 = new Cliente("6","J6","J","J","06-09-1997");
        ViagemCliente vcliente6 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,60,50,"Alberto",77);
        auxTop.add(vcliente6);
        cliente6.setHistorico(auxTop);
        auxTop.remove(vcliente6);
        
        Cliente cliente7 = new Cliente("7","J7","J","J","06-09-1997");
        ViagemCliente vcliente7 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,70,50,"Alberto",77);
        auxTop.add(vcliente7);
        cliente7.setHistorico(auxTop);
        auxTop.remove(vcliente7);

        Cliente cliente8 = new Cliente("8","J8","J","J","06-09-1997");
        ViagemCliente vcliente8 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,80,50,"Alberto",77);
        auxTop.add(vcliente8);
        cliente8.setHistorico(auxTop);
        auxTop.remove(vcliente8);
        
        Cliente cliente9 = new Cliente("9","J9","J","J","06-09-1997");
        ViagemCliente vcliente9 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,90,50,"Alberto",77);
        auxTop.add(vcliente9);
        cliente9.setHistorico(auxTop);
        auxTop.remove(vcliente9);
        
        Cliente cliente10 = new Cliente("10","J10","J","J","06-09-1997");
        ViagemCliente vcliente10 = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,100,50,"Alberto",77);
        auxTop.add(vcliente10);
        cliente10.setHistorico(auxTop);
        auxTop.remove(vcliente10);

        Cliente clienteLO= new Cliente("LO","LO","J","J","06-09-1997");
        ViagemCliente vclienteLO = new ViagemCliente(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,100,50,"Alberto",77);
        auxTop.add(vclienteLO);
        clienteLO.setHistorico(auxTop);
        auxTop.remove(vclienteLO);
        
        utlTop.put(cliente1.getEmail(),cliente1);
        utlTop.put(cliente2.getEmail(),cliente2);
        utlTop.put(cliente3.getEmail(),cliente3);
        utlTop.put(cliente4.getEmail(),cliente4);
        utlTop.put(cliente5.getEmail(),cliente5);
        utlTop.put(cliente6.getEmail(),cliente6);
        utlTop.put(cliente7.getEmail(),cliente7);
        utlTop.put(cliente8.getEmail(),cliente8);
        utlTop.put(cliente9.getEmail(),cliente9);
        utlTop.put(cliente10.getEmail(),cliente10);
        utlTop.put(clienteLO.getEmail(),clienteLO);
        
        listaTop.setUtilizadores(utlTop);
        listaCliente = listaTop.top10clientes();
        System.out.println(listaCliente.toString());
        */
       
        /*
        List<Motorista> listaMotorista = lista.top5motoristas();
        //System.out.println(listaMotorista.toString());
        
        listaMotorista = listaVazia.top5motoristas();
        //System.out.println(listaMotorista.toString());
        
        Motorista mot1 = new Motorista("1","1","x","x","x",true,100);
        Viagem vmot1 = new Viagem(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,  10,101);
        Viagem vmot1_1 = new Viagem(LocalDate.of(2018,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,  1,2);
        mot1.setQtViagens(1);
        auxTop.add(vmot1);
        auxTop.add(vmot1_1);
        mot1.setHistorico(auxTop);
        auxTop.remove(vmot1);
        auxTop.remove(vmot1_1);
        
        Motorista mot2 = new Motorista("2","2","x","x","x",true,100);
        Viagem vmot2 = new Viagem(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,  10,101);
        mot2.setQtViagens(1);
        auxTop.add(vmot2);
        mot2.setHistorico(auxTop);
        auxTop.remove(vmot2);
        
        Motorista mot3 = new Motorista("3","3","x","x","x",true,100);
        Viagem vmot3 = new Viagem(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,  15,100);
        mot3.setQtViagens(1);
        auxTop.add(vmot3);
        mot3.setHistorico(auxTop);
        auxTop.remove(vmot3);
        
        Motorista mot4 = new Motorista("4","4","x","x","x",true,100);
        Viagem vmot4 = new Viagem(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,  20,100);
        mot4.setQtViagens(1);
        auxTop.add(vmot4);
        mot4.setHistorico(auxTop);
        auxTop.remove(vmot4);
        
        Motorista mot5 = new Motorista("5","5","x","x","x",true,100);
        Viagem vmot5 = new Viagem(LocalDate.of(2017,5,22),LocalTime.of(22,30),e2,e4,car2,11,5,  50,100);
        mot5.setQtViagens(1);
        auxTop.add(vmot5);
        mot5.setHistorico(auxTop);
        auxTop.remove(vmot5);

        utlTop.put(mot1.getEmail(),mot1);
        utlTop.put(mot2.getEmail(),mot2);
        utlTop.put(mot3.getEmail(),mot3);
        utlTop.put(mot4.getEmail(),mot4);
        utlTop.put(mot5.getEmail(),mot5);
        
        listaTop.setUtilizadores(utlTop);
        listaMotorista = listaTop.top5motoristas();
        System.out.println(listaMotorista.toString());
        */
        
        
    }
}