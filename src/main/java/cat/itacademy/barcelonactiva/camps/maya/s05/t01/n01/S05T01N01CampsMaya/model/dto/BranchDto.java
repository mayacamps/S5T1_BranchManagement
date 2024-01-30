package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.util.StringUtils;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Table
public class BranchDto {

    private final List<String> EUROPEAN_COUNTRIES = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
    @Size(min=4, max=30, message = "Must be between 4 and 30 characters")
    @NotBlank(message = "Please introduce a name")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Cannot include special characters")
    @Column(unique = true)
    private String name;
    @NotBlank(message = "Must choose a country")
    private String country;

    @Enumerated(EnumType.STRING)
    private Type type;

    public BranchDto(String name, String country){
        this.name = StringUtils.capitalize(name);
        this.country = StringUtils.capitalize(country);
        this.type = getType(country);
    }

    private Type getType(String country){
        if (isEuropean(country)){
            return Type.EU;
        }
        return Type.NON_EU;
    }

    private boolean isEuropean(String country){
        return EUROPEAN_COUNTRIES.stream().anyMatch(country::equalsIgnoreCase);
    }

    @Override
    public String toString(){
        return "\n{\n\tBranch name: " + name +
                "\n\tCountry: " + country +
                "\n\tEU/non-EU: " + type + "\n}\n";
    }
}
