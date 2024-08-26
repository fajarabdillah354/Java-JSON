package fajar.belajar.JSON;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Student {


    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @JsonProperty("Full_Name")//memberi nama pada tampilan json sebagai Full_Name
    private String fullname;

    @JsonIgnore//akan meng ignore field password dalam  tampilan json, sehingga password tidak tampak
    private String password;

    @NotNull
    private int grade;

    private List<String> hobbies;

    private Date CreatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd")//membuat pattern baru untuk field UpdateAt
    private Date UpdateAt;

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
