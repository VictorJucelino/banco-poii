package DAO;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Contas;

public class ContasDAO {
    
    public void create(Contas contas) {
        Conexao conexao = new Conexao("bancovictor", "root", "root");
        Connection con = conexao.obterConexao();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO contas (numero, nome, tipo, saldo, limite, rendimento) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, contas.getNumero());  // Usa 'numero' como chave principal
            ps.setString(2, contas.getNome());
            ps.setString(3, contas.getTipo());
            ps.setDouble(4, contas.getSaldo());
            ps.setDouble(5, contas.getLimite());
            ps.setDouble(6, contas.getRendimento());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro SQLException");
            }
        }
    }

    public ArrayList<Contas> read(String conta) {
        Conexao conexao = new Conexao("bancovictor", "root", "root");
        Connection con = conexao.obterConexao();
        PreparedStatement ps;
        ArrayList<Contas> contas = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM contas WHERE contas.nome LIKE '%" + conta + "%' or '%%' order by numero desc");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contas c = new Contas();
                c.setNumero(rs.getInt("numero"));  // A referência é agora o 'numero'
                c.setNome(rs.getString("nome"));
                c.setTipo(rs.getString("tipo"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setLimite(rs.getDouble("limite"));
                c.setRendimento(rs.getDouble("rendimento"));
                contas.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler a tabela: " + ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return contas;
    }

    public void update(Contas conta) {
        Conexao conexao = new Conexao("bancovictor", "root", "root");
        Connection con = conexao.obterConexao();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("UPDATE contas SET nome = ?, tipo = ?, saldo = ?, limite = ?, rendimento = ? WHERE numero = ?");
            ps.setString(1, conta.getNome());
            ps.setString(2, conta.getTipo());
            ps.setDouble(3, conta.getSaldo());
            ps.setDouble(4, conta.getLimite());
            ps.setDouble(5, conta.getRendimento());
            ps.setInt(6, conta.getNumero());  
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }

    public void delete(Contas conta) {
        Conexao conexao = new Conexao("bancovictor", "root", "root");
        Connection con = conexao.obterConexao();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("DELETE FROM contas WHERE numero = ?");
            ps.setInt(1, conta.getNumero());  // Deleta com base no 'numero'
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO DELETAR: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
    }
    
    public Contas readByNumero(int numeroConta) {
        // Aqui você faria a consulta no banco de dados para obter a conta com base no número
        Contas conta = null;
        String sql = "SELECT * FROM contas WHERE numero = ?";
        
        try (Connection conn = new Conexao("BancoVictor", "root", "root").obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                conta = new Contas();
                conta.setNome(rs.getString("nome"));
                conta.setNumero(rs.getInt("numero"));
                conta.setTipo(rs.getString("tipo"));
                conta.setRendimento(rs.getDouble("rendimento"));  // Para Poupança
                conta.setLimite(rs.getDouble("limite"));  // Para Conta Especial
                conta.setSaldo(rs.getDouble("saldo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conta;
    }
    
    
        public Contas findByNumero(int numero) {
        Contas conta = null;
        String sql = "SELECT * FROM contas WHERE numero = ?";

        try (Connection conn = new Conexao("BancoVictor", "root", "root").obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                conta = new Contas();
                conta.setNumero(rs.getInt("numero"));
                conta.setNome(rs.getString("nome"));
                conta.setTipo(rs.getString("tipo"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setLimite(rs.getDouble("limite"));
                conta.setRendimento(rs.getDouble("rendimento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conta;
    }

    // Método para atualizar o saldo
    public void updateSaldo(Contas conta) {
        String sql = "UPDATE contas SET saldo = ? WHERE numero = ?";

        try (Connection conn = new Conexao("BancoVictor", "root", "root").obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, conta.getSaldo());
            ps.setInt(2, conta.getNumero());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}