package menu

import models.Archive
import utils.InputHelper

class ArchiveMenu(private val archives: MutableList<Archive>) : Menu("Архивы") {

    override fun setupItems() {
        items.clear()

        // Добавляем пункт "Создать архив"
        addItem("Создать архив") {
            createArchive()
        }

        // Добавляем существующие архивы
        archives.forEach { archive ->
            addItem(archive.name) {
                val noteMenu = NoteMenu(archive)
                noteMenu.show()
            }
        }
    }

    private fun createArchive() {
        val name = InputHelper.readNonEmptyString(
            "Введите название архива:",
            "Ошибка: название архива не может быть пустым"
        )

        val archive = Archive(name)
        archives.add(archive)
        println("Архив '$name' успешно создан!")

        // Обновляем меню после создания
        setupItems()
    }
}