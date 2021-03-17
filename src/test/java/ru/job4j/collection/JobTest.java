package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorByNameLess() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Петр", 0),
                new Job("Андрей", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameIncrease() {
        Comparator<Job> cmpNamePriority = new JobDescByNameIncrease();
        int rsl = cmpNamePriority.compare(
                new Job("Петр", 0),
                new Job("Андрей", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityLess() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Петр", 2),
                new Job("Андрей", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityIncrease() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityIncrease();
        int rsl = cmpNamePriority.compare(
                new Job("Петр", 2),
                new Job("Андрей", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCombComparator() {
        Comparator<Job> comb = new JobDescByName()
                        .thenComparing(new JobDescByPriority());
        int rsl = comb.compare(
                new Job("Андрей", 2),
                new Job("Андрей", 1)
        );
        assertThat(rsl, lessThan(0));
    }

}