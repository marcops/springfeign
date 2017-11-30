package br.marco.feignclient;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import br.marco.feignclient.client.PostClient;
import br.marco.feignclient.model.Post;

@SpringBootApplication
@EnableFeignClients
public class Application implements CommandLineRunner {

	private Logger LOG = Logger.getLogger(Application.class.getName());

	@Autowired
	private PostClient postClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		showFirstPost();
		showAllPosts();
	}

	private void showAllPosts() {
		List<Post> posts = postClient.getPosts();
		posts.forEach(p -> LOG.info(p.toString()));
	}

	private Post showFirstPost() {
		Integer POST_ID = 1;
		Post post = postClient.getPost(POST_ID);

		LOG.info("First post");
		LOG.info(post.toString());

		return post;
	}
}
