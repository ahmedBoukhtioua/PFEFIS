package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.DivisionList;
import com.pfe.RCV.Repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.pfe.RCV.Storage.StorageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CvServices {

    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private StorageService storageService;

    public CV addCv(DivisionList divisionList, String id_user, float note, MultipartFile file) {

        List<String> files = new ArrayList<String>();
        storageService.store(file);
        files.add(file.getOriginalFilename());
        CV cv = new CV(id_user, divisionList, note, file.getOriginalFilename());
        cvRepository.save(cv);
   return  cv;

    }
}
