package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.request.BranchRequestDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.entity.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    public List<BranchDto> getAllBranches();
    public BranchDto getBranch(int id);
    public void addBranch(BranchRequestDto branchReqDto);
    public boolean updateBranch(BranchDto branchDto);
    public void deleteBranch(int id);
    public BranchDto getByName (String name);
    public Branch toEntity(BranchRequestDto branchReqDto);
    public BranchDto toDto(Branch branch);

}
