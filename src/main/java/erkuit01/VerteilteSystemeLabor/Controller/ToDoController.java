package erkuit01.VerteilteSystemeLabor.Controller;

import erkuit01.VerteilteSystemeLabor.Datenbank.ToDo;
import erkuit01.VerteilteSystemeLabor.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    //gibt aktuelle db aus
    @GetMapping("todo/all")
    public List<ToDo> GetTodos(){
        return toDoRepository.findAll();
    }

    @GetMapping("todo/{id}")
    public ToDo getToDo(@PathVariable Long id) {
        return toDoRepository.getOne(id);
    }


    //POST ->  HTTP REQ
    @PostMapping("todo")
    public void AddTodo(@RequestBody String aufgabe){
        ToDo t = new ToDo();
        t.setAufgabe(aufgabe);
        toDoRepository.save(t);
    }

    @DeleteMapping("/{id}")
    public void DeleteTodo(@PathVariable String id){
        toDoRepository.deleteById(Long.parseLong(id));
    }
}
