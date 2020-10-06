package cn.SliverSea.pojo;

public class User {
    private String userName;
    private String password;
    private String name;

    public User() {
        super();
    }
    public User(String account,String password,String name){
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return name;
    }

    public void setAccount(String account) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
