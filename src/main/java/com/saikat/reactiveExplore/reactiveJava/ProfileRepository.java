package com.saikat.reactiveExplore.reactiveJava;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Saikat
 */

interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
}
