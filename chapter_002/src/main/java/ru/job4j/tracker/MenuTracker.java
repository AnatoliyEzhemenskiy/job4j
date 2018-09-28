package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private int position = 0;
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
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddAction(position++, "Add item"));
        this.actions.add(new ShowAllAction(position++, "Show all"));
        this.actions.add(new EditAction(position++, "Edit item"));
        this.actions.add(new DeleteAction(position++, "Delete item. "));
        this.actions.add(new FindByIdAction(position++, "Find by id"));
        this.actions.add(new FindByNameAction(position++, "Find by name"));
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
     * Строки Меню для автотестирования
     * @return StringBuilder
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
    private static class EditAction extends BaseAction {
        public EditAction(int key, String name) {
            super(key, name);
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
    }

    /**
     * Класс описывает удаление заявки
     */
    private class DeleteAction extends BaseAction {
        public DeleteAction(int key, String name) {
            super(key, name);
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
    }

    /**
     * Действие поиска по имени
     */
    private class FindByNameAction extends BaseAction {
        public FindByNameAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите наименование заявки:");
            for (Item item: tracker.findByName(name)) {
                showItem(item);
            }

        }
    }

    /**
     * Действие поиска по id
     */
    private class FindByIdAction extends BaseAction {
        public FindByIdAction(int key, String name) {
            super(key, name);
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
    }

    /**
     * Действие отображения всех заявок
     */
    private class ShowAllAction extends BaseAction {

        public ShowAllAction(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("заявки:");
            for (Item item : tracker.findAll()) {
                showItem(item);
            }
        }
    }

}

