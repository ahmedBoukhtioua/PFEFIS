package com.pfe.RCV.Storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.RCV.Models.CV;
import com.pfe.RCV.Models.DivisionList;
import com.pfe.RCV.Models.Skills;
import com.pfe.RCV.Repository.CvRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@Service
public class StorageService {

    @Autowired
    private CvRepository cvRepository;

    private CV cv;

    private final Path rootLocation = Paths.get("C:\\Users\\hp\\PycharmProjects\\untitled\\set10");



    public void store(MultipartFile file) {
        try {

            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));


            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));

            List<String> command = new ArrayList<>();
            command.add("python");
            command.add("C:/Users/hp/PycharmProjects/untitled/test.py");
            executeCmd(command, new File("C:/Users/hp/PycharmProjects/untitled"));

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }



    }
    private void executeCmd(final List<String> cmd, final File folder)
            throws IOException {
        System.out.println("Executing : " + cmd);
        final ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(folder);

        final Process process = pb.start();

        processBuilderToConsole(process.getInputStream());

        processBuilderToConsole(process.getErrorStream());

    }

    private void processBuilderToConsole(
            final InputStream inputStream) {

        final Consumer<String> outputConsumer = System.out::println;

        new Thread(new Runnable() {
            @Override
            public void run() {
                new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(outputConsumer);
            }
        }).start();
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
