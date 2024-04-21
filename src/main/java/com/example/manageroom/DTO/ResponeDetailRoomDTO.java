package com.example.manageroom.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponeDetailRoomDTO {
    private Integer code;
    private DetailedRoomDTO data;
    private String message;
}
