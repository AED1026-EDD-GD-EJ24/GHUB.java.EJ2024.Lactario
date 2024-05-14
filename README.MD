# Proyecto - Ejercicio Integrador de la Gestión de un Lactario #

## Descripción del Problema ##
Un lactario es un espacio dedicado y equipado para que las madres lactantes puedan extraerse leche de manera cómoda y segura durante su jornada laboral o académica. Este espacio garantiza la privacidad y la higiene necesarias para este proceso.

En el contexto de este proyecto, el lactario podría ser una aplicación o un módulo dentro de una aplicación más grande que permite a las madres registrar y gestionar información relacionada con la lactancia. Esto podría incluir el seguimiento de las sesiones de lactancia o extracción de leche, la cantidad de leche producida, y cualquier nota o observación que la madre desee registrar.

Además, el lactario podría proporcionar recursos y apoyo para las madres lactantes, como información sobre la lactancia, recordatorios para las sesiones de lactancia o extracción de leche, y una comunidad de apoyo donde las madres pueden compartir experiencias y consejos.

A continuación, se muestra la solución utilizando un diagrama de clases.

1. La clase Lactario podría tener atributos para almacenar información sobre las madres lactantes y sus sesiones de lactancia. Por ejemplo, podría tener una lista de objetos Mama y una lista de objetos Hijo. Cada objeto Mama podría almacenar información sobre una madre, como su nombre, y cada objeto Hijo podría almacenar información sobre un hijo, como su nombre y la cantidad de leche que consume.

La clase Lactario también podría tener métodos para agregar y eliminar madres e hijos, buscar madres e hijos por nombre, y otras operaciones relacionadas con la gestión de un lactario.

2. La clase Mama en este código representa a una madre en el contexto de un lactario. Implementa la interfaz Comparable, lo que significa que las instancias de esta clase pueden ser comparadas entre sí.

Los atributos de la clase Mama son:

id: Un identificador único para cada madre.
nombre: El nombre de la madre.
edad: La edad de la madre.
fechaNacimiento: La fecha de nacimiento de la madre.
hijos: Una lista doblemente enlazada de objetos Hijo. Cada objeto Hijo representa a un hijo de la madre.
La clase Mama tiene dos constructores:

El primer constructor toma un id, un nombre, una edad y una fechaNacimiento, y crea una nueva instancia de Mama con estos valores.
El segundo constructor toma los mismos parámetros que el primer constructor, además de una lista de hijos, y crea una nueva instancia de Mama con estos valores.


3. La clase Hijo en este código representa a un hijo en el contexto de un lactario.

Los atributos de la clase Hijo son:

id: Un identificador único para cada hijo.
nombre: El nombre del hijo.
edadMeses: La edad del hijo en meses.
edadDias: La edad del hijo en días.
fechaNacimiento: La fecha de nacimiento del hijo.
idMama: El identificador de la madre del hijo.
La clase Hijo tiene tres constructores:

El constructor por defecto, que no toma ningún argumento.
Un constructor que toma un id, un nombre, una edadDias, una edadMeses y una fechaNacimiento, y crea una nueva instancia de Hijo con estos valores.
Un constructor que toma los mismos parámetros que el segundo constructor, además de un idMama, y crea una nueva instancia de Hijo con estos valores.
La clase Hijo también tiene varios métodos getter y setter para obtener y establecer los valores de sus atributos.

Finalmente, la clase Hijo tiene un método toString() que devuelve una representación en cadena de la instancia de Hijo, en el formato "Hijo [id=ID, nombre=NOMBRE, edadMeses=EDADM, edadDias=EDADD, fechaNacimiento=FECHAN, idMama=IDM]".

La coleccióm de Mamas, se guarda en un árbol binario ordenado equilibrado, en donde el criterio de ordenamiento es por Id de la Madre,también utiliza una estructura tipo hash table, cuya entrada es el Id de la madre, se utilizan también dos listas doblemente ligadas, una para las madres y otras para los hijo.

Un objeto tipo Mama, puede contener una lista de dos objetos tipo hijos, eso se da cuando la madré proporciona lecha a mas de un bebe, por ejemplo en el caso de gemelos.


