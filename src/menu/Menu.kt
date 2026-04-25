package menu

typealias MenuAction = () -> Unit

data class MenuItem(
    val title: String,
    val action: MenuAction
)

abstract class Menu(
    protected val title: String,
    protected val exitOptionText: String = "Выход"
) {
    protected val items = mutableListOf<MenuItem>()

    protected abstract fun setupItems()

    protected fun addItem(title: String, action: MenuAction) {
        items.add(MenuItem(title, action))
    }

    protected fun displayMenu() {
        println("\n=== $title ===")
        items.forEachIndexed { index, item ->
            println("$index. ${item.title}")
        }
        println("${items.size}. $exitOptionText")
        println()
    }

    protected fun executeOption(choice: Int): Boolean {
        return when {
            choice in 0 until items.size -> {
                items[choice].action()
                false
            }
            choice == items.size -> {
                true
            }
            else -> {
                println("Ошибка: цифры $choice нет в меню")
                false
            }
        }
    }

    open fun show() {
        setupItems()
        while (true) {
            displayMenu()
            print("Выберите пункт меню: ")
            val input = readlnOrNull()

            val choice = input?.toIntOrNull()
            if (choice == null) {
                println("Ошибка: введите цифру")
                continue
            }

            if (executeOption(choice)) {
                break
            }
        }
    }
}