package com.example.demo.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Services.SessionService;

@Service
public class UserRootService implements UserDetailsService {
  private final AccountDAO userRepo;
  @Autowired
  SessionService session;
  public UserRootService(AccountDAO userRepo) {
    this.userRepo = userRepo;
  }

  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    Account user = userRepo.findByUsername(username)
        .orElseThrow(() ->
            new UsernameNotFoundException("User not found with username : " + username)
        );
    session.set("acc", user);
    return UserRoot.create(user);
  }
}
