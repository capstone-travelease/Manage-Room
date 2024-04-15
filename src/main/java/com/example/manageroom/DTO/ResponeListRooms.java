package com.example.manageroom.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponeListRooms {
    private Integer code;
    private List<ListRooms> list;
    private Integer total;
    private String message;
}
