package com.jpn.gemstone.texstone.server.dao;

import java.util.List;

import com.jpn.gemstone.texstone.server.model.DataVersion;

public interface DataVersionDao {
	public List<DataVersion> listVersion();
	public DataVersion createNewVersion();
}
