package com.example.manageroom.DTO;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@AllArgsConstructor
public class RequestUpdateRoomDTO {
    @NotNull
   private Integer roomId;
    @NotNull
    @NotBlank
   private String roomName;
    @NotNull
   private boolean roomStatus;
    @NotNull
   private Long roomPrice;
    @NotNull
   private Integer roomType;
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
    private List<Integer> facilities;
}
