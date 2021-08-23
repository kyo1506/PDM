package model.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sigla;

    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Aluno> alunos = new ArrayList<>();

    public Estado(){}
    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
    public Estado(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }
}
