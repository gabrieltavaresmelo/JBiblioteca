package dao;

import db.Conexao;
import models.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDao {

    public ArrayList<Aluno> listar() {

        try {
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();

            Connection conexao = Conexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM aluno");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula = rs.getString("matricula");
                String cpf = rs.getString("cpf");

                Aluno aluno = new Aluno(id, nome, email, matricula, cpf);
                alunos.add(aluno);
            }

            Conexao.close();

            return alunos;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Aluno> buscarPorNome(String nomeParam) {

        try {
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();

            Connection conexao = Conexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM aluno WHERE nome LIKE ?");
            ps.setString(1, "%" + nomeParam + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula = rs.getString("matricula");
                String cpf = rs.getString("cpf");

                Aluno aluno = new Aluno(id, nome, email, matricula, cpf);
                alunos.add(aluno);
            }

            Conexao.close();

            return alunos;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Aluno buscar(int idParam) {

        try {
            Connection conexao = Conexao.getConnection();

            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM aluno WHERE id=?");
            ps.setInt(1, idParam);
            ResultSet rs = ps.executeQuery();

            Aluno aluno = null;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula = rs.getString("matricula");
                String cpf = rs.getString("cpf");

                aluno = new Aluno(id, nome, email, matricula, cpf);
                break;
            }

            Conexao.close();

            return aluno;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
