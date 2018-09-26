package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
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
        this.actions.add(new AddAction(0, "Add item"));
        this.actions.add(new ShowAllAction(1, "Show all"));
        this.actions.add(new EditAction(2, "Edit item"));
        this.actions.add(new DeleteAction(3, "Delete item. "));
        this.actions.add(new FindByIdAction(4, "Find by id"));
        this.actions.add(new FindByNameAction(5, "Find by name"));
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
    public StringBuilder getMenuStr() {
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
        private int key;
        private  String name;

        public EditAction(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return key;
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
            return String.format("%d. %s", key, name);
        }
    }

    /**
     * Класс описывает удаление заявки
     */
    private class DeleteAction implements UserAction {
        private int key;
        private  String name;

        public DeleteAction(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return key;
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
            return String.format("%d. %s", key, name);
        }
    }

    /**
     * Действие поиска по имени
     */
    private class FindByNameAction implements UserAction {
        private int key;
        private String name;

        public FindByNameAction(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите наименование заявки:");
            for (Item item: tracker.findByName(name)) {
                showItem(item);
            }

        }

        @Override
        public String info() {
            return String.format("%d. %s", key, name);
        }
    }

    /**
     * Действие поиска по id
     */
    private class FindByIdAction implements UserAction {
        private int key;
        private String name;

        public FindByIdAction(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return key;
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
            return String.format("%d. %s", key, name);
        }
    }

    /**
     * Действие отображения всех заявок
     */
    private class ShowAllAction implements UserAction {
        private int key;
        private String name;

        public ShowAllAction(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return key;
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
            return String.format("%d. %s", key, name);
        }
    }

}

