package Ejercicio_2.Ejer2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	List<Clientes> listaClientes = obtenerClientes();
    	Integer numero = null;
    	System.out.println("Ingrese el numero de cliente: ");
    	Scanner teclado = new Scanner (System.in);
    	String input = teclado.nextLine();

    	try {
    	    numero = Integer.parseInt(input);
    	} catch (NumberFormatException e) {
    	    System.out.println("Error: debe ingresar un número entero válido");
    	}
        
    	Optional<Clientes> cliente = buscaCliente(numero, listaClientes);
        
    	if(cliente.isPresent()) {
    		
    		Optional<String> direccion = obtenerDireccion(cliente);
    		
    		if (direccion.isPresent()) {
    			System.out.println("La dirección es " + direccion.get());
    		}
    		else {
    			System.out.println("La dirección no existe para el cliente " + cliente.get().toString());
    		}
    		
    	}
    	else {
    		System.out.println("No existe el cliente");
    	}
        
        
    }
    
    
    
    private static Optional<String> obtenerDireccion(Optional<Clientes> cliente) {
		return cliente.map(Clientes::getDireccion);
    	
    	
	}



	private static Optional<Clientes> buscaCliente(Integer numero, List<Clientes> listaClientes) {
    	
    	return listaClientes.stream().filter(cliente -> cliente.getNro_cliente().equals(numero)).findFirst();
    	
	}

	private static List<Clientes> obtenerClientes() {
    	List<Clientes> clientes = Arrays.asList(
            new Clientes(1, "Juan", "Pérez", null, "1111-1111"),
            new Clientes(2, "María", "Gómez", "Av. Siempre Viva 742", "2222-2222"),
            new Clientes(3, "Carlos", "López", "Mitre 100", "3333-3333"),
            new Clientes(4, "Lucía", "Martínez", "Belgrano 456", "4444-4444"),
            new Clientes(5, "Ana", "Fernández", "San Martín 789", "5555-5555"),
            new Clientes(6, "Pedro", "Sánchez", null, "3333-4444"),
            new Clientes(7, "Laura", "Díaz", "Corrientes 202", "7777-7777"),
            new Clientes(8, "Diego", "Ramírez", null, "8888-8888"),
            new Clientes(9, "Suscribite", "Todocode", "Internet 404", "9999-9999"),
            new Clientes(10, "Valeria", "Acosta", null, "0000-0000")
    		);
    	return clientes;
    }
    
    
}
