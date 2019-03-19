package com.saikat.reactiveExplore.reactiveJava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Saikat
 */


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    private String id;

    private String email;
}
