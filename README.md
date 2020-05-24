# JavaSE-Functional

Notas generadas del curso de programacion funcional de Platzi.





## Funciones lambda.

Es una función anónima. O una función que no tiene nombre.

- Es un comportamiento de uso único.
- Una regla que solo se requiere en un lugar.
- Es una función extremadamente simple.





## Inmutabilidad.

Los datos inmutables son aquellos datos que una vez creados no se pueden alterar.





## Funciones.

**java.util.funcion**: **Function**.

Para crear una función del paquete funcion, se siguen los siguientes requerimientos.

- La declaración debe llevar especificado el tipo de dato de Entrada y Salida, es decir en este caso recibe un entero y retorna otro entero.
- Las funciones anónimas solo tienen un método el cual es sobre escrito en este caso es el método **apply**,.

```java
 Function<Integer, Integer> square = new Function<Integer, Integer>() {
    @Override
	public Integer apply(Integer x) {
		return x * x;
	}
 };
```



Este tipo de funciones se ejecutan por medio del método **apply**.

```java
System.out.println(square.apply(5));
// Return: 25
```

> Un método también puede ser una funcion, la diferencia es que las funciones también son tipos y al ser tipos podemos involucrarlas en variables, pasarlas como parámetros o recibirlas como retorno de una ejecución.



### Definición corta de funcion.

Función para verificar si un numero es impar.

Donde:

- La funcion recibe el tipo de entrada y salida.
- Y al ser una funcion solo realiza una operación.
- Se ocupa la notación de flecha.

```java
Function<Integer, Boolean> isOdd = x -> x % 2 == 1;
```





## Predicate

Se ocupan para testear si algo es verdadero o no.

Es una especie de funcion que es trabajada bajo un **tipo** pero que genera un **bolean**.

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
isEven.test(4); 
// true
```





## Consumer

Representa una operación que acepta un solo argumento de entrada y devuelve ningún resultado. A diferencia de la mayoría de las otras interfaces funcionales, se espera que al Consumidor para operar a través de efectos secundarios.

Donde:

- Un Consumer recibe el tipo de dato que va a recibir.
- Asigna un nuevo nombre al dato recibido.
- Realiza operaciones sobre ese dato.

```java
 // Recibe los argumentos del CLI
    static void showHelp(CLIArguments cliArguments) {
        // El consumer itera todos esos argumentos.
        // Recibe un CLIArguments.
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            // Realiza una evaluacion.
            if(cliArguments1.isHelp()) {
                System.out.println("Manual solicitado");
            }
        };
    }
```

Es invocado mediante la funcion **accept**.

```
consumerHelper.accept(cliArguments);
```





## Supplier

Es un tipo de funcion que se encarga de generar datos, proveer datos.

Se utiliza para generar configuraciones bajo demanda o crear archivos bajo demanda.

```java
static CLIArguments generateCLI() {
        Supplier<CLIArguments> generator = () -> new CLIArguments();

        return generator.get();
    }
```

> El supplier no recibe ningún dato, esto se denota con los paréntesis.





## UnaryOperator.

Representa una operación en un único operando que produce un resultado de mismo tipo que su operando. Esta es una especialización de la función para el caso en el operando y el resultado son del mismo tipo.

```java
UnaryOperator<String> quote = text -> "\"" + text + "\"";
UnaryOperator<String> addMark = text -> text + "!";
```

Se invoca mediante el método **apply**.

```java
System.out.println(quote.apply("Hola Estudiante de platzi!"));
System.out.println(addMark.apply("Hola"));
```





## BiFunction

Representa una función que acepta dos argumentos y produce un resultado.

```java
BiFunction<String, Integer, String> leftPad =
                (text, number) -> String.format("%" + number + "s", text);

System.out.println(leftPad.apply("Java", 8));
```

