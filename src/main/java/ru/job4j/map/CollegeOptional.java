package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CollegeOptional {
    private final Map<StudentOptional, Set<SubjectOptional>> students;

    public CollegeOptional(Map<StudentOptional, Set<SubjectOptional>> students) {
        this.students = students;
    }

    public Optional <StudentOptional> findByAccount(String account) {
        Optional<StudentOptional> rsl = Optional.empty();
        for (StudentOptional s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<SubjectOptional> findBySubjectName(String account, String name) {
        Optional<SubjectOptional> rsl = Optional.empty();
        Optional<StudentOptional> s = findByAccount(account);
        if (s.isPresent()) {
            Set<SubjectOptional> subjects = students.get(s.get());
            for (SubjectOptional subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
