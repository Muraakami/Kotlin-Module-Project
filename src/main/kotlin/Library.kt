open class Library: Navigation, WorkWithInput(){
    private val library: MutableList<Archive> = mutableListOf()

    override fun viewMenu(): List<Any> {
        return library
    }

    override fun create() {
        val archive = Archive(getText("Введите название архива:"))
        library.add(archive)
    }
}