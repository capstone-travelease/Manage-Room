package com.example.manageroom.Services;

import com.example.manageroom.DTO.AddRoomDTO;
import com.example.manageroom.DTO.ListRooms;
import com.example.manageroom.DTO.ResponeDTO;
import com.example.manageroom.Repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class RoomsService {

    private final String FOLDER_PATH = "D:\\Travel Market Place\\Image_Capstone\\";

    @Autowired
    private RoomsRepository roomsRepository;

    public List<ListRooms> listRooms(Integer hotelId){

        List<ListRooms> roomlists = roomsRepository.listRoooms(hotelId);
        for (ListRooms i: roomlists) {
            i.setImageUrl(getImageUrl(i.getRoomId()));
        }
        return roomlists;
    }
    public List<Object> listRoomTypes(){
        return roomsRepository.listRoomType();
    }

    private List<String> getImageUrl(Integer roomId){
        return roomsRepository.listImage(roomId);
    }

    public Integer insertRoom(AddRoomDTO room){
        try {
            Integer roomId = roomsRepository.addNewRoom(room.getRoomName(),room.getRoomStatus(),room.getRoomPrice(),room.getRoomType(),room.getHotelId(),room.getRoomQuantity());
            boolean isCheckDetailedRoom = insertDetailedRoom(roomId,room.getRoomDescription(),room.getRoomSize(),room.getRoomBedQuantity(),room.getRoomCapacity());
            boolean isCheckRoomFacilities = insertRoomFacilities(roomId,room.getRoomFacilites());
            if(!isCheckDetailedRoom || !isCheckRoomFacilities){
                return 500;
            }
            return roomId;
        }catch (Exception ex){
            System.err.println(ex);
            return 500;
        }
    }

    public Integer insertImage(List<MultipartFile> image,Integer roomId)  {
        try {
            for (MultipartFile i: image) {
                String fileUrl = FOLDER_PATH+i.getOriginalFilename();
                // tranfer from data of api to folder
                i.transferTo(new File(fileUrl));
                String imagePath = "/room_images/" + i.getOriginalFilename();
                Date now = new Date();
                Integer attachmentId = roomsRepository.insertImage(now,imagePath);
                boolean isCheckErrorRoomImage = insertRoomImage(attachmentId,roomId);
                if(!isCheckErrorRoomImage){
                    return 500;
                }
            }
            return 200;
        }catch (Exception ex){
            System.err.println(ex);
            return 500;
        }
    }

    public boolean disableRoom(Integer roomId, Integer roomStatus){
        try {
            roomsRepository.disableRoom(roomId,roomStatus);
            return true;
        }catch (Exception ex){
            System.err.println(ex);
            return false;
        }
    }
    private boolean insertRoomImage(Integer attachmentId, Integer roomId){
          try {
              roomsRepository.insertRoomImage(attachmentId,roomId);
              return true;
          }catch (Exception ex){
              System.err.println(ex);
              return false;
          }
    }

    private boolean insertDetailedRoom(Integer roomId,String roomDescription, String roomSize, Integer roomBedQuantity, Integer roomCapacity){
        try {
            roomsRepository.addDetailedRoom(roomId,roomDescription,roomSize,roomBedQuantity,roomCapacity);
            return true;
        }catch (Exception ex){
            System.err.println(ex);
            return false;
        }
    }

    private boolean insertRoomFacilities(Integer roomId, List<Integer> facilites){
        try {
            for (Integer i: facilites) {
                roomsRepository.insertRoomFacilites(roomId,i);
            }
            return true;
        }catch (Exception ex){
            System.err.println(ex);
            return false;
        }
    }




}
