package abreualtopeca.loginpage.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import abreualtopeca.loginpage.controller.CreateUserDto;
import abreualtopeca.loginpage.entity.User;
import abreualtopeca.loginpage.repository.UserRepository;

@Service // INDICA QUE ESSA CLASSE É CONTEM REGRA DE NEGOCIO, FAZENDO COM QUE O STRING IDENTIFIQUE O userRepository COMO UMA INJECAO
public class UserService {

    // CRIACAO DO METODO DE INJECAO DE DEPENDENCIA UserService == UserRepository (repository) + CreateUserDto (controller)

    private UserRepository userRepository;
   
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    } //CONSTRUTOR userRepository

    

    public UUID  createUser(CreateUserDto createUserDto){ //salvar usuario
           
        // DTO --> ENTITY

        var entity = new User(
                     createUserDto.login(), 
                     createUserDto.senha(),
                     null);

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
        
    }

    public Optional<User> getUserById(String userId) //verificar usuario
    {
      return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUsers()//hgft6ftftr
    {
        return userRepository.findAll();

        
    }
}
