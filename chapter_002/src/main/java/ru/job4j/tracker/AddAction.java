package ru.job4j.tracker;

/**
 * Класс описывает добавление заявки
 */
public class AddAction extends BaseAction{

    public AddAction(int key, String name) {
        super(key, name);
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
}
