package org.example.springcourse.controllers;


import jakarta.validation.Valid;
import org.example.springcourse.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
//    @GetMapping
//    public String index(
//            Model model){
//        model.addAttribute("books", bookService.findAll());
//        return "books/index";
//    }


//
//        @GetMapping("/{id}")
//        public String show(@PathVariable("id") int id, Model model) {
//            model.addAttribute("person", peopleService.findOne(id));
//            return "people/show";
//        }
//
//        @GetMapping("/new")
//        public String newPerson(@ModelAttribute("person") Person person) {
//            return "people/new";
//        }
//
//        @PostMapping()
//        public String create(@ModelAttribute("person") @Valid Person person,
//                             BindingResult bindingResult) {
//            if (bindingResult.hasErrors())
//                return "people/new";
//
//            peopleService.save(person);
//            return "redirect:/people";
//        }
//
//        @GetMapping("/{id}/edit")
//        public String edit(Model model, @PathVariable("id") int id) {
//            model.addAttribute("person", peopleService.findOne(id));
//            return "people/edit";
//        }
//
//        @PatchMapping("/{id}")
//        public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
//                             @PathVariable("id") int id) {
//            if (bindingResult.hasErrors())
//                return "people/edit";
//
//            peopleService.update(id, person);
//            return "redirect:/people";
//        }
//
//        @DeleteMapping("/{id}")
//        public String delete(@PathVariable("id") int id) {
//            peopleService.delete(id);
//            return "redirect:/people";
//        }


    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }


    @GetMapping()
    public String index(@RequestParam(value = "page", required = false) int page,
                        @RequestParam(value = "books_per_page", required = false) int books_per_page,
                        @RequestParam(value = "sort_by_year", required = false) boolean sort_by_year,
                        Model model) {

        model.addAttribute("books", booksService.findAll(page, books_per_page, sort_by_year));
        return "people/index";
    }


    //    public String create(@ModelAttribute("person") @Valid Person person,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "people/new";
    @GetMapping("/searching")
    public String search(@PathVariable("startingTitle") String startingTitle, Model model) {
        model.addAttribute("Book", booksService.findByTitleStartingWith(startingTitle));
        return
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }
}

}
