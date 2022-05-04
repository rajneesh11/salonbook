package com.salonbook.entity.dto;

public class BookingUserDto {
    private int id;
    private String booked_date;
    private String job;
    private int slot;
    private String booked_on;
    private int cancelled;
    private int job_served;
    private String user;

    public BookingUserDto(int id, String booked_date, String job, int slot, String booked_on, String user, int cancelled, int job_served) {
        this.id = id;
        this.booked_date = booked_date;
        this.job = job;
        this.slot = slot;
        this.booked_on = booked_on;
        this.cancelled = cancelled;
        this.job_served = job_served;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookingUserDto[" +
                "id=" + id +
                ", booked_date='" + booked_date + '\'' +
                ", job='" + job + '\'' +
                ", slot=" + slot +
                ", booked_on='" + booked_on + '\'' +
                ", cancelled=" + cancelled +
                ", job_served=" + job_served +
                ", user='" + user + '\'' +
                ']';
    }
}
