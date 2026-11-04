import kotlin.collections.listOf

class Work: WorkWithInput(){
    private val menuItems: Map<Int, List<String>> = mapOf(1 to listOf("Архивов", "Заметок"),
        2 to listOf("архив", "заметку"),
        3 to listOf("Выход", "Вернуться к архивам"))

    fun start(element: Library){
        var numPage = 0
        val archive = element as? Archive
        if(archive != null){
            numPage = 1
        }

        while(true) {
            println("Список ${menuItems[1]?.get(numPage)}:\n0. Создать ${menuItems[1]?.get(numPage)}")
            val items = element.viewMenu()
            var i = 1
            for(item in items){
                when(item){
                    is Archive -> println("$i. ${item.titleArchive}")
                    is Note -> println("$i. ${item.titleNote}")
                }
                i++
            }
            println("${items.size + 1}. ${menuItems[3]?.get(numPage)}")

            when (val numElement: Int = getNumber("Введите пункт из меню: ")) {
                0 -> element.create()
                in 1..items.size -> {
                    when(items[numElement - 1]){
                        is Archive -> {
                            val archive = items[numElement - 1] as Archive
                            start(archive)
                        }
                        is Note -> {
                            val note = items[numElement - 1] as Note
                            println(note.textNote)
                        }
                    }
                }
                i -> break
                else -> println("Такого пункта меню не существует!")
            }
        }
    }
}
