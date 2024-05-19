public class Account{
    String userName;
    String passWord;
    public Account(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    public String getUserName(){
        return userName;
    }

    public  String getPassWord(){
        return passWord;
    }
}

