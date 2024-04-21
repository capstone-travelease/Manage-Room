package com.example.manageroom.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisableRoomDTO {

    @NotNull
    private Integer roomId;
    @NotNull
    private boolean status;
}
