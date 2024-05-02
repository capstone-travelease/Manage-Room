package com.example.manageroom.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DetailedRoomDTO {
    private Integer roomId;
    private String roomName;
    private Integer roomType;
    private boolean roomStatus;
    private Long roomPrice;
    private Integer roomQuantity;
    private String roomDescription;
    private String roomSize;
    private Integer roomBedQuantity;
    private Integer roomCapacity;

    public List<Integer> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Integer> facilities) {
        this.facilities = facilities;
    }

    public List<String> getImagePath() {
        return imagePath;
    }

    public void setImagePath(List<String> imagePath) {
        this.imagePath = imagePath;
    }

    private List<Integer> facilities;
    private List<String> imagePath;

    public DetailedRoomDTO(Integer roomId, String roomName, Integer roomType, boolean roomStatus, Long roomPrice, Integer roomQuantity, String roomDescription, String roomSize, Integer roomBedQuantity, Integer roomCapacity) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.roomPrice = roomPrice;
        this.roomQuantity = roomQuantity;
        this.roomDescription = roomDescription;
        this.roomSize = roomSize;
        this.roomBedQuantity = roomBedQuantity;
        this.roomCapacity = roomCapacity;
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

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Long roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Integer getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(Integer roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public Integer getRoomBedQuantity() {
        return roomBedQuantity;
    }

    public void setRoomBedQuantity(Integer roomBedQuantity) {
        this.roomBedQuantity = roomBedQuantity;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    @Override
    public String toString() {
        return "DetailedRoomDTO{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomType=" + roomType +
                ", roomStatus=" + roomStatus +
                ", roomPrice=" + roomPrice +
                ", roomQuantity=" + roomQuantity +
                ", roomDescription='" + roomDescription + '\'' +
                ", roomSize='" + roomSize + '\'' +
                ", roomBedQuantity=" + roomBedQuantity +
                ", roomCapacity=" + roomCapacity +
                '}';
    }
}
