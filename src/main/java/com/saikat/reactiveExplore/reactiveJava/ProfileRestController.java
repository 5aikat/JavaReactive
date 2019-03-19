package com.saikat.reactiveExplore.reactiveJava;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.net.URI;

/**
 * @author Saikat
 */

@RestController
@RequestMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@org.springframework.context.annotation.Profile("classic")
public class ProfileRestController {

    private final MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
    private final ProfileService profileService;

    public ProfileRestController(ProfileService profileService){
        this.profileService=profileService;
    }

    @GetMapping
    Publisher<Profile> getAll(){
        return this.profileService.all();
    }

    @GetMapping("/{id")
    Publisher<Profile> getById(@PathVariable String id){
        return this.profileService.get(id);
    }

    @PostMapping
    Publisher<ResponseEntity<Profile>> create(@RequestBody Profile profile){
        return this.profileService
                .create(profile.getEmail())
                .map(p -> ResponseEntity.created(URI.create("/profiles/" + p.getId()))
                        .contentType(mediaType)
                        .build());
    }

    @DeleteMapping
    Publisher<Profile> deleteById(@PathVariable String id){
        return this.profileService.delete(id);
    }

    @PutMapping
    Publisher<ResponseEntity<Profile>> updateById(@PathVariable String id, @RequestBody Profile profile){
        return Mono.just(profile)
                .flatMap(p -> this.profileService.update(id, p.getEmail()))
                .map(p -> ResponseEntity
                .ok()
                .contentType(mediaType)
                .build());
    }


}
