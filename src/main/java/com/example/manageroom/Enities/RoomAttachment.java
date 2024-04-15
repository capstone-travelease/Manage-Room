package com.example.manageroom.Enities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "RoomAttachment")
@Table(name = "room_attachment")
public class RoomAttachment {
    @Id
    private Integer room_id;
    private Integer attachment_id;

    public RoomAttachment() {
    }

    public RoomAttachment(Integer room_id, Integer attachment_id) {
        this.room_id = room_id;
        this.attachment_id = attachment_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getAttachment_id() {
        return attachment_id;
    }

    public void setAttachment_id(Integer attachment_id) {
        this.attachment_id = attachment_id;
    }

    @Override
    public String toString() {
        return "RoomAttachment{" +
                "room_id=" + room_id +
                ", attachment_id=" + attachment_id +
                '}';
    }
}
