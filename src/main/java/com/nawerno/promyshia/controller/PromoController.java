package com.nawerno.promyshia.controller;

import com.nawerno.promyshia.entity.Promo;
import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.service.PromoService;
import com.nawerno.promyshia.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/promo")
@Tag(name = "promo")

public class PromoController {
    private final PromoService promoService;


    @GetMapping("/{id}")
    @Operation(summary = "id")
    public Promo getById(@PathVariable("id") int id) {
        return promoService.getById(id);}

    @RequestMapping(path = "/createImage/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "create Promo")
    public ResponseEntity<?> createImage(@RequestPart("file") MultipartFile file, @PathVariable("id") int id) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("file is empty");
        }
        if (promoService.createImage(id, file)){
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping(path = "/create")
    @Operation(summary = "create Promo")
    public ResponseEntity<?> create(@RequestBody() Promo promo) {
        var id = promoService.create(promo);
        return ResponseEntity.ok("id:" + String.valueOf(id));
    }




    @GetMapping("/list")
    @Operation(summary = "getAll promos")
    public List<Promo> getAll () {
        return promoService.getAll();
    }


}
