
package com.bancoPOOII.tabalhoPOOIIVisual;

import com.bancoPOOII.trabalhoPooi.entity.Contas;
import com.bancoPOOII.trabalhoPooi.entity.Extratos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor
 */
public class MenuCliente extends javax.swing.JFrame {
    int numero;
    Contas conta;
    
    // Pego a resposta JSON para obter a conta
    public Contas importaConta() throws IOException{
        // usando a função de buscar a conta pelo número para pegar todos os dados da conta
        String endpointBuscar = "/contas/buscar-por-numero/" + numero;
        String resposta = HttpClientUtil.getRequest(endpointBuscar);
        Gson gson = new Gson();
        Contas contaDTO = gson.fromJson(resposta, Contas.class);
        return contaDTO;
    }
    
    
    public MenuCliente(int numeroConta) throws IOException {
        this.numero = numeroConta; // Inicializar antes de usar
        this.conta = importaConta();
        initComponents();
        preencherDados();
        readJTable();
        
    }
    public void readJTable() {
        // Obtém o modelo da tabela
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0); // Limpa a tabela antes de preencher

        try {
            // Faz a requisição ao backend usando o número da conta
            String endpoint = "/extratos/buscar-por-conta/" + conta.getNumero();
            String response = HttpClientUtil.getRequest(endpoint);

            // Converte a resposta JSON em uma lista de objetos Extratos
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Extratos>>() {}.getType();
            List<Extratos> extratosList = new Gson().fromJson(response, listType);

            // Preenche a tabela com os dados retornados
            for (Extratos extrato : extratosList) {
                modelo.addRow(new Object[]{
                    extrato.getId(),
                    extrato.getData_hora(),  // Ajuste o formato de data se necessário
                    extrato.getTipo(),
                    extrato.getQuantia(),
                    extrato.getSaldo()
                });
            }
        } catch (Exception e) {
            // Exibe um alerta caso ocorra erro na requisição ou no processamento
            JOptionPane.showMessageDialog(null, "Erro ao carregar os extratos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tValor = new javax.swing.JFormattedTextField();
        btnDeposito = new javax.swing.JButton();
        btnSaque = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lSaldo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lNome = new javax.swing.JLabel();
        lNumero = new javax.swing.JLabel();
        lTipo = new javax.swing.JLabel();
        lLimiteRendimento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(189, 232, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Data/hota", "Tipo", "Quantia", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(209, 240, 255));
        jButton3.setText("CLIQUE AQUI PARA VOLTAR PARA O MENU INICIAL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("BLUEBANK");

        jPanel2.setBackground(new java.awt.Color(186, 227, 255));

        tValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tValorActionPerformed(evt);
            }
        });

        btnDeposito.setText("DEPOSITAR");
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });

        btnSaque.setText("SACAR");
        btnSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaqueActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Saldo: R$");

        lSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lSaldo.setText("valor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lSaldo))
                .addGap(18, 18, 18)
                .addComponent(tValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(179, 224, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Número da conta:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tipo da Conta:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("limite/rendimento:");

        lNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNome.setText("nome");

        lNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNumero.setText("numero");

        lTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lTipo.setText("tipo");

        lLimiteRendimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lLimiteRendimento.setText("valor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lLimiteRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lNome))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lNumero))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lTipo))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lLimiteRendimento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel6)
                .addGap(76, 76, 76)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void preencherDados() throws IOException {
        // usando a função de buscar a conta pelo número para pegar todos os dados da conta
        String endpointBuscar = "/contas/buscar-por-numero/" + numero;
        String resposta = HttpClientUtil.getRequest(endpointBuscar);
            
        // Atualizar as informações no painel
        lNome.setText(conta.getNome()); 
        lNumero.setText(String.valueOf(conta.getNumero()));  
        lTipo.setText(conta.getTipo());  
        String saldoFormatado = String.format("%.2f", conta.getSaldo());
        lSaldo.setText(saldoFormatado);

        // Condicional para o tipo de conta e o valor a ser mostrado em lLimiteRendimento
        if (conta.getTipo().equalsIgnoreCase("Conta Corrente")) {
            lLimiteRendimento.setVisible(false);  
            jLabel4.setVisible(false);  
        } else if (conta.getTipo().equalsIgnoreCase("Conta Poupança")) {
            lLimiteRendimento.setText(String.valueOf(conta.getRendimento()/100)); 
            lLimiteRendimento.setVisible(true);
        } else if (conta.getTipo().equalsIgnoreCase("Conta Especial")) {
            lLimiteRendimento.setText(String.valueOf(conta.getLimite()));  
            lLimiteRendimento.setVisible(true);
        }
    }
    
    private void saque (double valor){
        double saldoAtual = conta.getSaldo();
        double saldoAtualizado = saldoAtual - valor;
        conta.setSaldo(saldoAtualizado);
    }
    private void geraExtrato(String tipo){
        try {
            System.out.println("pegou valor do jtext");
            double valor = Double.parseDouble(tValor.getText());
            System.out.println("atribuindo valores");
            // usando a função de buscar a conta pelo número para pegar todos os dados da conta
            // Cria o JSON do extrato
            String jsonInput = "{"
            + "\"idConta\":" + (double)(conta.getNumero()) + ","
            + "\"quantia\":" + (double)valor + ","
            + "\"tipo\":\"" + tipo + "\","
            + "\"saldo\":" + (double)(conta.getSaldo())
            + "}";
            // Faz a requisição POST para criar o extrato
            System.out.println("fazendo a requisição");
            String endpoint = "/extratos/" ;
            HttpClientUtil.postRequest(endpoint, jsonInput);

            // Exibe mensagem de sucesso
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro extrato,inserir valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao criar o extrato: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tValorActionPerformed

    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
        //lSaldo.setText(String.format("%.2f", saldoAtualizado));
        try {
            double valorDeposito = Double.parseDouble(tValor.getText());

            // Verifica se o valor é positivo
            if (valorDeposito <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor positivo para o depósito!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            double saldoAtual = conta.getSaldo();

            //Atualizo o saldo somando o depósito
            double novoSaldo = saldoAtual + valorDeposito;
            conta.setSaldo(novoSaldo);

            //Mando a atualização para o backend
            String endpointAtualizar = "/contas/" + conta.getId();
            Gson gson = new Gson();
            String jsonInput = gson.toJson(conta);
            HttpClientUtil.putRequest(endpointAtualizar, jsonInput);
                        
            //limpo o campo de valor e atualizo o saldo do numero
            tValor.setText("");
            lSaldo.setText(String.format("%.2f", conta.getSaldo()));
            geraExtrato("Depósito");
            JOptionPane.showMessageDialog(this, "extrato gerado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            readJTable();
        } catch (IOException ex) {
            // Mensagem para erro de conexão ou requisição
            JOptionPane.showMessageDialog(this, "Erro de conexão: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        readJTable();
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaqueActionPerformed
        
        try{
            if (!tValor.getText().isEmpty()) {
                // pegando valores pra fazer operacoes logicas e matematicas
                double valor = Double.parseDouble(tValor.getText());
                double saldoAtual = conta.getSaldo();
                double limite = conta.getLimite();

                String tipoConta = conta.getTipo();
                // Verificar regras de saque de acordo com o tipo da conta
                if (tipoConta.equals("Conta Poupança") || tipoConta.equals("Conta Corrente")) {
                    if (valor <= saldoAtual) {
                        saque(valor);
                        geraExtrato("Saque");
                        readJTable();
                        lSaldo.setText(String.format("%.2f", conta.getSaldo()));
                    } else {
                        // Não permite o saque
                        JOptionPane.showMessageDialog(this, 
                            "Saldo insuficiente para realizar o saque.", 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    } else if (tipoConta.equals("Conta Especial")) {
                        if (valor <= saldoAtual + limite) {
                            saque(valor);
                            geraExtrato("Saque");
                            readJTable();
                            lSaldo.setText(String.format("%.2f", conta.getSaldo()));
                        }else {
                        // Não permite o saque
                        JOptionPane.showMessageDialog(this,"Limite insuficiente para realizar o saque.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Por favor, insira um valor.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch (NumberFormatException ex) {
            // Mensagem para entrada inválida no campo de valor
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido no campoS!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Mensagem para erro de conexão ou requisição
        
            
        
        
    }//GEN-LAST:event_btnSaqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnSaque;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lLimiteRendimento;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNumero;
    private javax.swing.JLabel lSaldo;
    private javax.swing.JLabel lTipo;
    private javax.swing.JFormattedTextField tValor;
    // End of variables declaration//GEN-END:variables
}
