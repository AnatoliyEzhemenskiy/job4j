package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
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
        Item item1 = new Item("test1","testDescription",123L);
        tracker.add(item1);
        Item item2 = new Item("test2","testDescription2",1234L);
        tracker.add(item2);
        Item item3 = new Item("test3","testDescription3",1234L);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] result = tracker.findAll();
        assertThat(result[1].getName(), is("test3"));
    }
    @Test
    public void whenFindByIdThenReturnCorrectItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L);
        tracker.add(item1);
        Item item2 = new Item("test2","testDescription2",1234L);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is("test1"));
    }
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L);
        tracker.add(item1);
        Item item2 = new Item("test2","testDescription2",1234L);
        tracker.add(item2);
        Item[] result = tracker.findByName("test2");
        assertThat(result[0].getName(), is("test2"));
    }
}