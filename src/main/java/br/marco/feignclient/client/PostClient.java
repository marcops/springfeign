package br.marco.feignclient.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.marco.feignclient.model.Post;

@FeignClient("post-client")
public interface PostClient {

	@RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
	public Post getPost(@PathVariable(value = "id") Integer id);
	
	@RequestMapping(path = "/posts", method = RequestMethod.GET)
	public List<Post> getPosts();
}