## Funcionalidades Implementadas ##
1. Gestión de Madres: Las madres podrían registrarse en la aplicación proporcionando detalles como su nombre, edad, fecha de nacimiento, etc. También podrían actualizar o eliminar su información.

2. Gestión de Hijos: La aplicación permitiría a las madres añadir, actualizar o eliminar información sobre sus hijos. Cada hijo tendría detalles como nombre, edad en meses y días, fecha de nacimiento, etc.

3. Gestión de Lactancia: Las madres podrían registrar la cantidad de leche que producen y la cantidad de leche que consumen sus hijos. También podrían ver un historial de sus sesiones de lactancia.

4. Solicitud de Recursos: Si el lactario proporciona recursos como bombas de leche o botellas, las madres podrían buscar estos recursos disponibles y solicitar un préstamo.


## Uso del Proyecto ##
El proyecto se puede compilar, probar y ejecutar utilizando los siguientes comandos:

make: Compila, prueba y ejecuta la aplicación.
make compile: Compila la aplicación.
make test: Ejecuta las pruebas unitarias.
make run: Ejecuta la aplicación.
make clean: Limpia los archivos binarios generados.
Contribución al Repositorio
Para contribuir al repositorio, se deben seguir los siguientes pasos:

Realizar los cambios necesarios en los archivos.
Agregar los cambios al área de preparación utilizando el comando git add ..
Hacer un commit de los cambios con un mensaje descriptivo utilizando el comando git commit -m "Descripción del cambio".
Enviar los cambios al repositorio remoto utilizando el comando git push origin main.

#### Este ejercicio implementa ####
      Un Sistema de Gestión de Lactario
        
      
## Diagrama de clase Lista

```mermaid
classDiagram
    class Lactario {
        -List<Mama> listaMamas
        -List<Hijo> listaHijos
        +agregarMama(Mama mama)
        +eliminarMama(String idMama)
        +buscarMamaPorNombre(String nombre)
        +agregarHijo(Hijo hijo)
        +eliminarHijo(String idHijo)
        +buscarHijoPorNombre(String nombre)
    }
    Lactario "1" --> "*" Mama: contiene
    Lactario "1" --> "*" Hijo: contiene
    class Mama {
        -String id
        -String nombre
        -int edad
        -Fecha fechaNacimiento
        -ListaDoblementeEnlazada<Hijo> hijos
        +Mama(String id, String nombre, int edad, Fecha fechaNacimiento)
        +Mama(String id, String nombre, int edad, Fecha fechaNacimiento, ListaDoblementeEnlazada<Hijo> hijos)
        +String getNombre()
        +void setNombre(String nombre)
        +String getId()
        +void setId(String id)
        +int getEdad()
        +void setEdad(int edad)
        +Fecha getFechaNacimiento()
        +void setFechaNacimiento(Fecha fechaNacimiento)
        +ListaDoblementeEnlazada<Hijo> getHijos()
        +void setHijos(ListaDoblementeEnlazada<Hijo> hijos)
        +boolean esMenor(Object q)
        +boolean esMayor(Object q)
        +boolean esIgual(Object q)
        +String toString()
    }
    class Fecha {
    }
    class ListaDoblementeEnlazada {
    }
    class Hijo {
    }
    Mama --> Fecha: tiene
    Mama --> ListaDoblementeEnlazada: tiene
    ListaDoblementeEnlazada --> Hijo: contiene

    class Hijo {
        -String id
        -String nombre
        -int edadMeses
        -int edadDias
        -Fecha fechaNacimiento
        -String idMama
        +Hijo()
        +Hijo(String id, String nombre, int edadDias, int edadMeses, Fecha fechaNacimiento)
        +Hijo(String id, String nombre, int edadDias, int edadMeses, Fecha fechaNacimiento, String idMama)
        +String getId()
        +void setId(String id)
        +String getNombre()
        +void setNombre(String nombre)
        +int getEdadMeses()
        +void setEdadMeses(int edadMeses)
        +int getEdadDias()
        +void setEdadDias(int edadDias)
        +Fecha getFechaNacimiento()
        +void setFechaNacimiento(Fecha fechaNacimiento)
        +String getIdMama()
        +void setIdMama(String idMama)
        +String toString()
    }
    class Fecha {
    }
    Hijo --> Fecha: tiene
    

    class Fecha {
        -Integer dia
        -Integer mes
        -Integer anio
        +Fecha(String s)
        +Fecha()
        +Fecha(int dia, int mes, int anio)
        +int getDia()
        +void setDia(int dia)
        +int getMes()
        +void setMes(int mes)
        +int getAnio()
        +void setAnio(int anio)
        +Fecha obtenerFechaSistema()
        +int calcularEdadMeses(Fecha fechaNacimiento)
        +int calcularEdadDias(Fecha fechaNacimiento)
        +String toString()
    }
    class ListaDoblementeEnlazada<T> {
        -Nodo<T> cabeza
        -int tamanio
        +ListaDoblementeEnlazada()
        +int getTamanio()
        +boolean esVacia()
        +void agregar(T valor)
        +void insertar(T valor, int pos)
        +T getValor(int pos)
        +void remover(int pos)
        +void limpiar()
        +void mostrar()
    }
    class Nodo<T> {
    }
    ListaDoblementeEnlazada --> Nodo: tiene
    class MenuOpciones{
        -lact: Lactario
        -fechaActual: Fecha
        +agregar_mama():
        +eliminar_mama():
        +editar_mama():
        +buscar_mama_id():
        +abuscarMamaPorNombreParcial():
        +mostrar_arbol_mamas():
        +mostrar_lista_mamas():
        +mostrar_lista_lactantes():
        

    }
    MenuOpciones o-- Lactario: contiene

    Class Lista{

    }

    class Menu{
        -iOpc: MenuOpciones
        +lectura():void
        +imprimirMenu():void
        +salir():void
        
    }

    class Principal{
        +i1: Menu
        +main():void()
    }
   
    



```

