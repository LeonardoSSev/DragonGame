
package testes;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

/*
 * @author Leonardo
 */
public class GameForm extends javax.swing.JFrame {

    Player p = new Player();
        Dragon d = new Dragon();
        
    
    public GameForm() {
        initComponents();
        centralizarComponente();
        jTextAreaTela.setText("Choose a name and click on Play");
        
        
    
    }
    public void centralizarComponente() {
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jButtonPlay = new javax.swing.JButton();
        jScrollPaneTela = new javax.swing.JScrollPane();
        jTextAreaTela = new javax.swing.JTextArea();
        jButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setText("Name");

        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jTextAreaTela.setColumns(20);
        jTextAreaTela.setRows(5);
        jScrollPaneTela.setViewportView(jTextAreaTela);

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneTela))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabelNome)))
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonPlay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonReset)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTela, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPlay)
                    .addComponent(jButtonReset))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
       
       Random rd = new Random();

       if (jTextFieldNome.getText().isEmpty()){
           jTextAreaTela.setText("You must inform a name to play");
       } else{
           p.setName(jTextFieldNome.getText());
           if (!jTextAreaTela.getText().isEmpty()){
               jTextAreaTela.setText("");
           }
           p.setPHit(rd.nextInt(4));
           if (d.getHp() <= 0){
               jTextAreaTela.setText(p.getName() + " defeated the dragon. Congratulations!");
                      jTextAreaTela.append("\n" + p.getName() + "'s life: " + p.getHp());
                      jTextAreaTela.append("\nDragon's life: " + d.getHp());
                      jTextAreaTela.append("\nClick on reset button to start a new game.");
           } else if(p.getHp() <= 0){
               jTextAreaTela.setText("The dragon defeated you. You lose!");
                    jTextAreaTela.append("\n" + p.getName() + "'s life: " + p.getHp());
                    jTextAreaTela.append("\nDragon's life: " + d.getHp());
                    jTextAreaTela.append("\nClick on reset button to start a new game.");
       } else if (p.getPHit() == 1 || p.getPHit() == 2 || p.getPHit() == 3){
               p.setPDamage(rd.nextInt(21));

               while(p.getPDamage() == 0){
                   p.setPDamage(rd.nextInt(21));
               }
               
               d.setHp(d.getHp()-p.getPDamage());
       
               if (d.getHp()>0 && p.getHp()>0){
                    jTextAreaTela.setText(p.sendPMsg()+"\n" + p.getName() + "'s life: " + p.getHp() + "\nDragon's life:" + d.getHp());
               }else if (d.getHp() <=0 || p.getHp() <=0){
                 jTextAreaTela.setText(d.sendDMsg()+"\n" + p.getName() + "'s life: " + p.getHp() + "\nDragon's life:" + d.getHp());
                   jTextAreaTela.append("\nThe game is over!");
           }
        } else{
           d.setDDamage(rd.nextInt(31));
           
           while (d.getDDamage() == 0){
               d.setDDamage(rd.nextInt(31));
           }
           p.setHp(p.getHp()-d.getDDamage());
               if (d.getHp()>0 && p.getHp()>0){
                    jTextAreaTela.setText(d.sendDMsg()+"\n" + p.getName() + "'s life: " + p.getHp() + "\nDragon's life:" + d.getHp());
               }else if (d.getHp() <=0 || p.getHp() <=0){
                jTextAreaTela.setText(d.sendDMsg()+"\n" + p.getName() + "'s life: " + p.getHp() + "\nDragon's life:" + d.getHp());
                   jTextAreaTela.append("\nThe game is over!");
               }
           }
       }
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        jTextFieldNome.setText("");
        jTextAreaTela.setText("Choose a name and click on Play");
        
        p.setName(" ");
        p.setHp(100);
        p.setPHit(0);
        p.setPDamage(0);
        
        d.setDDamage(0);
        d.setHp(150);
    }//GEN-LAST:event_jButtonResetActionPerformed

 
    public static void main(String args[]) {
    
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPaneTela;
    private javax.swing.JTextArea jTextAreaTela;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
