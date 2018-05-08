package service;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.PostDao;
import model.Post;

public class PostService {

	private Connection connection = null;
	public PostService() {
	}
	
	LocalDateTime dateTime = LocalDateTime.now();
	
	public List<Post> getPostByBbsId(int bbsId) {
		PostDao dao = new PostDao();
		this.connection = dao.createConnection();
		List<Post> posts = new ArrayList<Post>();
		posts = dao.findByBbsId(bbsId, connection);
		dao.closeConnection(connection);
		this.connection = null;
		return posts;
	}
	
	public void addPost(Post post) {
		post.setCreatedAt(dateTime);
		PostDao postDao = new PostDao();
		this.connection = postDao.createConnection();
		postDao.create(post, connection);
		postDao.closeConnection(connection);
		this.connection = null;
	}
	
	public void deletePostByBbsId(int bbsId) {
		PostDao postDao = new PostDao();
		this.connection = postDao.createConnection();
		postDao.deleteByBbsId(bbsId, connection);
		postDao.closeConnection(connection);
		this.connection = null;
	}
	
	public void deletePostByPostId(int postId) {
		PostDao dao = new PostDao();
		this.connection = dao.createConnection();
		dao.delete(postId, connection);
		dao.closeConnection(connection);
		this.connection = null;
	}
	
	public Post getPostByPostId(int postId) {
		PostDao dao = new PostDao();
		this.connection = dao.createConnection();
		Post post = new Post();
		post = dao.findOne(postId, connection);
		this.connection = null;
		return post;
	}
	
	public void update(Post post) {
		PostDao dao = new PostDao();
		this.connection = dao.createConnection();
		dao.update(post, connection);
		dao.closeConnection(connection);
		this.connection = null;
	}
}
