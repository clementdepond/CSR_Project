package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.MultiThreading.Requin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

public class RequinsRessources extends ServerResource {

    /** Backend. */
    private Backend backend_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public RequinsRessources()
    {
        super();
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }

    /**
     *
     * Returns the list of all the users
     *
     * @return  JSON representation of the users
     * @throws JSONException
     */
    @Get("json")
    public Representation getRequins() throws JSONException
    {
        int requins = backend_.getDatabase().getRequins();
        Collection<JSONObject> jsonRequins = new ArrayList<JSONObject>();

            JSONObject current = new JSONObject();
            current.put("Nb requins", requins);
            jsonRequins.add(current);

        JSONArray jsonArray = new JSONArray(jsonRequins);
        return new JsonRepresentation(jsonArray);
    }

    @Post("json")
    public Representation createRequin(JsonRepresentation representation)
            throws Exception
    {
        JSONObject object = representation.getJsonObject();
        //Zone zone = object.getZone("zone");
        //int pilotes = object.getInt("pilotes");
        JsonRepresentation result;

        // Save the user
        Requin requin = backend_.getDatabase().createRequin();

        if (requin != null){
        // generate result
        JSONObject resultObject = new JSONObject();
        resultObject.put("zone", requin.getZone());
        resultObject.put("pilotes", requin.getPilotes());
         result = new JsonRepresentation(resultObject);
        }else {
            result = new JsonRepresentation("Un requin occupe deja la zone");
        }

        return result;
    }
}
