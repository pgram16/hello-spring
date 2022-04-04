package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
public class JdbcTemplateMemberRepositoryTest {

    MemberRepository repository;

    @Autowired
    public JdbcTemplateMemberRepositoryTest(DataSource dataSource) {
        this.repository = new JdbcTemplateMemberRepository(dataSource);
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("please..");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll(){



        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(1);
    }

}
