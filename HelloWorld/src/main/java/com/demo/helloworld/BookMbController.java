package com.demo.helloworld;

import com.demo.helloworld.entity.BookMb;
import com.demo.helloworld.repository.BookMbDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Controller
@RequestMapping("/bookmb")
public class BookMbController {

    @Resource
    private BookMbDao bookMbDao;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("bookList", bookMbDao.findAll());
        return "bookListMb";
    }


    @PostMapping("/add")
    @Transactional
    public String add(BookMb bookMb) {
        bookMbDao.save(bookMb);
        return "forward:/bookmb/list";
    }

    @RequestMapping("/preUpdate/{id}")
    public String preUpdate(@PathVariable("id")Integer id, Model model){
        model.addAttribute("book", bookMbDao.getOne(id));
        return "bookUpdateMb";
    }

    @PostMapping(value="/update")
    public String update(BookMb bookMb){
        bookMbDao.save(bookMb);
        return "forward:/bookmb/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        bookMbDao.deleteById(id);
        return "forward:/bookmb/list";
    }
}
