package com.example.springangularfeed.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.springangularfeed.model.Role;
import com.example.springangularfeed.model.User;

@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	private List<User> users;
	private UserGenerator userGenerator;
	private static Long userId;
	
	private static volatile boolean stopFlag = true; 

	private static class UserGenerator implements Runnable {

		private List<User> users;
		private User newUser;
		private static final Random RND = new Random();

		public UserGenerator(List<User> users) {
			this.users = users;
		}
		
		@Override
		public void run() {
			while (stopFlag) {
				newUser = new User(userId++, new Date(), Role.values()[RND.nextInt(Role.values().length)]);
				users.add(newUser);

				try {
					Thread.sleep(1000L);
				} catch (InterruptedException ie) {
					LOG.warn("Couldn't pause the generator thread: "
							+ ie.getLocalizedMessage());
				}
			}
			
		}
		
	}
	
	@PostConstruct
	public void initialize() {
		userId = 0L;
		users = new CopyOnWriteArrayList<>();
		userGenerator = new UserGenerator(users); 
	}

	public void startFeed() {
		LOG.info("Start feed");
		UserService.stopFlag = true;
		new Thread(userGenerator).start();
	}

	public void stopFeed() {
		LOG.info("Stop feed");
		UserService.stopFlag = false;
	}
	
	public void reset() {
		LOG.info("Reset");
		stopFeed();
		users.clear();
		startFeed();
	}
	
	public List<User> getUsers() {
		return users;
	}
}
