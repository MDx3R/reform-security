package com.example.demo.model.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      SELECT t FROM Token t INNER JOIN User u\s
      on t.user.id = u.id\s
      WHERE u.id = :id AND (t.expired = false AND t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Integer id);

//    @Query(value = """
//      SELECT t FROM Token t INNER JOIN User u\s
//      on t.user.id = u.id\s
//      WHERE u.id = :id AND (t.expired = false AND t.revoked = false) AND t.token_type = 'ACCESS'\s
//      """)
//    List<Token> findAllValidAccessTokenByUser(Integer id);
//
//    @Query(value = """
//      SELECT t FROM Token t INNER JOIN User u\s
//      on t.user.id = u.id\s
//      WHERE u.id = :id AND (t.expired = false AND t.revoked = false) AND t.token_type = 'REFRESH'\s
//      """)
//    List<Token> findValidRefreshTokenByUser(Integer id);

    Optional<Token> findByToken(String token);

}
