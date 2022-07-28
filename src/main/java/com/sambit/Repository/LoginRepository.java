package com.sambit.Repository;

import com.sambit.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, Integer> {
//    public LoginBean findByUsernameAndPassword(LoginBean loginBean);
//    @Query("FROM Login l where l.username=:username and l.password=:password")
    Login findByUsernameAndPassword(String username, String password);

}
