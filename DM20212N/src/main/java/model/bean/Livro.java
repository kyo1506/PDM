package model.bean;

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
@Table(name = "livro")
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @ManyToMany(targetEntity = Autor.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
    @JoinTable(
            name="livro_autores",
            joinColumns=
            @JoinColumn( name="livro_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="autor_id", referencedColumnName="id"))
    private List<Autor> autores;
}
