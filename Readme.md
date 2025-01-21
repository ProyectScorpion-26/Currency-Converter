# Currency Converter
## Autor: Oscar Barajas
Este es un programa de consola que permite convertir una cantidad de una moneda a otra utilizando tasas de cambio actuales. Utiliza una API externa para obtener las tasas de cambio entre diferentes monedas. El programa está basado en Java y utiliza OkHttp para realizar solicitudes HTTP y Gson para procesar los datos en formato JSON.

## Requisitos

- JDK 8 o superior.
- Dependencias externas:
    - **OkHttp**: Librería para hacer solicitudes HTTP.
    - **Gson**: Librería para parsear y manejar datos en formato JSON.

## Dependencias

Si utilizas Maven para la gestión de dependencias, debes incluir las siguientes en tu archivo `pom.xml`:

```xml
<dependencies>
    <!-- OkHttp para realizar solicitudes HTTP -->
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.10.0</version>
    </dependency>
    <!-- Gson para procesar datos en formato JSON -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.9.1</version>
    </dependency>
</dependencies>
```

# Ejecución del programa
1. Clona el repositorio que se encuentra en el link https://github.com/ProyectScorpion-26/Currency-Converter
2. Compilar el código con el comando ```mvn clean install```
3. Una vez que hayas compilado el código, puedes ejecutar la clase Main que contiene el método main para iniciar el programa usando el comando ```java -cp target/currency-converter.jar org.barajas.oscar.Main```


## Ejemplo de ejecución
```
Welcome to the Currency Converter
Choose an option:
1. Convert currency
2. Exit
   1
   Enter the source currency code (e.g., USD, EUR, GBP):
   USD
   Enter the target currency code (e.g., USD, EUR, GBP):
   EUR
   Enter the amount to convert:
   100
   Result: 92.34 EUR
   Choose an option:
1. Convert currency
2. Exit
   2
   The program has ended
```

