package abreualtopeca.loginpage.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abreualtopeca.loginpage.entity.User;
import abreualtopeca.loginpage.service.UserService;

@RestController
@RequestMapping("/bd/user") 
public class UserController {
    
    // UserController --> UserService --> UserRepository

    // INJECAO DE DEPENDENCIA UserService 

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CRIACAO DOS ENDPOINTS 

    @PostMapping // ROTA DE CRIACAO DE USUARIO
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) //PostMapping PUXA OS DADOS DA CreateUserDto
    {
        var userId = userService.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/bd/user/" + userId.toString())).build();
       
    }

    @GetMapping("/{userId}") // ROTA PARA CONSULTA DE USUARIO RECEBENDO O CAMPO userId DEFINIDO COMO PRIMARY KEY
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId)
    {
        var user = userService.getUserById(userId);
        if(user.isPresent())
        {
            return ResponseEntity.ok(user.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }  
}
