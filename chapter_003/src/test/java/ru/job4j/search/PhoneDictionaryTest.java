package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Anatoliy", "Ezhemenskiy", "999-444-333", "Khimki")
        );
        List<Person> persons = phones.find("Anatoliy");
        assertThat(persons.iterator().next().getSurname(), is("Ezhemenskiy"));
    }
    @Test
    public void whenFindBAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Anatoliy", "Ezhemenskiy", "999-444-333", "Khimki")
        );
        List<Person> persons = phones.find("Khimki");
        assertThat(persons.iterator().next().getPhone(), is("999-444-333"));
    }

}