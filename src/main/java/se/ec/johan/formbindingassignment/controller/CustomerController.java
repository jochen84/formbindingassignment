package se.ec.johan.formbindingassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.ec.johan.formbindingassignment.data.CustomerDao;
import se.ec.johan.formbindingassignment.dto.CustomerFormDto;
import se.ec.johan.formbindingassignment.entity.Customer;
import se.ec.johan.formbindingassignment.entity.CustomerDetails;
import javax.validation.Valid;

@Controller
public class CustomerController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("customers/create")
    public String getCustomerForm(Model model){
        CustomerFormDto formDto = new CustomerFormDto();
        model.addAttribute("form", formDto);
        return "create-customer";
    }

    @PostMapping("customers/process")
    public String processForm(@Valid @ModelAttribute("form") CustomerFormDto formDto, BindingResult bindingResult){

        if (customerDao.findbyEmail(formDto.getEmail()).isPresent()){
            FieldError emailError = new FieldError("form", "email", "Email "+ formDto.getEmail() + " allready exists!");
            bindingResult.addError(emailError);
        }
        if (!formDto.getPassword().equals(formDto.getPasswordConfirm())){
            FieldError passwordConfirmError = new FieldError("form", "passwordConfirm", "Passwords doesn't match!");
            bindingResult.addError(passwordConfirmError);
        }
        if (bindingResult.hasErrors()){
            return "create-customer";
        }

        Customer newCustomer = new Customer(formDto.getEmail(), new CustomerDetails(
                formDto.getName(),
                formDto.getStreetAddress(),
                formDto.getZipCode(),
                formDto.getCity(),
                formDto.getPhoneNumber()
        ));
        newCustomer = customerDao.save(newCustomer);
        String url = "/customers?type=id&value=" + newCustomer.getCustomerId();
        //return "redirect:/customers";
        return "redirect:"+url;
    }

    @GetMapping("/customers")
    public String findAll(Model model){
        model.addAttribute("customers", customerDao.findAll());
        return "customer-list";
    }

    @GetMapping("customers/details")
    public String customer(@RequestParam("id") String customerId, Model model){
        Customer newCustomer = customerDao.findById(customerId).get();
        model.addAttribute("customer", newCustomer);
        //return "test-page";
        return "customer-view";
    }
}
