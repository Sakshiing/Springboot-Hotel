package com.Hotel.Hotel.Service;
import com.Hotel.Hotel.Model.Hotel;

import com.Hotel.Hotel.Repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelServiceImp implements HotelService {
    @Autowired

    private HotelRepo hotelRepo;
    public HotelServiceImp(HotelRepo hotelRepo)
    {
        this.hotelRepo=hotelRepo;
    }
    @Override
    public Hotel saveHotel(Hotel hotel)
    {
        return hotelRepo.save(hotel);
    }
    @Override
    public List<Hotel>getAllHotel()
    {
        return hotelRepo.findAll();
    }
    @Override
    public Hotel getHotelById(int id)
    {
        return hotelRepo.findById(id).orElseThrow();
    }
    @Override
    public Hotel updateHotel(Hotel hotel, int id)
    {
        Hotel existingHotel=hotelRepo.findById(id).orElseThrow();
        existingHotel.setName(hotel.getName());
        existingHotel.setEmail(hotel.getPassword());
        existingHotel.setEmail(hotel.getEmail());
        hotelRepo.save(existingHotel);
        return existingHotel;
    }
    @Override
    public void deleteHotel(int id)
    {
        hotelRepo.findById(id).orElseThrow();
        hotelRepo.deleteById(id);
    }

}
