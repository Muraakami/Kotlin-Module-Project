open class Library: Navigation, WorkWithInput(){
    val library: MutableList<Archive> = mutableListOf()

    override fun viewMenu() {
        var i = 1
        if (library.isNotEmpty()) {
            for (archive in library) println("${i++}. ${archive.titleArchive}")
        }
    }

    override fun create() {
        val archive = Archive(getText("Введите название архива:"))
        library.add(archive)
    }

    override fun count(): Int {
        return library.size
    }
}