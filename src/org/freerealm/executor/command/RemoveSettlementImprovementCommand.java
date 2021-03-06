package org.freerealm.executor.command;

import org.freerealm.executor.CommandResult;
import org.freerealm.settlement.Settlement;

/**
 * Command class to remove an improvement from a given settlement.
 * @author Deniz ARIKAN
 */
public class RemoveSettlementImprovementCommand extends AbstractCommand {

    private Settlement settlement;
    private int improvementTypeId;

    /**
     * Constructs a RemoveSettlementImprovementCommand using settlement
     * and improvement type id.
     * @param settlement Settlement from which the improvement will be removed
     * @param improvementTypeId Type id of the improvement to remove from settlement
     */
    public RemoveSettlementImprovementCommand(Settlement settlement, int improvementTypeId) {
        this.settlement = settlement;
        this.improvementTypeId = improvementTypeId;
    }

    /**
     * Executes command and removes the improvement from the settlement.
     * @param realm Realm to execute the command
     * @return CommandResult
     */
    public CommandResult execute() {
        settlement.removeImprovement(improvementTypeId);
        return new CommandResult(CommandResult.RESULT_OK, "");
    }
}
