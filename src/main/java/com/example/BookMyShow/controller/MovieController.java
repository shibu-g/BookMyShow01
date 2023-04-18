package com.example.BookMyShow.controller;

import com.example.BookMyShow.Service.impl.MovieServiceImpl;
import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {


    @Autowired
    MovieServiceImpl movieService;
    Logger l= LoggerFactory.getLogger(MovieController.class);


    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody() MovieEntryDto movieEntryDto){

        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);

        log.info("The movieResponseDto is ",movieResponseDto);
        return movieResponseDto;

    }

    @GetMapping("/get/{id}")
    public MovieNameAndIdObject getNameAndId(@PathVariable Integer id){

        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);

        return movieNameAndIdObject;
    }

}
