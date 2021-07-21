# Refactoring Test

Please review the following code snippet. Assume that all referenced assemblies have been properly included. The code is used to log different messages throughout an application. We want the ability to be able to log to a text file, the console and/or the database. Messages can be marked as message, warning or error. We also want the ability to selectively be able to choose what gets logged, such as to be able to log only errors or only errors and warnings.

If you were to review the following code, what feedback would you give? Please be specific and indicate any errors that would occur as well as other best practices and code refactoring that should be done.
Rewrite the code based on the feedback you provided in question 1. Please include unit tests on your code.


 1. Se viola el principio SOLID de una sola responsabilidad ya que la misma clase se usa para la lógica del log y ademas tiene la responsabilidad de el acceso a datos y trabajo con archivos 
 2. Se viola el principio SOLID de abierto y cerrado ya que si se quisiera adicionar otro tipo de logs ejemplo correo tendríamos que modificar la clase y debería ser extendida
 3. Ser mas descriptivo en los nombres de las variables eje l y t seguir un estándar de nombrado
 4. La variable l de la linea 74 se inicializa en null y después se le concatenan información
 5. La variable l de la linea 74 se llena posteriormente pero no se usa
 6. Si se hace un trim de null arroja una excepción 
 7. En la línea 46 el resultado del trim es ignorado
 8. Recomiendo utilizar hibernate como ORM para facilitar el trabajo con la BD  
 9. Las variables estáticas están mal usadas se asignan en el constructor debería de ser variables de configuración 
 10. Recomiendo utilizar el application.properties para externalizar las configuraciones generales de log, BD y Fichero y pueden ser cambiados en tiempo de ejecución
 11. En la línea 112 está actualizando la tabla en la bd y en el campo mensaje está salvando solo el valor boleado true o false debería de salvarse el texto
 12. El código no está separado por capas
 13. No se cierra la BD

Aclaraciones
Asumo que se quiere mantener la lógica de la aplicación para el ejercicio ya que existen librerías para el manejo de logs como log4j
Para la prueba utilicé una BD H2 en fichero para que se pueda comprobar su funcionamiento
