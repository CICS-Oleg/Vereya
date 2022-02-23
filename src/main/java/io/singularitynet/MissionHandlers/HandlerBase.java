package io.singularitynet.MissionHandlers;

import java.util.ArrayList;
import java.util.HashMap;

/** Lightweight baseclass for all handlers - provides access to parameters from the XML file.
 */
public class HandlerBase
{
    /** A static list of all classes that implement a handler - used to aid dynamic handler creation.
     */
    static ArrayList<String> handlers;

    /** Pointer up to the MissionBehaviour object that created us - useful for certain mission handlers.
     */
    private MissionBehaviour parentBehaviour = null;

    public HandlerBase() {}

    public void setParentBehaviour(MissionBehaviour mb)
    {
        this.parentBehaviour = mb;
    }

    protected MissionBehaviour parentBehaviour()
    {
        return this.parentBehaviour;
    }

    /** Attempt to parse the given object as a set of parameters for this handler.
     * @param params the parameter block to parse
     * @return true if the object made sense for this handler; false otherwise.
     */
    public boolean parseParameters(Object params)
    {
        return true;
    }

    /** Our chance to add any info the server might need before the mission starts.
     * @param map Map of data sent to server in the client's ping message.
     */
    public void appendExtraServerInformation(HashMap<String, String> map)
    {
        // Mostly does nothing, but, for example, TurnBasedCommandsImplementation uses this
        // in order to register with the server.
    }
}