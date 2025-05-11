package com.project.registrationpage.controller;

import com.project.registrationpage.dto.RegistrationDto;
import com.project.registrationpage.entity.RegistrationEntity;
import com.project.registrationpage.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping("/save")
    public String savedata(RegistrationDto registrationDto, Model model){
        System.out.println(registrationDto);
        Boolean result=registrationService.save(registrationDto);
        if (result){
            model.addAttribute("result","data saved!");
        }else {
            model.addAttribute("result","data not saved try again!!");
        }
        return "index.jsp";
    }

    @RequestMapping("/viewUsers")
    public String viewusers(Model model){
        List<RegistrationEntity> list=registrationService.getalldata();
        model.addAttribute("userlist",list);
        System.out.println(list);
        return "index.jsp";
    }

    @RequestMapping("updatepage")
    public String updatepageloder(String id,Model model){
        int idd= Integer.parseInt(id);
        RegistrationEntity registration=registrationService.findById(idd);
        if (registration!=null){
            model.addAttribute("user",registration);
            return "updatepage.jsp";
        }else {
            model.addAttribute("result","not found");
            return "index.jsp";
        }
    }

    @RequestMapping("/update")
    public String updatedata( RegistrationEntity registration, Model model) {
        System.out.println("Updating ID: " + registration.getId());

        Boolean result = registrationService.Update(registration);
        if (result) {
            model.addAttribute("result", "Updated successfully");
        } else {
            model.addAttribute("result", "Not updated, try again!");
        }
        return "index.jsp";
    }
}
