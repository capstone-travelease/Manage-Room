package com.example.manageroom.DTO;


import lombok.Data;

import java.util.List;


@Data
public class ListRooms {

    private Integer roomId;
    private String roomName;
    private Long roomPrice;
    private Integer status;
    private Integer roomQuantity;
    private String roomType;
    private List<String> imageUrl;

    public ListRooms() {
    }

    public ListRooms(Integer roomId, String roomName, Long roomPrice, Integer status, Integer roomQuantity, String roomType) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.status = status;
        this.roomQuantity = roomQuantity;
        this.roomType = roomType;

    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Long roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }



    @Override
    public String toString() {
        return "ListRooms{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomPrice=" + roomPrice +
                ", status=" + status +
                ", roomQuantity=" + roomQuantity +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}



