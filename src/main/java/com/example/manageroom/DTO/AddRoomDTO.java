package com.example.manageroom.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddRoomDTO {

    @NotNull
    @NotBlank
    private String roomName;

    @NotNull
    private Integer roomStatus;

    @NotNull
    private Long roomPrice;

    @NotNull
    private Integer roomType;

    @NotNull
    private Integer hotelId;

    @NotNull
    private Integer roomQuantity;


    @NotNull
    @NotBlank
    private String roomDescription;

    @NotNull
    @NotBlank
    private String roomSize;

    @NotNull
    private Integer roomBedQuantity;

    @NotNull
    private Integer roomCapacity;

    @NotNull
    @NotEmpty
    private List<Integer> roomFacilites;
}
