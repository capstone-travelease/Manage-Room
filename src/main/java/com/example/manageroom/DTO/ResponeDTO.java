package com.example.manageroom.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponeDTO {
    private Integer code;
    private List<Object> list;
    private String message;
}
