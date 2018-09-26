package ru.job4j.tracker;

/**
 * Класс описывает добавление заявки
 */
public class AddAction implements UserAction {
    @Override
    public int key() {
        return 1;
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
        return "0 - Add new Item.";
    }
}
