package main.java.jp.ac.haze.service;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import main.java.jp.ac.haze.dao.BbsDao;
import main.java.jp.ac.haze.model.Bbs;

public class BbsService {

	private Connection connection = null;

	public BbsService() {
	}

	LocalDateTime dateTime = LocalDateTime.now();

	public void createBbs(Bbs bbs) {
		bbs.setCreatedAt(dateTime);
		bbs.setUpdatedAt(dateTime);
		BbsDao dao = new BbsDao();
		this.connection = dao.createConnection();
		dao.create(bbs, connection);
		dao.closeConnection(this.connection);
		this.connection = null;
	}

	public List<Bbs> getBbs() {
		BbsDao dao = new BbsDao();
		this.connection = dao.createConnection();
		List<Bbs> bbs = dao.findAll(connection);
		this.connection = null;
		return bbs;
	}

	public Bbs getBbs(int bbsId) {
		BbsDao dao = new BbsDao();
		this.connection = dao.createConnection();
		Bbs bbs = new Bbs();
		bbs = dao.findOne(bbsId, connection);
		this.connection = null;
		return bbs;
	}

	public void updateBbs(Bbs bbs) {
		bbs.setUpdatedAt(dateTime);
		BbsDao dao = new BbsDao();
		this.connection = dao.createConnection();
		dao.update(bbs, connection);
		this.connection = null;
	}

	public void deleteBbs(int bbsId) {
		BbsDao dao = new BbsDao();
		this.connection = dao.createConnection();
		dao.delete(bbsId, connection);
		dao.closeConnection(connection);
		this.connection = null;
	}
}
