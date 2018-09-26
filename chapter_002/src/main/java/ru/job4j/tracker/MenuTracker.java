package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * Константа для вывода всех заявок
     */
    private static final int SHOW_ALL = 1;

    /**
     * Константа редактирования заявик
     */
    public static final int EDIT = 2;

    /**
     * Константа удаления заявки
     */
    public static final int DELETE = 3;

    /**
     * Константа поиска по id
     */
    public static final int FIND_BY_ID = 4;

    /**
     * Константа поиска по имент
     */
    public static final int FIND_BY_NAME = 5;

    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;

    /**
     * Метод отображения заявки
     */
    private void showItem(Item item) {
        System.out.println("id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription());
    }


    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddAction());
        this.actions.add(new ShowAllAction());
        this.actions.add(new EditAction());
        this.actions.add(new DeleteAction());
        this.actions.add(new FindByIdAction());
        this.actions.add(new FindByNameAction());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     *
     * @return
     */
    public StringBuilder getMenuStr(){
        StringBuilder result = new StringBuilder();
        for (UserAction action : this.actions) {
            if (action != null) {
               result.append(action.info());
               result.append(System.lineSeparator());
            }
        }
        return result;
    }

    /**
     * Класс описывает редактирование заявки
     */
    private static class EditAction implements UserAction {
        @Override
        public int key() {
            return EDIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Редактирование заявки");
            String id = input.ask("Введите ID заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc, 123L);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка с id: " + id + " изменена");
            } else {
                System.out.println("Заявка не найдена");
            }
        }

        @Override
        public String info() {
            return "2 - Edit Item";
        }
    }

    /**
     * Класс описывает удаление заявки
     */
    private class DeleteAction implements UserAction {

        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Удаление заявки");
            String id = input.ask("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Заявка с id: " + id + " удалена");
            } else {
                System.out.println("Заявка не найдена");
            }
        }

        @Override
        public String info() {
            return "3 - Delete Item";
        }
    }

    /**
     * Действие поиска по имени
     */
    private class FindByNameAction implements UserAction {

        @Override
        public int key() {
            return FIND_BY_NAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите наименование заявки:");
            for (Item item: tracker.findByName(name)
                    ) {
                showItem(item);
            }

        }

        @Override
        public String info() {
            return "5 - Find by name";
        }
    }

    /**
     * Действие поиска по id
     */
    private class FindByIdAction implements UserAction {

        @Override
        public int key() {
            return FIND_BY_ID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                showItem(item);
            } else {
                System.out.println("Заявки с указанным ID не найдено");
            }
        }

        @Override
        public String info() {
            return "4 - Find by id";
        }
    }

    /**
     * Действие отображения всех заявок
     */
    private class ShowAllAction implements UserAction{

        @Override
        public int key() {
            return SHOW_ALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("заявки:");
            for (Item item : tracker.findAll()) {
                showItem(item);
            }
        }

        @Override
        public String info() {
            return "1 - Show all";
        }
    }

}

