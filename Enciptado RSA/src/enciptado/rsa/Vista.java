package enciptado.rsa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vista extends JFrame implements ActionListener {

    JLabel titulo, p, q, n, palabra;
    JTextField campop, campon, campoq, campopalabra;
    JPanel p1;
    JButton encriptar;
    Mensaje c = new Mensaje();
    Primos pr = new Primos();
    RSA r = new RSA();
    ArrayList<Integer> caracteres;
    JTextArea area;

    public Vista() {
        Crearpanel();
        CrearVentana();
        escuchar();
    }

    private void Crearpanel() {
        p1 = new JPanel();
        p1.setLayout(null);
        campop = new JTextField();
        campon = new JTextField();
        campoq = new JTextField();
        campopalabra = new JTextField();
        p = new JLabel("Ingrese P");
        q = new JLabel("Ingrese q");
        n = new JLabel("Ingrese n");
        palabra = new JLabel("Ingrese una palabra");
        titulo = new JLabel("Encriptado RSA");
        titulo.setBounds(60, 20, 230, 40);
        titulo.setFont(new Font("Times New Roman", 1, 30));
        p.setBounds(50, 90, 60, 20);
        campop.setBounds(50, 120, 40, 20);
        q.setBounds(120, 90, 60, 20);
        campoq.setBounds(120, 120, 40, 20);
        n.setBounds(190, 90, 60, 20);
        campon.setBounds(190, 120, 40, 20);
        palabra.setBounds(260, 90, 120, 20);
        campopalabra.setBounds(260, 120, 100, 20);
        encriptar = new JButton("Encriptar");
        encriptar.setBounds(140, 170, 100, 20);
        area = new JTextArea();
        area.setBounds(0,200,300,100);
        p1.setBackground(Color.white);
        p1.add(p);
        p1.add(campop);
        p1.add(q);
        p1.add(campoq);
        p1.add(n);
        p1.add(campon);
        p1.add(palabra);
        p1.add(campopalabra);
        p1.add(encriptar);
        p1.add(titulo);
    }

    private void CrearVentana() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(encriptar)) {
            area.setText("");
            area.setText("Encriptar con el método RSA \n");
            area.append("(Rivest, Shamir y Adleman)\n");
            String mensaje = campopalabra.getText();
            System.out.println(mensaje);
            int q = Integer.parseInt(campoq.getText());
            int p = Integer.parseInt(campop.getText());
            int n = Integer.parseInt(campon.getText());
            caracteres = c.separarCaracteres(mensaje);
            for (int i = 0; i < mensaje.length(); i++) {
                if ((pr.veracidadPrimo(p)) && pr.veracidadPrimo(q) && pr.veracidadPrimo(n)) {
                    r.RSA1(p, q, n, caracteres.get(i));
                    if(i==0){
                        area.append("S= "+r.s+" (Clave Privada)     Z= "+r.z+"\n");
                    }
                    area.append(mensaje.charAt(i)+" = "+ r.encriptar()+"\n");
                    r.borrar();
                    
                } else {
                    if (pr.veracidadPrimo(p)) {
                        if (pr.veracidadPrimo(q)) {
                            JOptionPane.showMessageDialog(null, "El numero n no es primo", "Warning", 2);
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero q no es primo", "Warning", 2);
                        }

                    } else {
                        if (pr.veracidadPrimo(q)) {
                            JOptionPane.showMessageDialog(null, "El numero n no es primo", "Warning", 2);
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero p no es primo", "Warning", 2);
                        }

                    }
                }
            }
            
            
            setVisible(false);
            setSize(400, 500);
            area.setBounds(0,200,300,100+(50*mensaje.length()));    
            p1.add(area);
            area.setEditable(false);
            setVisible(true);

        }
        caracteres.clear();
        
    }

    private void escuchar() {
        encriptar.addActionListener(this);
    }

}
