
package com.mycompany.tallerarraylist;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.InputMismatchException;

public class Menu {
    private Scanner leer;
    private ArrayList<Integer> lista;
    
    public Menu()
    {
        leer = new Scanner(System.in);
        lista = new ArrayList<Integer>();
    }
    
    public void MostrarMenu()
    {
        System.out.println("====== MOSTRANDO MENU ======");
        System.out.println("1. Breve definicion ArrayList");
        System.out.println("2. 6 diferencias ArrayList y arreglo");
        System.out.println("3. Metodos ArrayList");
        System.out.println("4. Conclusiones");
        System.out.println("5. Funcionalidades ArrayList");
        System.out.println("6. Salir");
        OpcionMenu(ValidarOpcion(6));
    }
    
    private void MostrarSubMenu()
    {
        System.out.println("====== MOSTRANDO FUNCIONALIDADES ======");
        System.out.println("1. Agregar elemento");
        System.out.println("2. Eliminar elemento");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Mostrar array");
        System.out.println("5. Volver al menu");
        Funcionalidades(ValidarOpcion(5));
    }
    
    private void OpcionMenu(int opcion)
    {
        boolean continuar = true;
        switch (opcion)
        {
            case 1:
                MostrarDefinicion();
                break;
            case 2:
                MostrarDiferencias();
                break;
            case 3:
                MostrarMetodos();
                break;
            case 4:
                MostrarConclusiones();
                break;
            case 5:
                MostrarSubMenu();
                continuar = false;
                break;
            case 6:
                System.out.println("Saliendo...");
                continuar = false;
                break;
        }
        if (continuar)
        {
            MostrarMenu();
        }
    }
    
    private void MostrarDefinicion()
    {
        System.out.println("====== DEFINICION ======");
        System.out.println("Un ArrayList es una estructura de datos que permite modificar de manera dinamica su extension y solo tiene soporte para objetos.");
        System.out.println("Fuente:\nhttps://www.javatpoint.com/difference-between-array-and-arraylist#:~:text=Array%20is%20static%20in%20size,ArrayList%20is%20dynamic%20in%20size.&text=An%20array%20is%20a%20fixed,a%20variable%2Dlength%20data%20structure.");
    }
    
    private void MostrarDiferencias()
    {
        System.out.println("====== DIFERENCIAS ARRAYLIST Y ARRAY ======");
        System.out.println("1. Arraylist es una clase que debe importar a diferencia de los vectores que es una estructura de datos primitiva");
        System.out.println("2. Un ArrayList tiene una extension dinamica a diferencia de los vectores que siempre tienen la misma extension");
        System.out.println("3. El Arraylist tienen metodos para intercambiar elementos en este a diferencia de los vectores que se tiene que hacer a traves de asignacion");
        System.out.println("4. Un ArrayList es de una sola dimension a diferencia de un vector que puede tener varias");
        System.out.println("5. El Arraylist tiene metodos exclusivos para iterarse a parte de los bucles a difrencia de los vectores que solo se pueden iterar a traves de bucles for");
        System.out.println("6. Arraylist soporta odjetos a diferencia del arraylist que usa datos primitivos");
        System.out.println("Fuentes: java point, concept java of the day, how to doing java, oracle");
        
        System.out.println("Enlaces:\nhttps://www.javatpoint.com/difference-between-array-and-arraylist#:~:text=Array%20is%20static%20in%20size,ArrayList%20is%20dynamic%20in%20size.&text=An%20array%20is%20a%20fixed,a%20variable%2Dlength%20data%20structure.");
        System.out.println("https://javaconceptoftheday.com/differences-between-array-vs-arraylist-in-java/");
        System.out.println("https://howtodoinjava.com/java/array/array-vs-arraylist/");
        System.out.println("https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html");
    }
    
    private void MostrarMetodos()
    {
        System.out.println("====== METODOS ARRAYLIST ======");
        System.out.println(".add(elemento) , permite añadir elementos al ArrayList");
        System.out.println(".remove(elemento) , permite remover elementos que se encuentren en el ArrayList");
        System.out.println(".size() , retorna el tamaño del ArrayList");
        System.out.println(".get(indice) , permite obtener un elemento del ArrayList ingresando el indice");
        System.out.println("https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html");
    }
    
    private void MostrarConclusiones()
    {
        System.out.println("====== CONCLUSION ARRAYLIST ======");
        System.out.println("El ArrayList es una estructura de datos mas flexible ya que permite añadir y eliminar elementos de la misma, es util cuando el tamaño de la lista puede potencialmente variar. Por ejemplo cuando se buscan u ordenan objetos de la lista.");
    }
    
    private void Funcionalidades(int opcion)
    {
        boolean volverMenu = false;
        switch (opcion)
        {
            case 1:
                lista.add(ObtenerEntero());
                MostrarLista();
                break;
            case 2:
                int elemento_eliminacion = ObtenerEntero();
                if (lista.contains(elemento_eliminacion))
                {
                    int indice = lista.indexOf(elemento_eliminacion);
                    lista.remove(indice);
                    MostrarLista();
                }
                else
                {
                    System.out.println("La lista no contiene el elemento que desea eliminar.");
                }
                break;
            case 3:
                int elemento_busqueda = ObtenerEntero();
                if (lista.contains(elemento_busqueda))
                {
                    System.out.println("El elemento que busca se encuentra en el indice " + lista.indexOf(elemento_busqueda));
                }
                else
                {
                    System.out.println("La lista no contiene el elemento que busca.");
                }
                break;
            case 4:
                MostrarLista();
                break;
            case 5:
                volverMenu = true;
                break;
        }
        if (volverMenu)
        {
            MostrarMenu();
        }
        else
        {
            MostrarSubMenu();
        }
    }
    
    private void MostrarLista()
    {
        System.out.println("====== MOSTRANDO ARRAY ======");
        System.out.println(lista.toString());
    }
    
    private int ObtenerEntero()
    {
        int entero = 0;
        boolean continuar = true;
        System.out.println("Ingrese el elemento, debe ser un entero.");
        while(continuar)
        {
            try
            {
                entero = leer.nextInt();
                continuar = false;
            }
            catch (InputMismatchException ex)
            {
                leer.next();
                System.out.println("Error, debe ingresar un numero entero");
                continuar = true;
            }
        }
        return entero;
    }
    
    private int ValidarOpcion(int maximo)
    {
        int opcion = 0;
        boolean continuar = true;
        System.out.println("Ingrese su opcion.");
        while(continuar)
        {
            try
            {
                opcion = leer.nextInt();
                while (opcion < 1 && opcion > maximo)
                {
                    System.out.println("Error, su numero debe encontrarse entre las opciones");
                }
                continuar = false;
            }
            catch (InputMismatchException ex)
            {
                leer.next();
                System.out.println("Error, debe ingresar un numero entero");
                continuar = true;
            }
        }
        return opcion;
    }
}
