package com.project.caref.files.services;

import com.project.caref.files.dto.CreateFileDto;
import com.project.caref.files.dto.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Copyright (c) 2020, KTACENT, All Right Reserved.
 * https://www.linkedin.com/in/alex-kouasseu/
 * <p>
 * When : 07/11/2020 -- 13:14
 * By : @author alexk
 * Project : lp-user-service
 * Package : com.lukapharma.api.files.services
 */

public interface FileService {

    public void init();

    public void save(CreateFileDto createFileDto, MultipartFile file) throws Exception;

    public Resource load(String filename);

    public void deleteOneFile();

    public void deleteOneFile(String filename) throws IOException;

    public List<FileDto> findCarFile(Long carId);

    public List<FileDto> findGarageFile(Long garageId);

    public FileDto findUserFile(Long userId);

}
