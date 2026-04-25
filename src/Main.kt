import menu.ArchiveMenu
import models.Archive

fun main() {
    val archives = mutableListOf<Archive>()
    val archiveMenu = ArchiveMenu(archives)
    archiveMenu.show()
}