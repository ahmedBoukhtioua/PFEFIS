package com.pfe.RCV.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.RCV.Models.CV;

import com.pfe.RCV.Models.DivisionList;
import com.pfe.RCV.Models.Skills;
import com.pfe.RCV.Models.test;
import com.pfe.RCV.Repository.CvRepository;
import com.pfe.RCV.Security.Services.CvServices;
import com.pfe.RCV.Storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
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
            cv.setArchived(false);
            LocalDateTime date = LocalDateTime.now();

            cv.setDate(date);

            ObjectMapper mapper = new ObjectMapper();
            test test = null;
            try {
                test = mapper.readValue(new File("upload-dir/data.json"), test.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(test.getSkills());
            System.out.println(test.getLangue());
            cv.setDivisionList(test.getSkills());
            cv.setLanguesList(test.getLangue());
            cvRepository.save(cv);


            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }



    }

}
    @RequestMapping(method = RequestMethod.GET,value = "/findAll")
    public List<CV> getAll(){
        return cvServices.getAll();
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/validate/{id}")
    public void validerCV(@PathVariable String id){
        cvServices.validerCv(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/archived/{id}")
    public void archiverJobOffer(@PathVariable String id){
        cvServices.archiverCv(id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/findById/{id}")
    public CV getById(@PathVariable String id){
        return cvServices.getCv(id);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/nombreCvValide")
    public ArrayList<Integer> getNombreValide(){
        return cvServices.getNombreCv();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getAllNombreCV")
    public long getAllNombre(){
        return cvServices.getNombreAllCV();
    }





}
