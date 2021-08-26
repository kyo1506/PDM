package model.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "idade", nullable = false)
    private int idade;
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

    public Pessoa(){}
    public Pessoa(String nome, int idade, Estado estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }
    public Pessoa(Long id, String nome, int idade, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", estado=" + estado.toString() +
                '}';
    }
}
