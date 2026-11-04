class Work: WorkWithInput(){
    val title : List<String> = listOf("Архивов", "Заметок")
    val menuItemZero : List<String> = listOf("архив", "заметку")
    val menuItemEnd : List<String> = listOf("Выход", "Вернуться к архивам")

    fun start(element: Library){
        var numPage = 0
        val archive = element as? Archive
        if(archive != null){
            numPage = 1
        }

        while(true) {
            println("Список ${title[numPage]}:\n0. Создать ${menuItemZero[numPage]}")
            element.viewMenu()
            val size = element.count() + 1
            println("${size}. ${menuItemEnd[numPage]}")

            when (val numElement: Int = getNumber("Введите пункт из меню: ")) {
                0 -> element.create()
                in 1..element.count() -> {
                    if(element is Archive){
                        val archive: Archive = element
                        println(archive.notes[numElement - 1].textNote)
                    }else{
                        start(element.library[numElement - 1])
                    }
                }
                size -> break
                else -> println("Такого пункта меню не существует!")
            }
        }
    }
}
