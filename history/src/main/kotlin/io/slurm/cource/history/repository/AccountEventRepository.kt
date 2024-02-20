package io.slurm.cource.history.repository

import io.slurm.cource.history.model.AccountEvent
import io.slurm.cource.history.model.EventKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountEventRepository: JpaRepository<AccountEvent, EventKey> {
    fun findAllByAccountIdAndUserIdOrderByCreatedDesc(accountId: Long, userId: Long?): List<AccountEvent>
}