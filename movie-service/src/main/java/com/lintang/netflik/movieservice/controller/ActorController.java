package com.lintang.netflik.movieservice.controller;


import com.lintang.netflik.movieservice.dto.Actor;
import com.lintang.netflik.movieservice.dto.AddActorReq;
import com.lintang.netflik.movieservice.helper.DtoMapper.ActorDtoMapper;
import com.lintang.netflik.movieservice.service.ActorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/movie-service/actors")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ROLE_admin')")
public class ActorController {
    private static final Logger log = LoggerFactory.getLogger(ActorController.class);
    private ActorService actorService;
    private ActorDtoMapper mapper;


    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody AddActorReq newActor) {
        return ok(mapper.actorEntityToActorDto(actorService.addActor(newActor)));
    }
//


    @PutMapping("/{actorId}")
    public ResponseEntity<Actor> updateActor(@PathVariable int actorId,@RequestBody AddActorReq newActor) {
        return actorService.updateActor(actorId, newActor).map(mapper::actorEntityToActorDto).map(ResponseEntity::ok)
                .orElse(notFound().build());
    }

}
