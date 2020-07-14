package com.google.android.bindingtest.no_moshi_test

import com.google.android.bindingtest.no_moshi_test.GaeAnswerGroup
/**
 * Data class for InteractionInstance model
 * https://github.com/oppia/oppia/blob/15516a/core/domain/state_domain.py#L277
 */
data class GaeInteractionInstance(
        val id: String?,
        val answer_groups: List<GaeAnswerGroup>?,
        val solution: GaeSolution?,
        val confirmed_unclassified_answers: List<Any?>?,
        val hints: List<GaeHint?>?,
        val default_outcome: GaeOutcome?,
        val customization_args: Map<String, GaeCustomizationArgs>?
)