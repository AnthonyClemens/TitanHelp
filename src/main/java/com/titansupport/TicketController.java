package com.titansupport;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    @GetMapping("/")
    public String ticketForm(Model model) {
        return "ticketForm";
    }

    @PostMapping("/submitTicket")
    public String submitTicket(@RequestParam String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,@RequestParam String problemString, Model model) {
        Ticket ticket = new Ticket(name, date, problemString);
        // Process the ticket here
        model.addAttribute("ticket", ticket);
        return "ticketResult";
    }
}
