package com.example.exam_two_backend.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailAddressAndPassword(String user, String pass);
    List<User> findByEmailAddress(String email);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username=:username, u.emailAddress=:email, u.password=:password WHERE u.id=:id")
    void updateUser(@Param("username") String username, @Param("email") String email, @Param("password") String password, @Param("id") Long id);

    List<User> findByUsernameAndPassword(String username, String password);
    List<User> findUserByUserType(String userType);
    List<User> findUserByUsernameContainingIgnoreCase(String username);
    List<User> findUserByUsernameContainingIgnoreCaseAndPassword(String username, String password);
    List<User> findUserByUsernameContainingIgnoreCaseAndUserType(String username, String type);

    User findUserByUsername(String username);

    List<User> findUserByUsernameIgnoreCase(String username);

    List<User> findUsersByUserTypeIgnoreCase(String type);

    List<User> findUsersById(Long id);

    //List<User> findByUserSubjects(String subjects);

    //subjectList findByUser_Subjects(subjectList User_Subjects);
}