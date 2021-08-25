package org.jinho.ex3.controller;

import lombok.extern.slf4j.Slf4j;
import org.jinho.ex3.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @GetMapping("/ex1")
    public void ex1(){
        log.info("ex1.....................");
    }

    @GetMapping({"/ex2"})
    public String ex2(RedirectAttributes redirectAttributes){
        List<SampleDTO> sampleDTOS = IntStream.rangeClosed(1,20).asLongStream()
                .mapToObj(i->{
                    SampleDTO dto = SampleDTO.builder()
                            .sno(i)
                            .first("First : "+i)
                            .last("last :"+i)
                            .regTime(LocalDateTime.now())
                            .build();
                    return dto;
                }).collect(Collectors.toList());
        redirectAttributes.addFlashAttribute("result","success");
        redirectAttributes.addFlashAttribute("list",sampleDTOS);
        return "redirect:/sample/ex3";
    }
    @GetMapping("/ex3")
    public void ex3(){
        log.info("ex3...................");
    }




}
