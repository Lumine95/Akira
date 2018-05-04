package com.zmm.akira.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ZMM on 2018/5/4 11:17.
 */

@Entity
public class TestEntity {
    @Id
    private long id;
    private String name;
    private int age;
    @Generated(hash = 1907074098)
    public TestEntity(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 1020448049)
    public TestEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setId(long id) {
        this.id = id;
    }

}
