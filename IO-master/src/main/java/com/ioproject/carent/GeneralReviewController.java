package com.ioproject.carent;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GeneralReviewController {
    @Autowired
    private GeneralReviewService genReviewService;

    @PostMapping("/reviews/write")
    public ResponseEntity<GeneralReview> createReview(@RequestBody Map<String,Object> payload){
        return new ResponseEntity<GeneralReview>(genReviewService.createReview((String) payload.get("comment"), (String) payload.get("userName"), (String) payload.get("userCountry")), HttpStatus.CREATED);
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<GeneralReview>> getGenReviews(){
        return new ResponseEntity<List<GeneralReview>>(genReviewService.getAllReviews(),HttpStatus.OK);
    }

    @DeleteMapping("/reviews/delete/{id}")
    public ResponseEntity<DeleteResult> delete(@PathVariable int id){

        return new ResponseEntity<>(genReviewService.deleteRecord(id),HttpStatus.OK);
    }
}
