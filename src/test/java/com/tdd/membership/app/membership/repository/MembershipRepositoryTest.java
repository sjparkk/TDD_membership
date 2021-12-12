package com.tdd.membership.app.membership.repository;

import com.tdd.membership.app.entity.Membership;
import com.tdd.membership.app.enums.MembershipType;
import com.tdd.membership.app.repositoyry.MembershipRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

//@Transactional 포함하고 있어 자동 롤백
@DataJpaTest
public class MembershipRepositoryTest {

    @Autowired
    private MembershipRepository membershipRepository;

    @Test
    @DisplayName("멤버쉽리포지토리 널체크")
    public void MembershipRepositoryIsNotNull() {
        assertThat(membershipRepository).isNotNull();
    }

    @Test
    @DisplayName("멤버쉽 등록")
    public void create() {
        //given
        final Membership membership = Membership.builder()
                .userId("id")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        //when
        final Membership result = membershipRepository.save(membership);

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getUserId()).isEqualTo("id");
        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
        assertThat(result.getPoint()).isEqualTo(10000);
    }

    @Test
    @DisplayName("아이디와 멤버쉽타입으로 해당 멤버쉽을 조회할 수 있는지 테스트")
    public void read() {
        //given
        final Membership membership = Membership.builder()
                .userId("id")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();
        //when
        membershipRepository.save(membership);
        Membership resultMembership = membershipRepository.findByUserIdAndMembershipType("id", MembershipType.NAVER);
        //then
        assertThat(resultMembership).isNotNull(); //객체 널체크
        assertThat(resultMembership.getId()).isNotNull(); // 아이디로 널체크
        assertThat(resultMembership.getUserId()).isEqualTo("id"); // userid 값 체크
        assertThat(resultMembership.getMembershipType()).isEqualTo(MembershipType.NAVER); // type체크
        assertThat(resultMembership.getPoint()).isEqualTo(10000); // point 값 체크

    }
}
