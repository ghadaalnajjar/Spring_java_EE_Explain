package org.example.dao;

import org.example.model.AppUser;
import org.example.sequence.AppUserSequence;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component("AppUserDao") //Annotation
public class AppUserDaoImplement implements AppUserDao {
    private Set<AppUser> appUsers = new HashSet<>();

    @Override
    public AppUser save(AppUser appUser){
        if (appUser.getId() == null) {
            appUser.setId(AppUserSequence.nextAppUserId());
            appUsers.add(appUser);
        } else {
            Optional<AppUser> findAppUser = findById(appUser.getId());
            AppUser original = findAppUser.orElseThrow(IllegalArgumentException::new);
            original.setName(appUser.getName());
            original.setEmail(appUser.getEmail());
            original.setPassword(appUser.getPassword());
            original.setAddress(appUser.getAddress());
        }
        return appUser;
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return appUsers.stream().filter(appUser -> appUser.getId().equals(id)).findFirst();
    }

    @Override
    public boolean delete(Integer id) {
        AppUser appUser = findById(id).orElseThrow(IllegalArgumentException::new);
        return appUsers.remove(appUser);
    }
}
