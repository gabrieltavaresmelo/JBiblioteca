package dao;

import db.Conexao;
import models.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AutorDao {

    public ArrayList<Autor> listar() {

        try {
            ArrayList<Autor> lista = new ArrayList<Autor>();

            Connection conexao = Conexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM autor");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");

                Autor autor = new Autor(id, nome, email, telefone);
                lista.add(autor);
            }

            Conexao.close();

            return lista;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Autor> buscarPorNome(String nomeParam) {

        try {
            ArrayList<Autor> lista = new ArrayList<Autor>();

            Connection conexao = Conexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM autor WHERE nome LIKE ?");
            ps.setString(1, "%" + nomeParam + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");

                Autor autor = new Autor(id, nome, email, telefone);
                lista.add(autor);
            }

            Conexao.close();

            return lista;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Autor buscar(int idParam) {

        try {
            Connection conexao = Conexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM autor WHERE id=?");
            ps.setInt(1, idParam);
            ResultSet rs = ps.executeQuery();

            Autor autor = null;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");

                autor = new Autor(id, nome, email, telefone);
                break;
            }

            Conexao.close();

            return autor;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
