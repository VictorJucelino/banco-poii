
package DAO;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Contas;
import model.Extratos;

/**
 *
 * @author victor
 */
public class ExtratosDAO {
    public void create(Extratos extratos) {
        Conexao conexao = new Conexao("bancovictor", "root", "root");
        Connection con = conexao.obterConexao();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO extrato (fk_numero_conta, tipo, quantia, saldo_atual) VALUES (?,?,?,?)");
            ps.setInt(1, extratos.getNumeroConta());  // Usa 'numero' como chave principal
            ps.setString(2, extratos.getTipo());
            ps.setDouble(3, extratos.getQuantia());
            ps.setDouble(4, extratos.getSaldoAtual());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Extrato gerado.");
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
    
    public ArrayList<Extratos> readByNumeroConta(int numeroConta) {
    ArrayList<Extratos> extratos = new ArrayList<>();
    String sql = "SELECT * FROM extrato WHERE fk_numero_conta = ? order by data_hora desc";

    try (Connection conn = new Conexao("BancoVictor", "root", "root").obterConexao()) {
        if (conn == null) {
            System.out.println("Falha ao conectar ao banco de dados.");
            return extratos;  // Retorna uma lista vazia se não conseguir conectar
        }

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, numeroConta);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Extratos extrato = new Extratos();
            extrato.setId(rs.getInt("id"));
            extrato.setDataHora(rs.getString("data_hora"));
            extrato.setNumeroConta(rs.getInt("fk_numero_conta"));
            extrato.setTipo(rs.getString("tipo"));
            extrato.setQuantia(rs.getDouble("quantia"));
            extrato.setSaldoAtual(rs.getDouble("saldo_atual"));
            extratos.add(extrato);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao buscar extratos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    return extratos;
}

    
}
