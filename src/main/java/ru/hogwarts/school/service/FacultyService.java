package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(lastId++);
        faculties.put(lastId, faculty);
        return faculty; // добавили
    }

    public Faculty findFaculty(long id) {
        return faculties.get(id); // вывели
    }

    public Faculty editFaculty(Long id, Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty); // заменили}
            return faculty;
        }
    return null;
}

    public Faculty deletedFaculty(long id) {
        return faculties.remove(id); // удалили
    }

    public Collection<Faculty> filterByColor(String color) {
        return faculties.values().stream()
                .filter(f ->f.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList()); //wite=wite
    }
}
