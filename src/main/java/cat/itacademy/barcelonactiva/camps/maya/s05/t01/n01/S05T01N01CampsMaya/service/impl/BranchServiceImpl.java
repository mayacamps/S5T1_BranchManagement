package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.service.impl;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.request.BranchRequestDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.entity.Branch;
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
    public List<BranchDto> getAllBranches() {
        List<Branch> branches = branchRepo.findAll();
        System.out.println(branches.size());
        return branches.stream().map(this::toDto).toList();
    }

    @Override
    public BranchDto getBranch(int id) {
        return null;
    }

    @Override
    public void addBranch(BranchRequestDto branchReqDto) {
        Branch branch = toEntity(branchReqDto);
        toDto(branch).setId(branch.getId());
        branchRepo.save(branch);
    }

    @Override
    public boolean updateBranch(BranchDto branchDto) {
        BranchDto existingDto = getByName(branchDto.getName());
        if (existingDto == null){
            return false;
        }
        if (!branchDto.getName().equalsIgnoreCase(existingDto.getName())){
            existingDto.setName(branchDto.getName());
        }
        existingDto.setCountry(branchDto.getCountry());
        existingDto.setType(branchDto.getType());
//        branchRepo.save(toEntity(existingDto));
        return true;
    }

    @Override
    public void deleteBranch(int id) {

    }

    @Override
    public BranchDto getByName(String name) {
        Branch branchExisting = branchRepo.findByName(name).orElse(null);
        if (branchExisting!=null){
            return toDto(branchExisting);
        }
        return null;
    }

    @Override
    public Branch toEntity(BranchRequestDto reqDto) {
        return new Branch(reqDto.getName(), reqDto.getCountry());
    }

    @Override
    public BranchDto toDto(Branch branch) {
        return new BranchDto(branch.getId(), branch.getName(), branch.getCountry());
    }
}
