package com.example.demo.controls;

import com.example.demo.entity.LaserSearch;
import com.example.demo.reposDev.LaserSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("relation")
public class JPARelationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JPARelationRestController.class.getName());

    @Autowired
    private LaserSearchRepository laserSearchRepository;

    @PostMapping("/create")
    public ResponseEntity<LaserSearch> createLaserSearch(@RequestBody LaserSearch laserSearch) {
        try {
            laserSearch = laserSearchRepository.save(laserSearch);
            return new ResponseEntity<>(laserSearch, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<LaserSearch>> getAllSearches(@RequestParam(required = false) String title) {
        try {
            List<LaserSearch> searchList = new ArrayList<>();

            if (title == null) {
                laserSearchRepository.findAll().forEach(searchList::add);
            }
            //else
            laserSearchRepository.findByServiceIdContaining(title).forEach(searchList::add);

            if (searchList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(searchList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<LaserSearch> getSearchById(@PathVariable("id") long id) {
        Optional<LaserSearch> searchData = laserSearchRepository.findById(id);

        if (searchData.isPresent()) {
            return new ResponseEntity<>(searchData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<LaserSearch> updateTutorial(@PathVariable("id") long id, @RequestBody LaserSearch laserSearch) {
        Optional<LaserSearch> tutorialData = laserSearchRepository.findById(id);

        if (tutorialData.isPresent()) {
            laserSearch = tutorialData.get();
            laserSearch.setServiceId(laserSearch.getServiceId());
            return new ResponseEntity<>(laserSearchRepository.save(laserSearch), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<HttpStatus> deleteSearch(@PathVariable("id") long id) {
        try {
            laserSearchRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllSearches() {
        try {
            laserSearchRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

