package com.zc.blog.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class User  {

    @Id
    // 根据数据库自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "姓名不能为空")
    @Size(min=2,max=20)
    private String name;

    @NotEmpty(message = "邮箱不能为空")
    @Size(min = 2,max = 20)
    @Email(message = "邮箱格式不对")
    private String email;

    @NotEmpty(message = "账号不能为空")
    @Size(min = 3, max = 20)
    private String useranme;

    @NotEmpty(message = "密码不能为空")
    private String password;
    private String avatar;

    // 防止直接使用
    protected User() {
    }

    public User(String name, String email, String useranme, String password, String avatar) {
        this.name = name;
        this.email = email;
        this.useranme = useranme;
        this.password = password;
        // 用户头像
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUseranme() {
        return useranme;
    }

    public void setUseranme(String useranme) {
        this.useranme = useranme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", useranme='" + useranme + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(useranme, user.useranme) &&
                Objects.equals(password, user.password) &&
                Objects.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, useranme, password, avatar);
    }
}
