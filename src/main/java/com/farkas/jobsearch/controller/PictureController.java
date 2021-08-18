package com.farkas.jobsearch.controller;

import com.farkas.jobsearch.dto.PictureDTO;
import com.farkas.jobsearch.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/api/img")
@CrossOrigin
public class PictureController {

    PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping("/upload/employee/{id}")
    public ResponseEntity<?> uploadEmployeePicture(@PathVariable Long id, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        Object response = pictureService.uploadEmployeePicture(id, multipartFile);
        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/employee/{pictureName}")
    public ResponseEntity<byte[]> getEmployeePicture(@PathVariable String pictureName) {

        byte[] picture = pictureService.getEmployeePicture(pictureName);
        if(picture != null) {
            return new ResponseEntity<>(picture, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/employee/{fileName}")
    public ResponseEntity<?> deleteEmployeePicture(@PathVariable String fileName) {

        pictureService.deleteEmployeePicture(fileName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/upload/employer/{id}")
    public ResponseEntity<?> uploadEmployerPicture(@PathVariable Long id, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        Object response = pictureService.uploadEmployerPicture(id, multipartFile);
        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/employer/{pictureName}")
    public ResponseEntity<byte[]> getEmployerPicture(@PathVariable String pictureName) {

        byte[] picture = pictureService.getEmployerPicture(pictureName);
        if(picture != null) {
            return new ResponseEntity<>(picture, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/employer/{fileName}")
    public ResponseEntity<?> deleteEmployerPicture(@PathVariable String fileName) {

        pictureService.deleteEmployerPicture(fileName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
