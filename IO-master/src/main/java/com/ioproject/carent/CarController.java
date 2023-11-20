package com.ioproject.carent;


import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/offer")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<List<Car>>(carService.getAllCars(),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Car>> getCars(@RequestParam(required = false) String dateFrom, @RequestParam(required = false) String dateTo, @RequestParam(required = false) Integer locationId, @RequestParam(required = false) String geartype, @RequestParam(required = false) String fuel, @RequestParam(required = false) String type){
        List<Car> cars;
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype != null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithAllParameters(fuel,type,locationId,geartype,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype != null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelAndTypeAndLocationAndGear(fuel,type,locationId,geartype),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype == null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFTLandDates(fuel,type,locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype == null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelAndTypeAndLocation(fuel,type,locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype != null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGTLandDates(geartype,type,locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype != null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGearAndTypeAndLocation(geartype,type,locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype != null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFGLandDates(fuel,geartype,locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype != null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelAndGearAndLocation(fuel,geartype,locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype != null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGFandDates(geartype,fuel,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype != null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGearAndFuel(geartype,fuel),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype != null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFTGandDates(fuel,type,geartype,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype != null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelAndTypeAndGear(fuel,type,geartype),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype == null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithTLandDates(type,locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype == null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithTypeAndLocationId(type,locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype == null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFLandDates(fuel,locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype == null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelAndLocationId(fuel,locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype != null && fuel == null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGLandDates(geartype,locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype != null && fuel == null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGearAndLocation(geartype,locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype == null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFTandDates(fuel,type,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype == null && fuel != null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelAndType(fuel,type),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype != null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGTandDates(geartype,type,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype != null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGearAndType(geartype,type),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype != null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGFandDates(geartype,fuel,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype != null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGearAndFuel(geartype,fuel),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId!=null && geartype == null && fuel == null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithLocationandDates(locationId,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId!=null && geartype ==null && fuel == null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsFromLocation(locationId),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype != null && fuel == null && type== null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGearandDates(geartype,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype !=null && fuel == null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithGear(geartype),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId == null && geartype == null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithFuelandDates(fuel,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype ==null && fuel != null && type == null){
            return new ResponseEntity<List<Car>>(carService.getCarsOfFuel(fuel),HttpStatus.OK);
        }
        if(dateFrom!=null & dateTo!=null && locationId==null && geartype == null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsWithTypeandDates(type,dateFrom,dateTo),HttpStatus.OK);
        }
        if(locationId==null && geartype ==null && fuel == null && type != null){
            return new ResponseEntity<List<Car>>(carService.getCarsOfType(type),HttpStatus.OK);
        }
        if(locationId==null && geartype ==null && fuel == null && type == null && dateFrom!=null && dateTo!=null){
            return new ResponseEntity<>(carService.findAvailableCarsBetweenDates(dateFrom,dateTo),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<List<Car>>(carService.getAllCars(),HttpStatus.OK);
        }
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Optional<Car>> getSingleCar(@PathVariable int carId){
        return new ResponseEntity<Optional<Car>>(carService.singleCar(carId),HttpStatus.OK);
    }

    @PatchMapping("/update/{id}/techcond")
    public ResponseEntity<UpdateResult> updateTechCondition(@PathVariable int id, @RequestBody Map<String,Double> updateRequest) {
        return new ResponseEntity<UpdateResult>(carService.updateTechCond(id,updateRequest.get("updateValue")),HttpStatus.OK);
    }
    @PatchMapping("/update/{id}/techdesc")
    public ResponseEntity<UpdateResult> updateTechDescription(@PathVariable int id, @RequestBody Map<String,String> updateRequest) {
        return new ResponseEntity<>(carService.updateTechDesc(id,updateRequest.get("updateValue")),HttpStatus.OK);
    }

}
