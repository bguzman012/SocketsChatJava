/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import chat.frames.Cliente1Enviados;
import chat.frames.Cliente2Enviados;
import chat.frames.Cliente2Recibidos;
import chat.frames.Cliente3Enviados;
import chat.frames.Cliente3Recibidos;
import chat.frames.ClienteRecibidos;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class Multilista {

    Cliente1Enviados cli = null;
    ClienteRecibidos cliRec = null;
    
    Cliente2Enviados cli2 = null;
    Cliente2Recibidos cliRec2 = null;
    
    Cliente3Enviados cli3 = null;
    Cliente3Recibidos cliRec3 = null;

    public Multilista() {

    }

    public Nodo inserta(Nodo r, int nivel, String s[], Nodo n) {
        if (s.length - 1 == nivel) {
            Listas obj = new Listas(); // técnico
            obj.r = r;
            obj.insertaLista(n);
            return obj.r;
        } else {
            Nodo aux = busca(r, s[nivel]);
            if (aux != null) {
                aux.setAbj(inserta(aux.getAbj(), nivel + 1, s, n));
            }
            return r;
        }
    }

    public Nodo busca(Nodo r, String s) {
        Listas obj = new Listas();
        obj.r = r;
        return obj.busca(s);
    }

    public void llamarDespligar(Nodo r, String s, Cliente1Enviados cli) {
        this.cli = cli;
        this.despligar(r, s);
    }

    public void despligar(Nodo r, String s) {
        while (r != null) {

            if (r.getD().equals("Recibidos")) {
                break;
            }
            if (!r.getD().equals("Enviados")) {
                cli.setText(s + r.getD());
            }
            despligar(r.getAbj(), s);

            r = r.getSig();

        }
    }

    public void llamarDespligarRecibidos(Nodo r, String s, ClienteRecibidos cli) {
        this.cliRec = cli;
        this.despligarRecibidos(r, s);
    }

    public void despligarRecibidos(Nodo r, String s) {
        while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            
            if (!r.getD().equals("Recibidos")) {
                cliRec.setText(s + r.getD());
            }
            
            
            System.out.println(s + r.getD());
            despligarRecibidos(r.getAbj(), s );

            r = r.getSig();
        }
    }
    
    public void llamarDespligar3(Nodo r, String s, Cliente3Enviados cli) {
        this.cli3 = cli;
        this.despligar3(r, s);
    }

    public void despligar3(Nodo r, String s) {
        while (r != null) {

            if (r.getD().equals("Recibidos")) {
                break;
            }
            if (!r.getD().equals("Enviados")) {
                cli3.setText(s + r.getD());
            }
            despligar3(r.getAbj(), s);

            r = r.getSig();

        }
    }

    public void llamarDespligarRecibidos3(Nodo r, String s, Cliente3Recibidos cli) {
        this.cliRec3 = cli;
        this.despligarRecibidos3(r, s);
    }

    public void despligarRecibidos3(Nodo r, String s) {
        while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            
            if (!r.getD().equals("Recibidos")) {
                cliRec3.setText(s + r.getD());
            }
            
            
            System.out.println(s + r.getD());
            despligarRecibidos3(r.getAbj(), s );

            r = r.getSig();
        }
    }
    
    public void llamarDespligar2(Nodo r, String s, Cliente2Enviados cli) {
        this.cli2 = cli;
        this.despligar2(r, s);
    }

    public void despligar2(Nodo r, String s) {
        while (r != null) {

            if (r.getD().equals("Recibidos")) {
                break;
            }
            if (!r.getD().equals("Enviados")) {
                cli2.setText(s + r.getD());
            }
            despligar2(r.getAbj(), s);

            r = r.getSig();

        }
    }

    public void llamarDespligarRecibidos2(Nodo r, String s, Cliente2Recibidos cli) {
        this.cliRec2 = cli;
        this.despligarRecibidos2(r, s);
    }

    public void despligarRecibidos2(Nodo r, String s) {
        while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            
            if (!r.getD().equals("Recibidos")) {
                cliRec2.setText(s + r.getD());
            }
            
            
            System.out.println(s + r.getD());
            despligarRecibidos2(r.getAbj(), s );

            r = r.getSig();
        }
    }

}
