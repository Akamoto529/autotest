package Wrappers.Accounts;

public class Bot {
    private final String login;
    private final String password;

    public Bot(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
