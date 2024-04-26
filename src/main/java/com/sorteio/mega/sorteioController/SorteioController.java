package com.sorteio.mega.sorteioController;

import com.sorteio.mega.sorteioService.SorteioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/sorteio")
public class SorteioController {
    @Autowired
    SorteioService sorteioService;
}
