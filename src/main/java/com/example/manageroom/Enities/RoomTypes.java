package com.example.manageroom.Enities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "RoomTypes")
@Table(name = "roomtype")
public class RoomTypes {

    @Id
    private Integer room_type_id;
    private String room_type_name;

    public RoomTypes() {
    }

    public RoomTypes(Integer room_type_id, String room_type_name) {
        this.room_type_id = room_type_id;
        this.room_type_name = room_type_name;
    }

    public Integer getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(Integer room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getRoom_type_name() {
        return room_type_name;
    }

    public void setRoom_type_name(String room_type_name) {
        this.room_type_name = room_type_name;
    }

    @Override
    public String toString() {
        return "RoomTypes{" +
                "room_type_id=" + room_type_id +
                ", room_type_name='" + room_type_name + '\'' +
                '}';
    }
}
