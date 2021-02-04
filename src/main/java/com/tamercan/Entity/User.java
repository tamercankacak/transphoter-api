package com.tamercan.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

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
    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$", message = "{validation.username.regex}")
    private String username;

    @Size(max = 18, min = 3, message = "{validation.password.range}")
    @NotNull(message = "{validation.password.notNull}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", message = "{validation.password.regex}")
    private String password;


}
