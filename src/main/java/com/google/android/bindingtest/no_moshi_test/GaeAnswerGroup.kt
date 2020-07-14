package com.google.android.bindingtest.no_moshi_test

/**
 * Data class for AnswerGroup model
 * https://github.com/oppia/oppia/blob/15516a/core/domain/state_domain.py#L43
 */
data class GaeAnswerGroup(
        val tagged_skill_misconception_id: String?,
        val outcome: GaeOutcome?,
        val rule_specs: List<GaeRuleSpec?>?,
        val training_data: List<Any?>
)