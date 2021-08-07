package Model.DAO;

import Model.Bean.Pessoa;
import Model.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    public List<Pessoa> list() {
        List<Pessoa> pessoas = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM pessoa;");

            ResultSet rst = pstmt.executeQuery();

            while(rst.next())
            {
                pessoas.add(new Pessoa(rst.getInt("id"), rst.getString("nome"), rst.getInt("idade"), rst.getFloat("altura"), rst.getString("genero"), rst.getFloat("peso")));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return pessoas;
    }

    public Pessoa getById(int id) {
        Pessoa pessoa = new Pessoa();

        try(Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM pessoa WHERE id = ?;";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rst = pstmt.executeQuery();

            if(rst.next())
            {
                pessoa.setId(rst.getInt("id"));
                pessoa.setNome(rst.getString("nome"));
                pessoa.setIdade(rst.getInt("idade"));
                pessoa.setAltura(rst.getFloat("altura"));
                pessoa.setGenero(rst.getString("genero"));
                pessoa.setPeso(rst.getFloat("peso"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return pessoa;
    }

    public void insert (Pessoa pessoa) {
        try(Connection conn = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO pessoa (nome, idade, altura, genero, peso) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.setDouble(3, pessoa.getAltura());
            pstmt.setString(4, pessoa.getGenero());
            pstmt.setDouble(5, pessoa.getPeso());

            int rowsAffected = pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Insert bem sucedido! Foram inseridas " + rowsAffected + " linhas.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete (int id) {
        try(Connection conn = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM pessoa WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Delete bem sucedido! Foram deletadas " + rowsAffected + " linhas.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update (Pessoa pessoa) {
        try(Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE pessoa SET nome = ?, idade = ?, altura = ?, genero = ?, peso = ? WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.setDouble(3, pessoa.getAltura());
            pstmt.setString(4, pessoa.getGenero());
            pstmt.setDouble(5, pessoa.getPeso());
            pstmt.setInt(6, pessoa.getId());

            int rowsAffected = pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Update bem sucedido! Foram atualizadas " + rowsAffected + " linhas.", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
