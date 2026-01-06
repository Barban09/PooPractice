package Ejercicio_3.Ejercicio_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
        List<Producto> productos = Arrays.asList(
        		new Producto("Manzana", "frutas", 1, 0.1),
        		new Producto("Leche", "lacteos", 2, 1.2),
        		new Producto("Pan", "panaderia", 5, 1.0),
        		new Producto("Yogur", "lacteos", 3, 1.8),
        		new Producto("Pera", "frutas", 4, 3.0),
        		new Producto("Naranja", "frutas", 6, 2.0),
        		new Producto("Queso", "lacteos", 2, 3.5),
        		new Producto("Harina", "panaderia", 3, 1.5),
        		new Producto("Arroz", "alimentos", 4, 1.8),
        		new Producto("Tomate", "verduras", 5, 1.2),
        		new Producto("Lechuga", "verduras", 2, 0.9),
        		new Producto("Pescado", "pescaderia", 1, 4.0),
        		new Producto("Pollo", "carnes", 3, 5.0),
        		new Producto("Carne", "carnes", 2, 6.5)
       );       		
       
       //Filter products with category "Frutas"
        List<Producto> Frutasa = productos.stream().filter(producto -> producto.getCategoria().equals("frutas")).collect(Collectors.toList());        
        Frutasa.stream().forEach(System.out::println);
        
        //Calculate the total price for the products with category "Lacteos"
        double precio = productos.stream().filter(prod -> prod.getCategoria().equals("lacteos")).mapToDouble(Producto::getPrecio).sum();
        System.out.println("Total lacteos price " + precio);
        
        //Get the product with the lower price
        Producto lowprice = productos.stream().sorted(Comparator.comparing(Producto::getPrecio)).findFirst().orElse(null);
        System.out.println("Lower product price " + lowprice);
        
        //Group products by category
        Map<String, List<Producto>> ProductCategories = productos.stream().collect(Collectors.groupingBy(Producto::getCategoria));
        System.out.println(ProductCategories);
        
        //Calculate average for each category group
        Map<String, Double> CatProm = productos.parallelStream()
        		.collect(Collectors.groupingBy(Producto::getCategoria,Collectors.averagingDouble(Producto::getPrecio)));
        System.out.println(CatProm);
        
        //Get higher price
        String HighPrice = CatProm.entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);
        System.out.println("Category with higher price is" + HighPrice);
    }
}