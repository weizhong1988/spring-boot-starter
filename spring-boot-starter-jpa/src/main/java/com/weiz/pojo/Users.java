package com.weiz.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String account;
    private String pwd;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="detailId",referencedColumnName = "id")
    private UsersDetail userDetail;

    /**1对多，多的一方必须维护关系，即不能指定mapped=""**/
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name="role_id")
    private Roles role;

    @Override
    public String toString() {
        return String.format("Book [id=%s, name=%s, user detail=%s]", id, userDetail.getId());
    }
}