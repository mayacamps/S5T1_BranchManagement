package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.controller;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.entity.Branch;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;
    @GetMapping(value = {"/getAll","/"})
    public void getAll(){
        branchService.getAllBranches();
    }

    @PostMapping("/add")
    public void add(@Valid @RequestBody Branch branch){
        branchService.addBranch(branch);
    }

    @GetMapping("/get/{id}")
    public void getById(@PathVariable("id") Integer id){
        branchService.getBranch(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable("id") Integer id, @Valid @RequestBody Branch branch){
        branchService.updateBranch(id, branch);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        branchService.deleteBranch(id);
    }
}
