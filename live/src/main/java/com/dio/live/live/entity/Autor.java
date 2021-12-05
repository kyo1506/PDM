package com.dio.live.live.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "autor")
@JsonPropertyOrder({"id", "nome", "livros"})
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    @JsonProperty("id")
    private Long id;
    @Column(name = "nome", nullable = false)
    @JsonProperty("nome")
    private String nome;

    @ManyToMany(
            targetEntity = Livro.class,
            cascade = CascadeType.ALL)
    @JsonProperty("livros")
    private List<Livro> livros;
}
