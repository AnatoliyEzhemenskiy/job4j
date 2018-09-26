package ru.job4j.tracker;

/**
 * Класс описывает добавление заявки
 */
public class AddAction implements UserAction {
    private int key;
    private String name;

    public AddAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
        System.out.println("------------ Новая заявка с Name : " + item.getName() + "-----------");
        System.out.println("------------ Новая заявка с Description : " + item.getDescription() + "-----------");
    }

    @Override
    public String info() {
        return String.format("%d. %s", key, name);
    }
}
