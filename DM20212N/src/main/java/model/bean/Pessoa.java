package model.bean;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private float altura;
    private String genero;
    private float peso;

    public Pessoa(int id, String nome, int idade, float altura, String genero, float peso)
    {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.genero = genero;
        this.peso = peso;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pessoa {" + "id: " + id +
                ", nome: " + nome +
                ", idade: " + idade +
                ", altura: " + altura +
                ", genero: " + genero +
                " e peso: " + peso + "}";
    }
}
