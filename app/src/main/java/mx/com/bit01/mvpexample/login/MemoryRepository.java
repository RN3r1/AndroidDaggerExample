package mx.com.bit01.mvpexample.login;

/**
 * Created by roeeyn on 30/09/17.
 */

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {
        if(user == null){
            User user = new User("rodrigo", "medina");
            user.setId(0);
            return user;
        }else{

            return user;

        }
    }

    @Override
    public void saveUser(User user) {

        if(user == null){

            user = getUser();

        }

        this.user = user;

    }

}
