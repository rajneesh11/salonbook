package com.salonbook.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Bookings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String booked_date;
    private String job;
    private int slot;
    private String booked_on;
    @Column(name = "user")
    private int userId;
    private int cancelled;
    private int job_served;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public Bookings() {
    }

    public Bookings(int id, String booked_date, String job, int slot, String booked_on, int userId, int cancelled, int job_served, User user) {
        this.id = id;
        this.booked_date = booked_date;
        this.job = job;
        this.slot = slot;
        this.booked_on = booked_on;
        this.userId = userId;
        this.cancelled = cancelled;
        this.job_served = job_served;
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
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
}