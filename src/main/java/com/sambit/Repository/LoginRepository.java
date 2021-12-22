package com.sambit.Repository;

import com.sambit.Bean.LoginBean;
import com.sambit.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
//    public LoginBean findByUsernameAndPassword(LoginBean loginBean);
    Login findByUsernameAndPassword(String username, String password);
}
