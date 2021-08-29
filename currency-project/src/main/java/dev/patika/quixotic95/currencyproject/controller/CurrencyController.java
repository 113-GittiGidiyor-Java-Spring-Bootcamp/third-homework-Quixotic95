package dev.patika.quixotic95.currencyproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/currencyConverter")
public class CurrencyController {

    private final double RATE = 0.118;

    @GetMapping("/toTRY")
    public ResponseEntity<?> convertUsdToTry(@RequestParam double USD) {

        return ResponseEntity.ok(new DecimalFormat("##.##").format(USD/RATE) + " ₺");

    }

    @GetMapping("/toUSD")
    public ResponseEntity<?> convertTryToUsd(@RequestParam double TRY) {

        return ResponseEntity.ok(new DecimalFormat("##.##").format(TRY*RATE) + " $");

    }
}
