package model.bean;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int idade;
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

    public Aluno(){}
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public Aluno(String nome, int idade, Estado estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }
}
