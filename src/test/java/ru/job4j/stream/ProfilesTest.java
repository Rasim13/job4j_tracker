package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class ProfilesTest {

    @Test
    public void whenCollect() {
        Profiles prof = new Profiles();
        List<Address> addresses = prof.collect( List.of(
                new Profile(new Address("Сочи", "Некрасова", 45, 12)),
                new Profile(new Address("Москва", "Пушкина", 5, 56)),
                new Profile(new Address("Тюмень", "Юго - западная", 12, 23))
        ));
        List<Address> expected = List.of(
                new Address("Москва", "Пушкина", 5, 56),
                new Address("Сочи", "Некрасова", 45, 12),
                new Address("Тюмень", "Юго - западная", 12, 23)
        );
        assertThat(addresses, is(expected));
    }

    @Test
    public void whenCollectSortedAndDistinct() {
        Profiles prof = new Profiles();
        List<Address> addresses = prof.collect(List.of(
                new Profile(new Address("Сочи", "Некрасова", 45, 12)),
                new Profile(new Address("Сочи", "Некрасова", 45, 12)),
                new Profile(new Address("Москва", "Пушкина", 5, 56)),
                new Profile(new Address("Тюмень", "Юго - западная", 12, 23)),
                new Profile(new Address("Москва", "Пушкина", 5, 56))
        ));
        List<Address> expected = List.of(
                new Address("Москва", "Пушкина", 5, 56),
                new Address("Сочи", "Некрасова", 45, 12),
                new Address("Тюмень", "Юго - западная", 12, 23)
        );
        assertThat(addresses, is(expected));
    }
}