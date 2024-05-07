package com.titansupport;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @GetMapping("/form") //If user goes to /ticket/form
    public String ticketForm() {
        return "ticketForm"; // Load the ticketForm.html
    }

    @PostMapping("/add") //If user goes to /ticket/add
    public String addTicket(@RequestParam String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam String problemString, Model model) { //Take all of the inputs from the form in ticketForm.html
        Ticket ticket = new Ticket(name, date, problemString); //Create a new Ticket
        ManageTicket.addTicket(ticket); //Pass the ticket to hibernate
        model.addAttribute("submittedTicket", ticket); //Add the ticket to the model so that the results page can read the text
        return "results"; //Load the results page
    }
}
