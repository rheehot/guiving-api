package com.guiving.domain.guiver;

import com.guiving.vo.Name;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuiverRepositoryTest {
    @Autowired
    GuiverRepository guiverRepository;

    @Test
    public void findAllTest(){
        guiverRepository.findAll()
                .forEach(x ->
                        System.out.println("element : " + x)
                );
    }
    @Test
    public void findByName() {
        Name name = Name.builder()
                .firstName("Lee")
                .lastName("Harrison")
                .build();
        List<Guiver> list= guiverRepository.findByName(name);

        list.forEach(x-> System.out.println("element : " +x));

    }


}