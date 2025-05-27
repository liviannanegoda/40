package ru.gb.example_hw_sem6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.example_hw_sem6.model.Note;
import ru.gb.example_hw_sem6.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    // Добавление заметки
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    // Все заметки
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    // Поиск заметки по ID
    public Note findNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    // Редактирование заметки
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    // Удаление заметки
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
