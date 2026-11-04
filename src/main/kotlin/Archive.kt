class Archive(val titleArchive: String) : Library() {
    private val notes: MutableList<Note> = mutableListOf()

    override fun viewMenu(): List<Any> {
        return notes
    }

    override fun create() {
        val note = Note(getText("Введите имя заметки:"),
            getText("Введите содержание заметки:"))
        notes.add(note)
    }
}