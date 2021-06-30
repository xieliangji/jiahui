package jc.sugar.JiaHui.entity.vo;

/**
 * @Code 谢良基 2021/6/25
 */
public class AccountSignUpVO {

    private String username;

    private String email;

    private String password;

    private String repeatPassword;

    public AccountSignUpVO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
