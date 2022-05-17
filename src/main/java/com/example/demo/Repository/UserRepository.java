package com.example.demo.Repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    /** Jpa Methods */

    // find top 2 users where name starts with name
    List<User> findTop2ByNameStartsWith(String name);

    // find users by name and surname (?1, ?2)
    List<User> findByNameAndSurname(String name, String surname);

    // find users where email contains email sorted by surname (asc)
    List<User> findFirstByEmailContainingOrderBySurname(String email);



    // find users where name starts with A order by surname (asc)
    @Query(value = "select * from users where name like 'A%' order by surname", nativeQuery = true)
    List<User> findAllSorted();

    // find users where id greater than qid
    @Query(value = "select * from users where id > :qid", nativeQuery = true)
    List<User> findByGreaterId(Long qid);

    List<User> findByEmailContainingOrderByNameDesc(String email);
//
//    List<User> findByEmailContainingOrderByNameDesc(String email);
//
//    List<User> findByEmailEndsWith(String email1);
//
//    List<User> findBySurnameContaining(String surname3);
//
//    List<User> findByOrderById();
//
//    List<User> findTop2ByOrderByIdDesc();
//
//    List<User> findByOrderByNameDesc();
//
//    List<User> findByEmailNotContaining(String email7);
//
//    List<User> findAllW();
//
//    List<User> findAllQ();
//
//    List<User> findAllE();
}