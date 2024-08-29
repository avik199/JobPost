package com.avik.spring_boot_rest_jobPost;

import com.avik.spring_boot_rest_jobPost.model.JobPost;
import com.avik.spring_boot_rest_jobPost.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@Controller
public class JobRestController {
    @Autowired
    private JobService service;
    @GetMapping("JobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return (service.getAllJobs());
    }


}*/


@RestController//tells that all the methods are returning data not views or jsp pages.
@CrossOrigin(origins = "http://localhost:3000/")//link of front-end local server given to avoid CORS error.
public class JobRestController {
    @Autowired
    private JobService service;
    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return (service.getAllJobs());
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJobs(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJobs(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJobs(postId);
        return "Deleted!!!";
    }


    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }



    @PostMapping("load")
    public String loadDB(){
        service.load();
        return "Success";
    }

}