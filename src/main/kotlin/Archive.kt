class Archive(val titleArchive: String) : Library() {
    val notes: MutableList<Note> = mutableListOf()

    override fun viewMenu() {
        var i = 1
        if (notes.isNotEmpty()) {
            for ((titleNote) in notes) println("${i++}. $titleNote")
        }
    }

    override fun create() {
        val note = Note(getText("Введите имя заметки:"),
            getText("Введите содержание заметки:"))
        notes.add(note)
    }

    override fun count() : Int{
        return notes.size
    }
}