package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private final Random random = new Random();

    private static List<String> readAllLines(String resource) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(resource);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/")

    public ModelAndView changeLookOfPage() throws IOException {

        ModelAndView result = new ModelAndView("dynamicPage");

        List<String> quotes = readAllLines("quotes.txt");
        int randomNoOfQuote = random.nextInt(quotes.size());
        String randomQuote = quotes.get(randomNoOfQuote);
        result.addObject("quote", randomQuote);

        List<String> pictures = readAllLines("pictures.txt");
        int randomNoOfPicture = random.nextInt(pictures.size());
        String randomPicture = pictures.get(randomNoOfPicture);
        result.addObject("picture", randomPicture);

        return result;
    }
}
