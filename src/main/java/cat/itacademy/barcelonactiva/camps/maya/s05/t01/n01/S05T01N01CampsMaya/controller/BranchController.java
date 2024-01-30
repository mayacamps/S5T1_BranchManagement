package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.controller;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService service;

    @GetMapping("/")
    public String showHomePage(Model model){
        List<BranchDto> allBranches = service.getAllBranches();
        model.addAttribute("allBranches", allBranches);
        return "branch_mgm";
    }
    @GetMapping({"","/getAll"})
    public String getAll(){
       return "redirect:/api/v1/";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("branch_dto", new BranchDto());
        return "add_form";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("branch_dto") BranchDto branchDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("branch_dto", branchDto);
            System.out.println("hhhhh");
            return "add_form";
        }
        System.out.println("aaaaaaaa");
        service.addBranch(branchDto);
        return "redirect:/api/v1/";
    }

    @GetMapping("/get/{id}")
    public void getById(@PathVariable("id") Integer id){
        service.getBranch(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable("id") Integer id, @Valid @RequestBody BranchDto branchDto){
        service.updateBranch(id, branchDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteBranch(id);
    }
}
