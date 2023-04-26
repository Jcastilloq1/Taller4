package Interfaz;

import java.awt.Color;

import modelo.Tablero;
import modelo.RegistroTop10;
import modelo.Top10;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelCentro extends JPanel implements MouseListener
{
	private int ladoTablero;
	private VentanaPrincipal principal;
	private JLabel dibujoLuz;
	private boolean tableroIluminado;
	private JLabel lblImagen;
	private ImageIcon icono;
	private JLabel etiquetaImagen;
	private File fileName;
	
	public PanelCentro( VentanaPrincipal pPrincipal)
    {
        principal = pPrincipal;
        addMouseListener( this );
        add(new JLabel("                                                                                                " ));
        fileName = new File("./data/top10.csv");
        
    }
    
    public void paint(Graphics g)
    {
        Graphics2D  g2d = (Graphics2D) g;
        
 
        boolean[][] tableroJuego= principal.darTableroJuego( );
        ladoTablero=tableroJuego.length;
        
        int ancho=getWidth( )/ladoTablero;
        int alto= getHeight( )/ladoTablero;
        
        for(int i=0;i<ladoTablero;i++)
        {
            for(int j=0; j<ladoTablero;j++)
            {
            
            	
                 
                if(tableroJuego[i][j]==true)
                {
                    g.setColor( Color.YELLOW );
                    g.fillRect( i*ancho, j*alto, ancho, alto );
                    g.setColor( Color.BLACK );
                    g.drawRect( i*ancho, j*alto, ancho, alto );
                    ImageIcon icono = new ImageIcon("./data/luz.png");
                    g.drawImage(icono.getImage(), i * ancho, j * alto, ancho, alto, null);
                    
                    
                }
                else
                {
                	
                    g.setColor( Color.GRAY );
                    g.fillRect( i*ancho, j*alto, ancho, alto );
                    g.setColor( Color.BLUE );
                    g.drawRect( i*ancho, j*alto, ancho, alto );
                    etiquetaImagen = new JLabel( );
                    ImageIcon icono = new ImageIcon("./data/luz.png");
                    g.drawImage(icono.getImage(), i * ancho, j * alto, ancho, alto, null);
                }
                
                
            }
            
        }
        
        
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
		
		int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        principal.jugar(casilla[1], casilla[0]);
        principal.darJugadas();
        repaint();
		
		tableroIluminado = principal.tableroIluminado();
		
		if (tableroIluminado == true)
		{
			
			JOptionPane.showMessageDialog(principal, "GANASTE!!!", "Alert", JOptionPane.INFORMATION_MESSAGE);
			int puntaje = principal.darPuntaje();
			principal.agregarRegistro(puntaje);
			try {
				principal.salvarRegistro(fileName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
        
		
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y)
    {
//       
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
