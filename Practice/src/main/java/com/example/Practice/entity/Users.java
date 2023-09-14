package com.example.Practice.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> listratingFoods;

    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> listRatingRestaurants;

    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrders;

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    public Set<RatingRestaurant> getListRatingRestaurants() {
        return listRatingRestaurants;
    }

    public void setListRatingRestaurants(Set<RatingRestaurant> listRatingRestaurants) {
        this.listRatingRestaurants = listRatingRestaurants;
    }

    public Set<RatingFood> getListratingFoods() {
        return listratingFoods;
    }

    public void setListratingFoods(Set<RatingFood> listratingFoods) {
        this.listratingFoods = listratingFoods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
