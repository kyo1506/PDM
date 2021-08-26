package model.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sigla", nullable = false)
    private String sigla;

    @OneToMany(
            mappedBy = "estado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Pessoa> pessoas = new ArrayList<>();

    public Estado(){}
    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
    public Estado(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
