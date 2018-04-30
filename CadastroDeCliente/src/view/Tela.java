package view;

import controller.ClienteDAO;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import model.ClienteBEAN;

public class Tela extends javax.swing.JFrame {

    public Tela() {
        initComponents();
    }
                        
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        lblNomeMae = new javax.swing.JLabel();
        txtNomeMae = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        menuAjuda = new javax.swing.JMenu("Ajuda");
        menuArquivo = new javax.swing.JMenu("Arquivo");
        itemSair = new javax.swing.JMenuItem("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tela.this.botaoSair();
            }
        });
        
        
        
        
        itemSobre = new javax.swing.JMenuItem("Sobre");
        itemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tela.this.botaoSobre();
            }
        });
        
        
        barraDeMenu = new JMenuBar();
        barraDeMenu.add(menuArquivo);
        barraDeMenu.add(menuAjuda);
        
        menuAjuda.add(itemSobre);
        menuAjuda.add(itemSair);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO");  
       
        lblNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNome.setText("Nome:");

        lblNascimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNascimento.setText("Nascimento (AAAA-MM-DD):");

        lblNomeMae.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNomeMae.setText("Nome da Mãe:");

        lblCPF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCPF.setText("CPF:");

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblNascimento)
                    .addComponent(lblNomeMae)
                    .addComponent(lblCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNascimento)
                    .addComponent(txtNomeMae)
                    .addComponent(txtCPF)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeMae)
                    .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
       
        Container painel = this.getContentPane();
        painel.setForeground(Color.yellow);
        this.setJMenuBar(barraDeMenu);
        this.setVisible(true);
        this.setLocation(485, 200);
        pack();
    }                       
    

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) { 
        String nome, nascimento, nomeMae, CPF;
        nome = txtNome.getText();
        nascimento = txtNascimento.getText();
        nomeMae = txtNomeMae.getText();
        CPF = txtCPF.getText();
        ClienteBEAN cliente = new ClienteBEAN();
        if(ClienteDAO.verificaNascimento(nascimento)){
            try{
                ClienteDAO clienteBD = new ClienteDAO(); 
                cliente.setNome(nome);
                cliente.setNascimento(nascimento);
                cliente.setNomeMae(nomeMae);
                cliente.setCpf(CPF);
                clienteBD.insere(cliente);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR AO BANCO DE DADOS");
                System.exit(0);
            }        
        }else{
            JOptionPane.showMessageDialog(null, "DATA DE NASCIMENTO INCORRETA!");
        }
            txtNome.setText("");
            txtNascimento.setText("");
            txtNomeMae.setText("");
            txtCPF.setText("");
    }  
    
    
   private void botaoSair(){
       System.exit(0);
   }
        
   private void botaoSobre(){
       JOptionPane.showMessageDialog(null, "<html>Desenvolvido por <a href=\"www.facebook.com\">Emanoel Lucas.</a> </br> </br> |&nbsp; Versão 1.0</html>");      
   }
    
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNascimento ;
    private javax.swing.JLabel lblNomeMae;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSobre;
                    
}
