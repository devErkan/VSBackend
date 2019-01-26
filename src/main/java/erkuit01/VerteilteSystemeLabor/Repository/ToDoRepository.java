package erkuit01.VerteilteSystemeLabor.Repository;

import erkuit01.VerteilteSystemeLabor.Datenbank.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    void deleteById(UUID fromString);
}
