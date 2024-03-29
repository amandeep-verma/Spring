package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	
	List<Course> findByTopicId(String topicId);
	
	
	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic id)
	// deleteTopic(String id)
}
