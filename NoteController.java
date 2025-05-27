package ru.gb.example_hw_sem6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.example_hw_sem6.model.Note;
import ru.gb.example_hw_sem6.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    // Добавление заметки
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        note.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    // Все заметки
    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    // Поиск по ID
    @GetMapping("{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable("id") Long id) {
        Note note;
        try {
            note = noteService.findNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    // Редактирование
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        note.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    // Удаление
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }


}