[Editor en línea](https://mermaid.live/)

[Referencia-Mermaid](https://mermaid.js.org/syntax/classDiagram.html)

## Diagrama de clases UML con draw.io
El repositorio está configurado para crear Diagramas de clases UML con ```draw.io```. Para usarlo simplemente agrega un archivo con extensión ```.drawio.png```, das doble clic sobre el mismo y se activará el editor ```draw.io``` incrustado en ```VSCode``` para edición. Asegúrate de agregar las formas UML en el menú de formas del lado izquierdo (opción ```+Más formas```).


## Uso del proyecto con make

### Default - Compilar+Probar+Ejecutar
```
make
```
### Compilar
```
make compile
```
### Probar todo
```
make test
```
### Ejecutar App
```
make run
```
### Limpiar binarios
```
make clean
```
## Comandos Git-Cambios y envío a Autograding

### Por cada cambio importante que haga, actualice su historia usando los comandos:
```
git add .
git commit -m "Descripción del cambio"
```
### Envíe sus actualizaciones a GitHub para Autograding con el comando:
```
git push origin main
```
## Comandos individuales
### Compilar

```
find ./ -type f -name "*.java" > compfiles.txt
javac -encoding utf-8 -d bin -cp lib/junit-platform-console-standalone-1.5.2.jar @compfiles.txt
```
### Ejecutar ambos comandos en 1 sólo paso:
```
find ./ -type f -name "*.java" > compfiles.txt ; javac -encoding utf-8 -d bin -cp lib/junit-platform-console-standalone-1.5.2.jar @compfiles.txt
```

### Ejecutar Todas la pruebas locales de 1 Test Case
```
java -jar lib/junit-platform-console-standalone-1.5.2.jar -class-path bin --select-class miTest.AppTest
```
### Ejecutar 1 prueba local de 1 Test Case
```
java -jar lib/junit-platform-console-standalone-1.5.2.jar -class-path bin --select-method miTest.AppTest#appHasAGreeting
```
### Ejecutar App
```
java -cp bin miPrincipal.Principal
```
Los comandos anteriores están considerados para un ambiente Linux. [Referencia.](https://www.baeldung.com/junit-run-from-command-line)