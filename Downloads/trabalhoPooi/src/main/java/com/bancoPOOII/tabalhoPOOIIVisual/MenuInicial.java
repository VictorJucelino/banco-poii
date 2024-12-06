
package com.bancoPOOII.tabalhoPOOIIVisual;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuInicial extends javax.swing.JFrame {
    int numeroConta;
    public MenuInicial() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        pnlLoginSenha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLoginSenha = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        pnlLoginConta = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroConta = new javax.swing.JFormattedTextField();
        btnLoginConta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setForeground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("BLUEBANK");

        pnlLoginSenha.setBackground(new java.awt.Color(127, 203, 255));
        pnlLoginSenha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Menu Funcionário");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Digite a senha de acesso:");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel4.setText("senha: 1234");

        btnLoginSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoginSenha.setForeground(new java.awt.Color(0, 0, 153));
        btnLoginSenha.setText("LOGIN");
        btnLoginSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginSenhaActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(236, 236, 236));
        txtSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginSenhaLayout = new javax.swing.GroupLayout(pnlLoginSenha);
        pnlLoginSenha.setLayout(pnlLoginSenhaLayout);
        pnlLoginSenhaLayout.setHorizontalGroup(
            pnlLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginSenhaLayout.createSequentialGroup()
                .addGroup(pnlLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginSenhaLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlLoginSenhaLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel4))
                    .addGroup(pnlLoginSenhaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        pnlLoginSenhaLayout.setVerticalGroup(
            pnlLoginSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginSenhaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pnlLoginConta.setBackground(new java.awt.Color(127, 203, 255));
        pnlLoginConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Menu Clientes");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Digite o número da conta:");

        txtNumeroConta.setBackground(new java.awt.Color(236, 236, 236));
        txtNumeroConta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLoginConta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoginConta.setForeground(new java.awt.Color(0, 0, 204));
        btnLoginConta.setText("LOGIN");
        btnLoginConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnLoginContaActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(MenuInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel7.setText("Não necessita de senha aqui");

        javax.swing.GroupLayout pnlLoginContaLayout = new javax.swing.GroupLayout(pnlLoginConta);
        pnlLoginConta.setLayout(pnlLoginContaLayout);
        pnlLoginContaLayout.setHorizontalGroup(
            pnlLoginContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginContaLayout.createSequentialGroup()
                .addGroup(pnlLoginContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginContaLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlLoginContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNumeroConta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlLoginContaLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel7))
                    .addGroup(pnlLoginContaLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnLoginConta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginContaLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel5)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pnlLoginContaLayout.setVerticalGroup(
            pnlLoginContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginContaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoginConta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("SimSun", 2, 24)); // NOI18N
        jLabel8.setText("Segurança em Primeiro Lugar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(pnlLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(pnlLoginConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel1)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLoginConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

                                                 

    private void btnLoginSenhaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if (new String(txtSenha.getPassword()).equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Senha Correta!\nFazendo login...", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    new MenuFuncionario().setVisible(true);
                    this.dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Senha Incorreta!\n(tem a senha ali embaixos)", "Erro", JOptionPane.ERROR_MESSAGE);
                }
    }                                             

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btnLoginContaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                              

                // Pego o numero informado e busco se uma conta possui este número
                numeroConta = Integer.parseInt(txtNumeroConta.getText());
                String endpoint = "/contas/buscar-por-numero/" + numeroConta;

                //Pego a resposta e se o numero existe, abro o menu do cliente, exibindo mensagem caso contrário
                String resposta = HttpClientUtil.getRequest(endpoint);
                if (resposta != null && !resposta.isEmpty()) {
                    //new MenuConta(numeroConta).setVisible(true);
                    JOptionPane.showMessageDialog(this, "abrindo painel da conta!", "correto", JOptionPane.ERROR_MESSAGE);
                    new MenuCliente(numeroConta).setVisible(true);
                    this.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Conta não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

    }                                             


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnLoginConta;
    private javax.swing.JButton btnLoginSenha;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlLoginConta;
    private javax.swing.JPanel pnlLoginSenha;
    private javax.swing.JFormattedTextField txtNumeroConta;
    private javax.swing.JPasswordField txtSenha;
    
    // End of variables declaration     
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }
}
