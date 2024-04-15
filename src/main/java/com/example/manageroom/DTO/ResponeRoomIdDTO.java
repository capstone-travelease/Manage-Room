package com.example.manageroom.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class ResponeRoomIdDTO {
    private Integer code;
    private Integer roomId;
    private String message;
}
