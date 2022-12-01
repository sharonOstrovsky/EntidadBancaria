import Entity.Cliente;
import Service.ClienteService;

public class Main {
    public static void main(String[] args) {

        ClienteService serv  = new ClienteService();
        Cliente cliente = serv.crearCliente();
        System.out.println(cliente);

        
    }
}