package org.example;

import org.example.dao.AppUserDao;
import org.example.model.AppUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class App{

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //using for AnnotationConfigApplicationContext for load this class and used
    AppUserDao dao = context.getBean("appUserDao", AppUserDao.class );
    AppUser addAppUser = dao.save(new AppUser("Test", "test@yahoo.com","345555", "Vaxjo"));
    Optional<AppUser> user = dao.findById(addAppUser.getId());

    /*public static void main( String[] args ) {
        AppUserDaoImplement dao = new AppUserDaoImplement();
        AppUser newAppUser = dao.save(new AppUser("Test", "test@yahoo.com","345555", "Vaxjo"));
        System.out.println("newAppUser =" + newAppUser);
        Optional<AppUser> findAppUser = dao.findById(newAppUser.getId());
        System.out.println("findAppUser =" + findAppUser);
    }*/
}

