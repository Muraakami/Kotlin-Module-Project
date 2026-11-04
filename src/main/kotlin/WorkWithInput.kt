import java.util.Scanner

abstract class WorkWithInput{
    private val scanner = Scanner(System.`in`)

    fun getText(textOutConsole : String) : String {
        var text: String
        while(true){
            println(textOutConsole)
            text = scanner.nextLine()
            when(text) {
                "" -> println("Вы ввели пустую строку!")
                else -> break
            }
        }
        return text
    }

    fun getNumber(textOutConsole: String) : Int{
        var number: Int?
        while(true){
            print(textOutConsole)
            number = scanner.nextLine().toIntOrNull()
            when (number) {
                null -> println("Некорректно введено число, попробуйте снова")
                else -> break
            }
        }
        return number
    }
}