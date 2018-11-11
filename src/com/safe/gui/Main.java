/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safe.gui;

import com.safe.service.TokenManager;
import com.safe.service.SessionManager;
import java.awt.ComponentOrientation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author familia
 */
public class Main extends javax.swing.JFrame {
    
    private final TokenManager token;
    private final Login loginForm;
    private final SessionManager session;
    private javax.swing.JMenu jMenuProfile;
    java.awt.Component horizontalGlue;
    /**
     * Creates new form Main
     * @param loginForm
     * @param token
     */
    public Main(Login loginForm, TokenManager token) {
        initComponents();        
        initUserMenu();
        this.token = token;
        this.loginForm = loginForm;
        int sessionTime;
        try {
            sessionTime = (int)Integer.parseInt(getConfig().getProperty("safe.sessionMinuteTime"));
            System.out.println("Se establece la session a: " + sessionTime);
        } catch (IOException e) {
            sessionTime = 10;
            System.out.println("Error al leer la el tiempo de session. se establece como 10 minutos");
        }

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int px = (screenSize.width / 2) - ( this.getWidth() / 2);
        int py = (screenSize.height / 2) - ( this.getHeight() / 2);
        this.setLocation(new java.awt.Point(px, py));
        session = new SessionManager(this, sessionTime);
    }
    
    public void signin(){
        configureRoleMenu();        
        jLabelProfile.setText(token.getRoleName());
        this.setVisible(true);
        this.loginForm.setVisible(false);
        session.start();
    }
    
    public void logout(String reason){
        session.stop();
        this.setVisible(false);
        setJMenuBar(null);                
        this.loginForm.getPasswordField().setText("");
        this.loginForm.getLabelMessage().setText(reason);
        this.loginForm.setVisible(true);
    }
    
    public Login getLoginForm(){
        return this.loginForm;
    }
    
    private void configureRoleMenu(){   
        javax.swing.JMenuBar currentMenu = null;
        switch(token.getUserRole()){
            case "ROLE_ADMIN": currentMenu = jMenuAdmin;                
            break;            
            case "ROLE_SUPERVISOR": currentMenu = jMenuSupervisor;
            break;
            case "ROLE_ENGINER": currentMenu =jMenuEnginer;
            break;
        }
        jMenuProfile.setText(token.getUser().getFullName());
        if(currentMenu instanceof javax.swing.JMenuBar){
            currentMenu.add(horizontalGlue);
            currentMenu.add(jMenuProfile);
            setJMenuBar(currentMenu);
        }
    }
    
