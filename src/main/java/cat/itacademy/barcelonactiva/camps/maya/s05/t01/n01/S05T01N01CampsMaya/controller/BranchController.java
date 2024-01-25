package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.controller;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService service;

    @GetMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("allBranches", service.getAllBranches());
        return "index";
    }
    @GetMapping({"","/getAll"})
    public String getAll(){
       return "redirect:/api/v1/";
    }

    @PostMapping("/add")
    public void add(@Valid @RequestBody BranchDto branchDto){
        service.addBranch(branchDto);
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
