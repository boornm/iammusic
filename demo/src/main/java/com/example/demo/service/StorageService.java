package com.example.demo.service;

import com.example.demo.entity.ImageEntity;
import com.example.demo.entity.SongEntity;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ImageRepository imageRepository;

    public String uploadSong(MultipartFile file) throws IOException {
        try {
            SongEntity songEntity = SongEntity.builder()
                    .Filename(file.getOriginalFilename())
                    .FileType(file.getContentType())
                    .SongData(file.getBytes())
                    .build();

            SongEntity savedEntity = songRepository.save(songEntity);

            if (savedEntity != null) {
                return "File uploaded successfully: " + file.getOriginalFilename();
            } else {
                return "Failed to upload file: " + file.getOriginalFilename();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + file.getOriginalFilename() + " due to IOException";
        }
    }

    public String uploadImage(MultipartFile file) throws IOException {
        try {
            ImageEntity imageEntity = ImageEntity.builder()
                    .Filename(file.getOriginalFilename())
                    .FileType(file.getContentType())
                    .ImageData(file.getBytes())
                    .build();

            ImageEntity savedEntity = imageRepository.save(imageEntity);

            if (savedEntity != null) {
                return "File uploaded successfully: " + file.getOriginalFilename();
            } else {
                return "Failed to upload file: " + file.getOriginalFilename();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + file.getOriginalFilename() + " due to IOException";
        }
    }
}


