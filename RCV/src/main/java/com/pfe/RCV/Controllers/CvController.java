package com.pfe.RCV.Controllers;

import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.DivisionList;
import com.pfe.RCV.Repository.CvRepository;
import com.pfe.RCV.Security.Services.CvServices;
import com.pfe.RCV.Storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cv")

public class CvController {
    @Autowired
    private CvServices cvServices;
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    AuthController authController ;

    @Autowired
    StorageService storageService;
    @PostMapping("/addcv/{user_id}")
    public ResponseEntity<String> handleFileUpload(@PathVariable(value = "user_id") String id_user, @RequestParam("file") MultipartFile file  , float note ) {
        {
        String message = "";
        try {

            List<String> files = new ArrayList<String>();
            storageService.store(file);
            files.add(file.getOriginalFilename());
            CV cv = new CV(authController.user(id_user), note, file.getOriginalFilename());
            cvRepository.save(cv);


            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }



    }
}}
