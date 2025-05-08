package abreualtopeca.loginpage.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import abreualtopeca.loginpage.entity.User;

@Repository // DEFINE A INTERFACE COMO REPOSITORY E FAZ CONEXAO COM BANCO DE DADOS
public interface UserRepository extends JpaRepository<User, UUID>{
    // JpaRepository RECEBE O TIPO DA ENTIDADE (User) & TIPO DO ID (UUID)
}
