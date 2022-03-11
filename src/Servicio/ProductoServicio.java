package Servicio;

import Entidades.Producto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoServicio {
    //Entre <> Primer termino, digo que tipo de dato es la llave, segundo termino tipo de dato que es el OBJETO a guardar

    private HashMap<String, Producto> nuevoMapa; // Creo EL MAPA
    private Scanner leer; // Creo el Scanner para utilizar en toda mi clase

    //Esta es una muy buena practica
    public ProductoServicio() {
        this.nuevoMapa = new HashMap<>(); // Creo el espacio en memoria del MAPA
        this.leer = new Scanner(System.in).useDelimiter("\n");// Cuando se invoca la clase, habilita el flujo de datos
    }

    public void cargarProducto() {

        String respuesta = "";

        do {
            Producto produc = new Producto();
            System.out.println("Ingrese el Producto deseado");
            String pro = (leer.next());
            produc.setNombreProducto(pro);

            System.out.println("Ingrese el precio del Producto");
            Double precio = (leer.nextDouble());
            produc.setPrecioProducto(precio);
            nuevoMapa.put(pro, produc);

            System.out.println("Quiere ingresar otro Producto?");
            respuesta = leer.next();

        } while (respuesta.equalsIgnoreCase("S"));

    }

    public void buscarElimar() {
        System.out.println("");
        System.out.println("Ingrese el producto a Eliminar");
        String aux = leer.next();

        for (Map.Entry<String, Producto> entry : nuevoMapa.entrySet()) {
            String key = entry.getKey();
            Producto value = entry.getValue();
            if (aux.equals(entry.getKey())) {
                nuevoMapa.remove(key);
            } else {
                System.out.println("El producto no se encuentra");
            }
        }
    }

    public void cambiarPrecio() {
        Producto auxi = new Producto();
        System.out.println("");
        System.out.println("Ingrese el producto que quiere cambiar el precio:");
        String aux1 = leer.next();

        for (Map.Entry<String, Producto> aux : nuevoMapa.entrySet()) {
            String key = aux.getKey();
            Producto value = aux.getValue();

            if (aux1.equals(aux.getKey())) {
                System.out.println("Ingrese el nuevo precio");
                auxi.setPrecioProducto(leer.nextDouble());
                auxi.setNombreProducto(key);
                nuevoMapa.put(key, auxi);
            }
        }
        for (Map.Entry<String, Producto> entry : nuevoMapa.entrySet()) {
            System.out.println("Nombre del producto=" + entry.getKey() + ", Precio" + entry.getValue());
        }
    }

    public void mostrarProductos() {
        System.out.println("");
        System.out.println("La lista de todos los productos es:");
        for (Map.Entry<String, Producto> entry : nuevoMapa.entrySet()) {
            System.out.println("Nombre del producto=" + entry.getKey() + ", Precio" + entry.getValue());
        }
    }

    public void menu() {
        ProductoServicio p1 = new ProductoServicio();
        int opcion;
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("");
            System.out.println("Ingrese la operación que desea realizar: ");
            System.out.println("1.Ingresar Producto\n2.Listar Productos\n3.Eliminar Producto\n4.Cambiar Precio\n5.Salir");

            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    p1.cargarProducto();
                    break;
                case 2:
                    p1.mostrarProductos();
                    break;
                case 3:
                    p1.buscarElimar();
                    break;
                case 4:
                    p1.cambiarPrecio();
                    break;
                case 5:
                    salir = true;
                    break;
                //default: System.out.println("Ingrese una opcion valida: ");
            }
        }
    }
}
