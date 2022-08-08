package com.Hotel.Hotel.Repo;
import com.Hotel.Hotel.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotel,Integer> {
    Optional<Hotel> findByEmail(String email);
}
