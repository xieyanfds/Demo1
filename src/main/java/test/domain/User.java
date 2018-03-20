package test.domain;

/**
 * Created by Administrator on 2017/11/28.
 */
public class User {
    private String username;

    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
    public User(){

    }

    @Override
    public String toString() {
        return getUsername()+":"+getPwd();
    }
}
