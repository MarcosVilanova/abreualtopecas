package abreualtopeca.loginpage.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name= "usuario") //NOME DA TABELA NO BANCO DA DADOS
public class User {
    
    @Id //INDICA O CAMPO USER ID COMO PsRIMARY KEY 
    @GeneratedValue(strategy = GenerationType.UUID) // GERA O MEU PRIMARY KEY DE FORMA AUTOMATICA
    private UUID userId;

    @Column(name = "login") // DEFINE O NOME DA COLUNA NO BANCO DE DADOS
    private String login ;

    @Column(name = "senha")
    private String senha ; // DEFINE O NOME DA COLUNA NO BANCO DE DADOS

    //CRIAÇÃO DE CONSTRUTURES

    public User()
    {} 

    public User(String login, String senha, UUID userId) {
        this.login = login;
        this.senha = senha;
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //CRIACAO DOS GETTERS E SETTERS

   



}
