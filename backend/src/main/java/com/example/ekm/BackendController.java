package com.example.ekm;

import com.example.ekm.Model.Trail;
import com.example.ekm.Repository.TrailRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
public class BackendController {

    @Autowired
    TrailRepository trailRepository;

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    private static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @RequestMapping(path = "/hello")
    public @ResponseBody
    String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @RequestMapping(path = "/trail", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String name, @RequestParam String description) {
        Trail trail = new Trail(name, description);
        trailRepository.save(trail);

        LOG.info(trail.toString() + " successfully saved into DB");

        return trail.getId();
    }

    @RequestMapping(path = "/trail/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Trail getUser (@PathVariable long id) {
        Trail trail = trailRepository.findById(id).get();

        LOG.info(trail.toString() + " successfully fetched from DB");

        return trail;
    }


}
