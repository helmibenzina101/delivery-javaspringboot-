package tn.store.delivery.controller;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.store.*;
import tn.store.delivery.model.Article;
import tn.store.delivery.service.ArticleService;
@RestController 
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class ArticleController {

	//autowire the BooksService class  
	@Autowired  
    ArticleService articleService;  

	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/Article")
	
	private List<Article> getAllArticles()   
	{  
		return articleService.getAllArticle();  
	}  

	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/Article/{Articleid}")  
	private Article getArticles(@PathVariable("Articleid") int Articleid)   
	{  
		return articleService.getArticleById(Articleid);	}  


	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/Article/{Articleid}")  
	private void deleteArticle(@PathVariable("Articleid") int Articleid)   
	{  
		articleService.delete(Articleid);  
	} 

	@PostMapping("/Article")  
	private int saveArticle(@RequestBody Article article)   
	{  
		articleService.saveOrUpdate(article);  
		return article.getId();  
	} 

	//creating put mapping that updates the book detail
	//@CrossOrigin(origins = "*")
	@PutMapping("/Article")  
	private Article update(@RequestBody  Article article)   
	{  
		articleService.saveOrUpdate(article);  
		return article;  
	}  
}