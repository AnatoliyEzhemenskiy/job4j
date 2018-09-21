package ru.job4j.tracker;

public class StartUI {
    public static StringBuilder getMENU() {
        return MENU;
    }

    private static final StringBuilder MENU = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program");
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для вывода всех заявок
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа редактирования заявик
     */
    public static final String EDIT = "2";

    /**
     * Константа удаления заявки
     */
    public static final String DELETE = "3";

    /**
     * Константа поиска по id
     */
    public static final String FIND_BY_ID = "4";

    /**
     * Константа поиска по имент
     */
    public static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
           } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
               this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует редактирование записи с заявкой
     */
    private void editItem() {
        System.out.println("Редактирование заявки");
        String id = this.input.ask("Введите ID заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, 123L);
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка с id: " + id + " изменена");
        } else {
            System.out.println("Заявка не найдена");
        }

    }

    /**
     * Метод удаляет запись с заявкой
     */
    private void deleteItem() {
        System.out.println("Удаление заявки");
        String id = this.input.ask("Введите ID заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка с id: " + id + " удалена");
        } else {
            System.out.println("Заявка не найдена");
        }

    }

    /**
     * Метод отображает все заявки
     */
    private void showAll() {
        System.out.println("заявки:");
        for (Item item : this.tracker.findAll()) {
            showItem(item);
        }
    }

    /**
     * Метод отображения заявки по id
     */
    private void findById() {
        String id = this.input.ask("Введите ID заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            showItem(item);
        } else {
            System.out.println("Заявки с указанным ID не найдено");
        }
    }

    /**
     * Метод отображения заявки по наименованиж
     */
    private void findByName() {
        String name = this.input.ask("Введите наименование заявки:");
        for (Item item: this.tracker.findByName(name)
             ) {
            showItem(item);
        }
    }
    /**
     * Метод отображения заявки
     */
    private void showItem(Item item) {
        System.out.println("id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription());
    }
    /**
     * Метод отображения меню
     */
    private void showMenu() {
        System.out.println(MENU.toString());
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
