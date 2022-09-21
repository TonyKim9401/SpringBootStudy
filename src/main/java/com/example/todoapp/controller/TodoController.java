package com.example.todoapp.controller;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.repository.TodoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        Todo toDo = new Todo();
        toDo.setTodo(todo);
        todoRepository.save(toDo);
        return "redirect:/";
    }

}
