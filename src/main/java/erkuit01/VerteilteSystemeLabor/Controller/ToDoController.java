package erkuit01.VerteilteSystemeLabor.Controller;

import erkuit01.VerteilteSystemeLabor.Datenbank.ToDo;
import erkuit01.VerteilteSystemeLabor.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;


    @GetMapping("todo/all")
    public List<ToDo> GetTodos(){
        return toDoRepository.findAll();
    }
    
    @PostMapping("todo")
    public void AddTodo(@RequestBody String aufgabe){
        ToDo t = new ToDo();
        t.setAufgabe(aufgabe);
        toDoRepository.save(t);
    }

}
