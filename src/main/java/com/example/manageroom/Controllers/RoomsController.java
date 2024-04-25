package com.example.manageroom.Controllers;


import com.example.manageroom.DTO.*;
import com.example.manageroom.Services.RoomsService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class RoomsController {

   @Autowired
    private RoomsService roomsService;

    @GetMapping("/rooms")
    public ResponeListRooms listRooms(@RequestParam("hotelId") Integer hotelId, HttpServletResponse response){
        List<ListRooms> rooms = roomsService.listRooms(hotelId);
        return new ResponeListRooms(response.getStatus(),rooms,rooms.size(),"OK");
    }

    @GetMapping("/rooms/types")
    public ResponeDTO listRoomType(HttpServletResponse response){
        List<Object> roomTypes = roomsService.listRoomTypes();
        return new ResponeDTO(response.getStatus(),roomTypes,"OK");
    }

    @GetMapping("/rooms/detail/{id}")
    public  ResponeDetailRoomDTO getDetailedRoom(@PathVariable("id") Integer roomId){
        return new ResponeDetailRoomDTO(HttpServletResponse.SC_OK,roomsService.getDetailedRoom(roomId),"OK");

    }

    @PostMapping("/rooms")
    public ResponeRoomIdDTO addNewRoom(HttpServletResponse response, @RequestBody @Valid AddRoomDTO room){
        Integer roomCode = roomsService.insertRoom(room);
        if(roomCode == 500){
            response.setStatus(500);
            return new ResponeRoomIdDTO(response.getStatus(),null,"Internal Server Error");
        }
        return new ResponeRoomIdDTO(response.getStatus(),roomCode,"OK");
    }

    @PostMapping("/rooms/images")
    public ResponeDTO addRoomImage(HttpServletResponse response, @RequestParam("images") List<MultipartFile> file,@RequestParam("roomId") Integer roomId){
           Integer responseCode = roomsService.insertImage(file,roomId);
           if(responseCode == 500){
               response.setStatus(responseCode);
               return new ResponeDTO(response.getStatus(),null,"Internal Server Error");
           }
        return new ResponeDTO(response.getStatus(),null,"OK");
    }

    @PutMapping("/rooms")
    public ResponeDTO updateRoom(@RequestBody @Valid RequestUpdateRoomDTO rooms,HttpServletResponse response){
        boolean isCheckErrorRoom = roomsService.updateRoom(rooms);
        if(!isCheckErrorRoom){
             response.setStatus(400);
             return new ResponeDTO(response.getStatus(), null,"BAD_REQUEST");
        }
        return new ResponeDTO(response.getStatus(), null,"OK");

    }


    @PutMapping("/rooms/image/{id}")
    public ResponeDTO updateImage(@PathVariable("id") Integer roomId,@RequestParam("image") List<MultipartFile> image, @RequestPart List<String> data){
        Integer httpCode = roomsService.updateRoomImage(roomId,image,data);
        if(httpCode == HttpServletResponse.SC_INTERNAL_SERVER_ERROR){
            return new ResponeDTO(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,null,"Error");
        }
        return new ResponeDTO(HttpServletResponse.SC_OK,null,"OK");
    }
    @DeleteMapping("/rooms")
    public ResponeDTO disableRoom(HttpServletResponse response, @RequestBody @Valid DisableRoomDTO rooms ){
        boolean isCheckErrorRoom = roomsService.disableRoom(rooms.getRoomId(),rooms.isStatus());
        if(!isCheckErrorRoom){
            response.setStatus(500);
            return new ResponeDTO(response.getStatus(),null,"Internal Server Error");
        }
        return new ResponeDTO(response.getStatus(),null,"OK");
    }
}
