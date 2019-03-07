package com.stackroute.quizify.searchservice.controller;

import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.exception.GenreAlreadyExistsException;
import com.stackroute.quizify.searchservice.service.GenreService;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(description="Search by Genre")
public class GenreController {
    GenreService genreService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

//    @ApiOperation(value = "Search Genre By Name")
//    @GetMapping("/search/{topicName}")
//    public ResponseEntity<?> searchGenreByName(@PathVariable String genreName){
//        try {
//            return new ResponseEntity<List<Genre>>(genreService.getAllGenreByName(genreName), HttpStatus.OK);
//        }
//        catch (GenreDoesNotExistsException e)
//        {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

    @ApiOperation(value = "Save Genre")
    @PostMapping("/search-genre")
    public ResponseEntity<?> saveGenre(@RequestBody Genres genres){
        try
        {
            return new ResponseEntity<Genres>(genreService.saveGenre(genres), HttpStatus.OK);
        }
        catch (GenreAlreadyExistsException e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation(value = "Search Genre By Starts With")
    @GetMapping("/search-genre/{genreName}")
    public ResponseEntity<?>searchGenreByStartsWith(@PathVariable String genreName){
        try {
            return new ResponseEntity<List<Genres>>(genreService.getAllGenreByStartsWith(genreName), HttpStatus.OK);
        }
        catch (GenreDoesNotExistsException e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
