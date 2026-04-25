package menu

import models.Note

class NoteViewer(private val note: Note) : Menu("Просмотр заметки: ${note.title}", "Назад") {

    override fun setupItems() {
        items.clear()

        // В этой реализации мы не добавляем обычных пунктов меню,
        // а только показываем содержимое при входе
    }

    override fun show() {
        println("\n=== ${note.title} ===")
        println("Текст заметки:")
        println("-".repeat(40))
        println(note.content)
        println("-".repeat(40))

        val exitText = "Нажмите Enter, чтобы вернуться к списку заметок..."
        println(exitText)
        readlnOrNull()
    }
}