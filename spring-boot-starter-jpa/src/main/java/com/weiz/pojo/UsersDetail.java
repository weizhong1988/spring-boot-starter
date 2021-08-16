package com.weiz.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "UsersDetail")
public class UsersDetail {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private Integer age;

    @Override
    public String toString() {
        return String.format("UsersDetail [id=%s, address=%s, age=%s]", id,address,age);
    }
}
