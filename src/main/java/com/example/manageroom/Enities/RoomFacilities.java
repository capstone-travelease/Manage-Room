package com.example.manageroom.Enities;


import jakarta.persistence.*;

@Entity
@Table(name = "room_facilities")
public class RoomFacilities {
    private Integer room_id;
    private Integer facility_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer room_facilities_id;
}
