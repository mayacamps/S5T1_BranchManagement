package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.impl;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.entity.Branch;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.enums.Type;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.repository.BranchRepository;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepo;

    @Override
    public List<Branch> getAllBranches() {
        return null;
    }

    @Override
    public Branch getBranch(int id) {
        return null;
    }

    @Override
    public void addBranch(Branch branch) {

    }

    @Override
    public void updateBranch(int id, Branch branch) {

    }

    @Override
    public void deleteBranch(int id) {

    }

    @Override
    public Branch toEntity(BranchDto dto) {
        return new Branch(dto.getName(), dto.getCountry());
    }

    @Override
    public BranchDto toDto(Branch branch) {
        return new BranchDto(branch.getName(), branch.getCountry());
    }
}
