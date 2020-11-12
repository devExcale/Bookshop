package it.sincrono;

import it.sincrono.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping("/home")
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("home");
		mav.addObject("books", bookRepository.findAll());

		return mav;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:home";
	}

}
