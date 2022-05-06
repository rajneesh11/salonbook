package com.salonbook.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Bookings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String booked_date;
    private String job;
    private int slot;
    private String booked_on = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
    @Column(name = "user")
    private int userId;
    private int cancelled = 0;
    private int job_served = 0;

    @OneToOne
    @JoinColumn(name = "user", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private User user;

    public Bookings() {
    }

    public Bookings(String booked_date, String job, int slot, int userId) {
        this.booked_date = booked_date;
        this.job = job;
        this.slot = slot;
        this.userId = userId;
    }

    public Bookings(int id, String booked_date, String job, int slot, String booked_on, int userId, int cancelled, int job_served) {
        this.id = id;
        this.booked_date = booked_date;
        this.job = job;
        this.slot = slot;
        this.booked_on = booked_on;
        this.userId = userId;
        this.cancelled = cancelled;
        this.job_served = job_served;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(String booked_date) {
        this.booked_date = booked_date;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getBooked_on() {
        return booked_on;
    }

    public void setBooked_on(String booked_on) {
        this.booked_on = booked_on;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public int getJob_served() {
        return job_served;
    }

    public void setJob_served(int job_served) {
        this.job_served = job_served;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ",booked_date:" + this.booked_date + ",job:" + this.job + ",slot:" + this.slot +
                ",booked_on:" + this.booked_on + ",cancelled:" + this.cancelled + ",job_served:" + this.job_served +
                ",user:" + this.userName;
    }*/
}