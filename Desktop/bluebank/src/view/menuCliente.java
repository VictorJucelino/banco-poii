
package view;

import DAO.ContasDAO;
import DAO.ExtratosDAO;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Contas;
import model.Extratos;

public class menuCliente extends javax.swing.JFrame {

    public menuCliente(int numero) {
        initComponents();
        preencherTabela(numero);
        preencherInformacoesConta(numero);
    }
    
    private void preencherTabela(int numeroConta) {
    ExtratosDAO extratoDAO = new ExtratosDAO();
        ArrayList<Extratos> extratos = extratoDAO.readByNumeroConta(numeroConta);
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpar a tabela
        
        for (Extratos extrato : extratos) {
            model.addRow(new Object[]{
                extrato.getId(),
                extrato.getDataHora(),
                extrato.getTipo(),
                extrato.getQuantia(),
                extrato.getSaldoAtual()
            });
        }
    }
    
    private void preencherInformacoesConta(int numeroConta) {
        // Aqui você vai pegar os dados da conta com base no número fornecido
        ContasDAO contasDAO = new ContasDAO();
        Contas conta = contasDAO.readByNumero(numeroConta);  // Método que busca os dados da conta
        
        // Atualizar as informações no painel
        lNome.setText(conta.getNome());  // Nome do cliente associado à conta
        lNumero.setText(String.valueOf(conta.getNumero()));  // Número da conta
        lTipo.setText(conta.getTipo());  // Tipo da conta (Corrente, Poupança, Especial)
        String saldoFormatado = String.format("%.2f", conta.getSaldo());
        lSaldo.setText(saldoFormatado);
        System.out.println(saldoFormatado);

        // Condicional para o tipo de conta e o valor a ser mostrado em lLimiteRendimento
        if (conta.getTipo().equalsIgnoreCase("corrente")) {
            lLimiteRendimento.setVisible(false);  // Se for conta corrente, não mostrar o limite
        } else if (conta.getTipo().equalsIgnoreCase("poupanca")) {
            lLimiteRendimento.setText(String.valueOf(conta.getRendimento()/100));  // Mostrar rendimento da poupança
            lLimiteRendimento.setVisible(true);  // Garantir que o campo será visível
        } else if (conta.getTipo().equalsIgnoreCase("especial")) {
            lLimiteRendimento.setText(String.valueOf(conta.getLimite()));  // Mostrar limite da conta especial
            lLimiteRendimento.setVisible(true);  // Garantir que o campo será visível
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lNome = new javax.swing.JLabel();
        lNumero = new javax.swing.JLabel();
        lTipo = new javax.swing.JLabel();
        lLimiteRendimento = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tValor = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lSaldo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));

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

        jPanel2.setBackground(new java.awt.Color(186, 227, 255));

        tValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tValorActionPerformed(evt);
            }
        });

        jButton1.setText("DEPOSITAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SACAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tValorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!tValor.getText().isEmpty()) {
        // Converte o valor inserido para double
        double valor = Double.parseDouble(tValor.getText());
        int numeroConta = Integer.parseInt(lNumero.getText());
        ContasDAO contaDao = new ContasDAO();
        
        // Recupera a conta do banco de dados usando o número da conta
        Contas conta = contaDao.findByNumero(numeroConta);
        if (conta != null) {
        // Somando o valor do tValor ao saldo da conta
        double saldoAtualizado = conta.getSaldo() + valor;
        conta.setSaldo(saldoAtualizado); 
        contaDao.update(conta);
        
        Extratos extrato = new Extratos();
        extrato.setTipo("depósito");
        extrato.setQuantia(valor);
        extrato.setNumeroConta(conta.getNumero());
        extrato.setSaldoAtual(saldoAtualizado);

        // Inserir o extrato na tabela
        ExtratosDAO extratosDao = new ExtratosDAO();
        extratosDao.create(extrato);
        
        lSaldo.setText(String.format("%.2f", saldoAtualizado));
        preencherTabela(conta.getNumero());
    } else {
        // Caso o campo tValor esteja vazio, exibe uma mensagem de erro
        JOptionPane.showMessageDialog(this, "Por favor, insira um valor.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!tValor.getText().isEmpty()) {
        // Converte o valor inserido para double
        double valor = Double.parseDouble(tValor.getText());
        int numeroConta = Integer.parseInt(lNumero.getText());
        ContasDAO contaDao = new ContasDAO();
        
        // Recupera a conta do banco de dados usando o número da conta
        Contas conta = contaDao.findByNumero(numeroConta);
        
        if (conta != null) {
            String tipoConta = conta.getTipo();
            double saldoAtual = conta.getSaldo();
            double limite = conta.getLimite();
            
            // Verificar regras de saque de acordo com o tipo da conta
            if (tipoConta.equals("poupanca") || tipoConta.equals("corrente")) {
                if (valor <= saldoAtual) {
                    // Permite o saque
                    double saldoAtualizado = saldoAtual - valor;
                    conta.setSaldo(saldoAtualizado);
                    contaDao.update(conta);

                    // Atualiza o label de saldo
                    lSaldo.setText(String.format("%.2f", saldoAtualizado));

                    // Registrar o extrato
                    Extratos extrato = new Extratos();
                    extrato.setTipo("saque");
                    extrato.setQuantia(valor);
                    extrato.setNumeroConta(conta.getNumero());
                    extrato.setSaldoAtual(saldoAtualizado);

                    // Inserir o extrato na tabela
                    ExtratosDAO extratosDao = new ExtratosDAO();
                    extratosDao.create(extrato);
                    preencherTabela(conta.getNumero());

                } else {
                    // Não permite o saque
                    JOptionPane.showMessageDialog(this, 
                        "Saldo insuficiente para realizar o saque.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if (tipoConta.equals("especial")) {
                if (valor <= saldoAtual + limite) {
                    // Permite o saque, mesmo com saldo negativo
                    double saldoAtualizado = saldoAtual - valor;
                    conta.setSaldo(saldoAtualizado);
                    contaDao.update(conta);

                    // Atualiza o label de saldo
                    lSaldo.setText(String.format("%.2f", saldoAtualizado));

                    // Registrar o extrato
                    Extratos extrato = new Extratos();
                    extrato.setTipo("saque");
                    extrato.setQuantia(valor);
                    extrato.setNumeroConta(conta.getNumero());
                    extrato.setSaldoAtual(saldoAtualizado);

                    // Inserir o extrato na tabela
                    ExtratosDAO extratosDao = new ExtratosDAO();
                    extratosDao.create(extrato);
                    preencherTabela(conta.getNumero());

                } else {
                    // Não permite o saque
                    JOptionPane.showMessageDialog(this, 
                        "Limite insuficiente para realizar o saque.", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Conta não encontrada.", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Caso o campo tValor esteja vazio, exibe uma mensagem de erro
        JOptionPane.showMessageDialog(this, 
            "Por favor, insira um valor.", 
            "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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

    private static class ExtratoDAO {

        public ExtratoDAO() {
        }
    }
}
