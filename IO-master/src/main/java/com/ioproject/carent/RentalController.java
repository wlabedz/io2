package com.ioproject.carent;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;

    @PostMapping("/rental")
    public ResponseEntity<Rental> createRental(@RequestBody Map<String,Object> payload){
        return new ResponseEntity<Rental>(rentalService.createRental(rentalService.findRentalId(),(Integer) payload.get("userId"),(Integer) payload.get("carId"), (String) payload.get("dateFrom"), (String) payload.get("dateTo"),(Integer) payload.get("cost")), HttpStatus.CREATED);
    }

    @GetMapping("/rental/current")
    public ResponseEntity<List<Rental>> currentRentals(){
        return new ResponseEntity<>(rentalService.getCurrentRentals(),HttpStatus.OK);
    }

    @GetMapping("/rental/car/{id}")
    public ResponseEntity<List<Rental>> currentRentals(@PathVariable int id){
        return new ResponseEntity<>(rentalService.getRentalsForCar(id),HttpStatus.OK);
    }

    @DeleteMapping("/rental/delete/{id}")
    public ResponseEntity<DeleteResult> deleteRental(@PathVariable int id){
        return new ResponseEntity<>(rentalService.delete(id),HttpStatus.OK);
    }
}