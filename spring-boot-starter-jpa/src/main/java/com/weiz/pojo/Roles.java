package com.weiz.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue()
    private Long id;

    private String name;
    /**
     * cascade表示级联操作，all是全部，一般用MERGE 更新,persist表示持久化即新增
     * 此类是维护关系的类，删除它，可以删除对应的外键,但是如果需要删除对应的权限就需要CascadeType.all
     * cascade:作用在本放，对于删除或其他操作本方时，对标注连接方的影响！和数据库一样！！
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name="permission_role")
    private Set<Permissions> permissions = new HashSet<Permissions>();

    @OneToMany(mappedBy="role",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Users> users = new HashSet<Users>();
}
