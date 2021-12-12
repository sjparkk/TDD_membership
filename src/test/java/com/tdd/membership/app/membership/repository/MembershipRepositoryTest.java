package com.tdd.membership.app.membership.repository;

import com.tdd.membership.app.repositoyry.MembershipRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MembershipRepositoryTest {

    @Autowired
    private MembershipRepository membershipRepository;

    @Test
    @DisplayName("멤버쉽리포지토리 널체크")
    public void MembershipRepositoryIsNotNull() {
        Assertions.assertThat(membershipRepository).isNotNull();
    }
}
