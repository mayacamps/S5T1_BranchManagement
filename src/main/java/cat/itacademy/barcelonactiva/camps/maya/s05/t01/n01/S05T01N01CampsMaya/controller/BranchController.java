package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.controller;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.request.BranchRequestDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.entity.Branch;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
        model.addAttribute("branch_dto", new BranchRequestDto());
        return "add_form";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("branch_dto") BranchRequestDto branchReqDto, BindingResult bindingResult, RedirectAttributes redirect, Model model){
        BranchDto existingDto = service.getByName(branchReqDto.getName());
        if (existingDto != null){
            bindingResult.reject("duplicate_entry", "Cannot use this name. '" + branchReqDto.getName() + "' already exists.");
        }
        if (bindingResult.hasErrors()) {
            return "add_form";
        }
        service.addBranch(branchReqDto);
        redirect.addFlashAttribute("added_success", "Branch added to the list.");
        return "redirect:/api/v1/";
    }

    @GetMapping("/get/{id}")
    public void getById(@PathVariable("id") Integer id){
        service.getBranch(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable("id") Integer id, @Valid @RequestBody BranchDto branchDto){
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteBranch(id);
    }
}
