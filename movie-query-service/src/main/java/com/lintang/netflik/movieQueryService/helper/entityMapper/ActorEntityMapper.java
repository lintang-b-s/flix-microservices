package com.lintang.netflik.movieQueryService.helper.entityMapper;

import com.lintang.netflik.movieQueryService.dto.Actor;
import com.lintang.netflik.movieQueryService.dto.AddActorReq;
import com.lintang.netflik.movieQueryService.entity.ActorEntity;
import org.springframework.stereotype.Component;

@Component
public class ActorEntityMapper {

    public ActorEntity toEntity(Actor m) {
        ActorEntity entity = new ActorEntity();
        return entity.setName(m.getName());
    }
    public ActorEntity toActorEntity(Actor m){
        ActorEntity entity = new ActorEntity();
        return entity.setName(m.getName()).setId(m.getId());
    }
}