    private void initUserMenu(){
        jMenuProfile = new javax.swing.JMenu();
        horizontalGlue = javax.swing.Box.createHorizontalGlue();
        javax.swing.JMenuItem item = new javax.swing.JMenuItem();
        item.setText("Cerrar Sesión");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout("Su sesión se ha cerrado con exito.");
            }
        });
        jMenuProfile.add(item);                    
        jMenuProfile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    
    private Properties getConfig() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                System.getProperty("user.dir") +
                "/resources/config.properties"
        );

        if (inputStream instanceof InputStream) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("falta archivo file 'config.properties'");
        }
        
        return prop;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuSupervisor = new javax.swing.JMenuBar();
        jMenuTerreno = new javax.swing.JMenu();
        jMenuPlanCap = new javax.swing.JMenu();
        jMenuPlanSalud = new javax.swing.JMenu();
        jMenuExpositor = new javax.swing.JMenu();
        jMenuMedicoSup = new javax.swing.JMenu();
        jMenuMedListar1 = new javax.swing.JMenuItem();
        jMenuMedEditar1 = new javax.swing.JMenuItem();
        jMenuCal = new javax.swing.JMenu();
        jMenuAdmin = new javax.swing.JMenuBar();
        jMenuEmpresa = new javax.swing.JMenu();
        jMenuEmpCrear = new javax.swing.JMenuItem();
        jMenuEmpListar = new javax.swing.JMenuItem();
        jMenuEmpEditar = new javax.swing.JMenuItem();
        jMenuEmpEliminar = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuUsrCrear = new javax.swing.JMenuItem();
        jMenuUsrListar = new javax.swing.JMenuItem();
        jMenuUsrEditar = new javax.swing.JMenuItem();
        jMenuUsrEliminar = new javax.swing.JMenuItem();
        jMenuCapacitacion = new javax.swing.JMenu();
        jMenuCapCrear = new javax.swing.JMenuItem();
        jMenuCapListar = new javax.swing.JMenuItem();
        jMenuCapEditar = new javax.swing.JMenuItem();
        jMenuCapEliminar = new javax.swing.JMenuItem();
        jMenuExamen = new javax.swing.JMenu();
        jMenuExmCrear = new javax.swing.JMenuItem();
        jMenuExmListar = new javax.swing.JMenuItem();
        jMenuExmEditar = new javax.swing.JMenuItem();
        jMenuExmEliminar = new javax.swing.JMenuItem();
        jMenuMedico = new javax.swing.JMenu();
        jMenuMedCrear = new javax.swing.JMenuItem();
        jMenuMedListar = new javax.swing.JMenuItem();
        jMenuMedEditar = new javax.swing.JMenuItem();
        jMenuMedEliminar = new javax.swing.JMenuItem();
        jMenuEnginer = new javax.swing.JMenuBar();
        jMenuTerrenoEng = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelProfile = new javax.swing.JLabel();

        jMenuSupervisor.setOpaque(false);

        jMenuTerreno.setText("Evaluación En Terreno");
        jMenuTerreno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuTerreno.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuSupervisor.add(jMenuTerreno);

        jMenuPlanCap.setText("Plan Capacitación");
        jMenuPlanCap.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuSupervisor.add(jMenuPlanCap);

        jMenuPlanSalud.setText("Plan de Salud");
        jMenuPlanSalud.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuSupervisor.add(jMenuPlanSalud);

        jMenuExpositor.setText("Expositores");
        jMenuExpositor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuSupervisor.add(jMenuExpositor);

        jMenuMedicoSup.setText("Médicos");
        jMenuMedicoSup.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jMenuMedListar1.setText("Listar");
        jMenuMedicoSup.add(jMenuMedListar1);

        jMenuMedEditar1.setText("Editar");
        jMenuMedEditar1.setEnabled(false);
        jMenuMedicoSup.add(jMenuMedEditar1);

        jMenuSupervisor.add(jMenuMedicoSup);

        jMenuCal.setText("Calendario");
        jMenuCal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuSupervisor.add(jMenuCal);

        jMenuAdmin.setOpaque(false);

        jMenuEmpresa.setText("Empresas");

        jMenuEmpCrear.setText("Crear");
        jMenuEmpCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEmpCrearActionPerformed(evt);
            }
        });
        jMenuEmpresa.add(jMenuEmpCrear);

        jMenuEmpListar.setText("Listar");
        jMenuEmpresa.add(jMenuEmpListar);

        jMenuEmpEditar.setText("Editar");
        jMenuEmpEditar.setEnabled(false);
        jMenuEmpresa.add(jMenuEmpEditar);

        jMenuEmpEliminar.setText("Eliminar");
        jMenuEmpEliminar.setEnabled(false);
        jMenuEmpresa.add(jMenuEmpEliminar);

        jMenuAdmin.add(jMenuEmpresa);

        jMenuUsuario.setText("Usuarios");

        jMenuUsrCrear.setText("Crear");
        jMenuUsuario.add(jMenuUsrCrear);

        jMenuUsrListar.setText("Listar");
        jMenuUsuario.add(jMenuUsrListar);

        jMenuUsrEditar.setText("Editar");
        jMenuUsrEditar.setEnabled(false);
        jMenuUsuario.add(jMenuUsrEditar);

        jMenuUsrEliminar.setText("Eliminar");
        jMenuUsrEliminar.setEnabled(false);
        jMenuUsuario.add(jMenuUsrEliminar);

        jMenuAdmin.add(jMenuUsuario);

        jMenuCapacitacion.setText("Capacitaciones");

        jMenuCapCrear.setText("Crear");
        jMenuCapacitacion.add(jMenuCapCrear);

        jMenuCapListar.setText("Listar");
        jMenuCapacitacion.add(jMenuCapListar);

        jMenuCapEditar.setText("Editar");
        jMenuCapEditar.setEnabled(false);
        jMenuCapacitacion.add(jMenuCapEditar);

        jMenuCapEliminar.setText("Eliminar");
        jMenuCapEliminar.setEnabled(false);
        jMenuCapacitacion.add(jMenuCapEliminar);

        jMenuAdmin.add(jMenuCapacitacion);

        jMenuExamen.setText("Exámenes");

        jMenuExmCrear.setText("Crear");
        jMenuExamen.add(jMenuExmCrear);

        jMenuExmListar.setText("Listar");
        jMenuExamen.add(jMenuExmListar);

        jMenuExmEditar.setText("Editar");
        jMenuExmEditar.setEnabled(false);
        jMenuExamen.add(jMenuExmEditar);

        jMenuExmEliminar.setText("Eliminar");
        jMenuExmEliminar.setEnabled(false);
        jMenuExamen.add(jMenuExmEliminar);

        jMenuAdmin.add(jMenuExamen);

        jMenuMedico.setText("Médicos");

        jMenuMedCrear.setText("Crear");
        jMenuMedCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMedCrearActionPerformed(evt);
            }
        });
        jMenuMedico.add(jMenuMedCrear);

        jMenuMedListar.setText("Listar");
        jMenuMedico.add(jMenuMedListar);

        jMenuMedEditar.setText("Editar");
        jMenuMedEditar.setEnabled(false);
        jMenuMedico.add(jMenuMedEditar);

        jMenuMedEliminar.setText("Eliminar");
        jMenuMedEliminar.setEnabled(false);
        jMenuMedico.add(jMenuMedEliminar);

        jMenuAdmin.add(jMenuMedico);

        jMenuEnginer.setOpaque(false);

        jMenuTerrenoEng.setText("Evaluaciones en Terreno");
        jMenuEnginer.add(jMenuTerrenoEng);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de administración SAFE");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");

        jLabel2.setText("Perfil de usuario:");

        jLabelProfile.setText("Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2)
                        .addGap(78, 78, 78)
                        .addComponent(jLabelProfile)
                        .addGap(0, 220, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelProfile))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuEmpCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEmpCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuEmpCrearActionPerformed

    private void jMenuMedCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMedCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuMedCrearActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        session.alive();
    }//GEN-LAST:event_formMouseMoved

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        System.out.println("Listo!");
    }//GEN-LAST:event_formWindowStateChanged
    
    /**
     * @param args the command line arguments
    
    public static void Main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelProfile;
    private javax.swing.JMenuBar jMenuAdmin;
    private javax.swing.JMenu jMenuCal;
    private javax.swing.JMenuItem jMenuCapCrear;
    private javax.swing.JMenuItem jMenuCapEditar;
    private javax.swing.JMenuItem jMenuCapEliminar;
    private javax.swing.JMenuItem jMenuCapListar;
    private javax.swing.JMenu jMenuCapacitacion;
    private javax.swing.JMenuItem jMenuEmpCrear;
    private javax.swing.JMenuItem jMenuEmpEditar;
    private javax.swing.JMenuItem jMenuEmpEliminar;
    private javax.swing.JMenuItem jMenuEmpListar;
    private javax.swing.JMenu jMenuEmpresa;
    private javax.swing.JMenuBar jMenuEnginer;
    private javax.swing.JMenu jMenuExamen;
    private javax.swing.JMenuItem jMenuExmCrear;
    private javax.swing.JMenuItem jMenuExmEditar;
    private javax.swing.JMenuItem jMenuExmEliminar;
    private javax.swing.JMenuItem jMenuExmListar;
    private javax.swing.JMenu jMenuExpositor;
    private javax.swing.JMenuItem jMenuMedCrear;
    private javax.swing.JMenuItem jMenuMedEditar;
    private javax.swing.JMenuItem jMenuMedEditar1;
    private javax.swing.JMenuItem jMenuMedEliminar;
    private javax.swing.JMenuItem jMenuMedListar;
    private javax.swing.JMenuItem jMenuMedListar1;
    private javax.swing.JMenu jMenuMedico;
    private javax.swing.JMenu jMenuMedicoSup;
    private javax.swing.JMenu jMenuPlanCap;
    private javax.swing.JMenu jMenuPlanSalud;
    private javax.swing.JMenuBar jMenuSupervisor;
    private javax.swing.JMenu jMenuTerreno;
    private javax.swing.JMenu jMenuTerrenoEng;
    private javax.swing.JMenuItem jMenuUsrCrear;
    private javax.swing.JMenuItem jMenuUsrEditar;
    private javax.swing.JMenuItem jMenuUsrEliminar;
    private javax.swing.JMenuItem jMenuUsrListar;
    private javax.swing.JMenu jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
