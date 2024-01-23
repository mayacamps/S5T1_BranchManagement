package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.dto;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto {
    /*TODO
    create list from csv
     */
    private List<String> europeanCountries = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
    private String name;
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
        return europeanCountries.stream().anyMatch(country::equalsIgnoreCase);
    }

    @Override
    public String toString(){
        return "{\nBranch name: " + name +
                "\nCountry: " + country +
                "\nEU/non-EU: " + type + "\n}";
    }
}
