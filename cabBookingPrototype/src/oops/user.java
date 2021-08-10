/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oops;

/**
 *
 * @author tulaib pc
 */
public class user {
    String name;
    String id;
    String password;
    String phone;
    String email;
    int money=300;
    int index;
    public user(){}
    public user(String name, String id, String password, String phone, String email,int index) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.index=index;
    }
    public int getMoney(){
        return money;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
