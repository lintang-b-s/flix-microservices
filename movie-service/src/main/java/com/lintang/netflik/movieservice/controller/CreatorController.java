package com.lintang.netflik.movieservice.controller;

import com.lintang.netflik.movieservice.dto.AddCreatorReq;
import com.lintang.netflik.movieservice.dto.Creator;
import com.lintang.netflik.movieservice.helper.DtoMapper.CreatorDtoMapper;
import com.lintang.netflik.movieservice.service.CreatorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/movie-service/creators")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ROLE_admin')")
public class CreatorController {
    private static final Logger log = LoggerFactory.getLogger(CreatorController.class);
    private CreatorService creatorService;
    private CreatorDtoMapper mapper;

    @PostMapping
    public ResponseEntity<Creator> addCreator(@RequestBody AddCreatorReq newCreator) {
        return ok(mapper.creatorEntityToCreatorDto(creatorService.addCreator(newCreator)));
    }



    @PutMapping("/{creatorId}")
    public ResponseEntity<Creator> updateCreator(@PathVariable int creatorId,@RequestBody AddCreatorReq newCreator ) {
        return creatorService.updateCreator(creatorId, newCreator).map(mapper::creatorEntityToCreatorDto).map(ResponseEntity::ok)
                .orElse(notFound().build());
    }
}
