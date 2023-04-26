package Interfaz;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Tablero;
import modelo.Top10;

public class VentanaPrincipal extends JFrame
{
	
	private Tablero tablero;
	
    private PanelOpciones panelOpciones;
    private PanelSur panelSur;
    private PanelNorte panelNorte;
    private PanelCentro panelCentro;
    private int tamano;
    private int dificultad;
    private int seleccionado;
    private int seleccionadoD;
    private int jugadas;
    private Top10 top10;
    private File nombreFile;
    
    
    private boolean[][] matriz;
    
    public static void main (String[ ] args)
    {
    	
        VentanaPrincipal interfaz= new VentanaPrincipal();
        interfaz.setLocationRelativeTo( null );
        interfaz.setVisible( true );
    }
    
    
    public VentanaPrincipal()
    {
        tamano = 3;
        dificultad = 1;
        tablero = new Tablero(tamano);
        tablero.desordenar(dificultad);
        
        setSize( 900,650 );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setTitle( "LightsOut" );
        setLayout( new BorderLayout( ) );
               
        panelNorte= new PanelNorte(this);
        add(panelNorte, BorderLayout.NORTH);
        
        panelOpciones = new PanelOpciones(this);
        add(panelOpciones, BorderLayout.EAST);
        
        panelSur = new PanelSur( this);
        add(panelSur, BorderLayout.SOUTH);
        
        panelCentro = new PanelCentro(this);
        add(panelCentro, BorderLayout.CENTER);
        
        addWindowListener(new WindowAdapter()
        {
        	public void windowClosing(WindowEvent e)
        	{
        		//salvarTop10();
        	}
        });
        
        
        //ejemplo = new Ejemplo2D( this );
        //add(ejemplo, BorderLayout.WEST);
        
        
    }
    
    public int darTamano()
    {
    	seleccionado  = panelNorte.darTamano();
    	return seleccionado;
    }
    
    public int darDificultad()
    {
    	seleccionadoD = panelNorte.darDificultad();
    	return seleccionadoD;
    }

    
    public void nuevoTablero(int tamano)
    {
    	
    	tablero = new Tablero(tamano);
    }
    
    public void desordenar()
    {
    	
    	tablero.desordenar(seleccionadoD);
    	repaint();
    }


    public boolean[][] darTableroJuego( )
    {
        return tablero.darTablero();
    }

    public void jugar( int i, int j )
    {
        tablero.jugar(i, j);
        panelSur.actualizarCantidadJugadas(jugadas);
    }
    
    public void reiniciar()
    {
    	tablero.reiniciar();
    }


	public int darJugadas() 
	{
		
		jugadas = tablero.darJugadas();
		return jugadas;
	}
	
	public void actualizar(int cantJugadas)
	{
		panelSur.actualizarCantidadJugadas(cantJugadas);
		
	}


	public void actualizarNombre(String nombre) 
	{
		panelSur.actualizarNombre(nombre);
		
	}
	
	public boolean tableroIluminado()
	{
		boolean rta = tablero.tableroIluminado();
		return rta;
		
	}


	public int darPuntaje() 
	{
		int puntaje = tablero.calcularPuntaje();
		return puntaje;
	}


	public void agregarRegistro(int puntaje) 
	{
		panelOpciones.agregarRegistro(puntaje);
	}
	
	public void salvarRegistro(File nombreFile) throws FileNotFoundException, UnsupportedEncodingException
	{
		top10.salvarRecords(nombreFile);
	}
    
}
