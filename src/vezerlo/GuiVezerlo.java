
package vezerlo;

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
    }

    private void start() {
        nezet.megjelenit(modell.kezdes());
        int v ;
        if((v = nezet.bekeres())== -1){
            modell.setValasztas(v);
            nezet.visszajelzes("Nincs láda kiválasztva");
        }
        //nezet.megjelenit(modell.ellenorzes());
        
    }

    private void guiBeallitas() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nezet.setVisible(true);
            }
        });
    }
 
    
}
