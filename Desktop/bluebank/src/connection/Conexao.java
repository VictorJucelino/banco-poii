
package connection;

import java.sql.*;
public class Conexao {

    //Declarar as variáveis que utilizarenos na classe"
    protected String nomeBanco;
    protected String usuario;
    protected String senha;
    private String ip, porta;

    //método responsável por setar os valores socials das variáveis/
    private void setarValores (String nomeBanco, String usuario, String senha, String ip, String porta){
    this.nomeBanco = nomeBanco;
    this.usuario = usuario;
    this.senha = senha;
    this.ip = ip;
    this.porta = porta;
    }

    //Construtor da classe, onde deve ser informade todos os parametros/ 
    public Conexao (String nomeBanco, String usuario, String senha, String ip, String porta) {
        this.setarValores (nomeBanco, usuario, senha, ip, porta);
    }

    //Contrutor de classe, onde deve ser informado apenas o nome do banco, usuário esenha pois já preenche com valores padrão e IP porta/
    public Conexao (String nomeBanco, String usuario, String senha) {
        this.setarValores (nomeBanco, usuario, senha, "Localhost", "3306");
    }
    
    public Connection obterConexao () {
        Connection conexao = null;
        try{
            String url;
            url="jdbc:mysql://" + this.ip + ":" + this.porta + "/" + this.nomeBanco;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,this.usuario, this.senha);
            System.out.println("Conexão realizada com sucesso!");
        } catch (ClassNotFoundException erro){
            System.out.println("Driver não encontrado!");
        } catch (SQLException erro) {
            System.out.println("SQL inválido!");
        } finally{
            return conexao;
        }
    }
}
