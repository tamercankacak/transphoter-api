package com.tamercan.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "words", schema = "public")
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80, min = 1, message = "{validation.words.range}")
    @NotNull(message = "{validation.words.notNull}")
    private String englishword;

    @Size(max = 80, min = 1, message = "{validation.words.range}")
    @NotNull(message = "{validation.words.notNull}")
    private String turkishword;

}
