package com.farkas.jobsearch.service;

import com.farkas.jobsearch.dto.PictureDTO;
import com.farkas.jobsearch.repository.EmployeeRepository;
import com.farkas.jobsearch.repository.EmployerRepository;
import com.farkas.jobsearch.repository.PictureUploadUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PictureService {

    EmployeeRepository employeeRepository;
    EmployerRepository employerRepository;

    @Autowired
    public PictureService(EmployeeRepository employeeRepository, EmployerRepository employerRepository) {
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
    }

    public Object uploadEmployeePicture(Long id, MultipartFile multipartFile) {

        String fileName = StringUtils.cleanPath(id + "_" + multipartFile.getOriginalFilename());
        String uploadDir = "employee-pictures/";

        try {
            PictureUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            employeeRepository.setPicture(id, fileName);
        } catch (IOException ignored) {
            return null;
        }
        String response = "data:image/jpg;base64, " + Base64.encodeBase64String(getEmployeePicture(fileName));
        return new PictureDTO(response);
    }

    public static byte[] getEmployeePicture(String pictureName) {

        String picturePath = "employee-pictures/" + pictureName;
        try {
            BufferedImage picture = ImageIO.read(new File(picturePath));
            ByteArrayOutputStream pictureStream = new ByteArrayOutputStream();
            ImageIO.write(picture, "jpg", pictureStream);
            return pictureStream.toByteArray();
        } catch (IOException ignored) {
            return null;
        }
    }

    public void deleteEmployeePicture(String pictureName) {

        String picturePath = "employee-pictures/" + pictureName;
        try {
            Files.deleteIfExists(Path.of(picturePath));
        } catch(IOException ignored) {
        } finally {
            employeeRepository.deletePicture(pictureName);
        }
    }

    public Object uploadEmployerPicture(Long id, MultipartFile multipartFile) {

        String fileName = StringUtils.cleanPath(id + "_" + multipartFile.getOriginalFilename());
        String uploadDir = "employer-pictures/";

        try {
            PictureUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            employerRepository.setPicture(id, fileName);
        } catch (IOException ignored) {
            return null;
        }
        String response = "data:image/jpg;base64, " + Base64.encodeBase64String(getEmployerPicture(fileName));
        return new PictureDTO(response);
    }

    public static byte[] getEmployerPicture(String pictureName) {

        String picturePath = "employer-pictures/" + pictureName;
        try {
            BufferedImage picture = ImageIO.read(new File(picturePath));
            ByteArrayOutputStream pictureStream = new ByteArrayOutputStream();
            ImageIO.write(picture, "jpg", pictureStream);
            return pictureStream.toByteArray();
        } catch (IOException ignored) {
            return null;
        }
    }

    public void deleteEmployerPicture(String pictureName) {

        String picturePath = "employer-pictures/" + pictureName;
        try {
            Files.deleteIfExists(Path.of(picturePath));
        } catch(IOException ignored) {
        } finally {
            employerRepository.deletePicture(pictureName);
        }
    }
}
