package org.example.dao;

import org.example.model.AppUser;

import java.util.Optional;

public interface AppUserDao {

    AppUser save(AppUser appUser);
    Optional<AppUser> findById (Integer id);
    boolean delete (Integer id);
}
