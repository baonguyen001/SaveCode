package com.example.Practice.entity;

import jakarta.persistence.*;

import java.util.Date;

import com.example.Practice.entity.keys.keyOrderItem;

@Entity(name = "order_item")
public class OrderItem {

   @EmbeddedId
   keyOrderItem keys;

   @ManyToOne
   @JoinColumn(name = "order_id", insertable=false, updatable=false)
   private Orders orders;

   @ManyToOne
   @JoinColumn(name = "food_id", insertable=false, updatable=false)
   private Food food;

    @Column(name = "create_date")
    private Date createDate;

    public keyOrderItem getKeys() {
        return keys;
    }

    public void setKeys(keyOrderItem keys) {
        this.keys = keys;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
