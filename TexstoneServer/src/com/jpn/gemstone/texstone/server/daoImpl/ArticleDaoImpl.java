package com.jpn.gemstone.texstone.server.daoImpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.jpn.gemstone.texstone.server.dao.ArticleDao;
import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.DataVersion;

public class ArticleDaoImpl implements ArticleDao{
	
	@SessionTarget
	Session session;

	public void saveArticleList(List<Article> articleList){
		for (Article article : articleList) {
			session.save(article);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleList(String tag, String category,
			String version) {
		Criteria query = session.createCriteria(Article.class);
		if(StringUtils.isNotEmpty(version)){
			if(version.equals("null")){
				query.add(Restrictions.isNull("version"));
			}
			else {
				DataVersion dataVersion = (DataVersion) session.load(DataVersion.class, Long.valueOf(version));
				query.add(Restrictions.eq("version", dataVersion));
			}
		}
		
		if(StringUtils.isNotEmpty(tag)){
			query.add(Restrictions.like("tag", tag+"%"));
		}
		
		if(StringUtils.isNotEmpty(category)){
			query.add(Restrictions.eq("categoryId", Long.valueOf(category)));
		}
		

		return query.list();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Article> getNotYetPublishedArticleList() {
		Criteria query = session.createCriteria(Article.class);
		query.add(Restrictions.isNull("version"));
		return query.list();
	}
	
	
	
	
	@Override
	public void saveOrUpdate(Article article){
		session.saveOrUpdate(article);
	}
	
	
	@Override
	public void delete(Article article){
		session.delete(article);
	}

	@Override
	public Article findArticleById(Long articleId) {
		return (Article) session.load(Article.class, articleId);
	}

	@Override
	public void publishArticleList(DataVersion version) {
		// TODO Auto-generated method stub
		Query query = session.createQuery("update Article set version = :version where version is NULL");
		query.setParameter("version", version);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Article> getNewArticleList(Long deviceDataVersionId) {
		Criteria query = session.createCriteria(Article.class);
		query.add(Restrictions.gt("version.versionId", deviceDataVersionId));
		return query.list();
	}


	
	

}