/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import conexion.conexionSQL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ruldin
 */
public class VentanaPokedex extends javax.swing.JFrame {

    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    BufferedImage buffer1 =null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 =(Graphics2D) imagenPokemon.getGraphics();
        
        g2.drawImage(buffer1, 0,0,imagenPokemon.getWidth(),imagenPokemon.getHeight(),null);
        
    }
    
    private void cargarpokemon(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbtodos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbtodos.getColumnCount(); i++){
            tbtodos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n" 
                    + "from test.pokemon\n"
                    + "where color=" + "'" + txtfiltroColor.getText() + "'";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
      private void filtrohabitat(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbtodos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbtodos.getColumnCount(); i++){
            tbtodos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n" 
                    + "from test.pokemon\n"
                    + "where habitat=" + "'" + txtfiltrohabitat.getText() + "'";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
     private void cargarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbdatos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50};
        for(int i=0; i <tbdatos.getColumnCount(); i++){
            tbdatos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "SELECT * FROM tb_favoritos";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
     
     
      private void cargartabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tb_datos2nofav.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50};
        for(int i=0; i <tb_datos2nofav.getColumnCount(); i++){
            tb_datos2nofav.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "SELECT * FROM tb_no_favoritos";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
     
      
      private void dtpokemon(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbpokedex.getModel();
        modeloTabla.setRowCount(0);
       int id = Integer.valueOf(idpokemon.getText());
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbpokedex.getColumnCount(); i++){
            tbpokedex.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
      
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n"
                    + "from test.pokemon\n"
                    + "where id =" + idpokemon.getText();
            
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
            
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
       private void filtroexpe(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbtodos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbtodos.getColumnCount(); i++){
            tbtodos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n" 
                    + "from test.pokemon\n"
                    + "where base_experience=" +txtfiltroexpe.getText() ;
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
      
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        cargarTabla();
        dtpokemon();
        cargarpokemon();
        filtrohabitat();
        filtroexpe();
        cargartabla();
        try {
            //imagen1 = ImageIO.read(getClass().getResource("/imagenes/back-white.png"));
            imagen1 =ImageIO.read(new File("C:\\tmp2\\black-white.png"));
        } catch (IOException ex) {  
            ex.printStackTrace(System.out);
        }
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC"; 
            
            conexion = DriverManager.getConnection(JDBC_URL,"root","");
            estado = conexion.createStatement();
            
            
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hay error de clase no encontrada");
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
            System.out.println("Hay error de BD");
        }
        
        
        
    }

    
    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        
        
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        
        repaint();
        
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BUTTONBUS = new javax.swing.JButton();
        TXTBUSCARE = new javax.swing.JTextField();
        nombrePokemon = new javax.swing.JLabel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        imagenPokemon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpokedex = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_datos2nofav = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idpokemon = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnomnousu = new javax.swing.JTextField();
        idpokemno = new javax.swing.JTextField();
        buttnagnofav = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtfiltroColor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfiltrohabitat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfiltroexpe = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbtodos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));

        BUTTONBUS.setBackground(new java.awt.Color(255, 0, 0));
        BUTTONBUS.setText("BUSCAR");
        BUTTONBUS.setBorder(new javax.swing.border.MatteBorder(null));
        BUTTONBUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTTONBUSActionPerformed(evt);
            }
        });

        nombrePokemon.setFont(new java.awt.Font("Tw Cen MT", 3, 36)); // NOI18N
        nombrePokemon.setText("nombre");

        izq.setText("<== Izquierda");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText("derecha ==>");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        tbpokedex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "especie", "color", "habitat", "experiencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbpokedex);

        jPanel4.setBackground(new java.awt.Color(255, 0, 102));

        jLabel1.setText("Pokemon's Favoritos");

        tbdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "id_pokemon", "usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdatos);

        tb_datos2nofav.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "id_pokemon", "usuario"
            }
        ));
        tb_datos2nofav.setRowHeight(30);
        jScrollPane3.setViewportView(tb_datos2nofav);

        jLabel2.setText("Nombre ");

        jLabel3.setText("id del pokemon");

        idpokemon.setText("0");

        btnagregar.setText("Agregar a favoritos");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel7.setText("Pokemon's no Favoritos");

        jLabel8.setText("Nombre");

        jLabel9.setText("id del pokemon");

        buttnagnofav.setText("Agregar a no favoritos");
        buttnagnofav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttnagnofavActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 51));

        jLabel4.setText("Filtrar por color");

        txtfiltroColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroColorActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtrar por habitat");

        txtfiltrohabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltrohabitatActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtrar por experiencia");

        txtfiltroexpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroexpeActionPerformed(evt);
            }
        });

        tbtodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "especie", "color", "habitat", "experiencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbtodos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtfiltroexpe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(txtfiltrohabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(txtfiltroColor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtfiltroColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtfiltrohabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txtfiltroexpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(292, 292, 292)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(276, 276, 276))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 380, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(idpokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttnagnofav, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(btnagregar))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(504, 504, 504))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idpokemno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnomnousu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnomnousu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idpokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(idpokemno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnagregar)
                    .addComponent(buttnagnofav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TXTBUSCARE, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BUTTONBUS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(izq)
                        .addGap(73, 73, 73)
                        .addComponent(der))
                    .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTBUSCARE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BUTTONBUS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(nombrePokemon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(der)
                            .addComponent(izq))))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(880, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
      
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        try {
            resultadoConsulta = estado.
                    executeQuery("select * from pokemon where id="+(contador + 1));
            
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
                 idpokemon.setText(resultadoConsulta.getString(1));
                 
         dtpokemon();
            } else {
                nombrePokemon.setText("Este chucho no esta e el pokedex");
                 idpokemon.setText("sin resultado");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        contador++;
        if (contador >= 649){
            contador = 649;
        }
        
        
    }//GEN-LAST:event_derActionPerformed

    public void agregarUsuario(){
        
        String nombre =String.valueOf(txtnombre.getText());
        int pdex =Integer.valueOf(idpokemon.getText());
        String SQL = "insert into tb_favoritos (id_pokemon,usuario) values(?,?)";
        
        try{
            PreparedStatement pst =con.prepareStatement(SQL);
            
            pst.setInt(1,pdex);
            pst.setString(2,nombre);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
        }
    }
    
    
    public void agregarnoUsuario(){
        
         String nombre =String.valueOf(txtnomnousu.getText());
        int pdex =Integer.valueOf(idpokemno.getText());
        String SQL = "insert into tb_no_favoritos (id_pokemon,usuario) values(?,?)";
        
        try{
            PreparedStatement pst =con.prepareStatement(SQL);
            
            pst.setInt(1,pdex);
            pst.setString(2,nombre);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
        }
        
        
    }
    
    
    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        try {
            resultadoConsulta = estado.
                    executeQuery("select * from pokemon where id="+(contador+1));
            
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
                idpokemon.setText(resultadoConsulta.getString(1));
                 dtpokemon();
            } else {
                nombrePokemon.setText("Este chucho no esta e el pokedex");
                idpokemon.setText("sin resultado");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        contador--;
        if (contador >= 649){
            contador = 649;
        }
        
        
        
        
//        //evento cuando el usr de click en izquierdo
//        contador--;
//        if(contador <=0){
//            contador=1;
//        }
//        dibujaElPokemonQueEstaEnLaPosicion(contador);
//        
    }//GEN-LAST:event_izqActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
       agregarUsuario();
       cargarTabla();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void txtfiltroColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroColorActionPerformed
            cargarpokemon();
    }//GEN-LAST:event_txtfiltroColorActionPerformed

    private void txtfiltrohabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltrohabitatActionPerformed
        filtrohabitat();
    }//GEN-LAST:event_txtfiltrohabitatActionPerformed

    private void txtfiltroexpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroexpeActionPerformed
      filtroexpe();
    }//GEN-LAST:event_txtfiltroexpeActionPerformed

    private void BUTTONBUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTTONBUSActionPerformed
        // TODO add your handling code here:
         String BUTTONBUS = TXTBUSCARE.getText();
        try {
            resultadoConsulta = estado.
                    executeQuery("select name pokemon where name like"+"'%"+BUTTONBUS.toLowerCase()+"%'");
            
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
            } else {
                nombrePokemon.setText("Este chucho no esta e el pokedex");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            dibujaElPokemonQueEstaEnLaPosicion(resultadoConsulta.getInt(1)-1);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        JTable jTable1 = (JTable) resultadoConsulta;
    }//GEN-LAST:event_BUTTONBUSActionPerformed

    private void buttnagnofavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttnagnofavActionPerformed
        agregarnoUsuario();
        cargarTabla();
    }//GEN-LAST:event_buttnagnofavActionPerformed

    
    
   

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTTONBUS;
    private javax.swing.JTextField TXTBUSCARE;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton buttnagnofav;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton der;
    private javax.swing.JTextField idpokemno;
    private javax.swing.JTextField idpokemon;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JTable tb_datos2nofav;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTable tbpokedex;
    private javax.swing.JTable tbtodos;
    private javax.swing.JTextField txtfiltroColor;
    private javax.swing.JTextField txtfiltroexpe;
    private javax.swing.JTextField txtfiltrohabitat;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnomnousu;
    // End of variables declaration//GEN-END:variables

}
