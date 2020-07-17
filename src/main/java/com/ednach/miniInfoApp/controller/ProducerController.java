package com.ednach.miniInfoApp.controller;


import com.ednach.miniInfoApp.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/producer")
public class ProducerController {

    private ProducerService producerService;

}
