package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.MultiThreading.Zone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

public class ZonesRessources extends ServerResource {

    /** Backend. */
    private Backend backend_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public ZonesRessources()
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
    public Representation getZones() throws JSONException
    {
        Collection<Zone> users = backend_.getDatabase().getZones();
        Collection<JSONObject> jsonZones = new ArrayList<JSONObject>();

        for (Zone zone : users)
        {
            JSONObject current = new JSONObject();
            current.put("case1", zone.getX());
            current.put("case2", zone.getY());
            jsonZones.add(current);

        }
        JSONArray jsonArray = new JSONArray(jsonZones);
        return new JsonRepresentation(jsonArray);
    }
}
