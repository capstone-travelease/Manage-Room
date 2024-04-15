package com.example.manageroom.Repositories;

import com.example.manageroom.DTO.ListRooms;
import com.example.manageroom.Enities.Rooms;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms,Integer> {
      @Query("SELECT new com.example.manageroom.DTO.ListRooms(r.room_id,r.room_name, r.room_price, r.room_status, r.room_quantity, rt.room_type_name)\n" +
              "FROM Rooms r\n" +
              "INNER JOIN RoomTypes rt ON rt.room_type_id = r.room_type_id\n" +
              "WHERE r.hotel_id = ?1")
      List<ListRooms> listRoooms(Integer hotelId);


      @Query("SELECT a.file_url\n" +
              "FROM Rooms r\n" +
              "INNER JOIN RoomAttachment ra ON r.room_id = ra.room_id\n" +
              "INNER JOIN Attachment a ON a.attachment_id = ra.attachment_id\n" +
              "WHERE r.room_id = ?1")
      List<String> listImage(Integer roomId);

      @Query("SELECT rt FROM RoomTypes rt")
      List<Object> listRoomType();

      @Query(value = "INSERT INTO public.rooms(\n" +
              "\t room_name, room_status, room_price, room_type_id, hotel_id, room_quantity)\n" +
              "\tVALUES (?1, ?2, ?3, ?4, ?5, ?6) returning room_id",nativeQuery = true)
      Integer addNewRoom(String roomName, Integer roomStatus, Long roomPrice, Integer roomType, Integer hotelId, Integer roomQuantity);



      @Transactional
      @Modifying
      @Query(value = "INSERT INTO public.roomdetail(\n" +
              "\t room_id, room_description, room_size, room_bed_quantity, room_capacity)\n" +
              "\tVALUES (?1, ?2, ?3, ?4, ?5);",nativeQuery = true)
      void addDetailedRoom(Integer roomId, String roomDescription, String roomSize, Integer roomBedQuantity, Integer roomCapacity);

      @Transactional
      @Modifying
      @Query(value = "INSERT INTO public.room_facilities(\n" +
              "\troom_id, facility_id)\n" +
              "\tVALUES (?1, ?2 );",nativeQuery = true)
      void insertRoomFacilites(Integer roomId, Integer facilityId);


      @Query(value = "INSERT INTO public.attachment(\n" +
              "\t upload_at, file_url)\n" +
              "\tVALUES (?1, ?2) returning attachment_id",nativeQuery = true)
      Integer insertImage(Date uploadAt, String fileUrl);

      @Transactional
      @Modifying
      @Query(value = "INSERT INTO public.room_attachment(\n" +
              "\tattachment_id, room_id)\n" +
              "\tVALUES (?1, ?2);",nativeQuery = true)
      void insertRoomImage(Integer attachmentId, Integer roomId);


      @Transactional
      @Modifying
      @Query(value = "UPDATE public.rooms r\n" +
              "\tSET room_status= ?2\n" +
              "\tWHERE r.room_id = ?1;",nativeQuery = true)
      void disableRoom(Integer roomId, Integer roomStatus);
}
