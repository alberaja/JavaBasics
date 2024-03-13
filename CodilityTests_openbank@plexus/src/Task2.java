


----------------------
package com.codility.caching;

import org.springframework.stereotype.Service;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;

@Service
public class CachingArticlesService implements ArticlesService {

    @Override
    public Article getArticle(Long articleId) {
        return null;
    }

    @Override
    public void removeArticle(Long articleId) {

    }

    @Override
    public void saveArticle(Article article) {

    }

    @Override
    public Article updateLikes(Long articleId, int likes) {
        return null;
    }
}

----------------------   Solucion que envio:
package com.codility.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;

@Service
public class CachingArticlesService implements ArticlesService {

	private final ArticlesRepository articlesRepository;

	//@Autowired
	public CachingArticlesService(ArticlesRepository articlesRepository) {
    	this.articlesRepository = articlesRepository;
	}

	@Override
	@Cacheable(cacheNames = "articles", key = "#articleId")
	public Article getArticle(Long articleId) {
    	return articlesRepository.get(articleId);
	}

	@Override
	@CacheEvict(cacheNames = "articles", key = "#articleId")
	public void removeArticle(Long articleId) {
    	articlesRepository.remove(articleId);
	}

	@Override
	public void saveArticle(Article article) {
    	articlesRepository.save(article);
	}

	@Override
	@CachePut(cacheNames = "articles", key = "#articleId")
	public Article updateLikes(Long articleId, int likes) { 
       Article updatedArticle = articlesRepository.updateLikes(articleId, likes);          
       //Article updatedArticle = articlesRepository.get(articleId);        
        //updatedArticle.setLikes(likes); 
    
    return updatedArticle;
	}
}
