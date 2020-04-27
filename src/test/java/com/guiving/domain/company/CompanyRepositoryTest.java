package com.guiving.domain.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {

    @Autowired
    CompanyRepository cp;

    @Test
    public void findByIdTest() throws Exception{
        Company cm = cp.findById(Long.parseLong("64")).orElseThrow(Exception::new);
        System.out.println("CompanyCompany : " + cm);

    }
    @Test
    @Transactional
    public void getOpCountTest() throws Exception{
        Company cm = cp.findById(Long.parseLong("64")).orElseThrow(Exception::new);
        System.out.println("OpCount : " + cm.getOpCount());

    }

    @Test
    @Transactional
    public void findAllTest(){
        cp.findAll()
                    .forEach(x->{
                            System.out.println("element : " + x +"  opcount  : " + x.getOperatorList().size());
                            System.out.println("element : " + x +"  gvcount  : " + x.getGuiverList().size());
                            //System.out.println("element : " + x);
                        }
                    );
    }
}
