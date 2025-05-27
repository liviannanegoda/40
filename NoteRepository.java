package ru.gb.example_hw_sem6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.example_hw_sem6.model.Note;



@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
