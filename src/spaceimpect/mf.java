/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceimpect;

import about.personal;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static java.lang.Thread.sleep;

/**
 *
 * @author Mahadi Hassan
 */

public class mf extends javax.swing.JFrame {

    /**
     * Creates new form mf
     */
    int speed=200,buSpeed=80;  //input (enemy,bullet)
    
    int sPosition=260, yy=560,damage=5;
    boolean gameOver,t1=true,t2=true,t3=true,t4=true,t5=true;

    
    JLabel b1=new JLabel();
    JLabel e1=new JLabel();
    JLabel e2=new JLabel();
    JLabel e3=new JLabel();
    JLabel e4=new JLabel();
    JLabel eb=new JLabel();
    JLabel ship=new JLabel();
    
    
    public int ran(){
        return (int) ((Math.random()*(6-1)+1));
    }
    
    
    public void atc(){
        if(ran()==1 && true){
            attack(b1.getLocation().x,b1.getLocation().y);
        }
        else if(ran()==2 && true){
            attack(e2.getLocation().x,e2.getLocation().y);
        }
        else if(ran()==3 && true){
            attack(e3.getLocation().x,e3.getLocation().y);
        }
        else if(ran()==4 && true){
            attack(e4.getLocation().x,e4.getLocation().y);
        }
        else if(ran()==5 && true){
            attack(e1.getLocation().x,e1.getLocation().y);
        }
    }
            
    
    public void gameOver(int i){
        if(i>=480&& (t4||t5)){
            gameOver=true;
            e1.setLocation(e1.getLocation().x,e1.getLocation().y);
            e2.setLocation(e2.getLocation().x,e2.getLocation().y);
            e3.setLocation(e3.getLocation().x,e3.getLocation().y);
            e4.setLocation(e4.getLocation().x,e4.getLocation().y);
            b1.setLocation(b1.getLocation().x,b1.getLocation().y);
            JOptionPane.showMessageDialog(null, "Game Over !", "Alert (damage by 1st row)",JOptionPane.ERROR_MESSAGE);
            new personal().setVisible(true);
            
        }
        else if(i>=500&& t1){
            gameOver=true;
            e1.setLocation(e1.getLocation().x,e1.getLocation().y);
            e2.setLocation(e2.getLocation().x,e2.getLocation().y);
            e3.setLocation(e3.getLocation().x,e3.getLocation().y);
            e4.setLocation(e4.getLocation().x,e4.getLocation().y);
            b1.setLocation(b1.getLocation().x,b1.getLocation().y);
            JOptionPane.showMessageDialog(null, "Game Over !", "Alert (damage by 2nd row)",JOptionPane.ERROR_MESSAGE);
        }
        else if(i>=580&& (t2||t3)){
            gameOver=true;
            e1.setLocation(e1.getLocation().x,e1.getLocation().y);
            e2.setLocation(e2.getLocation().x,e2.getLocation().y);
            e3.setLocation(e3.getLocation().x,e3.getLocation().y);
            e4.setLocation(e4.getLocation().x,e4.getLocation().y);
            b1.setLocation(b1.getLocation().x,b1.getLocation().y);
            JOptionPane.showMessageDialog(null, "Game Over !", "Alert (damage by 3rd row",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    
    public void fire(){
        int fPosition=ship.getLocation().x;
        
        JLabel bu=new JLabel();
        bu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/fire.png")));
        bu.setSize(20,20);
        scn.add(bu);

        Thread t=new Thread(){
            public void run(){
                for (int i = 540; i >= -20; i-=10) {
                    try {
                        sleep(buSpeed);
                    } catch (Exception e) {
                    }
                    bu.setLocation(fPosition+24,i);
                    //System.out.println("Bullet= "+bu.getLocation().x+" X "+bu.getLocation().y);
                    /////---------------Damage
                    System.out.println("Enemy= "+b1.getLocation().x+" x "+b1.getLocation().y);
                    System.out.println("Bullet= "+(bu.getLocation().x-4)+" x "+bu.getLocation().y+"\n");
                    
                    if(t1&&bu.getLocation().x-4==b1.getLocation().x && bu.getLocation().y==b1.getLocation().y){
                        b1.hide();
                        bu.hide();
                        t1=false;
                        damage--;
                        System.out.println("Damege= "+damage);
                        if(damage==0){
                            b1.hide();
                            e1.hide();
                            e2.hide();
                            e3.hide();
                            e4.hide();
                            JOptionPane.showMessageDialog(null, "Winner :)","Vector",JOptionPane.QUESTION_MESSAGE);
                            new personal().setVisible(true);
                            break;
                        }
                    }
                    if(t2&&bu.getLocation().x-4==e1.getLocation().x && bu.getLocation().y==e1.getLocation().y){
                        e1.hide();
                        bu.hide();
                        t2=false;
                        damage--;
                        System.out.println("Damege= "+damage);
                        if(damage==0){
                            b1.hide();
                            e1.hide();
                            e1.hide();
                            e3.hide();
                            e4.hide();
                            JOptionPane.showMessageDialog(null, "Winner :)","Vector",JOptionPane.QUESTION_MESSAGE);
                            new personal().setVisible(true);
                            break;
                        }
                    }
                    if(t3&&bu.getLocation().x-4==e2.getLocation().x && bu.getLocation().y==e2.getLocation().y){
                        e2.hide();
                        bu.hide();
                        t3=false;
                        damage--;
                        System.out.println("Damege= "+damage);
                        if(damage==0){
                            b1.hide();
                            e1.hide();
                            e2.hide();
                            e3.hide();
                            e4.hide();
                            JOptionPane.showMessageDialog(null, "Winner :)","Vector",JOptionPane.QUESTION_MESSAGE);
                            new personal().setVisible(true);
                            break;
                        }
                    }
                    if(t4&&bu.getLocation().x-4==e3.getLocation().x && bu.getLocation().y==e3.getLocation().y){
                        e3.hide();
                        bu.hide();
                        t4=false;
                        damage--;
                        System.out.println("Damege= "+damage);
                        if(damage==0){
                            b1.hide();
                            e1.hide();
                            e2.hide();
                            e3.hide();
                            e4.hide();
                            JOptionPane.showMessageDialog(null, "Winner :)","Vector",JOptionPane.QUESTION_MESSAGE);
                            new personal().setVisible(true);
                            break;
                        }
                    }
                    if(t5&&bu.getLocation().x-4==e4.getLocation().x && bu.getLocation().y==e4.getLocation().y){
                        e4.hide();
                        bu.hide();
                        t5=false;
                        damage--;
                        System.out.println("Damege= "+damage);
                        if(damage==0){
                            b1.hide();
                            e1.hide();
                            e2.hide();
                            e3.hide();
                            e4.hide();
                            JOptionPane.showMessageDialog(null, "Winner :)","Vector",JOptionPane.QUESTION_MESSAGE);
                            new personal().setVisible(true);
                            break;
                        }
                    }                    
                }              
            }
        };
        t.start();
    }

    
    public void attack(int a,int b){
        int bx=a;
        Thread tt=new Thread(){
            public void run(){
                for (int j = b+100; j < 660; j+=10) {
                    try {
                        Thread.sleep(40);
                    } catch (Exception e) {
                    }
                    scn.add(eb);
                    eb.setLocation(bx,j);
                }
            }
        };
        tt.start();
    }
    
    //----------------------- MAIN FUNCTION ---------------------------------x
    
    
    public mf() {
        initComponents();
        
        this.setLocationRelativeTo(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("si.png")));

        
        gameOver=false;
        
        eb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/eb.png")));
        eb.setSize(20,20);
        
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/ufo3.png")));
        b1.setSize(70,70);
        scn.add(b1);
        
        e1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/ufo1.png")));
        e1.setSize(70,70);
        scn.add(e1);
        
        e2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/ufo1.png")));
        e2.setSize(70,70);
        scn.add(e2);
        
        e3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/ufo.png")));
        e3.setSize(70,70);
        scn.add(e3);
        
        e4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/ufo.png")));
        e4.setSize(70,70);
        scn.add(e4);
                
        ship.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/ship.png")));
        ship.setSize(60,62);
        ship.setLocation(280, yy);
        scn.add(ship);
        
        int ii=80,jj=280;
        
        Thread t=new Thread(){
            public void run(){
                for (int i = 80; i > 0 && !gameOver; i+=40) {
                    
//                    if(i>=480&& (t4||t5)){
//                        e1.setLocation(e1.getLocation().x,e1.getLocation().y);
//                        e2.setLocation(e2.getLocation().x,e2.getLocation().y);
//                        e3.setLocation(e3.getLocation().x,e3.getLocation().y);
//                        e4.setLocation(e4.getLocation().x,e4.getLocation().y);
//                        b1.setLocation(b1.getLocation().x,b1.getLocation().y);
//                        JOptionPane.showMessageDialog(null, "Game Over !", "Alert (damage by 1st row)",JOptionPane.ERROR_MESSAGE);
//                        break;
//                    }
//                    else if(i>=500&& t1){
//                        e1.setLocation(e1.getLocation().x,e1.getLocation().y);
//                        e2.setLocation(e2.getLocation().x,e2.getLocation().y);
//                        e3.setLocation(e3.getLocation().x,e3.getLocation().y);
//                        e4.setLocation(e4.getLocation().x,e4.getLocation().y);
//                        b1.setLocation(b1.getLocation().x,b1.getLocation().y);
//                        JOptionPane.showMessageDialog(null, "Game Over !", "Alert (damage by 2nd row)",JOptionPane.ERROR_MESSAGE);
//                        break;
//                    }
//                    else if(i>=580&& (t2||t3)){
//                        e1.setLocation(e1.getLocation().x,e1.getLocation().y);
//                        e2.setLocation(e2.getLocation().x,e2.getLocation().y);
//                        e3.setLocation(e3.getLocation().x,e3.getLocation().y);
//                        e4.setLocation(e4.getLocation().x,e4.getLocation().y);
//                        b1.setLocation(b1.getLocation().x,b1.getLocation().y);
//                        JOptionPane.showMessageDialog(null, "Game Over !", "Alert (damage by 3rd row",JOptionPane.ERROR_MESSAGE);
//                        break;
//                    }

                    System.out.println("Life Limit= "+i);
                    
                    gameOver(i);
                    if(gameOver){
                        break;
                    }
                    
                    atc();
                    
                    for (int j = 420; j >= 120; j-=20) {
                        try {
                            sleep(speed);
                            b1.setLocation(j,i);
                            e1.setLocation(j+100,i-40);
                            e2.setLocation(j-100,i-40);
                            e3.setLocation(j-100,i+40);
                            e4.setLocation(j+100,i+40);
                            //System.out.println("Enemy= "+j+" x "+i);                            
                        } catch (Exception e) {
                        }
                    }

                    i+=40;
                    System.out.println("Life Limit= "+i);

                    gameOver(i);
                    if(gameOver){
                        break;
                    }
                    
                    atc();
                    
                    for (int k = 120; k <= 420; k+=20) {
                        try {
                            sleep(speed);
                            b1.setLocation(k,i);
                            e1.setLocation(k+100,i-40);
                            e2.setLocation(k-100,i-40);
                            e3.setLocation(k-100,i+40);
                            e4.setLocation(k+100,i+40);
                            //System.out.println("Enemy"+k+" x "+i);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Space Impact");
        setBounds(new java.awt.Rectangle(500, 10, 350, 350));
        setPreferredSize(new java.awt.Dimension(600, 680));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(51, 51, 51));
        panel.setPreferredSize(new java.awt.Dimension(600, 700));

        scn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceimpect/g.jpg"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scn, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(scn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 680, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_SPACE){
            System.out.println("Fire !!");
            fire();
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
            sPosition+=20;
            System.out.println("Ship Right Move= "+sPosition+" X "+ship.getLocation().y);
            if(sPosition>520){
                sPosition=520;
            }
            ship.setLocation(sPosition,yy);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            sPosition-=20;
            System.out.println("Ship Right Move= "+sPosition+" X "+ship.getLocation().y);
            if(sPosition<20){
                sPosition=20;
            }
            ship.setLocation(sPosition,yy);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            System.out.println("======DowN=====");
            attack(200,300);
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(mf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private javax.swing.JLabel scn;
    // End of variables declaration//GEN-END:variables
}
