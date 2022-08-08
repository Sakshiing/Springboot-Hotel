package com.Hotel.Hotel.Controller;

import com.Hotel.Hotel.Model.Hotel;
import com.Hotel.Hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/Hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {

        this.hotelService = hotelService;
    }
    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
    {
        return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Hotel> getAllHotel()
    {
        return hotelService.getAllHotel();}


    @GetMapping("{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") int id)
    {
        return new ResponseEntity<Hotel>(hotelService.getHotelById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") int id,@RequestBody Hotel hotel)
    {
        return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") int id)
    {
        hotelService.deleteHotel(id);
        return new ResponseEntity<String>("Details deleted successfully",HttpStatus.OK);
    }

}
