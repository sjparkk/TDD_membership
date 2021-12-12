package com.tdd.membership.app.membership.repository;

import com.tdd.membership.app.entity.Membership;
import com.tdd.membership.app.repositoyry.MembershipRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

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
                .membershipName("네이버")
                .point(10000)
                .build();

        //when
        final Membership result = membershipRepository.save(membership);

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getUserId()).isEqualTo("id");
        assertThat(result.getMembershipName()).isEqualTo("네이버");
        assertThat(result.getPoint()).isEqualTo(10000);
    }
}
