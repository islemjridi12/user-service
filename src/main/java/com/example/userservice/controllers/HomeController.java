package com.example.userservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String loginPage() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Connexion</title>
            </head>
            <body>
                <h1>Connexion avec Google</h1>
                <a href=\"/oauth2/authorization/google\">
                    <button>Se connecter avec Google</button>
                </a>
            </body>
            </html>
        """;
    }

    @GetMapping("/home")
    @ResponseBody
    public String homePage() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Accueil</title>
            </head>
            <body>
                <h1>Bienvenue !</h1>
                <p>Vous êtes connecté avec succès.</p>
                <a href=\"/logout\"><button>Déconnexion</button></a>
            </body>
            </html>
        """;
    }
}
