package com.Hotel.Hotel.Security;
import com.Hotel.Hotel.Model.Hotel;
import com.Hotel.Hotel.Repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


    @Component
    public class ClientDetails implements UserDetailsService {
        @Autowired
        private HotelRepo hotelRepo;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Hotel hotel= this.hotelRepo.findByEmail(username).orElseThrow();
            return hotel;
        }

    }


