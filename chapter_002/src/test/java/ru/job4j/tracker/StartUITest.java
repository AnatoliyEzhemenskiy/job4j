package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;
public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Строка вывода заявки
     * @param item
     * @return String
     */
    private String getStringItem(Item item) {
        return "id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription();
    }

     @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc",123L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerDoesntHaveItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item[] items = {new Item("test name", "desc",123L),
                new Item("test name2", "desc2",123L)
        };
        Item item =  new Item("test name3", "desc3",123L);
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(),"6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenFindByIdThenShowItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        tracker.add(new Item("test name", "desc",123L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
       StartUI su =  new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Item item = tracker.findAll()[0];
        StringBuilder result = new StringBuilder()
                .append(su.getMENU().toString())
                .append(System.lineSeparator())
                .append("заявки:")
                .append(System.lineSeparator())
                .append(getStringItem(item))
                .append(System.lineSeparator())
                .append(su.getMENU().toString())
                .append(System.lineSeparator());
        assertThat( new String(out.toString()), is(result.toString()));
    }

    @Test
    public void whenFindByIdThenReturnItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        tracker.add(new Item("test name", "desc",123L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"4", tracker.findAll()[0].getId(),"6"});
        // создаём StartUI и вызываем метод init()
        StartUI su = new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        StringBuilder result = new StringBuilder()
                .append(su.getMENU().toString())
                .append(System.lineSeparator())
                .append(getStringItem(tracker.findAll()[0]))
                .append(System.lineSeparator())
                .append(su.getMENU().toString())
                .append(System.lineSeparator());
        assertThat( new String(out.toString()), is(result.toString()));

    }

    @Test
    public void whenFindByNameThenReturnArrayItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        tracker.add(new Item("test", "desc",123L));
        tracker.add(new Item("test", "desc2",123L));

        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"5", "test","6"});
        // создаём StartUI и вызываем метод init()
        StartUI su  = new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        StringBuilder result = new StringBuilder()
                .append(su.getMENU().toString())
                .append(System.lineSeparator())
                .append(getStringItem(tracker.findAll()[0]))
                .append(System.lineSeparator())
                .append(getStringItem(tracker.findAll()[1]))
                .append(System.lineSeparator())
                .append(su.getMENU().toString())
                .append(System.lineSeparator());
        assertThat( new String(out.toString()), is(result.toString()));

    }

}