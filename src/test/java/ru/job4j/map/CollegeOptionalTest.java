package ru.job4j.map;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CollegeOptionalTest {

    @Test
    public void whenAccountIsOptionalEmpty() {
        Map<StudentOptional, Set<SubjectOptional>> students = Map.of(
                new StudentOptional("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOptional("Math", 70),
                        new SubjectOptional("English", 85)
                ),
                new StudentOptional("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOptional("Economic", 75),
                        new SubjectOptional("Sociology", 65)
                )
        );
        CollegeOptional college = new CollegeOptional(students);
        assertThat(college.findByAccount("000010"), is(Optional.empty()));
    }

    @Test
    public void whenAccountIsOptionalNotEmpty() {
        Map<StudentOptional, Set<SubjectOptional>> students = Map.of(
                new StudentOptional("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOptional("Math", 70),
                        new SubjectOptional("English", 85)
                ),
                new StudentOptional("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOptional("Economic", 75),
                        new SubjectOptional("Sociology", 65)
                )
        );
        CollegeOptional college = new CollegeOptional(students);
        assertThat(college.findByAccount("000001").get().getGroup(), is("201-18-15"));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<StudentOptional, Set<SubjectOptional>> students = Map.of(
                new StudentOptional("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOptional("Math", 70),
                        new SubjectOptional("English", 85)
                ),
                new StudentOptional("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOptional("Economic", 75),
                        new SubjectOptional("Sociology", 65)
                )
        );
        CollegeOptional college = new CollegeOptional(students);
        assertThat(college.findBySubjectName("000010", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<StudentOptional, Set<SubjectOptional>> students = Map.of(
                new StudentOptional("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOptional("Math", 70),
                        new SubjectOptional("English", 85)
                ),
                new StudentOptional("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOptional("Economic", 75),
                        new SubjectOptional("Sociology", 65)
                )
        );
        CollegeOptional college = new CollegeOptional(students);
        assertThat(college.findBySubjectName("000001", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalNotEmpty() {
        Map<StudentOptional, Set<SubjectOptional>> students = Map.of(
                new StudentOptional("Student1", "000001", "201-18-15"),
                Set.of(
                        new SubjectOptional("Math", 70),
                        new SubjectOptional("English", 85)
                ),
                new StudentOptional("Student2", "000002", "201-18-15"),
                Set.of(
                        new SubjectOptional("Economic", 75),
                        new SubjectOptional("Sociology", 65)
                )
        );
        CollegeOptional college = new CollegeOptional(students);
        assertThat(college.findBySubjectName("000002", "Sociology").get().getScore(), is(65));
    }
}