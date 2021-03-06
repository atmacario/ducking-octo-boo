package org.freemars.controller.action;

import org.freemars.controller.FreeMarsController;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.freemars.ui.unit.AttackUnitDialog;
import org.freerealm.Realm;
import org.freerealm.executor.CommandResult;
import org.freerealm.executor.command.AttackUnitCommand;
import org.freerealm.unit.Unit;

/**
 *
 * @author Deniz ARIKAN
 */
public class AttackUnitAction extends AbstractAction {

    private FreeMarsController freeMarsController;
    private Unit attacker;
    private Unit defender;
    private AttackUnitDialog attackUnitDialog;

    public AttackUnitAction(FreeMarsController freeMarsController, Unit attacker, Unit defender, AttackUnitDialog attackUnitDialog) {
        super("Attack");
        this.freeMarsController = freeMarsController;
        this.attacker = attacker;
        this.defender = defender;
        this.attackUnitDialog = attackUnitDialog;
    }

    public void actionPerformed(ActionEvent e) {
        attackUnitDialog.setVisible(false);
        attackUnitDialog.dispose();
//        freeMarsController.getGameFrame().getMapPanel().moveUnit(attacker, attacker.getCoordinate(), defender.getCoordinate());
        Realm realm = freeMarsController.getFreeMarsModel().getRealm();
        CommandResult commandResult = freeMarsController.execute(new AttackUnitCommand(realm, attacker, defender));
        Unit winner = (Unit) commandResult.getParameter("winner");
        if (defender.equals(winner)) {
//            FreeMarsOptionPane.showMessageDialog(controller.getGameFrame(), "Defender won", "Battle result");
        } else {
//            FreeMarsOptionPane.showMessageDialog(controller.getGameFrame(), "Attacker won", "Battle result");
        }
    }
}
