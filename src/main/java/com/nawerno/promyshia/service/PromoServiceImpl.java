package com.nawerno.promyshia.service;

import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.repository.read.PromoReadRepository;
import com.nawerno.promyshia.repository.read.UserReadRepository;
import com.nawerno.promyshia.repository.write.PromoWriteRepository;
import com.nawerno.promyshia.repository.write.UserWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService{
    private static final String UPLOAD_FOLDER = "/Users/stepansalikov/Downloads/promyshia/src/main/resources/storage";
    private static final String HOST = "http://localhost:8080";

    private final PromoReadRepository promoReadRepository;
    private final PromoWriteRepository promoWriteRepository;

    @Override
    public Promo getById(int id){
        return promoReadRepository.getById(id);
    }

    @Override
    public int create(Promo promo){

        var newId = promoWriteRepository.create(promo);
        promo.setId(newId);
        return newId;
    }

    @Override
    public boolean createImage(int id, MultipartFile file) {


        try {
            // Создайте каталог, если его нет
            File directory = new File(UPLOAD_FOLDER);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Сохраните файл в каталог
            Path filepath = Paths.get(UPLOAD_FOLDER, id + ".jpg");
            file.transferTo(filepath.toFile());
        } catch (IOException e) {
            return false;

        }
        promoWriteRepository.createImage(id, HOST +"/storage/" + id + ".jpg");
        return true;
    }

    @Override
    public List<Promo> getAll(){
        return promoReadRepository.getAll();
    }

}
