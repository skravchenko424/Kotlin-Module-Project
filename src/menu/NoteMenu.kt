package menu

import models.Archive
import models.Note
import utils.InputHelper

class NoteMenu(private val archive: Archive) : Menu("Заметки в архиве '${archive.name}'") {

    override fun setupItems() {
        items.clear()

        // Добавляем пункт "Создать заметку"
        addItem("Создать заметку") {
            createNote()
        }

        // Добавляем существующие заметки
        archive.notes.forEachIndexed { index, note ->
            addItem(note.title) {
                val noteViewer = NoteViewer(note)
                noteViewer.show()
            }
        }
    }

    private fun createNote() {
        val title = InputHelper.readNonEmptyString(
            "Введите заголовок заметки:",
            "Ошибка: заголовок заметки не может быть пустым"
        )

        val content = InputHelper.readNonEmptyString(
            "Введите текст заметки:",
            "Ошибка: текст заметки не может быть пустым"
        )

        val note = Note(title, content)
        archive.notes.add(note)
        println("Заметка '$title' успешно создана!")

        // Обновляем меню после создания
        setupItems()
    }
}