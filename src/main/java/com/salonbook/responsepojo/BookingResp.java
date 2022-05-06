package com.salonbook.responsepojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salonbook.entity.dto.BookingUserDto;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResp {
    @JsonProperty("status")
    private boolean status;

    @JsonProperty("records")
    private List<BookingUserDto> bookingsList;

    @JsonProperty("message")
    private String message;

    public BookingResp(){}

    public BookingResp(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public BookingResp(boolean status, List<BookingUserDto> bookingsList) {
        this.status = status;
        this.bookingsList = bookingsList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BookingUserDto> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(List<BookingUserDto> bookingsList) {
        this.bookingsList = bookingsList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
