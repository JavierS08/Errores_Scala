import java.time.LocalDate
import scala.io.StdIn.readLine
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object Main {
  //Crear una lista para almacenar los errores
  var lst = List[String]()
  def log(codigo:String, error:String, date:LocalDate, hora:String): Unit = {
    //Almacemar los errores en la lista
    lst = lst :+ s"Error $codigo: $error, Fecha: $date ---- $hora"
  }
  def main(args: Array[String]): Unit = {
    println("Bienvenido a un programa para reportar errores de compilación")
    var opc = ""
    while (opc != "No") {
      println("Ingrese el nombre del código")
      val codigo = readLine()
      println("Ingrese el error")
      val error = readLine()
      val date = LocalDate.now()
      val hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
      log(codigo, error, date, hora)
      //Le preguntamos al usuario si desea reportar otro error
      println("¿Desea reportar otro error? (Si/No)")
      opc = readLine()
    }
    println("Gracias por usar el programa")
    println("Los errores reportados son:")
    lst.foreach(println)
    //Imprimir la cantidad de errores reportados
    println("La cantidad de errores reportados es: " + lst.length)
  }
}
