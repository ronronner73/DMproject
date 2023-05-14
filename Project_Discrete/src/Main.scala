import scala.io.StdIn

object Main {

  def monitorOrControl(): Unit = {
    println("Please choose an option:")
    println("1. Monitor equipment")
    println("2. Control equipment")
    println("3. Exit")
    val choice2 = StdIn.readInt()
    choice2 match {
      case 1 =>
        println("Monitoring equipment...")
        energyMonitor.monitor()
        monitorOrControl()
      case 2 =>
        println("Controlling equipment...")
        try{
          energyMonitor.control()
        }catch{
          case e:IllegalArgumentException => println(e.getMessage)
        }
        monitorOrControl()
      case 3 =>
        println("Exiting")
      case _ =>
        println("Invalid choice. Please try again.")
        monitorOrControl()
    }
  }

  def adjust_menu(): Int = {
    println("Do you want to adjust the status?")
    println("1. Yes")
    println("2. No")
    val choice3 = StdIn.readInt()
    return choice3
  }


  def view_menu(): Unit = {
    val s = new SolarPanel("Solar Panel")
    val w = new WindTurbine("Wind Turbine")
    val h = new Hydropower("Hydropower")

    println("Please choose one to check the view:")
    println("1. Solar Panel")
    println("2. Wind Turbine")
    println("3. Hydropower")
    println("4. Exit")
    val choice3 = StdIn.readInt()
    choice3 match {
      case 1 =>
        s.view()
        val select = adjust_menu()
        select match {
          case 1 =>
            s.adjust("Solar Panel", s.status)
          case 2 => println("Exiting...")
        }
        view_menu()
      case 2 =>
        w.view()
        val select = adjust_menu()
        select match {
          case 1 =>
            w.adjust("Wind Turbine", w.status)
          case 2 => println("Exiting...")
        }
        view_menu()
      case 3 =>
        h.view()
        val select = adjust_menu()
        select match {
          case 1 =>
            h.adjust("Hydropower", h.status)
          case 2 => println("Exiting...")
        }
        view_menu()
      case 4 => println("Exiting")
      case _ =>
        println("Invalid choice. Please try again.")
        view_menu()
    }
  }

  def menu(): Unit = {
    println("Please choose an option:")
    println("1. Monitor and Control")
    println("2. Collecting Data and Store")
    println("3. View")
    println("4. Analyse Data")
    println("5. Detect and Handle Issues")
    println("6. Exit")
    println("Please enter your option: ")
    val choice = StdIn.readInt()
    choice match {
      case 1 =>
        monitorOrControl()
        menu()
      case 2 =>
        dataProcessor.collection()
        menu()
      case 3 =>
        view_menu()
        menu()
      case 4 =>
        dataProcessor.dataHandleCenter()
        menu()
      case 5 =>
        dataProcessor.dataDetecting()
        menu()
      case 6 => println("Goodbye!")
      case _ =>
        println("Invalid choice. Please try again.")
        menu()
    }
  }

  def main(args: Array[String]): Unit = {
    menu()
  }
}








