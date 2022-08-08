package com.Hotel.Hotel.Service;

import com.Hotel.Hotel.Model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);

    List<Hotel>getAllHotel();

    Hotel getHotelById(int id);

    Hotel updateHotel(Hotel hotel, int id);

    void deleteHotel(int id);





}
