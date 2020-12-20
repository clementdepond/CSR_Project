package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

public class SardinesRessources extends ServerResource {

    /** Backend. */
    private Backend backend_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public SardinesRessources()
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
    public Representation getSardines() throws JSONException
    {
        int sardines = backend_.getDatabase().getSardines();
        Collection<JSONObject> jsonSardines = new ArrayList<JSONObject>();

        JSONObject current = new JSONObject();
        current.put("Nb sardines", sardines);
        jsonSardines.add(current);

        JSONArray jsonArray = new JSONArray(jsonSardines);
        return new JsonRepresentation(jsonArray);
    }
}
