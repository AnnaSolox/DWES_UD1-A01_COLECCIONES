package org.annasolox;


import org.annasolox.models.Libro;
import org.annasolox.models.Usuario;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        // Cargar libros y usuarios predefinidos
        List<Libro> libros = biblioteca.getLibrosPredefinidos();
        List<Usuario> usuarios = biblioteca.getUsuariosPredefinidos();

        //Ejercicio 1. - Stack
        //Implementa un historial de navegación de libros consultados
        //1.1 Cada vez que un usuario abre un libro, este se añade al Stack.
        biblioteca.abrirLibro(libros.get(3));
        biblioteca.abrirLibro(libros.get(1));
        biblioteca.abrirLibro(libros.get(2));
        biblioteca.abrirLibro(libros.get(4));
        biblioteca.abrirLibro(libros.get(5));
        biblioteca.abrirLibro(libros.get(6));
        biblioteca.abrirLibro(libros.get(7));

        //1.2 El programa debe permitir:
        biblioteca.mostrarUltimoLibroConsultado();
        biblioteca.listarLibrosConsultados();
        biblioteca.retrocederEnElHistorial();
        biblioteca.mostrarUltimoLibroConsultado();

        //1.3 Pregunta: ¿Qué estructura de acceso representa un Stack (LIFO o FIFO)?
        // Respuesta: LIFO -> Last In First Out. Cogeremos siempre de arriba de la pila, por lo que el último
        // libro introducido será el que salga cuando hagamos pop().

        //Ejercicio 2. - Queue
        // Simula la cola de espera de un libro popular con una Queue<String>
        //2.1
        biblioteca.aniadirUsuarioACola(new Usuario("Anna", "asdasdf321654"));
        biblioteca.aniadirUsuarioACola(new Usuario("Enrique", "faoDIJH90y5"));
        biblioteca.aniadirUsuarioACola(new Usuario("Erika", "32984sdfkjQO3G"));
        biblioteca.aniadirUsuarioACola(new Usuario("Jordi", "234weafjbro8q237"));
        //2.2
        biblioteca.atenderUsuarioCola();
        //2.3
        biblioteca.mostrarCola();
        //2.4. Pregunta: ¿Qué estructura de acceso representa una Queue (LIFO o FIFO)?
        // Respuesta: FIFO -> First In First Out. En las colecciones Queue, siempre sale primero el que ha entrado
        // primero, como en una fila de personas en la vida real.

        //Ejercicio 3. - Set
        //Crea un catálogo de libros usando un HashSet<String>.
        //3.1
        biblioteca.insertarEnCatalogo(libros.get(0));
        biblioteca.insertarEnCatalogo(libros.get(9));
        biblioteca.insertarEnCatalogo(libros.get(9));
        biblioteca.insertarEnCatalogo(libros.get(7));
        biblioteca.insertarEnCatalogo(libros.get(7));
        biblioteca.insertarEnCatalogo(libros.get(3));
        biblioteca.insertarEnCatalogo(libros.get(1));
        //3.2
        biblioteca.comprobarCatalogo("Moby Dick");
        biblioteca.comprobarCatalogo("El Principito");
        //3.3
        biblioteca.mostrarTitulosDisponibles();
        //3.4 Pregunta: ¿Qué ocurre al intentar insertar elementos duplicados en un HashMap? ¿Qué diferencia hay con el HashSet? ¿Cuándo crees que puede ser útil esta estructura (HashSet)?
        //Respuesta: En un HashMap podemos introducir valores duplicados con claves distintas, pero si introducimos
        // una clave duplicada, el valor asociado a este clave cambiará por el nuevo valor introducido.
        // El HashSet no permite duplicados. Si intentas introducir un valor que ya existe, no se almacenará de nuevo.

        //Ejercicio 4. - HashMap
        //Gestiona un sistema de usuarios y contraseñas con un HashMap<String, String>
        //4.1
        usuarios.forEach(biblioteca::registrarUsuario);
        biblioteca.registrarUsuario(new Usuario("Juan", "askfjbPQ3984Y"));
        //4.2
        biblioteca.verificarInicioSesion(usuarios.getFirst().getNombre());
        biblioteca.verificarInicioSesion("David");
        //4.3
        biblioteca.mostrarTodosLosUsuarios();
        //4.4 Pregunta: ¿Cómo diferencia HashMap a dos claves distintas que generan el mismo hashCode()?
        //Respuesta: Cuando dos claves distintas generan el mismo hashCode, se produce una colisión. Para solventar
        // esta colisión, HashMap guarda el segundo par clave-valor en el mismo bucket. Si el número de colisiones no
        // es grande, convierte el bucket en un LinkedList. Si hay muchas colisiones, lo convierte en un árbol
        // rojo-negro.
        // El acceso a la clave correcta, lo realiza haciendo comparaciones de los nodos con equals().

        //Ejercicio 5
        //5.1
        biblioteca.aniadirLibroADescargar(libros.getFirst().getTitulo(), 3);
        biblioteca.aniadirLibroADescargar(libros.getLast().getTitulo(), 2);
        biblioteca.aniadirLibroADescargar(libros.get(3).getTitulo(), 5);
        biblioteca.aniadirLibroADescargar(libros.get(4).getTitulo(), 6);
        biblioteca.aniadirLibroADescargar(libros.get(1).getTitulo(), 2);
        biblioteca.aniadirLibroADescargar(libros.get(2).getTitulo(), 4);
        biblioteca.aniadirLibroADescargar(libros.get(5).getTitulo(), 8);
        biblioteca.aniadirLibroADescargar(libros.get(6).getTitulo(), 8);
        biblioteca.aniadirLibroADescargar(libros.get(7).getTitulo(), 1);
        biblioteca.aniadirLibroADescargar(libros.get(8).getTitulo(), 2);
        biblioteca.aniadirLibroADescargar(libros.get(9).getTitulo(), 1);
        //5.2
        biblioteca.mostrarAlfabeticamentePorTitulo();
        //5.3
        biblioteca.consultarPrimerLibro();
        biblioteca.consultarUltimoLibro();
        //5.4 Pregunta: ¿En qué se diferencia un TreeMap de un HashMap en cuanto al orden de las claves?
        //El HashMap guarda los pares clave según el hashCode generado, sin un orden concreto. El TreeMap los guarda de
        // forma ordenada utilizando una estructura de árbol rojo-negro.
    }
}