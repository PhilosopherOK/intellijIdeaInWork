package org.example.springcourse.controllers;


import jakarta.validation.Valid;
import org.example.springcourse.models.Book;
import org.example.springcourse.models.Person;
import org.example.springcourse.services.BooksService;
import org.example.springcourse.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final PeopleService peopleService;

    @Autowired
    public BooksController(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index(@RequestParam(value = "page", required = false) int page,
                        @RequestParam(value = "books_per_page", required = false) int books_per_page,
                        @RequestParam(value = "sort_by_year", required = false) boolean sort_by_year,
                        Model model) {

        model.addAttribute("books", booksService.findAll(page, books_per_page, sort_by_year));
        return "books/index";
    }


    //    public String create(@ModelAttribute("person") @Valid Person person,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "people/new";
    @GetMapping("/searching")
    public String search(@PathVariable("startingTitle") String startingTitle, Model model) {
        model.addAttribute("books", booksService.findByTitleStartingWith(startingTitle));
        return "books/searching";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("books", booksService.findOne(id));
        if(booksService.findOne(id).getOwner() != null){
            model.addAttribute("owner", booksService.findOne(id).getOwner());
        }else{
            model.addAttribute("people", peopleService.findAll());
        }
        return "books/show";
    }

    @PatchMapping("/{id}/addHost")
    public String addHost(@PathVariable("id") int id, @ModelAttribute("person") Person person){
        booksService.addHostByBookId(id, person);
        return "redirect:/books"+id;
    }
    @PatchMapping("/{id}/deleteHost")
    public String deleteHost(@PathVariable("id") int id){
        booksService.deleteHostByBookId(id);
        return "redirect:/books"+id;
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("books") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("Book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";

        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", booksService.findOne(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("books") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "books/edit";

        booksService.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }
}
