package com.example.manageroom.Enities;


import jakarta.persistence.*;

@Entity
@Table
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer room_id;
    private String room_name;
    private Integer room_status;
    private Long room_price;
    private Integer room_type_id;
    private Integer hotel_id;
    private Integer room_quantity;

    public Rooms() {
    }

    public Rooms(Integer room_id, String room_name, Integer room_status, Long room_price, Integer room_type_id, Integer hotel_id, Integer room_quantity) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_status = room_status;
        this.room_price = room_price;
        this.room_type_id = room_type_id;
        this.hotel_id = hotel_id;
        this.room_quantity = room_quantity;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Integer getRoom_status() {
        return room_status;
    }

    public void setRoom_status(Integer room_status) {
        this.room_status = room_status;
    }

    public Long getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Long room_price) {
        this.room_price = room_price;
    }

    public Integer getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(Integer room_type_id) {
        this.room_type_id = room_type_id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getRoom_quantity() {
        return room_quantity;
    }

    public void setRoom_quantity(Integer room_quantity) {
        this.room_quantity = room_quantity;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "room_id=" + room_id +
                ", room_name='" + room_name + '\'' +
                ", room_status=" + room_status +
                ", room_price=" + room_price +
                ", room_type_id=" + room_type_id +
                ", hotel_id=" + hotel_id +
                ", room_quantity=" + room_quantity +
                '}';
    }
}
