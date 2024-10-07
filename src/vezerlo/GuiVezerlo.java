package vezerlo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modell.JatekModell;
import nezet.GuiNezet;

/**
 *
 * @author bajari.gergo
 */
public class GuiVezerlo {

    private JatekModell modell;
    private GuiNezet nezet;

    public GuiVezerlo(JatekModell modell, GuiNezet nezet) {
        this.modell = modell;
        this.nezet = nezet;
        guiBeallitas();
        start();
        valasztas();
    }

    private void start() {
        nezet.megjelenit(modell.kezdes());

        //nezet.megjelenit(modell.ellenorzes());
    }

    private void guiBeallitas() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nezet.setVisible(true);
            }
        });
    }

    private void valasztas() {
        JButton gomb = nezet.getBttnValaszt();
        gomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v = nezet.bekeres();
                modell.setValasztas(v);
                String s = "Nincs láda kiválasztva";
                s = v > -1 ? modell.ellenorzes() : s;
                nezet.visszajelzes(s);
                
//                int v;
//                if ((v = nezet.bekeres()) == -1) {
//                    modell.setValasztas(v);
//                    nezet.visszajelzes("Nincs láda kiválasztva");
//                }else{
//                    modell.setValasztas(v);
//                    nezet.visszajelzes(modell.ellenorzes());
//                }
            }
        });

    }
}
