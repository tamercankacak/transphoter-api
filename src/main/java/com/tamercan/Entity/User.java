package com.tamercan.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 18, min = 3, message = "{validation.username.range}")
    @NotNull(message = "{validation.username.notNull}")
    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$", message = "{validation.username.regex}")//least 3, max 18 characters. no special character.
    private String username;

    @Size(max = 18, min = 3, message = "{validation.password.range}")
    @NotNull(message = "{validation.password.notNull}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", message = "{validation.password.regex}")
    //least 3, max 18, one lowercase, one number characters. no special character.
    private String password;


}
