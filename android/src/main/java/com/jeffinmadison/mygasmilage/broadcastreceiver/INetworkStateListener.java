package com.jeffinmadison.mygasmilage.broadcastreceiver;

/**
 * Created by Jeff on 10/16/13.
 * Copyright JeffInMadison 2013
 */
public interface INetworkStateListener {
	public void networkStateChanged(boolean isOnline);
}