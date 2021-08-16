package com.weiz.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * 权限表
 */
@Getter
@Setter
@Entity
@Table(name="Permissions")
public class Permissions {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String url;
    @Column(name="perm_code")
    private String permCode;

    /**
     * 注意不能2边用mappedBy:这个属性就是维护关系的意思！谁主类有此属性谁不维护关系。
     * 比如2个多对多的关系是由role中的permissions维护的，那么，只有操作role方，指定permissions，才可建立外键的关系。
     * 注意:只有OneToOne，OneToMany，ManyToMany上才有mappedBy属性，ManyToOne不存在该属性； 并且mappedBy一直和joinXX互斥。
     */
    @ManyToMany(mappedBy="permissions",fetch = FetchType.LAZY)
    private Set<Roles> roles;
}
