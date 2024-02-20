package io.slurm.cource.history.service

import io.slurm.cource.history.model.AccountEvent
import io.slurm.cource.history.repository.AccountEventRepository
import org.springframework.stereotype.Service

@Service
class AccountEventService (private val userService: ResolveUserService, private val repository: AccountEventRepository) {
    fun findAllAccountEvents(accountId: Long) : List<AccountEvent> {
        val userId = userService.resolveUserId()
        return repository.findAllByAccountIdAndUserIdOrderByCreatedDesc(accountId, userId)
    }
}