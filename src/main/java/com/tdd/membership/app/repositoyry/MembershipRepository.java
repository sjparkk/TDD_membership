package com.tdd.membership.app.repositoyry;

import com.tdd.membership.app.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
