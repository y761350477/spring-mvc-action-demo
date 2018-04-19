package entity;


import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class Account {

    @NotNull
    @Size(min = 0, max = 10)
    private String user;

    @NotNull
    @Size(min = 0, max = 10)
    private String pwd;

    public Account() {
    }

    public Account(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
