package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.TitledBorder;

import modelo.RegistroTop10;
import modelo.Tablero;
import modelo.Top10;

public class PanelOpciones extends JPanel implements ActionListener
{
	
	
	private JButton btnNuevo;    
    private JButton btnReiniciar;
    private JButton btnTop10;
    private JButton btnCambiarJ;
    private JDialog dialogIngNombre;
    private JDialog dialogTop;
    private VentanaPrincipal principal; 
    private JList rank10;     
    private JList listadoNombres;
    private JLabel espacio;
    private String nombre;
    private JScrollPane scrollableTextArea;
    private Collection<RegistroTop10> nombres;
    private PanelTop panelTop;
	private Top10 p10;
    
    public PanelOpciones(VentanaPrincipal principal, Top10 p10)
    {
    	this.p10 = p10;
    	p10.cargarRecords(new File("./data/top10.csv"));
    	this.principal=principal;
        
        setLayout( new GridLayout( 9,1 ) );
        
        espacio = new JLabel();
        add(espacio);
        
        btnNuevo= new JButton("Nuevo");
        btnNuevo.addActionListener( this );
        btnNuevo.setBackground(new Color(126, 205, 250));
        add(btnNuevo);
        
        espacio = new JLabel();
        add(espacio);
        
        btnReiniciar=new JButton( "Reiniciar");
        btnReiniciar.addActionListener( this );
        add(btnReiniciar);
        
        espacio = new JLabel();
        add(espacio);
        
        btnTop10=new JButton( "Top-10");
        add(btnTop10);
        btnTop10.addActionListener( this );
        
        espacio = new JLabel();
        add(espacio); 
        
        btnCambiarJ = new JButton("Cambiar Jugador");
        add(btnCambiarJ);
        btnCambiarJ.addActionListener( this );
        
      
    }
    
 




	@Override
	public void actionPerformed( ActionEvent e )
    {
        if(e.getSource( )==btnNuevo)
        {
        	int tam = principal.darTamano();
            principal.nuevoTablero(tam);
            int dif = principal.darDificultad();
            principal.desordenar();
            repaint();
            nombre = JOptionPane.showInputDialog(principal,"Ingrese su nombre");
            principal.actualizarNombre(nombre);
            int jugadas = principal.darJugadas();
            principal.actualizar(jugadas);
            
            
            
        }
        else if(e.getSource( )==btnReiniciar)
        {
        	principal.reiniciar();
        	int dif = principal.darDificultad();
            principal.desordenar();
            repaint();
      
        }
        
        else if(e.getSource()== btnTop10)
        {
        	panelTop = new PanelTop(principal, p10);
            
        }
        else if(e.getSource()== btnCambiarJ)
        {
        	
        }
        
        
    }




	public void agregarRegistro(int puntaje)
	{
		p10.agregarRegistro(nombre, puntaje);
		
	}
	

}
