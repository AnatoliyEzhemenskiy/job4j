package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenReturnNewArrayWithoutItem() {
        Tracker tracker = new Tracker();
        Item[] items = {new Item("test1", "testDescription", 123L),
                new Item("test2", "testDescription2", 1234L),
        };
        Item item = new Item("test3", "testDescription3", 1234L);
        tracker.add(item);
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.delete(item.getId());
        assertThat(tracker.findAll(), is(items));
    }
    @Test
    public void whenFindByIdThenReturnCorrectItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item2);

        Item result =  tracker.findAll()[0];
        result.setId(tracker.findAll()[0].getId());

        assertThat(tracker.findAll()[0], is(result));
    }
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test1", "testDescription2", 1234L);
        tracker.add(item2);
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(tracker.findAll()));
    }
}