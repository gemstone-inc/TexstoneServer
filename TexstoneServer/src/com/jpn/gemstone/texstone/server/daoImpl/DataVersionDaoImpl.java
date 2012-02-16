package com.jpn.gemstone.texstone.server.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.jpn.gemstone.texstone.server.dao.DataVersionDao;
import com.jpn.gemstone.texstone.server.model.DataVersion;




public class DataVersionDaoImpl implements DataVersionDao {

	@SessionTarget
	Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataVersion> listVersion() {
		List<DataVersion> versionList = null;
		versionList = session.createQuery("from DataVersion order by releaseDate desc").list();
		return versionList;
	}
	
	public DataVersion createNewVersion(){
		DataVersion newVersion = new DataVersion();
		newVersion.setReleaseDate(new Date());
		Long versionId = (Long)session.save(newVersion);
		newVersion.setVersionId(versionId);
		return newVersion;
	}

}
