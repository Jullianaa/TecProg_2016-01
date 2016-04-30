/**
 *  File: EventEvaluationDAO.java
 *  Purpose: allows to evaluate events, besides only search through the code to improve th
 *  e interest on a event.
 */

package dao;

import android.app.Activity;

import org.json.JSONObject;

import model.Evaluation;
import model.EventEvaluation;

public class EventEvaluationDAO extends DAO{

    public EventEvaluationDAO(){}

    public EventEvaluationDAO(Activity activity){
        super(activity);
    }

    public void evaluateEvent(EventEvaluation evaluation){
        final String QUERY;

        JSONObject findEvaluation = searchEventEvaluation(evaluation.getEventId(),
                                    evaluation.getUserId());

        if(findEvaluation==null){
            QUERY = "INSERT INTO participate(grade, idUser, idEvent) VALUES (\"" +
                    evaluation.getRating() + "\"," +
                    "\"" + evaluation.getUserId() + "\"," +
                    "\"" + evaluation.getEventId() + "\")";
        }else{
            QUERY = "UPDATE participate SET grade = \"" +evaluation.getRating() + "\" " +
                    "WHERE idEvent = \"" + evaluation.getEventId() + "\" AND idUser = \"" +
                    evaluation.getUserId() + "\"";
        }

        executeQuery(QUERY);
    }

    public JSONObject searchEventEvaluation(int eventId, int userId){
        final String QUERY = "SELECT * FROM participate WHERE idUser = \"" + userId
                            + "\" AND idEvent = " + eventId;

        return executeConsult(QUERY);
    }
}
