package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.entity.Branch;

import java.util.List;

public interface BranchService {
    public List<BranchDto> getAllBranches();
    public BranchDto getBranch(int id);
    public void addBranch(BranchDto branchDto);
    public void updateBranch(int id, BranchDto branchDto);
    public void deleteBranch(int id);
    public Branch toEntity(BranchDto dto);
    public BranchDto toDto(Branch branch);
}
