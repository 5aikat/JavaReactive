package com.saikat.reactiveExplore.reactiveJava;

import org.springframework.context.ApplicationEvent;

/**
 * @author Saikat
 */
public class ProfileCreatedEvent extends ApplicationEvent {
    public ProfileCreatedEvent(Profile profile) {
        super(profile);
    }
}
