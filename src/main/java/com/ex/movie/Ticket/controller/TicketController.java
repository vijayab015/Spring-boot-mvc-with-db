package com.ex.movie.Ticket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.model.Ticket;
import com.ex.model.dao.TicketDao;

@Controller
public class TicketController {

	@Autowired
	TicketDao ticketDao;
	
	@RequestMapping("/bookticket")
	public String showCreateTicket() {
		System.out.println("Inside book ticket ");
		return "createTicket";
	}

	@RequestMapping("/createTicket")
	public String createTicket(Ticket ticket, ModelMap mm)

	{
		System.out.println(ticket.getId() + " " + ticket.getMovie() + " " + ticket.getScreen() + " " + ticket.getSeat());
        ticketDao.create(ticket);
        //Success message
        mm.addAttribute("msg", "Ticket booked successfully");
        System.out.println(mm.get("msg"));
		return "createTicket";
	}

}
