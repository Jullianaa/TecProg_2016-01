/**
 * File: PlaceDAO.java
 * Purpose: Establish communication with the database to send and receive data of Brasilia's places
 */

package dao;

import android.support.v4.app.FragmentActivity;
import org.json.JSONObject;

public class PlaceDAO extends DAO{

    /**
     * PlaceDAO constructor
     * @param currentActivity - Current activity to show message of connection problem
     */
    public PlaceDAO(FragmentActivity currentActivity){
        super(currentActivity);
    }

    /**
     * Searches places by part of name
     * @param name - Part of the name to be searched on places name
     * @return JSONObject - Data of the places found
     */
    public JSONObject searchPlaceByPartName(String name){

        assert name != null;
        assert name.isEmpty() == false;

        final String QUERY = "SELECT * FROM vw_place WHERE namePlace LIKE '%" + name + "%'";

        JSONObject placeByPartNameQueryResult = this.executeConsult(QUERY);

        return placeByPartNameQueryResult;
    }

    /**
     * Searches all places available in database
     * @return JSONObject - Data of the places found
     */
    public JSONObject searchAllPlaces(){

        final String QUERY = "SELECT * FROM vw_place ORDER BY evaluate DESC";

        JSONObject searchAllPlacesQueryResult = this.executeConsult(QUERY);

        return searchAllPlacesQueryResult;
    }

    /**
     * Searches the five events with better evaluation
     * @return JSONObject - Data of the five events found
     */
    public JSONObject searchTop5Places(){

        final String QUERY = "SELECT * FROM vw_place ORDER BY evaluate DESC LIMIT 5";

        JSONObject searchTop5PlacesQueryResult =  this.executeConsult(QUERY);

        return searchTop5PlacesQueryResult;
    }
}
