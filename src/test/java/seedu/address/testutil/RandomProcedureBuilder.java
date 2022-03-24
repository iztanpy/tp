package seedu.address.testutil;

import seedu.address.model.procedure.Completion;
import seedu.address.model.procedure.Cost;
import seedu.address.model.procedure.Date;
import seedu.address.model.procedure.Information;
import seedu.address.model.procedure.Procedure;

/**
 * A utility class to help with building random Procedure objects.
 */
public class RandomProcedureBuilder {

    private Date[] dateList;
    private Information info;
    private Date date;
    private Cost cost;
    private Completion hasCompleted;
    private boolean dateCheck = false;
    private TypicalRandomProcedureDetails procedureDetails = new TypicalRandomProcedureDetails();

    public RandomProcedureBuilder() {
    }

    /**
     * This will build a new random Procedure out of the details selected from TypicalRandomProcedureDetails.
     * However, since the autosort test needs the dates to be sorted, the function will trigger dataCheck. Without this,
     * should buildRandomProcedure be called again, a new set of random dates may be generated. buildRandomProcedures
     * takes in an integer i to allow it to iterate through the stored dateList in order to return the generated date.
     *
     * @param i Integer to assist in selecting dates from dateList
     * @return A new random Procedure
     */

    public Procedure buildRandomProcedure(int i) {
        info = procedureDetails.getInfo();
        cost = procedureDetails.getCost();
        hasCompleted = new Completion("false");
        if (!dateCheck) {
            dateList = procedureDetails.getDates();
            dateCheck = true;
        }
        date = dateList[i];
        return new Procedure(info, date, cost, hasCompleted);
    }
}
