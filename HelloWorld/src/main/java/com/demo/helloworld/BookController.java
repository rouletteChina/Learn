package com.demo.helloworld;


import com.demo.helloworld.entity.BookJpa;
import com.demo.helloworld.repository.BookDaoJpa;
import com.demo.helloworld.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookDaoJpa bookDaoJpa;

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("bookList", bookDaoJpa.findAll());
        return "bookList";
    }

    @PostMapping("/add")
    @Transactional
    public String add(BookJpa book) {
        bookDaoJpa.save(book);
        System.out.println(bookService.toString());
        return "forward:/book/list";
    }

    @RequestMapping("/preUpdate/{id}")
    public String preUpdate(@PathVariable("id")Integer id, Model model){
        model.addAttribute("book", bookDaoJpa.getOne(id));
        return "bookUpdate";
    }

    @PostMapping(value="/update")
    public String update(BookJpa book){
        bookDaoJpa.save(book);
        return "forward:/book/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        bookDaoJpa.deleteById(id);
        return "forward:/book/list";
    }

    /**
     * 根据条件动态查询
     * @param book
     * @return
     */
    @RequestMapping("/list2")
    public String list2(BookJpa book, Model model){
        List<BookJpa> bookList= bookDaoJpa.findAll(new Specification<BookJpa>() {

            @Override
            public Predicate toPredicate(Root<BookJpa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate=cb.conjunction();
                if(book!=null){
                    if(book.getName()!=null && !"".equals(book.getName())){
                        predicate.getExpressions().add(cb.like(root.get("name"), "%"+book.getName()+"%"));
                    }
                    if(book.getAuthor()!=null && !"".equals(book.getAuthor())){
                        predicate.getExpressions().add(cb.like(root.get("author"), "%"+book.getAuthor()+"%"));
                    }
                }
                return predicate;
            }
        });
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

}
