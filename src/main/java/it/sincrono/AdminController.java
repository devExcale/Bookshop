package it.sincrono;

import it.sincrono.models.Book;
import it.sincrono.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	BookRepository bookRepository;

	@RequestMapping("")
	public String index() {
		return "redirect:/admin/home";
	}

	@RequestMapping("/home")
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("admin/home");
		mav.addObject("books", bookRepository.findAll());

		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editPost(@RequestParam Book book) {

		ModelAndView mav = new ModelAndView("admin/edit");

		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editGet(@RequestParam(required = false) String id) {

		ModelAndView mav;

		Optional<Book> book = bookRepository.findById(id != null ? id : "");

		if(!book.isPresent()) {

			mav = new ModelAndView("redirect:/admin/home");
			mav.setStatus(HttpStatus.NOT_FOUND);

		} else {

			mav = new ModelAndView("admin/edit");
			mav.addObject("book", book.get());

		}

		return mav;
	}

}
