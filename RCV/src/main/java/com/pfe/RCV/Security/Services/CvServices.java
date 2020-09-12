package com.pfe.RCV.Security.Services;

import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.DivisionList;
import com.pfe.RCV.Models.JobOffer;
import com.pfe.RCV.Models.Quiz;
import com.pfe.RCV.Repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.pfe.RCV.Storage.StorageService;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;
import java.io.*;
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
    public List<CV> getAll()
    {
        return cvRepository.findAll();

    }
    public void validerCv(String id){
        CV cv= cvRepository.findById(id).orElse(null);
        cv.setArchived(false);
        cvRepository.save(cv);
    }
    public void archiverCv(String id) {
        CV cv= cvRepository.findById(id).orElse(null);
        cv.setArchived(true);
        cvRepository.save(cv);
    }
    public CV getCv(String id){
        return cvRepository.findById(id).orElse(null);
    }

    @Test
    public void givenPythonScriptEngineIsAvailable_whenScriptInvoked_thenOutputDisplayed() throws Exception {
        StringWriter writer = new StringWriter();
        ScriptContext context = new SimpleScriptContext();
        context.setWriter(writer);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("python");
        engine.eval(new FileReader(resolvePythonScriptPath("hello.py")), context);
        assertEquals("Should contain script output: ", "Hello Baeldung Readers!!", writer.toString().trim());
    }


}

