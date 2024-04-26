package com.example.demo1.service;

import com.example.demo1.entities.Employee;
import com.example.demo1.model.EmployeeDto;
import com.example.demo1.repository.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    private final String[] HEAVENLY_STEMS = {"Canh", "Tan", "Nham", "Quy", "Giap", "At", "Binh", "Dinh", "Mau", "Ky"};
    private final String[] EARTHLY_BRANCHES = {"Ty", "Suu", "Dan", "Mao", "Thin", "Ty.", "Ngo", "Mui", "Than", "Dau", "Tuat", "Hoi"};
    private final String[] ELEMENTS  = {"Kim", "Thuy", "Hoa", "Tho", "Moc"};

    private String calculateChineseZodiac(int year) {
        int stemIndex = (year - 4) % 10;
        int branchIndex = (year - 4) % 12;
        String heavenlyStem = HEAVENLY_STEMS[stemIndex];
        String earthlyBranch = EARTHLY_BRANCHES[branchIndex];
        return heavenlyStem + " " + earthlyBranch;
    }

    public String calculateFiveElements(int year) {
        int thienCan = 0;
        switch (year % 10) {
            case 4:
            case 5:
                thienCan = 1;
                break;
            case 6:
            case 7:
                thienCan = 2;
                break;
            case 8:
            case 9:
                thienCan = 3;
                break;
            case 0:
            case 1:
                thienCan = 4;
                break;
            case 2:
            case 3:
                thienCan = 5;
                break;
            default:
                break;
        }

        int diaChi = 0;
        switch ((year - 4) % 12) {
            case 0:
            case 1:
            case 6:
            case 7:
                diaChi = 0;
                break;
            case 2:
            case 3:
            case 8:
            case 9:
                diaChi = 1;
                break;
            case 4:
            case 5:
            case 10:
            case 11:
                diaChi = 2;
                break;
            default:
                break;
        }
        int indexElement = (thienCan + diaChi) > 5 ? (thienCan + diaChi) - 5 : (thienCan + diaChi); 
        String element = ELEMENTS[indexElement - 1];
        return element;

    }

    public List<EmployeeDto> getEmployees() {
        return employeeRepo.findAll().stream()
                .map(obj -> {
                    LocalDate dateOfBirth = obj.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int year = Year.from(dateOfBirth).getValue();

                    String chineseZodiac = calculateChineseZodiac(year);
                    String fiveElements = calculateFiveElements(year);
                    return new EmployeeDto(obj.getId(), obj.getName(), obj.getDateOfBirth(), chineseZodiac, fiveElements);
                })
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        var item = employeeRepo.findById(id).orElseThrow();
        return new EmployeeDto(item.getId(), item.getName(), item.getDateOfBirth(), null, null);
    }

    @Override
    public void createEmployee(String name, Date dayOfBirth) {
        Employee newUser = new Employee();
        newUser.setName(name);
        newUser.setDateOfBirth(dayOfBirth);

        employeeRepo.save(newUser);
    }

    @Override
    public void updateEmployee(Long id, String name, Date dayOfBirth) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee updatedUser = optionalEmployee.get();
            updatedUser.setName(name);
            updatedUser.setDateOfBirth(dayOfBirth);

            employeeRepo.save(updatedUser);
        } else {
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
